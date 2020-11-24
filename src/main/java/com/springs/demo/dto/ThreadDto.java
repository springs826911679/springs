package com.springs.demo.dto;


import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ThreadDto {

    private Integer id;
    private Integer userId;
    private String userName;
    private String content;
    private Integer goodsId;
    private Date createDate;

}
