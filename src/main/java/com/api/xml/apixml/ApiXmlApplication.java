package com.api.xml.apixml;

import static java.lang.System.exit;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.api.xml.apixml.service.AnalyzeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class ApiXmlApplication implements CommandLineRunner {

	private final AnalyzeService analyzeService;
	
	public ApiXmlApplication(final AnalyzeService analyzeService) {
        this.analyzeService = analyzeService;
    }
	
	public static void main(String[] args) {
		SpringApplication.run(ApiXmlApplication.class, args);
	}
	
	@Override
	public void run(final String... args) {
		log.info("Please enter the filename: ");
		final Scanner scanner = new Scanner(System.in);
		
		if(scanner.hasNext()) {
			System.out.println("analyzing data....");
			analyzeService.process(scanner.nextLine());
		}
		log.info("Log analyzed successfuly. Resulted saved!");
		exit(0);
	}

}
