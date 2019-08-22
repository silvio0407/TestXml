package com.api.xml.apixml.help;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.api.xml.apixml.exceptions.NotFoundDocumentAndPageException;
import com.api.xml.apixml.exceptions.NotFoundUIDException;
import com.api.xml.apixml.model.LogLine;
import com.api.xml.apixml.model.Rendering;

import static java.util.Collections.singletonList;

@Component
public class RenderingHelper {

	private static final Pattern DOCUMENT_AND_PAGE_PATTERN = Pattern.compile("\\[(\\d+),\\s(\\d+)]");
    private static final Pattern UID_PATTERN = Pattern.compile("(\\d+-\\d+)");

    public Matcher getMatcherDocumentAndPage(LogLine logLine) {
        final Matcher documentAndPageMatcher = DOCUMENT_AND_PAGE_PATTERN.matcher(logLine.getMessage());
        if (!documentAndPageMatcher.find()) {
            throw new NotFoundDocumentAndPageException();
        }
        return documentAndPageMatcher;
    }

    public Matcher getMatcherUID(LogLine logLine) {
        final Matcher uIDMatcher = UID_PATTERN.matcher(logLine.getMessage());
        if (!uIDMatcher.find()) {
            throw new NotFoundUIDException();
        }
        return uIDMatcher;
    }

    public Rendering updateGetRendering(final String timestampLine, final Rendering renderingSaved) {
        Rendering rendering = renderingSaved;
        if (rendering.getCommandGetRenderings() == null) {
            rendering = rendering.toBuilder().commandGetRenderings(singletonList(timestampLine)).build();
        } else {
            rendering.getCommandGetRenderings().add(timestampLine);
        }
        return rendering;
    }

    public Rendering updateStartRendering(final String timestampLine, final Rendering startRendering) {
        Rendering rendering = startRendering;
        if (rendering.getCommandStarts() == null) {
            rendering = rendering.toBuilder().commandStarts(singletonList(timestampLine)).build();
        } else {
            rendering.getCommandStarts().add(timestampLine);
        }
        return rendering;
    }
}
