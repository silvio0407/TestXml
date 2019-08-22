package com.api.xml.apixml.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.api.xml.apixml.model.Rendering;

@Repository
public interface RenderingRepository extends MongoRepository<Rendering, String> {

	List<Rendering> findTop100ByUID();
}
