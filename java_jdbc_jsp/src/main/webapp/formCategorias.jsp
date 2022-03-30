<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Formulario</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/estilos.css">
</head>
<body>
<header>
        <h1>Formulario de categorias</h1>
        </header>
        <nav>
            <a href="${pageContext.request.contextPath}/index.jsp">Home</a>
            <a href="${pageContext.request.contextPath}/prod">Ver productos</a>
            <a href="${pageContext.request.contextPath}/categorias">Ver categorias</a>
            <a href="#">Contacto</a>
        </nav>

        <div class="row">
            <aside>
                <h2>Aside</h2>
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Rerum unde ab veritatis numquam aperiam facilis voluptate! Nisi adipisci voluptatibus non eligendi vel, itaque, labore voluptatem, obcaecati unde quam quis repellat?</p>
            </aside>
            <section>
             <div class="principal">
                <h1>Productos</h1>
                <form action="${pageContext.request.contextPath}/formCategoria" method="post">
                    <table>
                        <tr>
                            <td><label for="nombre">Nombre categoria</label></td>
                            <td><input type="text" name="nombre" id="nombre" value="${categoria.nombre}"></td>
                        </tr>
                    </table>

                    <input type="submit" value="Guardar"/>
                    <input type="hidden" name="id" value="${categoria.id}"/>
                </form>
             </div>

            </section>
        </div>

        <footer>
            <h5>&copy Sergio de Diego, 2022</h5>
            <p>sergio.de.diego.ter@gmail.com</p>
        </footer>

</body>
</html>