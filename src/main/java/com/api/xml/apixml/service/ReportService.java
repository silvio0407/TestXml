package com.api.xml.apixml.service;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.api.xml.apixml.help.XMLHelper;
import com.api.xml.apixml.model.Rendering;
import com.api.xml.apixml.model.Report;
import com.api.xml.apixml.model.Summary;
import com.api.xml.apixml.repository.RenderingRepository;

@Service
public class ReportService {

	private final RenderingRepository repository;
    private final XMLHelper xmlHelper;

    public ReportService(final RenderingRepository repository, final XMLHelper xmlHelper) {
        this.repository = repository;
        this.xmlHelper = xmlHelper;
    }

    public void generateXMLReport(final Path path) {
        xmlHelper.createXMLReport(path, mountReport());
    }

    private Report mountReport() {
        List<Rendering> renderings = new ArrayList<>();
        Integer unnecessary = 0;
        Integer duplicates = 0;

       /* for (Rendering rendering : repository.findAll()) {
            if (rendering.getCommandStarts() != null) {
                if (rendering.getCommandGetRenderings() == null) {
                    unnecessary++;
                    continue;
                }
                if (rendering.getCommandStarts().size() > 1) {
                    duplicates++;
                }
            }
            renderings.add(rendering);
        }*/

        Summary summary = Summary.builder()
                .count(renderings.size() + unnecessary)
                .duplicates(duplicates)
                .unnecessary(unnecessary).build();
        return new Report(renderings, summary);
    }
}
