import com.rain.mapper.OrderMapper;
import com.rain.mapper.UserMapper;
import com.rain.pojo.Order;
import com.rain.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author rain
 * created on 2018/3/22
 */
public class WayOfAnnotationTest {
    private static SqlSessionFactoryBuilder sqlSessionFactoryBuilder;
    private static SqlSessionFactory sqlSessionFactory;
    private static String config = "mybatis-config.xml";

    static {
        sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        try {
            InputStream inputStream = Resources.getResourceAsStream(config);
            sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSelectOfUser() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.queryUserByUserId(1);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void testOneToOne() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        iterator(orderMapper.queryOrdersOfUser());
        sqlSession.close();
    }

    @Test
    public void testOneToMany() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = sqlSession.getMapper(UserMapper.class).queryOrdersOfTheUser(1);
        System.out.println(user);
        sqlSession.close();
    }

    private <T> void iterator(List<T> objects) {
        for (Object object : objects) {
            System.out.println(object);
        }
    }
}