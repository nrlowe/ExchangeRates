package com.exr.cli.ExchangeRates;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExchangeRatesApplication {

	public static void main(String[] args) {
		exchangeRateMain();
	}

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

		//add or delete to file
		try(BufferedWriter writer = new BufferedWriter(new FileWriter("rates.txt", true));
			PrintWriter pw = new PrintWriter(writer)){
			String content = input.take();
			pw.println(content);
		} catch(Exception ex){
			System.err.println("Error");
		}
	}

}
