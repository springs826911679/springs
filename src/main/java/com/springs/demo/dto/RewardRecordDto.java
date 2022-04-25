package com.springs.demo.dto;

import lombok.Data;

import java.util.Date;


@Data
public class RewardRecordDto {

    private Integer id;
    private String name;
    private String username;
    private Date createDate;

}
