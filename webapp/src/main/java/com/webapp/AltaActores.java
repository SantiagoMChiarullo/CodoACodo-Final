package com.webapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class AltaActores {

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
            String insertarActor = "INSERT INTO actores (nombre, APELLIDO, peli_actua, fk_pelicula) VALUE (?,?,?,?)";
            declaracion = conexion.prepareStatement(insertarActor);
            declaracion.setString(1, "Ricardo");
            declaracion.setString(2, "Darin");
            declaracion.setString(3, "1985");
            declaracion.setString(4, "2");
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
