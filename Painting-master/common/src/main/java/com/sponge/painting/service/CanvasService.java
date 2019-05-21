package com.sponge.painting.service;

import com.sponge.painting.entity.Canvas;
import com.sponge.painting.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CanvasService {
    private SqlSession sqlSession;
    private List<Canvas> canvas;
    //获取全部油画
    public List<Canvas> getCanvas()
    {
        try{
            sqlSession=getSqlSession();
            canvas=sqlSession.selectList("getCanvas");
        }catch (Exception  e)
        {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return canvas;
    }

    //根据页数获取油画
    public List<Canvas> getCanvasByPage(int page,int count)
    {
        Map<String,Object> map=new HashMap<>();
        try{
            sqlSession=getSqlSession();
            map.put("skip",count*(page-1));
            map.put("count",count);
            canvas=sqlSession.selectList("getCanvas",map);
        }catch (Exception e)
        {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return canvas;
    }


    //根据页数和id来获取油画
    public List<Canvas> getCanvasByPageAndCategoryId(Long categoryId,int page,int count)
    {
        Map<String,Object> map=new HashMap<>();
        try{
            sqlSession=getSqlSession();
            map.put("skip",count*(page-1));
            map.put("count",count);
            map.put("categoryId",categoryId);
            canvas=sqlSession.selectList("getCanvas",map);
        }catch (Exception e)
        {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return canvas;
    }

    //获取油画的数量
    public int getCanvasCount()
    {
        List<Integer> integers=null;
        try{
            sqlSession=getSqlSession();
            integers=sqlSession.selectList("getCanvasCount");
        }catch (Exception e)
        {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return integers.get(0);
    }

    //根据目录id获取油画
    public List<Canvas> getCanvasByCategoryId(Long categoryId)
    {
        try{
            sqlSession=getSqlSession();
            canvas=sqlSession.selectList("getCanvasByCategoryId",categoryId);
        }catch (Exception e)
        {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return canvas;
    }

    //根据目录id获取油画数量
    public int getCanvasCountByCategoryId(Long categoryId)
    {
        List<Integer> list=null;
        try{
            sqlSession=getSqlSession();
            list=sqlSession.selectList("getCanvasCountByCategoryId",categoryId);
        }catch (Exception e)
        {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return list.get(0);
    }

    //添加油画
    public int addCanvas(Canvas canvas)
    {
        int count=0;
        try {
            sqlSession=getSqlSession();
            count=sqlSession.insert("addCanvas",canvas);
            sqlSession.commit();
        }catch (Exception e)
        {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return count;
    }

    //删除油画
    public int deleteCanvas(Long id)
    {
        int count=0;
        try{
           sqlSession=getSqlSession();
           count=sqlSession.delete("deleteCanvas",id);
           sqlSession.commit();
        }catch (Exception e)
        {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return count;
    }

    //获取油画图片
    public Canvas getCanvasImage(Long id)
    {
        Canvas canvas=null;
        try {
            sqlSession=getSqlSession();
            canvas=sqlSession.selectOne("getCanvasImage",id);
        }catch (Exception e)
        {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return canvas;
    }

    //根据id获取油画
    public Canvas getCanvasById(Long id)
    {
        Canvas canvas=null;
        try{
            sqlSession=getSqlSession();
            canvas=sqlSession.selectOne("getCanvasById",id);
        }catch (Exception e)
        {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return canvas;
    }

    private SqlSession getSqlSession()
    {
        return MybatisUtil.getFactory().openSession();
    }
}
