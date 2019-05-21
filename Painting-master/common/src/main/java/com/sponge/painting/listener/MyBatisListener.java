package com.sponge.painting.listener;

import com.sponge.painting.utils.MybatisUtil;
import org.omg.CORBA.Context;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyBatisListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        MybatisUtil.InitMyBatis();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        MybatisUtil.ReleaseMyBatis();
    }
}
