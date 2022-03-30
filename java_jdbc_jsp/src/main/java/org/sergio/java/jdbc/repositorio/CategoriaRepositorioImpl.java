package org.sergio.java.jdbc.repositorio;

import org.sergio.java.jdbc.modelo.Categoria;
import org.sergio.java.jdbc.modelo.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaRepositorioImpl implements Repositorio<Categoria> {

    private Connection conexion;

    public CategoriaRepositorioImpl(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public List<Categoria> listar() {
        List<Categoria> categorias = new ArrayList<>();
        try (Statement stmt = conexion.createStatement();
             ResultSet resul = stmt.executeQuery("select * from categorias")) {
            while (resul.next()) {
                categorias.add(crearCategoriaDesdeBBDD(resul));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categorias;
    }


    @Override
    public Categoria porId(Long id) {
        Categoria categoria = null;
        try (PreparedStatement stmt = conexion.prepareStatement("select * from categorias as c where c.id=?")) {
            stmt.setLong(1, id);
            ResultSet resul = stmt.executeQuery();
            if (resul.next()) {
                categoria = crearCategoriaDesdeBBDD(resul);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return categoria;
    }

    @Override
    public void guardar(Categoria categoria) {
        String sql = "";
        if (categoria.getId() != null && categoria.getId() > 0) {
            sql = "UPDATE categorias SET nombre = ? WHERE id=?";
        } else {
            sql = "INSERT INTO categorias (nombre) VALUES(?)";
        }
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, categoria.getNombre());

            if (categoria.getId() != null && categoria.getId() > 0) {
                stmt.setLong(2, categoria.getId());
            }
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(Long id) {

    }

    private Categoria crearCategoriaDesdeBBDD(ResultSet resul) throws SQLException {
        Categoria categoria = new Categoria();
        categoria.setId(resul.getLong(1));
        categoria.setNombre(resul.getString(2));
        return categoria;
    }
}