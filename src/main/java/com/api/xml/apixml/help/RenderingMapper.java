package com.api.xml.apixml.help;

import java.util.Optional;
import java.util.regex.Matcher;

import org.springframework.stereotype.Component;

import com.api.xml.apixml.model.LogLine;
import com.api.xml.apixml.model.Rendering;
import static java.util.Collections.singletonList;

@Component
public class RenderingMapper {

	private final RenderingHelper helper;

    public RenderingMapper(final RenderingHelper helper) {
        this.helper = helper;
    }

    public Optional<Rendering> map(final LogLine startRenderingLogLine, final LogLine startRenderingReturnLogLine) {
        final Matcher documentAndPageMatcher = helper.getMatcherDocumentAndPage(startRenderingLogLine);
        final Matcher uIDMatcher = helper.getMatcherUID(startRenderingReturnLogLine);

        return Optional.of(Rendering.builder()
                .documentId(documentAndPageMatcher.group(1))
                .page(documentAndPageMatcher.group(2))
                .UID(Integer.valueOf(uIDMatcher.group(1)))
                .commandStarts(singletonList(startRenderingLogLine.getTimestamp()))
                .build());
    }
}
