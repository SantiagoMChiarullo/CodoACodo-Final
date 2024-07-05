package com.webapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PruebaConexion {

    public static void main(String[] args) {
        // declaracion e iniciacion de variables
        String url = "jdbc:mysql://localhost:3306/peliculas";
        String usuario = "root";
        String pass = "Root";
        // declaramos un objeto connection
        Connection conexion = null;
        // Establecemos la conexion dentro de un try-catch
        try {
            // cargar el driver jdbc
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, pass);
            System.out.println("conexion exitosa a workbench");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (SQLException e) {
            System.out.println(e);
        } finally {

            try {
                if (conexion != null) {
                    conexion.close();
                    System.out.println("Conexion cerrada");
                }

            } catch (SQLException e) {
                System.out.println("Error: " + e);
                e.printStackTrace();

            }

        }

    }
}
