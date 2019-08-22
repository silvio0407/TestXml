package com.api.xml.apixml.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import org.springframework.data.annotation.Id;

import lombok.Builder;
import lombok.Getter;

@Builder(toBuilder = true)
@Getter
@XmlAccessorType(XmlAccessType.FIELD)
public class Rendering {

	@Id
    private final String UID;
    private final String documentId;
    private final String page;
    private final List<String> commandStarts;
    private final List<String> commandGetRenderings;
}
