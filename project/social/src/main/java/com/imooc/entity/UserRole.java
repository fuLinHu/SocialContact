package com.imooc.entity;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "user_role")
@Entity
public class UserRole implements Serializable{
    private static final long serialVersionUID = -916411139749530670L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "userId")
    private Integer userid;

    @Column(name = "roleId")
    private String roleid;

    /**
     * @return userId
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * @param userid
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}