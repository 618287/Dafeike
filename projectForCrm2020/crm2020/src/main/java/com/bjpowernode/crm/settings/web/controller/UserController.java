package com.bjpowernode.crm.settings.web.controller;


import com.bjpowernode.crm.commons.contants.ReturnFinal;
import com.bjpowernode.crm.commons.domain.ReturnObject;
import com.bjpowernode.crm.commons.utils.CookieTool;
import com.bjpowernode.crm.commons.utils.DateUtils;
import com.bjpowernode.crm.commons.utils.MD5Util;
import com.bjpowernode.crm.settings.domain.User;
import com.bjpowernode.crm.settings.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * ************
 * 暗月     *********
 * **    *   *
 * **********
 * <p>
 * 2021/6/3
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    //cookie判断
    @RequestMapping("/settings/qx/user/toLogin")
    public String cookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        String loginAct = null;
        String loginPwd = null;

        for (Cookie cookie : cookies) {
            if ("loginAct".equals(cookie.getName())) {
                loginAct = cookie.getValue();
                continue;
            }
            if ("loginPwd".equals(cookie.getName())) {
                loginPwd = cookie.getValue();
            }
        }
        if (loginAct != null && loginPwd != null) {
            Map<String, Object> returnMap = new HashMap<>();
            returnMap.put("loginAct", loginAct);
            returnMap.put("loginPwd", MD5Util.getMD5(loginPwd));
            User user = userService.selectVerify(returnMap);
            if (user == null) {
                return "settings/qx/user/login";
            } else {
                if (loginPwd.equals(user.getLoginPwd())) {
                    return "settings/qx/user/login";
                }
                //判断会员截至日期
                if (DateUtils.formatDateTime(new Date()).compareTo(user.getExpireTime()) > 0) {
                    return "settings/qx/user/login";
                    //判断账户状态
                } else if ("0".equals(user.getLockState()) && user.getLockState() == null) {
                    return "settings/qx/user/login";
                }
                request.getSession().setAttribute(ReturnFinal.SESSION_USER, user);
                return "redirect:/workbench/index.do";
            }


        }
        return "settings/qx/user/login";
    }


    //登陆验证
    @RequestMapping(value = "/settings/qx/user/login", method = RequestMethod.POST)
    @ResponseBody
    public Object indexUser(
            String loginAct, String loginPwd, Boolean isRemPwd,
            HttpServletResponse response,
            HttpServletRequest request) {


        //返回一个对象
        Map<String, Object> returnMap = new HashMap<>();
        returnMap.put("loginAct", loginAct);
        returnMap.put("loginPwd", loginPwd);
        //service返回处理结果
        User user = userService.selectVerify(returnMap);
        //创建返回对象
        ReturnObject object1 = new ReturnObject();

        System.out.println(request.getRemoteAddr());


        if (user == null) {
            //判断用户名和密码
            object1.setMessage("输错了！");
            return object1.setCode(ReturnFinal.MISTAKE);
        } else {
            if (!MD5Util.getMD5(loginPwd).equals(user.getLoginPwd())) {
                object1.setMessage("输错了！");
                return object1.setCode(ReturnFinal.MISTAKE);
            }

            //判断会员截至日期
            if (DateUtils.formatDateTime(new Date()).compareTo(user.getExpireTime()) > 0) {
                object1.setMessage("充钱吧，韭菜");
                return object1.setCode(ReturnFinal.MISTAKE);
            } else if ("0".equals(user.getLockState()) && user.getLockState() == null) {
                //判断用户状态是否异常
                object1.setMessage("你瞎搞被封号了！");
                return object1.setCode(ReturnFinal.MISTAKE);
                //取得用户的ip地址
            } else if (!user.getAllowIps().contains(request.getRemoteAddr())) {
                //判断ip地址是否正确
                object1.setMessage("你的ip在月球吗？你必须把月球搬到你家才登录！");
                return object1.setCode(ReturnFinal.MISTAKE);
            } else {
                //验证成功，颁发User
                request.getSession().setAttribute(ReturnFinal.SESSION_USER, user);
                if (isRemPwd) {
                    //第二种情况：用户未持有cookie，但验证成功，并选择下次使用cookie，颁发cookie
                    //颁发cookie
                    CookieTool.addCookie(response, user);

                } else {
                    //第四种情况：用户未持有cookie，验证通过，但并未选择使用cookie,清除cookie
                    CookieTool.deleteCookie(response);
                }
            }
        }
        return object1.setCode(ReturnFinal.CORRECT);
    }

    @RequestMapping("settings/qx/user/logout")
    public String exit(HttpServletResponse response,HttpServletRequest request){
        CookieTool.deleteCookie(response);
        request.getSession(false).invalidate();

        return "redirect:/workbench/index.do";
    }















}
