import com.sponge.painting.entity.Canvas;
import com.sponge.painting.entity.Category;
import com.sponge.painting.service.CanvasService;
import com.sponge.painting.service.CategoryService;
import com.sponge.painting.utils.MybatisUtil;
import org.junit.Test;

import java.util.List;

public class MybatisTest {
    @Test
    public void demo()
    {
        MybatisUtil.InitMyBatis();
        CategoryService service=new CategoryService();
        List<Category> categories=service.getCategories();
        for(Category category:categories)
        {
            System.out.println(category);
        }
    }

    @Test
    public void demo2()
    {
        MybatisUtil.InitMyBatis();
        CanvasService service=new CanvasService();
        int count=service.getCanvasCountByCategoryId(Long.valueOf(1));
        System.out.println(count);
    }

    @Test
    public void demo3()
    {
        MybatisUtil.InitMyBatis();
        CanvasService service=new CanvasService();
        List<Canvas> canvas=service.getCanvasByPageAndCategoryId(Long.valueOf(1),2,2);
        for (Canvas canvas1:canvas)
        {
            System.out.println(canvas1);
        }
    }

    @Test
    public void demo4()
    {
        MybatisUtil.InitMyBatis();
        CategoryService service=new CategoryService();
        Category category=service.getCategoryById(Long.valueOf(1));
        System.out.println(category);
    }
}
