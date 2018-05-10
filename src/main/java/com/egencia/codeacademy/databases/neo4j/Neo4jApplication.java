package com.egencia.codeacademy.databases.neo4j;


import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class Neo4jApplication {

//	public static void main(String[] args) {
//		SpringApplication.run(Neo4jApplication.class, args);
//	}

	public static void main(String[] args) {
		Neo4jConnection connection = new Neo4jConnection("localhost", "neo4j", "codeacademy");
		Session session = connection.getSession();
		session.run("CREATE (:Lesson {name:\"neo4j\", date:\"15 may 2018\"})");

		StatementResult result = session.run("MATCH (p:Person) return p LIMIT 25");

		while(result.hasNext()) {
			Record record = result.next();
			System.out.println(record.get("p").asNode().get("name"));
		}

		session.close();
	}
}
