package com.springs.demo.common.search;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.persistence.criteria.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PageSearch<T> {

    PagingAndSortingRepository pagingAndSortingRepository;
    JpaSpecificationExecutor jpaSpecificationExecutor;
    public PageSearch(PagingAndSortingRepository pagingAndSortingRepository, JpaSpecificationExecutor jpaSpecificationExecutor){
        this.pagingAndSortingRepository = pagingAndSortingRepository;
        this.jpaSpecificationExecutor = jpaSpecificationExecutor;
    }
    public Page<T> search(SearchParams params){
        if(params == null) return pagingAndSortingRepository.findAll(getDefaultPageable());
        Pageable pageable = getPageable(params);
        Specification<T> specification = getSpec(params);
        return jpaSpecificationExecutor.findAll(specification, pageable);
    }

    public static Pageable getDefaultPageable(){
        return PageRequest.of(SearchParams.defaultPage - 1,SearchParams.defaultPerPage);
    }
    public Pageable getPageable(SearchParams params){
        Sort sortOption = null;
        if( params.sort != null ){
            List<Sort.Order> orders = parseOrders(params.sort);
            if(orders.size()>0){
                sortOption =  Sort.by(orders);
            }
        }
        if(sortOption == null ){
            return PageRequest.of(params.currentPage -1,params.pageSize);
        }

        return PageRequest.of(params.currentPage -1,params.pageSize,sortOption);

    }

    public static List<Sort.Order> parseOrders(String s){
        List<Sort.Order> orders = new ArrayList<Sort.Order>();
        List<String> list = Arrays.asList(s.split(","));
        for(int i=0;i<list.size();i++){
            String item = list.get(i);
            if(item!=null && !"".equals(item.trim())) {
                item = item.trim();
                if (item.startsWith("-")) {
                    orders.add(new Sort.Order(Sort.Direction.DESC, item.substring(1)));
                } else {
                    orders.add(new Sort.Order(Sort.Direction.ASC, item));
                }
            }
        }
        return orders;
    }


    public Specification getSpec(SearchParams params){
        Class<? extends SearchParams> clazz = params.getClass();

        Specification<T> specification = new Specification<T>() {
            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                //匹配条件
                List<Predicate> predicates = new ArrayList<Predicate>();

                //可用于join其他表
//                Join<Db1NewsFilesEntity, Db1NewsItemsEntity> join = root.join("newsItem", JoinType.INNER);

                boolean useKeyword = params.keyword != null;

                Field[] fields = clazz.getFields();
                List<Field> keywordFields = new ArrayList<Field>();
                try {


                    for (Field field: fields) {
                        Object value = field.get(params);
                        SearchProporty annotation = field.getAnnotation(SearchProporty.class);
                        if(annotation != null ){
                            //以下选出在keyword检索范围内的字段
                            if(annotation.inKeywords() && field.getType().equals(String.class)){
                                keywordFields.add(field);
                            }
                            //以下处理该字段
                            if(value == null ) continue;

                            String fieldName = annotation.linkEntityField().isEmpty() ? field.getName() : annotation.linkEntityField();
                            if(annotation.joinAttributeName().isEmpty()){
                                Path path = root.get(fieldName);

                                if(field.getType().equals(String.class)){
                                    predicates.add(criteriaBuilder.like(path,"%"+value.toString()+"%"));
                                }else if(field.getType().equals(Integer.class) || field.getType().equals(Boolean.class)){
//                                    Path path = root.get(fieldName);
                                    predicates.add(criteriaBuilder.equal(path, value));
                                }else if(field.getType().equals(List.class)){
                                    CriteriaBuilder.In in = criteriaBuilder.in(path);
                                    for (Object o : (List<?>) value) {
                                        if(o instanceof Integer){
                                            in.value(Integer.class.cast(o));
                                        }
                                    }

                                    predicates.add(in);
                                }
                            }else{
                                String joinTargetAttributeName = !annotation.joinTargetAttributeName().isEmpty() ? annotation.joinTargetAttributeName() : fieldName;
                                Path path = root.join(annotation.joinAttributeName(), JoinType.LEFT).get(joinTargetAttributeName);
                                if(field.getType().equals(String.class)){
                                    predicates.add(criteriaBuilder.like(path,"%"+value.toString()+"%"));
                                }else if(field.getType().equals(Integer.class) || field.getType().equals(Boolean.class)){
                                    predicates.add(criteriaBuilder.equal(path, value));
                                }
                            }



                        }
                    }

                    if(params.keyword != null && !params.keyword.isEmpty() && keywordFields.size()>0){
                        Predicate predicate = null;

                        for(int i=0;i<keywordFields.size();i++){
                            Path path = root.get(keywordFields.get(i).getName());
                            if(i==0){
                                predicate = criteriaBuilder.like(path, "%" + params.keyword + "%");
                            }else{
                                predicate = criteriaBuilder.or(predicate,criteriaBuilder.like(path, "%" + params.keyword + "%"));
                            }
                        }
                        predicates.add(predicate);
                    }



                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

                return criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
            }
        };
        return specification;
    }
}
