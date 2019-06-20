package soft.demo3.pojo;

import soft.demo1.pojo.User;

import java.io.Serializable;
import java.util.List;

public class QueryVo implements Serializable {

    private static final long serialVersionUID =1L;

    private User user;
    private Integer[] ids;
    private List<Integer> idlist;

    public Integer[] getIds() {
        return ids;
    }

    public void setIds(Integer[] ids) {
        this.ids = ids;
    }

    public List<Integer> getIdlist() {
        return idlist;
    }

    public void setIdlist(List<Integer> idlist) {
        this.idlist = idlist;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
