package com.egencia.codeacademy.databases.neo4j;

import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Session;

public class Neo4jConnection {

    private final Driver driver;
    private final Session session;

    public Neo4jConnection(String host, String login, String password) {
        this.driver = GraphDatabase.driver("bolt://" + host+":7687", AuthTokens.basic(login, password));
        this.session = driver.session();
    }

    public void close() {
        session.close();
        driver.close();
    }

    public Session getSession() {
        return session;
    }
}
