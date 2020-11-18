package com.springs.demo.search;

import com.springs.demo.common.search.SearchParams;
import com.springs.demo.common.search.SearchProporty;
import lombok.Data;


@Data
public class GoodsSearchParams extends SearchParams {



    @SearchProporty
    public Integer id;

    @SearchProporty
    public String  name;

}
