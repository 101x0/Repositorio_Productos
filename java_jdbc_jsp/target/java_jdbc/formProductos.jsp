<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Formulario</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/estilos.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Tangerine&display=swap" rel="stylesheet">
</head>
<body>
<header>
        <h1>Formulario de productos</h1>
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
                <form action="${pageContext.request.contextPath}/form" method="post">
                    <table class="tablaEditar">
                        <tr>
                            <td><label for="nombre">Producto</label></td>
                            <td><input type="text" name="nombre" id="nombre" value="${producto.nombre}"></td>
                        </tr>

                        <tr>
                            <td><label for="precio">Precio</label></td>
                            <td><input type="text" name="precio" id="precio" value="${producto.precio}"></td>
                        </tr>

                        <tr>
                            <td><label for="fecha">Fecha</label></td>
                            <td><input type="date" name="fecha" id="fecha" value="${producto.fecha_registro}"></td>
                        </tr>

                        <tr>
                           <td><label for="">Categoria</label></td>
                           <td>
                                <select name="categoria" id="categoria">
                                    <option value="">--Categoria--</option>

                                    <c:forEach items="${categorias}" var="c">
                                        <option value="${c.id}" ${c.id.equals(producto.categoria.id) ? "selected" : ""}>${c.nombre}</option>
                                    </c:forEach>
                                </select>
                           </td>
                        </tr>

                    </table>

                    <input id ="guardar" type="submit" value="Guardar"/>
                    <input type="hidden" name="id" value="${producto.id}"/>
                </form>
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