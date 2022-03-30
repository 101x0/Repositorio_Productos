<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Productos</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/estilos.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Tangerine&display=swap" rel="stylesheet">
</head>
<body>
        <header>
            <h1>Productos</h1>
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
                        <a href="${pageContext.request.contextPath}/form">Añadir</a>
                        <table>
                            <tr>
                                <th>ID</th>
                                <th>Nombre</th>
                                <th>Precio</th>
                                <th>Fecha Registro</th>
                                <th>Categoria</th>
                            </tr>
                            <c:forEach items="${productos}" var="p">
                            <tr>
                                <td>${p.id}</td>
                                <td>${p.nombre}</td>
                                <td>${p.precio}</td>
                                <td>${p.fecha_registro}</td>
                                <td>${p.categoria.nombre}</td>
                                <td class="editar"><a href="${pageContext.request.contextPath}/form?id=${p.id}">Editar</a></td>
                                <td class="eliminar"><a href="${pageContext.request.contextPath}/eliminar?id=${p.id}" onclick="return confirm('¿Eliminar este producto?')">Eliminar</a></td>

                            </tr>
                            </c:forEach>
                        </table>
                    </div>

            </section>
        </div>

        <footer>
            <section>
                <p>sergio.de.diego.ter@gmail.com</p>
            </section>
            <p class="nombre">&copy Sergio de Diego, 2022</p>
        </footer>

</body>
</html>












