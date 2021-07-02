package com.bjpowernode.crm.commons.utils;

import com.bjpowernode.crm.settings.domain.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * ************
 * 暗月     *********
 * **    *   *
 * **********
 * <p>
 * 2021/6/3
 */
public class CookieTool {


    //添加cookie
    public static void addCookie(HttpServletResponse response, User user) {
        Cookie cookieName = new Cookie("loginAct", user.getLoginAct());
        cookieName.setMaxAge(60*60*24*10);
        response.addCookie(cookieName);
        Cookie cookiePsW = new Cookie("loginPwd", MD5Util.getMD5(user.getLoginPwd()));
        cookiePsW.setMaxAge(60*60*24*10);
        response.addCookie(cookiePsW);
    }


    //清除cookie
    public static void deleteCookie(HttpServletResponse response){
        Cookie cookieName = new Cookie("loginAct", null);
        cookieName.setMaxAge(0);
        response.addCookie(cookieName);
        Cookie cookiePsW = new Cookie("loginPwd",null);
        cookiePsW.setMaxAge(0);
        response.addCookie(cookiePsW);
    }
}
