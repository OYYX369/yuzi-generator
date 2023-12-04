package com.yupi;


import com.yupi.cli.CommandExecutor;
import com.yupi.cli.pattern.Command;

public class Main {

    public static void main(String[] args) {
        args = new String[]{"generate", "-l", "-a", "-o"};
//        args = new String[]{"config"};
//        args = new String[]{"list"};
        CommandExecutor  commandExecutor = new CommandExecutor();
        commandExecutor.doExecute(args);
    }
}
