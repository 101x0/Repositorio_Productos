package org.sergio.java.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBBDD {
    private static String url = "jdbc:mysql://localhost:3306/java?serverTimeZone=Europe/Madrid";
    private static String username = "root";
    private static String password = "sasa";
    private static Connection conexion;

    public static Connection obtenerConexionBBDD() throws SQLException {
        if (conexion == null) {
            return DriverManager.getConnection(url, username, password);
        }
        return conexion;
    }


}
