package todo.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import todo.dto.UserInfo;

@Component
public class TodoDao {

	@Autowired
	EntityManager manager;

	public void save(UserInfo userInfo) {
		manager.getTransaction().begin();
		manager.persist(userInfo);
		manager.getTransaction().commit();
	}

}
