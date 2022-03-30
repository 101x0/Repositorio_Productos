package org.sergio.java.jdbc.servicio;

import org.sergio.java.jdbc.modelo.Categoria;
import org.sergio.java.jdbc.modelo.Producto;
import org.sergio.java.jdbc.repositorio.CategoriaRepositorioImpl;
import org.sergio.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.sergio.java.jdbc.repositorio.Repositorio;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class ServicioProductoCategoriaImpl implements ServicioProductoCategoria{

    private Repositorio<Producto> repositorioProd;
    private Repositorio<Categoria> categoriaRepositorio;

    public ServicioProductoCategoriaImpl(Connection conexion) {
        this.repositorioProd = new ProductoRepositorioImpl(conexion);
        this.categoriaRepositorio = new CategoriaRepositorioImpl(conexion);
    }

    @Override
    public List<Producto> listarProducto() {
        return repositorioProd.listar();
    }

    @Override
    public void eliminarProducto(Long id) {
        repositorioProd.eliminar(id);
    }

    @Override
    public Optional<Producto> porIdProducto(Long id) {
        return Optional.ofNullable(repositorioProd.porId(id));
    }

    @Override
    public void guardarProducto(Producto producto) {
        repositorioProd.guardar(producto);
    }



    @Override
    public List<Categoria> listarCategorias() {
        return categoriaRepositorio.listar();
    }

    @Override
    public Optional<Categoria> porIdCategoria(Long id) {
        return Optional.ofNullable(categoriaRepositorio.porId(id));
    }

    @Override
    public void guardarCategoria(Categoria categoria) {
        categoriaRepositorio.guardar(categoria);
    }
}
