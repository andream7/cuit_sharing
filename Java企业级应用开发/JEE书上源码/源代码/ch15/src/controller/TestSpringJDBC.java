package controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import dao.TestDao;
import pojo.MyUser;
@Controller
public class TestSpringJDBC {
	@Autowired
	private TestDao testDao;
	@RequestMapping("/jdbcTest")
	public String test() {
		String insertSql = "insert into usertable values(?,?)";
		//数组param的值与insertSql语句中?一一对应
		Object param1[] = {"chenheng1", "111"};
		Object param2[] = {"chenheng2", "222"};
		Object param3[] = {"chenheng3", "333"};
		Object param4[] = {"chenheng4", "444"};
		//添加用户
		testDao.update(insertSql, param1);
		testDao.update(insertSql, param2);
		testDao.update(insertSql, param3);
		testDao.update(insertSql, param4);
		//查询用户
		String selectSql ="select * from usertable";
		List<MyUser> list = testDao.query(selectSql, null);
		for(MyUser mu : list) {
			System.out.println(mu);
		}
		return "jdbcTest";
	}
}
