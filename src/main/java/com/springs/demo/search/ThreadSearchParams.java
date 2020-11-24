package com.springs.demo.search;

import com.springs.demo.common.search.SearchParams;
import com.springs.demo.common.search.SearchProporty;
import lombok.Data;

@Data
public class ThreadSearchParams extends SearchParams {


    @SearchProporty
    public Integer goodsId;

    @SearchProporty
    public Integer id;

}
