package org.sergio.java.jdbc.repositorio;

import org.sergio.java.jdbc.modelo.Categoria;
import org.sergio.java.jdbc.modelo.Producto;
import org.sergio.java.jdbc.util.ConexionBBDD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepositorioImpl implements Repositorio<Producto> {

    private Connection conexion;

    public ProductoRepositorioImpl(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public List<Producto> listar() {
        List<Producto> productos = new ArrayList<>();
        try (Statement stmt = conexion.createStatement();
             ResultSet resul = stmt.executeQuery("select p.*, c.nombre as categoria from productos as p " +
                     "inner join categorias as c on (p.categoria_id = c.id) order by p.id")) {
            while (resul.next()) {
                productos.add(crearProductoDesdeBBDD(resul));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productos;
    }


    @Override
    public Producto porId(Long id) {
        Producto p = null;
        try (PreparedStatement stmt = conexion.prepareStatement("select p.*, c.nombre as categoria from productos as p " +
                "inner join categorias as c on (p.categoria_id = c.id) where p.id=?")) {
            stmt.setLong(1, id);
            ResultSet resul = stmt.executeQuery();
            if (resul.next()) {
                p = crearProductoDesdeBBDD(resul);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return p;
    }

    @Override
    public void guardar(Producto producto) {
        String sql = "";
        if (producto.getId() != null && producto.getId() > 0) {
            sql = "UPDATE productos SET nombre = ?, precio=?, categoria_id=?, fecha_registro=? WHERE id=?";
        } else {
            sql = "INSERT INTO productos (nombre, precio, categoria_id, fecha_registro) VALUES(?,?,?,?)";
        }
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, producto.getNombre());
            stmt.setInt(2, producto.getPrecio());
            stmt.setLong(3, producto.getCategoria().getId());
            stmt.setDate(4, Date.valueOf(producto.getFecha_registro()));

            if (producto.getId() != null && producto.getId() > 0) {
                stmt.setLong(5, producto.getId());
            }
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(Long id) {
        try (PreparedStatement stmt = conexion.prepareStatement("delete from productos where id = ?")) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Producto crearProductoDesdeBBDD(ResultSet resul) throws SQLException {
        Producto p = new Producto();
        p.setId(resul.getLong(1));
        p.setNombre(resul.getString(2));
        p.setPrecio(resul.getInt(3));
        p.setFecha_registro(resul.getDate(4).toLocalDate());
        Categoria categoria = new Categoria();
        categoria.setId(resul.getLong("categoria_id"));
        categoria.setNombre(resul.getString("categoria"));
        p.setCategoria(categoria);
        return p;
    }


}
