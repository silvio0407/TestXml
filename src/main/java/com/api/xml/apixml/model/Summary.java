package com.api.xml.apixml.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@XmlAccessorType(XmlAccessType.FIELD)
public class Summary {

	private final Integer count;
    private final Integer duplicates;
    private final Integer unnecessary;
}
