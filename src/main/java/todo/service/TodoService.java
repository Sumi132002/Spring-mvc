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
	
	public String signup(UserInfo userInfo, ModelMap model)
	{
		dao.save(userInfo);
		model.put("pass", "Account Created Succesfully");
		return "Login.jsp";
	}
}
