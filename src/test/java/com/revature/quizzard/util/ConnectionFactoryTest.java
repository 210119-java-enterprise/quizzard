package com.revature.quizzard.util;

import java.sql.Connection;

public class ConnectionFactoryTest {

    public static void main(String[] args) {
        Connection conn = ConnectionFactory.getInstance().getConnection();
        if (conn != null) {
            System.out.println("Connection established!");
        } else {
            System.out.println("Could not obtain connection to DB!");
        }
    }
}
