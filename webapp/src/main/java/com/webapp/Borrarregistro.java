package com.webapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Borrarregistro {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/peliculas";
        String usuario = "root";
        String pass = "Root";

        Connection conexion = null;
        PreparedStatement declaracion = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, pass);
            System.out.println("Conexión exitosa");

            String sqlBorrar = "DELETE FROM actores WHERE id_actor = ?";

            declaracion = conexion.prepareStatement(sqlBorrar);

            declaracion.setInt(1, 2);

            int filasEliminadas = declaracion.executeUpdate();

            if (filasEliminadas > 0) {
                System.out.println("Fila eliminada con éxito");
            } else {
                System.out.println("No se pudo eliminar el registro");
            }

        } catch (Exception e) {
            e.printStackTrace();

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
