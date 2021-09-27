<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<body>
<header class="page-header">
    <nav class="navbar navbar-expand-lg justify-content-around">
        <a href="/" class="navbar-brand main-logo">
            Zaplanuj <span>Jedzonko</span>
        </a>
        <ul class="nav nounderline text-uppercase">
            <li class="nav-item ml-4">
                <a class="nav-link color-header" href="/login">logowanie</a>
            </li>
            <li class="nav-item ml-4">
                <a class="nav-link color-header" href="/register">rejestracja</a>
            </li>
            <li class="nav-item ml-4">
                <a class="nav-link" href="/about">o aplikacji</a>
            </li>
            <li class="nav-item ml-4">
                <a class="nav-link disabled" href="/recipes">Przepisy</a>
            </li>
            <li class="nav-item ml-4">
                <a class="nav-link disabled" href="/contact">Kontakt</a>
            </li>
            <li>
                <%  HttpSession sess = request.getSession();
                    if (sess.getAttribute("adminID")!=null) {%>
                <a href="/dashboard">
                    <div class="circle-div text-center">
                        <i class="fas fa-user icon-user"></i>
                    </div>
                </a>
                <% } %>
            </li>
        </ul>
    </nav>
</header>