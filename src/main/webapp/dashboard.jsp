<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="/header.jsp"/>
<jsp:include page="/topsection_login.jsp"/>
<jsp:include page="/sidemenu_login.jsp"/>

<div class="m-4 p-4 width-medium">
    <div class="dashboard-header m-4">
        <div class="dashboard-menu">
            <div class="menu-item border-dashed">
                <a href="/app/recipe/add">
                    <i class="far fa-plus-square icon-plus-square"></i>
                    <span class="title">dodaj przepis</span> </a>
                </a>
            </div>
            <div class="menu-item border-dashed">
                <a href="/app/plan/add">
                    <i class="far fa-plus-square icon-plus-square"></i>
                    <span class="title">dodaj plan</span>
                </a>
            </div>
            <div class="menu-item border-dashed">
                <a href="app/plan/list">
                    <i class="far fa-plus-square icon-plus-square"></i>
                    <span class="title">dodaj przepis do planu</span>
                </a>
            </div>
        </div>

        <div class="dashboard-alerts">
            <div class="alert-item alert-info">
                <i class="fas icon-circle fa-info-circle"></i>
                <span class="font-weight-bold">Liczba przepisów: ${nrOfMeals}</span>
            </div>
            <div class="alert-item alert-light">
                <i class="far icon-calendar fa-calendar-alt"></i>
                <span class="font-weight-bold">Liczba planów: ${nrOfPlans}</span>
            </div>
        </div>
    </div>
    <div class="m-4 p-4 border-dashed">
        <h2 class="dashboard-content-title">
            <span>Ostatnio dodany plan: ${lastPlanName}</span>
        </h2>
        <c:if test="${not empty lastPlanMon}">
        <table class="table">
            <thead>
            <tr class="d-flex">
                <th class="col-2">Poniedziałek</th>
                <th class="col-8"></th>
                <th class="col-2"></th>
            </tr>
            </thead>
                <c:forEach var="item" items="${lastPlanMon}" varStatus="loop">
            <tbody>
            <tr class="d-flex">
                <td class="col-2">${item.mealName}</td>
                <td class="col-8">${item.recipeName}
                </td>
                <td class="col-2">
                    <a href="/recipe/details?id=${item.id}&url=/dashboard">
                        <button type="button" class="btn btn-primary rounded-0">Szczegóły
                        </button>
                    </a>
                </td>
            </tr>
            </tbody>
                </c:forEach>
        </table>
        </c:if>
        <c:if test="${not empty lastPlanTue}">
            <table class="table">
                <thead>
                <tr class="d-flex">
                    <th class="col-2">Wtorek</th>
                    <th class="col-8"></th>
                    <th class="col-2"></th>
                </tr>
                </thead>
                <c:forEach var="item" items="${lastPlanTue}" varStatus="loop">
                    <tbody>
                    <tr class="d-flex">
                        <td class="col-2">${item.mealName}</td>
                        <td class="col-8">${item.recipeName}
                        </td>
                        <td class="col-2">
                            <a href="/app/recipe/details?id=${item.id}&url=/dashboard">
                                <button type="button" class="btn btn-primary rounded-0">Szczegóły
                                </button>
                            </a>
                        </td>
                    </tr>
                    </tbody>
                </c:forEach>
            </table>
        </c:if>
        <c:if test="${not empty lastPlanWed}">
            <table class="table">
                <thead>
                <tr class="d-flex">
                    <th class="col-2">Środa</th>
                    <th class="col-8"></th>
                    <th class="col-2"></th>
                </tr>
                </thead>
                <c:forEach var="item" items="${lastPlanWed}" varStatus="loop">
                    <tbody>
                    <tr class="d-flex">
                        <td class="col-2">${item.mealName}</td>
                        <td class="col-8">${item.recipeName}
                        </td>
                        <td class="col-2">
                            <a href="/app/recipe/details?id=${item.id}&url=/dashboard">
                                <button type="button" class="btn btn-primary rounded-0">Szczegóły
                                </button>
                            </a>
                        </td>
                    </tr>
                    </tbody>
                </c:forEach>
            </table>
        </c:if>
        <c:if test="${not empty lastPlanThu}">
            <table class="table">
                <thead>
                <tr class="d-flex">
                    <th class="col-2">Czwartek</th>
                    <th class="col-8"></th>
                    <th class="col-2"></th>
                </tr>
                </thead>
                <c:forEach var="item" items="${lastPlanThu}" varStatus="loop">
                    <tbody>
                    <tr class="d-flex">
                        <td class="col-2">${item.mealName}</td>
                        <td class="col-8">${item.recipeName}
                        </td>
                        <td class="col-2">
                            <a href="/app/recipe/details?id=${item.id}&url=/dashboard">
                                <button type="button" class="btn btn-primary rounded-0">Szczegóły
                                </button>
                            </a>
                        </td>
                    </tr>
                    </tbody>
                </c:forEach>
            </table>
        </c:if>
        <c:if test="${not empty lastPlanFri}">
            <table class="table">
                <thead>
                <tr class="d-flex">
                    <th class="col-2">Piątek</th>
                    <th class="col-8"></th>
                    <th class="col-2"></th>
                </tr>
                </thead>
                <c:forEach var="item" items="${lastPlanFri}" varStatus="loop">
                    <tbody>
                    <tr class="d-flex">
                        <td class="col-2">${item.mealName}</td>
                        <td class="col-8">${item.recipeName}
                        </td>
                        <td class="col-2">
                            <a href="/app/recipe/details?id=${item.id}&url=/dashboard">
                                <button type="button" class="btn btn-primary rounded-0">Szczegóły
                                </button>
                            </a>
                        </td>
                    </tr>
                    </tbody>
                </c:forEach>
            </table>
        </c:if>
        <c:if test="${not empty lastPlanSat}">
            <table class="table">
                <thead>
                <tr class="d-flex">
                    <th class="col-2">Sobota</th>
                    <th class="col-8"></th>
                    <th class="col-2"></th>
                </tr>
                </thead>
                <c:forEach var="item" items="${lastPlanSat}" varStatus="loop">
                    <tbody>
                    <tr class="d-flex">
                        <td class="col-2">${item.mealName}</td>
                        <td class="col-8">${item.recipeName}
                        </td>
                        <td class="col-2">
                            <a href="/app/recipe/details?id=${item.id}&url=/dashboard">
                                <button type="button" class="btn btn-primary rounded-0">Szczegóły
                                </button>
                            </a>
                        </td>
                    </tr>
                    </tbody>
                </c:forEach>
            </table>
        </c:if>
        <c:if test="${not empty lastPlanSun}">
            <table class="table">
                <thead>
                <tr class="d-flex">
                    <th class="col-2">Niedziela</th>
                    <th class="col-8"></th>
                    <th class="col-2"></th>
                </tr>
                </thead>
                <c:forEach var="item" items="${lastPlanSun}" varStatus="loop">
                    <tbody>
                    <tr class="d-flex">
                        <td class="col-2">${item.mealName}</td>
                        <td class="col-8">${item.recipeName}
                        </td>
                        <td class="col-2">
                            <a href="/app/recipe/details?id=${item.id}&url=/dashboard">
                                <button type="button" class="btn btn-primary rounded-0">Szczegóły
                                </button>
                            </a>
                        </td>
                    </tr>
                    </tbody>
                </c:forEach>
            </table>
        </c:if>

    </div>
</div>
</div>
</section>

<jsp:include page="footer.jsp"/>