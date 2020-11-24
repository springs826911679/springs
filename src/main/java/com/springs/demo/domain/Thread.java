package com.springs.demo.domain;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_thread")
@EntityListeners(AuditingEntityListener.class)
@Data
public class Thread {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "content",columnDefinition="mediumtext")
    private String content;
    @Column(name = "create_date")
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "goods_id")
    private Integer goodsId;
}
