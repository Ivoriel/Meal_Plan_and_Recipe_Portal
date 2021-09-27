<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<jsp:include page="/header.jsp"/>
<jsp:include page="/topsection_login.jsp"/>
<jsp:include page="/sidemenu_login.jsp"/>

<div class="m-4 p-3 width-medium">
    <div class="dashboard-content border-dashed p-3 m-4 view-height">

            <form action="/app/recipe/plan/add" method="POST">
                <div class="row border-bottom border-3 p-1 m-1">
                    <div class="col noPadding">
                        <h3 class="color-header text-uppercase">DODAJ PRZEPIS DO PLANU</h3>
                    </div>
                    <div class="col d-flex justify-content-end mb-2 noPadding">
                        <button type="submit" class="btn btn-color rounded-0 pt-0 pb-0 pr-4 pl-4">Zapisz</button>
                    </div>
                </div>

                <div class="schedules-content">
                <div class="form-group row">
                    <label for="choosePlan" class="col-sm-2 label-size col-form-label">
                        Wybierz plan
                    </label>
                    <div class="col-sm-3">
                        <select name="planId" class="form-control" id="choosePlan">
                            <c:forEach items="${sessionScope.plans}" var="plan">
                                <option  value="${plan.id}"><c:out value="${plan.name}"/></option>
                            </c:forEach>

                        </select>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="name" class="col-sm-2 label-size col-form-label">
                        Nazwa posiłku
                    </label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="name" id="name" placeholder="Nazwa posiłku">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="number" class="col-sm-2 label-size col-form-label">
                        Numer posiłku
                    </label>
                    <div class="col-sm-2">
                        <input type="number" class="form-control"  name="number" id="number" placeholder="Numer posiłku">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="recipe" class="col-sm-2 label-size col-form-label">
                        Przepis
                    </label>
                    <div class="col-sm-4">
                        <select name="recipeId" class="form-control" id="recipe">
                            <c:forEach items="${sessionScope.recipes}" var="recipe">
                                <option  value="${recipe.id}"><c:out value="${recipe.name}"/></option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="day" class="col-sm-2 label-size col-form-label">
                        Dzień
                    </label>
                    <div class="col-sm-2">
                        <select name="dayId" class="form-control" id="day">
                            <c:forEach items="${sessionScope.days}" var="day">
                                <option  value="${day.id}"><c:out value="${day.name}"/></option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>


<jsp:include page="footer.jsp"/>