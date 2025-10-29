package br.com.gustavomarmo.to_do_list.repository;

import org.springframework.data.jpa.repository.JpaRepository;

// Importo o package inteiro ou somente a minha entity?
import br.com.gustavomarmo.to_do_list.entity.Todo;
import org.springframework.stereotype.Repository;

// Sempre são interfaces que extendem o JPA??
// Toda classe tem que ter uma anotação, tanto para o colega quanto o Spring saber
@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

}