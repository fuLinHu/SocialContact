package com.imooc.entity;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "role_resources")
@Entity
@IdClass(RoleResources.class)
public class RoleResources implements Serializable{
    private static final long serialVersionUID = -8559867942708057891L;

    @Id
    @Column(name = "roleid")
    private Integer roleid;

    @Id
    @Column(name = "resourcesid")
    private String resourcesid;

    /**
     * @return roleId
     */
    public Integer getRoleid() {
        return roleid;
    }

    /**
     * @param roleid
     */
    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getResourcesid() {
        return resourcesid;
    }

    public void setResourcesid(String resourcesid) {
        this.resourcesid = resourcesid;
    }
}