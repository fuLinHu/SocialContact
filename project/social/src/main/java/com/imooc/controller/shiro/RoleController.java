package com.imooc.controller.shiro;


import com.imooc.entity.Role;
import com.imooc.entity.RoleResources;
import com.imooc.service.RoleResourcesService;
import com.imooc.service.RoleService;
import com.imooc.util.tools.PageableTools;
import org.springframework.data.domain.Page;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yangqj on 2017/4/26.
 */
@RestController
@RequestMapping("/roles")
public class RoleController {
    @Resource
    private RoleService roleService;
    @Resource
    private RoleResourcesService roleResourcesService;

    @RequestMapping
    public Map<String, Object> getAll(Role role, String draw,
                                      @RequestParam(required = false, defaultValue = "1") int start,
                                      @RequestParam(required = false, defaultValue = "10") int length) {

        Map<String, Object> map = new HashMap<>();
        Page<Role> page = roleService.findPage(PageableTools.basicPage(start, length));
        List<Role> list=new ArrayList<Role>();
        page.forEach(item->{
            list.add(item);
        });
        map.put("data", list);
        return map;
    }

    @RequestMapping("/rolesWithSelected")
    public List<Role> rolesWithSelected(Integer uid) {
        return roleService.queryRoleListWithSelected(uid);
    }

    //分配角色
    @RequestMapping("/saveRoleResources")
    public String saveRoleResources(RoleResources roleResources) {
        if (StringUtils.isEmpty(roleResources.getRoleid()))
            return "error";
        try {
            Integer roleid = roleResources.getRoleid();
            String resourcesid = roleResources.getResourcesid();
            String[] split = resourcesid.split(",");
            List<RoleResources> list =new ArrayList<RoleResources>();
            for(String item:split){
                RoleResources r=new RoleResources();
                r.setRoleid(roleid);
                r.setResourcesid(item);
                list.add(r);
            }
            roleResourcesService.save(list);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping(value = "/add")
    public String add(Role role) {
        try {
            roleService.save(role);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping(value = "/delete")
    public String delete(Long id) {
        try {
            roleService.delete(id);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }


}
