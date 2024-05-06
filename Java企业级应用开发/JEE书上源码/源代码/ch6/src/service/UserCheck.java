package service;
import dto.User;
public class UserCheck {
	// ÑéÖ¤µÇÂ½
	public boolean validate(User user) {
		if (user != null && user.getName().equals("JSPMVC")) {
			if (user.getPwd().equals("MVC")) {
				return true;
			}
			return false;
		}
		return false;
	}
}
