package com.dstvdm.bamf.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by pscot on 3/2/2016.
 */

import com.dstvdm.bamf.model.Person;
import com.dstvdm.bamf.model.Team;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.orient.OrientGraph;
import com.tinkerpop.blueprints.impls.orient.OrientVertexType;

@Component
public class PersonRepository  {

	@Autowired
	private OrientGraph graph;
	
	public String addPerson(Person person) {
		OrientVertexType vertexType = graph.getVertexType("Person");
    	if(vertexType == null) {
    		graph.createVertexType("Person");
    		
    	}
    	Vertex p = graph.addVertex("Person", "Person");
    	Object id = p.getId();
    	
    	p.setProperty("firstName", person.getFirstName());
    	p.setProperty("lastName", person.getLastName());
    	graph.commit();
    	
    	return id.toString();
	}
	
    public Iterable<Vertex> findByFirstName(String firstName) {
    	return graph.getVertices("firstName", firstName); 
    }
	
    public List<Person> findByTeam(Team team) {
		return null;
    	
    }
    
    public void createIndexes() {
    	//graph.createKeyIndex("firstName", Vertex.class);
    	//graph.createKeyIndex("lastName", Vertex.class);
    	
    }
}