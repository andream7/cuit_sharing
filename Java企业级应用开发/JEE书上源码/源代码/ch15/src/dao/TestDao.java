package dao;
import java.util.List;
import pojo.MyUser;
public interface TestDao {
	public int update(String sql, Object[] param);
	public List<MyUser> query(String sql, Object[] param);
}
