package com.example.paintBackend.undoRedo;

public interface ICommand {

    void execute();
    void unExecute();
}
