package com.sponge.painting.service;

import com.sponge.painting.entity.Category;
import com.sponge.painting.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class CategoryService {
    private SqlSession sqlSession;
    private List<Category> categories;
    //获取全部分类
    public List<Category> getCategories()
    {
        try{
            sqlSession=getSqlSession();
            categories=sqlSession.selectList("getCategory");
        }catch (Exception e)
        {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return categories;
    }

    //获取id获取分类
    public Category getCategoryById(Long id)
    {
        Category category=null;
        try{
            sqlSession=getSqlSession();
            category=sqlSession.selectOne("getCategory",id);
        }catch (Exception e)
        {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return category;
    }

    //删除分类
    public int deleteCategory(Long id)
    {
        int count=0;
        try{
            sqlSession=getSqlSession();
            count=sqlSession.delete("deleteCategory",id);
            sqlSession.commit();
        }catch (Exception e)
        {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return count;
    }

    //添加分类
    public int addCategory(Category category)
    {
        int count=0;
        try{
            sqlSession=getSqlSession();
            count=sqlSession.insert("addCategory",category);
            sqlSession.commit();
        }catch (Exception e)
        {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return count;
    }

    private SqlSession getSqlSession()
    {
        return MybatisUtil.getFactory().openSession();
    }
}
