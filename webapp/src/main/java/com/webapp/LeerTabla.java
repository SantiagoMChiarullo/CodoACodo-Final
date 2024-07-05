package com.webapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LeerTabla {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/peliculas";
        String usuario = "root";
        String pass = "Root";

        Connection conexion = null;

        Statement declaracion = null;

        ResultSet resultado = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, pass);
            System.out.println("conexión a base de datos: EXITOSA");

            declaracion = conexion.createStatement();
            String sqlTabla = "SELECT * FROM pelislatam";
            resultado = declaracion.executeQuery(sqlTabla);

            while (resultado.next()) {
                int id = resultado.getInt("id_pelicula");
                String nombre = resultado.getString("nombre_pelicula");
                String pais = resultado.getString("nombre_pais");

                System.out.print(" ID: " + id + " | ");
                System.out.print(" Título de la película: " + nombre + " | ");
                System.out.print(" País de origen: " + pais + " | ");
                System.out.println(" | ");
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (resultado != null) {
                    resultado.close();
                }
                if (declaracion != null) {
                    declaracion.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException e) {
                System.out.println("Error: " + e);
                e.printStackTrace();
            }

        }
    }
}
