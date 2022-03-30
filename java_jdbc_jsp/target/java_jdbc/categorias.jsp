<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Categorias</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/estilos.css">
</head>
<body>
        <header>
            <h1>Categorias</h1>
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
                        <h1>Categorias</h1>
                        <a href="${pageContext.request.contextPath}/formCategoria">Añadir</a>
                        <table>
                            <tr>
                                <th>ID</th>
                                <th>Nombre</th>
                            </tr>
                            <c:forEach items="${categorias}" var="c">
                            <tr>
                                <td>${c.id}</td>
                                <td>${c.nombre}</td>
                                <td class="editar"><a href="${pageContext.request.contextPath}/formCategoria?id=${c.id}">Editar</a></td>
                            </tr>
                            </c:forEach>
                        </table>
                    </div>

            </section>
        </div>

        <footer>
            <h5>&copy Sergio de Diego, 2022</h5>
            <p>sergio.de.diego.ter@gmail.com</p>
        </footer>

</body>
</html>












