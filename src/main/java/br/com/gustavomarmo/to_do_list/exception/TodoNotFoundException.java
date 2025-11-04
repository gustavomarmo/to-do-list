package br.com.gustavomarmo.to_do_list.exception;

public class TodoNotFoundException extends RuntimeException {

    public TodoNotFoundException() { super("A tarefa não foi encontrada"); }

    public TodoNotFoundException(String message) { super(message); }

}
