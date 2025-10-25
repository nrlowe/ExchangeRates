package com.exr.cli.ExchangeRates;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.exr.cli.ExchangeRates.Utilities.UserInput;

@SpringBootApplication
public class ExchangeRatesApplication {

	public static void main(String[] args) {
		exchangeRateMain();
	}

	@Autowired
	static
	UserInput userInput;

	public static void exchangeRateMain(){
		BlockingQueue<String> input = new LinkedBlockingQueue<>();
		Thread inputThread = new Thread(() -> {
			try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
				String line;
				while((line = br.readLine()) != null){
					if(!line.isEmpty()){
						input.offer(line);
					}
				}
			} catch (IOException ex) {
				System.out.println(ex.getLocalizedMessage());
			}
		}, "input-thread");
		inputThread.start();

		System.out.println("Welcome to Exchange Rate CLI, the following rates have been logged");
		System.out.println("####");

		try(BufferedReader reader = new BufferedReader(new FileReader("rates.txt"))){
			String line;
			while((line = reader.readLine()) != null){
				System.out.println(line);
			}
		} catch(IOException e){
			System.err.println("Error");
		}
		userInput.addOrRemoveExistingRates(input);
	}

}
