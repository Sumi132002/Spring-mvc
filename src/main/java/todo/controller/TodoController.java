package todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import todo.dto.UserInfo;
import todo.service.TodoService;

@Controller
public class TodoController {

	@Autowired
	TodoService service;

	@PostMapping("signup")
	public String signup(UserInfo userInfo, ModelMap model) {
		return service.signup(userInfo, model);
	}
	
	@PostMapping("login")
	public String login(@RequestParam String email,@RequestParam String password,ModelMap model)
	{
		return service.login(email,password,model);
	}
}
