package org.sergio.java.jdbc.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.sergio.java.jdbc.modelo.Categoria;
import org.sergio.java.jdbc.servicio.ServicioProductoCategoria;
import org.sergio.java.jdbc.servicio.ServicioProductoCategoriaImpl;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/categorias")
public class ListarCategoriasServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conexion = (Connection) req.getAttribute("conn");
        ServicioProductoCategoria servicio = new ServicioProductoCategoriaImpl(conexion);
        List<Categoria> categorias = servicio.listarCategorias();
        req.setAttribute("categorias", categorias);
        getServletContext().getRequestDispatcher("/categorias.jsp").forward(req, resp);


    }
}
