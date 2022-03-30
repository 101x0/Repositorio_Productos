package org.sergio.java.jdbc;


import org.sergio.java.jdbc.modelo.Categoria;
import org.sergio.java.jdbc.modelo.Producto;
import org.sergio.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.sergio.java.jdbc.repositorio.Repositorio;
import org.sergio.java.jdbc.util.ConexionBBDD;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        /*Repositorio<Producto> repo = new ProductoRepositorioImpl();

        try (Connection conexion = ConexionBBDD.obtenerConexionBBDD()) {



            System.out.println("---------------Listar--------------");
            repo.listar().forEach(System.out::println);

            System.out.println("---------------Por ID (5)--------------");
            Producto p = repo.porId(5l);
            System.out.println(p);



        } catch (SQLException *//*| ParseException*//* e) {
            e.printStackTrace();
        }*/
    }
}

