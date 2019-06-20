package soft.demo3.junit;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import soft.demo1.pojo.User;
import soft.demo3.OrdersMapper;
import soft.demo3.UserMapper;
import soft.demo3.pojo.Orders;
import soft.demo3.pojo.QueryVo;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MybatisMapperTest {

    private static String resource;
    private static InputStream in;
    private static SqlSessionFactory sqlSessionFactory;
    private static SqlSession sqlSession;

    static {
        resource = "soft/demo3/SqlMapConfig.xml";
        in = null;
        try {
            //加载核心配置文件
            in = Resources.getResourceAsStream(resource);
            //创建SqlSessionFactory
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
            //创建SqlSession
            sqlSession = sqlSessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testMapperQueryVo(){
        //SqlSession帮我生成一个实现类（给接口）
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        QueryVo vo = new QueryVo();
        User user = new User();
        user.setUsername("五");
        vo.setUser(user);

        List<User> us = userMapper.findUserByQueryVo(vo);
        for (User u:us) {
            System.out.println(u);
        }
    }
    @Test
    //查询数据条数
    public void testcount(){
        //SqlSession帮我生成一个实现类（给接口）
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        Integer i = userMapper.countUser();
        System.out.println(i);
    }
    @Test
    //查询订单表Orders的所有数据
    public void testOrderscount(){
        //SqlSession帮我生成一个实现类（给接口）
        OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);

        List<Orders> i = ordersMapper.selectOrdersList();
        for (Orders order : i) {
            System.out.println(order);
        }
    }
    @Test
    //根据性别和名称查询用户
    public void testByUserSexAndName(){
        //SqlSession帮我生成一个实现类（给接口）
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setSex("1");
        user.setUsername("陈小明");
        List<User> userList = userMapper.findUserBySexAndName(user);
        for (User users:userList) {
            System.out.println(users);
        }
    }
    @Test
    /*
        根据多个Id查询用户
        findUserByIds(QueryVo vo)方法实现
     */
    /*public void testByIds(){
        //SqlSession帮我生成一个实现类（给接口）
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(16);
        list.add(22);
        QueryVo vo = new QueryVo();
        vo.setIdlist(list);
        List<User> userList = userMapper.findUserByIds(vo);
        for (User users:userList) {
            System.out.println(users);
        }
    }*/
    /*
        根据多个Id查询用户
        findUserByIds(Integer[] ids)方法实现
     */
    /*public void testByIds(){
        //SqlSession帮我生成一个实现类（给接口）
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        Integer[] ids = new Integer[3];
        ids[0] = 10;
        ids[1] = 16;
        ids[2] = 22;
        List<User> userList = userMapper.findUserByIds(ids);
        for (User users:userList) {
            System.out.println(users);
        }
    }*/
    /*
        根据多个Id查询用户
        findUserByIds(List<Integer> idlist)方法实现
     */
    public void testByIds(){
        //SqlSession帮我生成一个实现类（给接口）
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(16);
        list.add(22);
        List<User> userList = userMapper.findUserByIds(list);
        for (User users:userList) {
            System.out.println(users);
        }
    }
    @Test
    //一对多关联
    public void testUserList(){
        OrdersMapper mapper = sqlSession.getMapper(OrdersMapper.class);

        List<soft.demo3.pojo.User> userList = mapper.selectUserList();
        for (soft.demo3.pojo.User user:userList) {
            if (user.getId()!=null){
                System.out.println(user);
            }
        }
    }

}
