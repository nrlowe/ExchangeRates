package com.exr.cli.ExchangeRates.Utilities;

import java.util.Arrays;
import java.util.concurrent.BlockingQueue;

import com.exr.cli.ExchangeRates.Common.Phrases;

public class UserInput {
    public void addOrRemoveExistingRates(BlockingQueue<String> input){
        try{
            System.out.println(Phrases.ADD_OR_REMOVE);
            String userInput = input.take();
            if(!userInput.isBlank() && userInput != null){
                int ycount = (int) Arrays.stream(Phrases.YES).filter(x -> x.equals(userInput.toUpperCase())).count();
                int ncount = (int) Arrays.stream(Phrases.NO).filter(x -> x.equals(userInput.toUpperCase())).count();
                if(ycount > 0){
                    
                } else if(ncount > 0){

                }
            }
            //parse
        } catch (Exception ex){

        }
    }
}
