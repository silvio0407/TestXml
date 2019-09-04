package com.api.xml.apixml.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Getter
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Rendering {

	@javax.persistence.Id
    private  Integer UID;
    private  String documentId;
    private  String page;
    @Transient private  List<String> commandStarts;
    @Transient private  List<String> commandGetRenderings;
}
