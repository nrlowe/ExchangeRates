package com.exr.cli.ExchangeRates.Utilities;

import java.util.Arrays;
import java.util.concurrent.BlockingQueue;

import org.springframework.beans.factory.annotation.Autowired;

import com.exr.cli.ExchangeRates.Common.Phrases;

public class UserInput {

    @Autowired
    static
    ParseFunctions parseFunctions;

    public static void addOrRemoveExistingRates(BlockingQueue<String> input){
        try{
            System.out.println(Phrases.ADD_OR_REMOVE);
            String userInput = input.take();
            if(!userInput.isBlank() && userInput != null){
                int ycount = (int) Arrays.stream(Phrases.YES).filter(x -> x.equals(userInput.toUpperCase())).count();
                int ncount = (int) Arrays.stream(Phrases.NO).filter(x -> x.equals(userInput.toUpperCase())).count();
                if(ycount > 0){
                    parseFunctions.parseNewUserInput(input);
                } else if(ncount > 0){
                    //go to customer input
                }
            }
            //parse
        } catch (Exception ex){

        }
    }
}
