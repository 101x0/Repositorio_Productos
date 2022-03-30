package org.sergio.java.jdbc.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.sergio.java.jdbc.modelo.Categoria;
import org.sergio.java.jdbc.modelo.Producto;
import org.sergio.java.jdbc.servicio.ServicioProductoCategoria;
import org.sergio.java.jdbc.servicio.ServicioProductoCategoriaImpl;

import java.io.IOException;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@WebServlet("/form")
public class FormProductoServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        ServicioProductoCategoria servicio = new ServicioProductoCategoriaImpl(conn);
        Long id;
        try {
            id = Long.valueOf(req.getParameter("id"));
        } catch (NumberFormatException nfe) {
            id = 0l;
            nfe.printStackTrace();
        }

        List<Categoria> categorias = servicio.listarCategorias();

        Optional<Producto> producto = servicio.porIdProducto(id);
        req.setAttribute("producto", producto.orElse(new Producto()));
        req.setAttribute("categorias", categorias);
        getServletContext().getRequestDispatcher("/formProductos.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        ServicioProductoCategoria servicio = new ServicioProductoCategoriaImpl(conn);

        String nombre = req.getParameter("nombre");
        Integer precio = Integer.valueOf(req.getParameter("precio"));
        String fechaStr = req.getParameter("fecha");
        LocalDate fecha = LocalDate.parse(fechaStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        Long idCategoria = Long.valueOf(req.getParameter("categoria"));
        Categoria categoria = servicio.porIdCategoria(idCategoria).get();

        Long id;
        try {
            id = Long.valueOf(req.getParameter("id"));
        }catch (NumberFormatException nfe){
            id = 0L;
            nfe.printStackTrace();
        }
        Producto p = new Producto();
        p.setId(id);
        p.setNombre(nombre);
        p.setPrecio(precio);
        p.setFecha_registro(fecha);
        p.setCategoria(categoria);
        servicio.guardarProducto(p);
        resp.sendRedirect(req.getContextPath() + "/prod");
    }
}
