package com.imooc.controller.shiro;

import com.imooc.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by yangqj on 2017/4/21.
 */
@Controller
public class HomeController {
    @RequestMapping(value="/login",method= RequestMethod.GET)
    public String login(){
        return "/shiro/login";
    }

    @RequestMapping(value="/login",method=RequestMethod.POST)
    public String login(HttpServletRequest request, User user, Model model){
        if (StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword())) {
            request.setAttribute("msg", "用户名或密码不能为空！");
            return "login";
        }
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(user.getUsername(),user.getPassword());
        if(request.getParameter("rememberMe")!=null){
            token.setRememberMe(true);
        }
        try {
            subject.login(token);
            return "redirect:usersPage";
        }catch (LockedAccountException lae) {
            token.clear();
            request.setAttribute("msg", "用户已经被锁定不能登录，请与管理员联系！");
            return "login";
        } catch (AuthenticationException e) {
            token.clear();
            request.setAttribute("msg", "用户或密码不正确！");
            return "login";
        }
    }
    @RequestMapping(value={"/usersPage",""})
    public String usersPage(){
        return "shiro/user/users";
    }

    @RequestMapping("/rolesPage")
    public String rolesPage(){
        return "shiro/role/roles";
    }

    @RequestMapping("/resourcesPage")
    public String resourcesPage(){
        return "shiro/resources/resources";
    }

    @RequestMapping("/403")
    public String forbidden(){
        return "shiro/403";
    }
}
