package service;
import org.springframework.stereotype.Service;
import pojo.UserForm;
//注解为一个服务
@Service
public class UserServiceImpl implements UserService{
	@Override
	public boolean login(UserForm user) {
		if("zhangsan".equals(user.getUname()) 
				&& "123456".equals(user.getUpass()))
			return true;
		return false;
	}
	@Override
	public boolean register(UserForm user) {
		if("zhangsan".equals(user.getUname()) 
				&& "123456".equals(user.getUpass()))
			return true;
		return false;
	}
}
