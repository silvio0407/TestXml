package com.api.xml.apixml.help;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import org.springframework.stereotype.Component;

import com.api.xml.apixml.model.LogLevel;
import com.api.xml.apixml.model.LogLine;

@Component
public class LogLineFactory {

	 private static final String TIME_STAMP_PATTERN = "^\\d{4}-\\d{2}-\\d{2}\\s[\\d:.]*"; // ^\d{4}-\d{2}-\d{2} [\d:.]* - (^\d{4}-\d{2}-\d{2}) ([\d:.]*) +[A-Z]{4,5}
	    private static final String THREAD_PATTERN = "[A-Z]{4,5}";
	    private static final String LOG_LEVEL_PATTERN = "[a-zA-Z]+";
	    private static final String MESSAGE_SENDER_CLASS_PATTERN = "[a-zA-Z$]{40}";
	    private static final String MESSAGE_PATTERN = "[0-9a-zA-Z'.\\s\\[$\\]\\(;:-]+";
	    private static final Pattern LOG_LINE_PATTERN = Pattern.compile("(" + TIME_STAMP_PATTERN + ")\\s+(" + THREAD_PATTERN + ")\\s+[0-9]{5}\\s[-]{3}\\s[\\[\\s]+" +
	            "(" + LOG_LEVEL_PATTERN + ")]\\s(" + MESSAGE_SENDER_CLASS_PATTERN + ")[\\s:]+(" + MESSAGE_PATTERN + ")\\)*");
	    

	    public Optional<LogLine> buildFrom(final String line) {
	        final Matcher matcher = LOG_LINE_PATTERN.matcher(line);

	        if (matcher.find()) {
	            return Optional.of(LogLine.builder()
	                    .timestamp(matcher.group(1))
	                    .thread(matcher.group(3))
	                    .logLevel(LogLevel.valueOf(matcher.group(2)))
	                    .messageSenderClass(matcher.group(5))
	                    .message(matcher.group(4))
	                    .build());
	        }
	        return Optional.empty();
	    }
}
//