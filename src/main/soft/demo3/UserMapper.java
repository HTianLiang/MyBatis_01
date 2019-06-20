package soft.demo3;

import soft.demo1.pojo.User;
import soft.demo3.pojo.QueryVo;

import java.util.List;

public interface UserMapper {

    /*遵循四个原则
     1、接口方法名 == User.xml中id名
     2、返回值类型 与 Mapper.xml文件中返回值类型要一致
     3、方法的入参类型与Mapper.xml中入参的类型要一致
     4、命名空间绑定此接口
     */
    public User findUserById(Integer id);
    public List<User> findUserByQueryVo(QueryVo vo);

//    查询订单表Orders的所有数据
    public Integer countUser();

    //根据性别与名字查询用户
    public List<User> findUserBySexAndName(User user);
    /*
        根据多个Id查询用户
        法一：
        法二：
        法三：
     */
//    public List<User> findUserByIds(Integer[] ids);
    public List<User> findUserByIds(List<Integer> idlist);
//    public List<User> findUserByIds(QueryVo vo);

}
