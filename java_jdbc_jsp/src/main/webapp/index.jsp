<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Inicio</title>
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/estilos.css">

</head>
<body>
        <header><h1>Inicio</h1></header>
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
                <h2>Section</h2>
                <p>Vivamus at urna enim. Ut dui magna, interdum non sollicitudin vel, molestie a nulla. Mauris ac nisi quis magna porttitor sagittis ac sed dui. Pellentesque et sem fermentum, lacinia nulla ac, mattis odio. Integer sed diam enim. Donec commodo placerat vehicula. Praesent vel luctus velit. Pellentesque blandit quam ac justo pretium vulputate. Suspendisse at sapien vestibulum, venenatis ipsum ut, tincidunt sem. Pellentesque rutrum hendrerit enim quis imperdiet. Aliquam turpis justo, dapibus eget tempus sit amet, porta sit amet orci. Phasellus ipsum urna, hendrerit vitae dui a, mattis porttitor nisi. Duis scelerisque erat eget condimentum tempor. Maecenas efficitur mattis blandit.</p>
                <p>Duis vitae vestibulum justo. Aliquam placerat nunc libero, eget interdum eros sollicitudin in. Integer sit amet lectus dignissim nibh porttitor venenatis vitae id mauris. Nullam consectetur tortor felis, quis aliquet dolor aliquet sed. Mauris dapibus urna eget eleifend dictum. Vivamus vehicula massa vitae mauris gravida, ac consectetur erat pharetra. Vestibulum sollicitudin, ante non ultrices interdum, velit sapien congue est, nec tempor metus nisl eu ipsum. Nulla facilisi. Pellentesque tincidunt condimentum lorem, vulputate tincidunt sapien dignissim et.</p>
            </section>
        </div>

        <footer>
            <h5>&copy Sergio de Diego, 2022</h5>
            <p>sergio.de.diego.ter@gmail.com</p>
        </footer>
</body>
</html>