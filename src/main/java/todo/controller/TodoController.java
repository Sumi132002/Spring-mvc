package todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;

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
}
