package com.springs.demo.domain;


import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "tbl_award_record")
@EntityListeners(AuditingEntityListener.class)
public class AwardRecord {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;


    @Column(name = "award_id")
    private Integer goodsId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "create_data")
    private Date createData;

}
