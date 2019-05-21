package com.sponge.painting.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtil {
    private static SqlSessionFactory factory;
    private static String resource="Mybatis.xml";
    private static ThreadLocal<SqlSession> threadLocal=new ThreadLocal<>();
    //初始化
    public static void InitMyBatis()
    {
        try {
            InputStream inputStream= Resources.getResourceAsStream(resource);
            factory=new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //获取SqlSession
    public static SqlSessionFactory getFactory()
    {
        return factory;
    }

    //释放资源
    public static void ReleaseMyBatis()
    {
        SqlSession sqlSession=threadLocal.get();
        if(sqlSession!=null)
        {
            sqlSession.close();
            threadLocal.set(null);
        }
    }
}
