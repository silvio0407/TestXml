package com.api.xml.apixml.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Render {

	@Id
	private Integer id;
	private String nome;
}
