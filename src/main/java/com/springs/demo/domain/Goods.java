package com.springs.demo.domain;


import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tbl_goods")
@EntityListeners(AuditingEntityListener.class)
public class Goods {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "intro")
    private String intro;

    @Column(name = "price")
    private String price;

    @Column(name = "num")
    private Integer num;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "static",columnDefinition = "text")
    private String  img;

    @Column(name = "video",columnDefinition = "text")
    private String video;

    @Column(name = "video_name")
    private String videoName;

    @Column(name = "author")
    private String author;


}
