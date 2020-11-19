package com.springs.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@EntityListeners({AuditingEntityListener.class})
//@Multitenant(MultitenantType.SINGLE_TABLE)
@Table(name = "tbl_course_enrollment",uniqueConstraints = @UniqueConstraint(columnNames={"course_id","user_id"}))
//@TenantDiscriminatorColumn(name = "tenant_dbu", contextProperty = "eclipselink.tenant-id")
public class CourseEnrollment {
    //主键
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Getter
    @Setter
    private Integer id;

    //课程id
    @Column(name = "course_id")
    @Getter
    @Setter
    private Integer courseId;

    //用户Id
    @Column(name = "user_id")
    @Getter
    @Setter
    private Integer userId;

}
