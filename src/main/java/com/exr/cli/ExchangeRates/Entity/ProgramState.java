package com.exr.cli.ExchangeRates.Entity;

public class ProgramState {
    public static boolean isMenu;
    public static boolean isCrudOperation;
    public static boolean isConsumerState;

    ProgramState(){
        ProgramState.isMenu = true;
        ProgramState.isCrudOperation = false;
        ProgramState.isConsumerState = false;
    }

    public static void flipMenuState(){
        ProgramState.isMenu = ProgramState.isMenu ? false : true;
    }

    public static void flipCrudOps(){
        ProgramState.isCrudOperation = ProgramState.isCrudOperation ? false : true;
    }

    public static void flipConsumerState(){
        ProgramState.isConsumerState = ProgramState.isConsumerState ? false : true;
    }
}
