package com.rohitwebAppToDo.todo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//<Bean operating on, Primary key type>
public interface TodoRepository extends JpaRepository<Todo, Long> {

	public List<Todo> findByUsername(String username);
}
