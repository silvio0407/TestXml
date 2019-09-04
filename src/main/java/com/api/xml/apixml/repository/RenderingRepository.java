package com.api.xml.apixml.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.xml.apixml.model.Render;
import com.api.xml.apixml.model.Rendering;

/*import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.api.xml.apixml.model.Rendering;*/

@Repository
public interface RenderingRepository extends JpaRepository<Rendering, Integer> /*extends MongoRepository<Rendering, String>*/ {

	//List<Rendering> findTop100ByUID();
}
