package org.sergio.java.jdbc.servicio;

import org.sergio.java.jdbc.modelo.Categoria;
import org.sergio.java.jdbc.modelo.Producto;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface ServicioProductoCategoria {
    List<Producto> listarProducto();
    void eliminarProducto(Long id);
    Optional<Producto> porIdProducto(Long id);
    void guardarProducto(Producto producto);

    List<Categoria> listarCategorias();
    Optional<Categoria> porIdCategoria(Long id);
    void guardarCategoria(Categoria categoria);
}
