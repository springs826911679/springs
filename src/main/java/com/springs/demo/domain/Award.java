package com.springs.demo.domain;


import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "tbl_award")
@EntityListeners(AuditingEntityListener.class)
public class Award {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "award_name")
    private String awardName;

    @Column(name = "goods_id")
    private Integer goodsId;

    @Column(name = "award_describe")
    private String awardDescribe;

    @Column(name = "likelihood")
    private Float likelihood;

}
