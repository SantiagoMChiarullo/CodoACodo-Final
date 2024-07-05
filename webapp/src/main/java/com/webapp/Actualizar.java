package com.webapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Actualizar {

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

            String sqlActualizar = "UPDATE actores SET nombre = ?, APELLIDO = ?, peli_actua = ?, fk_pelicula =?  WHERE id_actor = ?";

            declaracion = conexion.prepareStatement(sqlActualizar);

            declaracion.setString(1, "Guillermo");
            declaracion.setString(2, "Francella");
            declaracion.setString(3, "1985");
            declaracion.setInt(4, 2);

            declaracion.setInt(5, 2);

            int filasActualizadas = declaracion.executeUpdate();

            if (filasActualizadas > 0) {
                System.out.println("La actualización se realizó con éxito");
            } else {
                System.out.println("No se pudo realizar la actualización");
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
