package com.webapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class AltaPeliculas {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/peliculas";
        String usuario = "root";
        String pass = "Root";
        Connection conexion = null;
        Statement statement = null;
        PreparedStatement declaracion = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, pass);
            System.out.println("Conexion exitosa");

            String insertarPeliculas = "INSERT INTO pelislatam (nombre_pais, nombre_pelicula) VALUES (?, ?)";
            declaracion = conexion.prepareStatement(insertarPeliculas);
            declaracion.setString(1, "Argentina");
            declaracion.setString(2, "1985");

            int filasInsertadas = declaracion.executeUpdate();
            if (filasInsertadas > 0) {
                System.out.println("Inserción de datos exitosa");
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
