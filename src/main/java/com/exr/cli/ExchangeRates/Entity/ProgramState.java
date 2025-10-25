package com.exr.cli.ExchangeRates.Entity;

public class ProgramState {
    private boolean isMenu;
    private boolean isCrudOperation;
    private boolean isConsumerState;

    ProgramState(){
        this.isMenu = true;
        this.isCrudOperation = false;
        this.isConsumerState = false;
    }

    public void flipMenuState(){
        this.isMenu = this.isMenu ? false : true;
    }

    public void flipCrudOps(){
        this.isCrudOperation = this.isCrudOperation ? false : true;
    }

    public void flipConsumerState(){
        this.isConsumerState = this.isConsumerState ? false : true;
    }
}
