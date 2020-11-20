package com.springs.demo.domain;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Data
@EntityListeners({AuditingEntityListener.class})
@Table(name = "tbl_goods_enrollment")
public class GoodsEnrollment {
    //主键
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    //课程id
    @Column(name = "course_id")
    private Integer courseId;

    //用户Id
    @Column(name = "user_id")
    private Integer userId;

}
