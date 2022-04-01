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
import java.util.List;
import java.util.Optional;

@WebServlet("/formCategoria")
public class FormCategoriaServlet extends HttpServlet {


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

        Categoria categoria = servicio.porIdCategoria(id).orElse(new Categoria());
        req.setAttribute("categoria", categoria);
        getServletContext().getRequestDispatcher("/formCategorias.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        ServicioProductoCategoria servicio = new ServicioProductoCategoriaImpl(conn);

        String nombre = req.getParameter("nombre");

        Long id;
        try {
            id = Long.valueOf(req.getParameter("id"));
        }catch (NumberFormatException nfe){
            id = 0L;
            nfe.printStackTrace();
        }
        Categoria c = new Categoria();
        c.setId(id);
        c.setNombre(nombre);

        servicio.guardarCategoria(c);
        resp.sendRedirect(req.getContextPath() + "/categorias");
    }
}
