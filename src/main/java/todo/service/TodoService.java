package todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

import todo.dao.TodoDao;
import todo.dto.UserInfo;

@Component
public class TodoService {

	@Autowired
	TodoDao dao;

	public String signup(UserInfo userInfo, ModelMap model) {
		// if (dao.save(userInfo)) {
		// model.put("pass", "Account Created Succesfully");
		// return "Login.jsp";
		// } else {
		// model.put("fail", "Email you entered already exists, should be unique");
		// return "Signup.jsp";
		// }

		if (dao.findByEmail(userInfo.getEmail()) == null) {
			dao.save(userInfo);
			model.put("pass", "Account Created Succesfully");
			return "Login.jsp";
		} else {
			model.put("fail", "Email you entered already exists, should be unique");
			return "Signup.jsp";
		}

	}

	public String login(String email, String password, ModelMap model) {
		UserInfo userInfo=dao.findByEmail(email);
		if(userInfo==null)	
		{
			model.put("fail", "Incorrect Email");
			return "Login.jsp";
		}
		else {
			if(userInfo.getPassword().equals(password))
			{
				model.put("pass", "Login Success");
				return "TodoHome.jsp";
			}
			else {
				model.put("fail", "Incorrect Password");
				return "Login.jsp";
			}
		}
	}
}
