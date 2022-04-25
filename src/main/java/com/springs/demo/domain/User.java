package com.springs.demo.domain;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Data
@Entity
@Table(name = "tbl_user")
@EntityListeners(AuditingEntityListener.class)
public class User  {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "roles_encode",columnDefinition = "char(64) default 'USER'",nullable=false)
    private String rolesEncode;

    @Column(name = "count")
    private Integer count;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "create_date")
    private Date createDate;


    public Set<String> getRoles() {
        if(this.rolesEncode!=null && !this.rolesEncode.isEmpty()){
            String[] roles = this.rolesEncode.split(",");
            Set<String> set = new HashSet<>(Arrays.asList(roles));
            return set;
        }
        return new HashSet<String>();
    }
    @PrePersist
    public void beforeSave(){
        if(this.rolesEncode == null){
            this.rolesEncode = "USER";
        }
        if(this.createDate == null){
            this.createDate = new Date();
        }
    }


}
