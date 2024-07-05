package com.webapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class crearBDyTabla {

    //importacion de librerias
    public static void main(String[] args) {
        //delcaramos variables

        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String pass = "Root";

//declaramos objetos que nos ayudan con la conexion y sentencias SQL
        Connection connection = null;

        Statement statement = null;

        try {

//cargar controlador jdbc
            Class.forName("com.mysql.cj.jdbc.Driver");

//Conectamos al server
            connection = DriverManager.getConnection(url, user, pass);

// inicializar statement(para realizar declaraciones en SQL)
            statement = connection.createStatement();

//Creamos al abase de datos y sus tablas
            String sql = "CREATE DATABASE IF NOT EXISTS peliculas";
//ejecutamos la sentencia

            statement.executeUpdate(sql);

            System.out.println("La base de datos peliculas fue creada o ya existe");

//Nos conectamos a la base de datos mis_usuarios
            connection = DriverManager.getConnection(url + "peliculas", user, pass);
            statement = connection.createStatement();

//Creamos tablas si no existen
            String crearTablaSQL = "CREATE TABLE IF NOT EXISTS pelislatam (id_pelicula INT PRIMARY KEY AUTO_INCREMENT, nombre_pais VARCHAR(150) NOT NULL, nombre_pelicula VARCHAR(150) NOT NULL)";

//Ejecutamos la clausula o statement SQL 
            statement.executeUpdate(crearTablaSQL);

            System.out.println("Tabla creada o ya existe");

            String crearTablaSQL2 = "CREATE TABLE IF NOT EXISTS actores (id_actor INT PRIMARY KEY AUTO_INCREMENT, nombre VARCHAR(255) NOT NULL, APELLIDO varchar(255) NOT NULL, peli_actua VARCHAR(100) NOT NULL, fk_pelicula INT, FOREIGN KEY (fk_pelicula) REFERENCES pelislatam(id_pelicula))";

            statement.executeUpdate(crearTablaSQL2);

            System.out.println("Tabla creada o ya existe.");

        } catch (ClassNotFoundException e) {

            System.out.println(e);

        } catch (SQLException e) {
            System.out.println(e);

        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
