import com.rain.mapper.GoodMapper;
import com.rain.pojo.Good;
import com.rain.service.GoodService;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author rain
 * created on 2018/3/23
 */
public class MyBatisAndSpringTest {
    private static AbstractApplicationContext context;

    @BeforeClass
    public static void setUp() {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test
    public void integration() {
        GoodMapper goodMapper = (GoodMapper) context.getBean("goodMapper");
        if (goodMapper != null) {
            Good good = goodMapper.queryGoodByGoodId(1);
            System.out.println(good);
        } else {
            System.out.println("goodMapper is not initial");
        }
    }

    @Test
    public void testService() {
        GoodService goodService = (GoodService) context.getBean("goodService");
        if (goodService != null) {
            System.out.println(goodService.queryGoodByGoodId(1));
        }
    }
}