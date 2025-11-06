package br.com.gustavomarmo.to_do_list.exception;

public class TaskNotFoundException extends RuntimeException {

    public TaskNotFoundException(Long id) { super("ID not found: " + id);}

    public TaskNotFoundException(String message) { super(message); }
}
