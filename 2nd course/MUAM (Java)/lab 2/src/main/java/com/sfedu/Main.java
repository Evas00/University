package com.sfedu;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:postgresql://localhost:5432/demo";
        String userName = "postgres";
        String password = "perec1512";
        try{
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(
                    jdbcURL,
                    userName,
                    password
            );
            Statement statement = connection.createStatement();
            String selectSQL = "SELECT * FROM aircrafts;";
            ResultSet resultSet = statement.executeQuery(selectSQL);

            while (resultSet.next()){
                System.out.println(
                        "aircraft_code: " + resultSet.getString("aircraft_code")+
                        ", model: " + resultSet.getString("model")+
                        ", range: " + resultSet.getString("range")
                );
            }
            connection.close();
        } catch (Exception ignored){    }
    }
}