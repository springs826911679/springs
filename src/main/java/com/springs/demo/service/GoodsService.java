package com.springs.demo.service;

import com.springs.demo.common.search.PageSearch;
import com.springs.demo.domain.Goods;
import com.springs.demo.repository.GoodsRepository;
import com.springs.demo.search.GoodsSearchParams;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class GoodsService {
    @Autowired
    GoodsRepository goodsRepository;


    public Goods save(Goods article){
        return goodsRepository.saveAndFlush(article);
    }
    public List<Goods> getAll(){
       return goodsRepository.findAll();
    }
    public Page<Goods> search(GoodsSearchParams params){
        PageSearch<Goods> search = new PageSearch<>(goodsRepository,goodsRepository);
        return search.search(params);
    }
    public Goods findOne(int id) {
//            Course model = courseRepository.findOne(id);
        Optional<Goods> optional = goodsRepository.findById(id);
        Goods model = optional.orElse(null);
        return model;
    }
    @Transactional
    public int deleteOne(Integer id)throws Exception{
        return goodsRepository.retain(id);
    }
    public Goods updateOne(Integer id,Map<String,Object> map) throws InvocationTargetException, IllegalAccessException {
        Optional<Goods> optional = goodsRepository.findById(id);
        Goods model = optional.orElse(null);
        if(model !=null){
            BeanUtils.populate(model,map);
            goodsRepository.saveAndFlush(model);
        }
        return model;
    }
//    public List<Goods> findAllByCategoryId(Integer categoryId){
//       return goodsRepository.findAllByCategoryId(categoryId);
//    }
//    public ArticleDto toDto(Article article) throws InvocationTargetException, IllegalAccessException {
//        ArticleDto articleDto = new ArticleDto();
//        BeanUtils.copyProperties(articleDto, article);
//        if (article.getCategoryId()!=null) {
//            Optional<ArticleCategory> byId = articleCategoryRepository.findById(article.getCategoryId());
//            if (byId!=null){
//            articleDto.setCategoryId(byId.get().getId());
//            articleDto.setCategoryName(byId.get().getName());
//            }
//        }
//        return articleDto;
//    }
//    public List<ArticleDto> toDtos(List<Article> articles) throws InvocationTargetException, IllegalAccessException {
//        List<ArticleDto> articleDtos = new ArrayList<>();
//        for (Article article:articles){
//            ArticleDto articleDto = toDto(article);
//            articleDtos.add(articleDto);
//        }
//        return articleDtos;
//    }

}
