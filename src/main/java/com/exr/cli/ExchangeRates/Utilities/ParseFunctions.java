package com.exr.cli.ExchangeRates.Utilities;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ParseFunctions {
    public void parseFileCRUD(){

    }

    public void addNewRates(String input){
        try(BufferedWriter reader = new BufferedWriter(new FileWriter("rates.txt",true));
            PrintWriter pw = new PrintWriter(reader)){
			pw.write(input);
		} catch(IOException e){
			System.err.println("Error");
		}
    }

    public void parseUserInput(){

    }
}
