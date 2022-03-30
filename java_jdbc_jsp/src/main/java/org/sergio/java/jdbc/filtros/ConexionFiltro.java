package org.sergio.java.jdbc.filtros;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import org.sergio.java.jdbc.util.ConexionBBDD;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebFilter("/*")
public class ConexionFiltro implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try (Connection conexion = ConexionBBDD.obtenerConexionBBDD()){

            try {
                request.setAttribute("conn", conexion);
                chain.doFilter(request, response);
                conexion.commit();
            }catch (SQLException e){
                conexion.rollback();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
