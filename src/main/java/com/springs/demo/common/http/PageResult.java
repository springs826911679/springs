package com.springs.demo.common.http;

import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
public class PageResult<T> {

    List<T> list;

    Pagination pagination;



    public static <V> PageResult<V> wrap(Page<V> page){
        PageResult<V> result = new PageResult<V>();
        result.setList(page.getContent());
        Pagination pagination = new Pagination();
        pagination.setTotal(page.getTotalElements());
        pagination.setPageSize(page.getSize());
        pagination.setCurrentPage(page.getNumber()+1);
        result.setPagination(pagination);
        return result;
    }


    @Data
    static class Pagination {
        public long total;
        public int currentPage;
        public int pageSize;
    }

    // getter / setter 略
}