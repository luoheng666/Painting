package com.sponge.painting.utils;

import javax.servlet.http.Cookie;

public class CookieUtil {
    public static Cookie getCookie(Cookie[] cookies,String name)
    {
        if(null!=cookies&&cookies.length>0&&null!=name&&!"".equals(name))
        {
            for(Cookie cookie:cookies)
            {
                if(cookie.getName().equals(name))
                {
                    return cookie;
                }

            }
        }
        return null;
    }
}
