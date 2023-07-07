package todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TodoController {

	@RequestMapping("signup")
	@ResponseBody
	public String signup() {
		return "This is Signup Logic method";
	}
}
