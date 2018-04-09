package com.egencia.codeacademy.databases.postgresql.jdbc;

import com.egencia.codeacademy.databases.postgresql.jdbc.model.Traveler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SimpleJDBC {
    private Connection connection;

    public List<Traveler> findAllTravelers() throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("SELECT * from \"Traveler\"");
        ResultSet rs = stmt.executeQuery();
        List<Traveler> travelers = new ArrayList<>();
        while(rs.next()) {
            long travelerId = rs.getLong(1);
            String travelerName = rs.getString(2);
            travelers.add(new Traveler(travelerId, travelerName));
        }
        return travelers;
    }

    public void connectToDB() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(
                "jdbc:postgresql://ddomanine-code-academy.cbbfapy28unu.us-west-2.rds.amazonaws.com:5432/jdbctest",
                "masteruser",
                "123456A_");
    }

    public void shutDown() throws SQLException {
        connection.close();
    }

    public Traveler insertTraveler(Traveler traveler) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("INSERT INTO \"Traveler\" (traveler_name) VALUES ('titi')", Statement.RETURN_GENERATED_KEYS);
        int nbUpdated = stmt.executeUpdate();
        System.out.println("updated " + nbUpdated + " rows");
        ResultSet keys = stmt.getGeneratedKeys();
        keys.next();
        long generatedKey = keys.getLong(1);
        traveler.setTravelerId(generatedKey);
        return traveler;
    }
}
