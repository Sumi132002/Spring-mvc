package todo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import todo.dto.Task;
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
	public String login(@RequestParam String email, @RequestParam String password, ModelMap model,
			HttpSession session) {
		return service.login(email, password, model, session);
	}

	@PostMapping("addtask")
	public String addTask(Task task, @RequestParam String day, ModelMap model, HttpSession session) {
		return service.addTask(task, day, model, session);
	}

	@GetMapping("/logout")
	public String logout(HttpSession session, ModelMap model) {
		session.invalidate();
		model.put("pass", "Logged out Success");
		return "Login.jsp";

	}
}
