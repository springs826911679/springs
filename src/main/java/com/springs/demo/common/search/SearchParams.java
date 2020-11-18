package com.springs.demo.common.search;

import lombok.Data;

@Data
public class SearchParams {
    static int defaultPage = 1;
    static int defaultPerPage = 20;
    String keyword;
    Integer currentPage = defaultPage;
    Integer pageSize = defaultPerPage;
    String sort;

}
