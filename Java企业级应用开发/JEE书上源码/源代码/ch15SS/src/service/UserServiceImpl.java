package service;
import java.util.ArrayList;
import org.springframework.stereotype.Service;
import pojo.User;
@Service
public class UserServiceImpl implements UserService{
	//使用静态集合变量users模拟数据库
	private static ArrayList<User> users = new ArrayList<User>();
	@Override
	public boolean addUser(User u) {
		if(!"IT民工".equals(u.getCarrer())){//不允许添加IT民工
			users.add(u);
			return true;
		}
		return false;
	}
	@Override
	public ArrayList<User> getUsers() {
		return users;
	}
}
