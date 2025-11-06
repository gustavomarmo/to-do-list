package br.com.gustavomarmo.to_do_list.exception;

public class TaskNotFoundException extends RuntimeException {

    public TaskNotFoundException() { super("ID não encontrado");}

    public TaskNotFoundException(String message) { super(message); }
}
