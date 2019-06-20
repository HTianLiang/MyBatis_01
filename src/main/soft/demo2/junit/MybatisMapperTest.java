package soft.demo2.junit;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import soft.demo1.pojo.User;
import soft.demo2.UserMapper;

import java.io.IOException;
import java.io.InputStream;

public class MybatisMapperTest {

    @Test
    public void test() throws IOException {
        //加载核心配置文件
        String resource = "soft/demo2/SqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        //创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //SqlSession帮我生成一个实现类（给接口）
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.findUserById(26);
        System.out.println(user);
    }

}
