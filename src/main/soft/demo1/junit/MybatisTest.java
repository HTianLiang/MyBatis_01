package soft.demo1.junit;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import soft.demo1.pojo.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;


public class MybatisTest {

    @Test
    public void test() throws IOException {
        //加载核心配置文件
        String resource = "soft/demo1/SqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        //创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession 并打开SqlSession会话
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //执行Sql语句
        User user = sqlSession.selectOne("test.findUserById", 10);
        System.out.println("\n"+user);
    }
    @Test
    //根据用户名模糊查询用户列表
    public void test1() throws IOException {
        //加载核心配置文件
        String resource = "soft/demo1/SqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        //创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //执行Sql语句
        List<User> user1 = sqlSession.selectList("test.findUserByUsername", "王");
        for(User user2:user1){
            /*
                相当于 int i=0;i<user1.length;i++
                        user2=user1.get(i);
             */
            System.out.println("\n"+user2);
        }
    }
    @Test
    //新增用户
    public void test2() throws IOException {
        //加载核心配置文件
        String resource = "soft/demo1/SqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        //创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //执行Sql语句
        User user = new User();
        user.setUsername("龙猫");
        user.setBirthday(new Date());
        user.setSex("猫");
        user.setAddress("火星");
        int i = sqlSession.insert("test.insertUser", user);
        if (i>0){
            System.out.println("Success！");
        }
        sqlSession.commit();//提交
        System.out.println(user.getId());
    }
    @Test
    //修改用户
    public void test3() throws IOException {
        //加载核心配置文件
        String resource = "soft/demo1/SqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        //创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //执行Sql语句
        User user = new User();
        user.setId(28);
        user.setUsername("大龙猫");
        user.setBirthday(new Date());
        user.setSex("猫");
        user.setAddress("喵星");
        int i = sqlSession.update("test.updateUserById",user);
        if (i>0){
            System.out.println("Success！");
        }
        sqlSession.commit();//提交
    }
    @Test
    //删除用户
    public void test4() throws IOException {
        //加载核心配置文件
        String resource = "soft/demo1/SqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        //创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //执行Sql语句
        User user = new User();
        int i = sqlSession.delete("test.deleteUserById",26);
        if (i>0){
            System.out.println("Success！");
        }
        sqlSession.commit();//提交
    }

}
