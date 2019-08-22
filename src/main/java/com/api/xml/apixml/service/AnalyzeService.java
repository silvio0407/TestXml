package com.api.xml.apixml.service;

import java.io.IOException;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;

import com.api.xml.apixml.exceptions.ErrorTryingProcessLogFileException;

@Service
public class AnalyzeService {

	private final LogService logService;
	private final ReportService reportService;
	
	public AnalyzeService(LogService logService, ReportService reportService) {
		this.logService = logService;
		this.reportService = reportService;
	}
	
	public void process(final String fileName) {
		try {
            logService.saveRenderingsFrom(fileName);
            reportService.generateXMLReport(Paths.get(fileName));
        } catch (final IOException e) {
            throw new ErrorTryingProcessLogFileException("Error trying to process the log file.", e);
        }
	}
}
