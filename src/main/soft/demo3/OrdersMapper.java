package soft.demo3;


import soft.demo3.pojo.Orders;
import soft.demo3.pojo.User;

import java.util.List;

public interface OrdersMapper {

    //查询订单orders的所有数据
    public List<Orders> selectOrdersList();

    //一对一关联查询 以订单为中心，关联用户
    public List<Orders> selectOrders();
    //一对多关联
    public List<User> selectUserList();

}
