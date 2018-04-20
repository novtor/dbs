package com.egencia.codeacademy.databases.postgresql;

import com.egencia.codeacademy.databases.postgresql.jdbc.SimpleJDBC;
import com.egencia.codeacademy.databases.postgresql.jdbc.model.Traveler;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostgresqlJDBCTest {

	private static SimpleJDBC simpleJDBCService = new SimpleJDBC();

	@BeforeClass
	public static void init() throws SQLException, ClassNotFoundException {
		simpleJDBCService.connectToDB();
	}

	@AfterClass
	public static void shutDown() throws SQLException {
		simpleJDBCService.shutDown();
	}


	@Test
	public void insertTraveler() throws SQLException {
		Traveler traveler = new Traveler("titi");
		Traveler savedTraveler = simpleJDBCService.insertTraveler(traveler);
		System.out.println(savedTraveler);
	}

	@Test
	public void getAllTravelers() throws SQLException {
		List<Traveler> travelers = simpleJDBCService.findAllTravelers();
		System.out.println("found travelers:");
		travelers.forEach(System.out::println);
	}

}
