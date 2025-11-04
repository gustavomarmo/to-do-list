package br.com.gustavomarmo.to_do_list.exception;

public class TaskNotFoundException extends RuntimeException {

    public TaskNotFoundException() { super("A tarefa não foi encontrada"); }

    public TaskNotFoundException(String message) { super(message); }

}
