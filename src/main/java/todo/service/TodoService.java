package todo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

import todo.dao.TodoDao;
import todo.dto.Task;
import todo.dto.UserInfo;

@Component
public class TodoService {

	@Autowired
	TodoDao dao;

	public String signup(UserInfo userInfo, ModelMap model) {
		if (dao.findByEmail(userInfo.getEmail()) == null) {
			dao.save(userInfo);
			model.put("pass", "Account Created Succesfully");
			return "Login.jsp";
		} else {
			model.put("fail", "Email you entered already exists, should be unique");
			return "Signup.jsp";
		}

	}

	public String login(String email, String password, ModelMap model, HttpSession session) {
		UserInfo userInfo = dao.findByEmail(email);
		if (userInfo == null) {
			model.put("fail", "Incorrect Email");
			return "Login.jsp";
		} else {
			if (userInfo.getPassword().equals(password)) {
				session.setAttribute("userInfo", userInfo);
				model.put("pass", "Login Success");
				List<Task> list=userInfo.getTasks();
				if(list==null)
				{
					list=new ArrayList<Task>();
				}
				model.put("list", list);
				return "TodoHome.jsp";
			} else {
				model.put("fail", "Incorrect Password");
				return "Login.jsp";
			}
		}
	}

	public String addTask(Task task, String day, ModelMap model, HttpSession session) {
		task.setDate(LocalDate.parse(day));
		UserInfo info = (UserInfo) session.getAttribute("userInfo");
		if(info==null)
		{
			model.put("fail", "Invalid Session");
			return "Login.jsp";
		}
		else {
		dao.save(task);
		List<Task> list=info.getTasks();
	
		if(list==null)
		list=new ArrayList<Task>();
			
		list.add(task);
		info.setTasks(list);
		
		dao.save(info);
		
		model.put("pass", "Task Added Success");
		model.put("list", info.getTasks());
		return "TodoHome.jsp";
		}
	}

	public String changeStatus(HttpSession session, ModelMap model, int id) {
		UserInfo info = (UserInfo) session.getAttribute("userInfo");
		if(info==null)
		{
			model.put("fail", "Invalid Session");
			return "Login.jsp";
		}
		else {
			Task task=dao.findById(id);
			
			if(task.isStatus())
				task.setStatus(false);
			else
				task.setStatus(true);
			
			dao.update(task);
			
			model.put("pass", "Status Changed Success");
			model.put("list", info.getTasks());
			return "TodoHome.jsp";
		}
	}

	public String deleteTask(HttpSession session, ModelMap model, int id) {
		UserInfo info = (UserInfo) session.getAttribute("userInfo");
		if(info==null)
		{
			model.put("fail", "Invalid Session");
			return "Login.jsp";
		}
		else {
			Task task=dao.findById(id);
			info.getTasks().remove(task);
			dao.update(info);
			
			dao.delete(task);
			model.put("pass", "Task Deleted Success");
			model.put("list", info.getTasks());
			return "TodoHome.jsp";
			
		}
	}

	public String update(HttpSession session, ModelMap model, int id) {
		UserInfo info = (UserInfo) session.getAttribute("userInfo");
		if(info==null)
		{
			model.put("fail", "Invalid Session");
			return "Login.jsp";
		}
		else {
			Task task=dao.findById(id);
			model.put("task", task);
			return "Update.jsp";
			
		}
	}

	public String updateTask(Task task, String day, ModelMap model, HttpSession session) {
		task.setDate(LocalDate.parse(day));
		UserInfo info = (UserInfo) session.getAttribute("userInfo");
		if(info==null)
		{
			model.put("fail", "Invalid Session");
			return "Login.jsp";
		}
		else {
		dao.update(task);
		
		model.put("pass", "Task Updated Success");
		model.put("list", info.getTasks());
		return "TodoHome.jsp";
	}
	}
}
