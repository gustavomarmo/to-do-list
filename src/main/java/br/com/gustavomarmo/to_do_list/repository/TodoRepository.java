package br.com.gustavomarmo.to_do_list.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.gustavomarmo.to_do_list.model.Todo;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

}