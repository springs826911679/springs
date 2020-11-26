package com.springs.demo.domain;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Arrays;
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
            this.rolesEncode = "ADMIN";
        }
    }


}
