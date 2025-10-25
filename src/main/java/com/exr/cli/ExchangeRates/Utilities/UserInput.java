package com.exr.cli.ExchangeRates.Utilities;

import java.util.concurrent.BlockingQueue;

public class UserInput {
    public void addOrRemoveExistingRates(BlockingQueue<String> input){
        try{
            String userInput = input.take();
            //parse
        } catch (Exception ex){

        }
    }
}
