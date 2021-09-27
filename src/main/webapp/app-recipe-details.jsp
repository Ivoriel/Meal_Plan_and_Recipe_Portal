<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<jsp:include page="/header.jsp"/>
<c:if test="${not empty sessionScope.adminID}">
    <jsp:include page="/topsection_login.jsp"/>
    <jsp:include page="/sidemenu_login.jsp"/>
</c:if>
<c:if test="${empty sessionScope.adminID}">
    <jsp:include page="/topsection_logout.jsp"/>
</c:if>


<div class="m-4 p-3 width-medium text-color-darker">
    <div class="dashboard-content border-dashed p-3 m-4 view-height">
        <div class="mt-4 ml-4 mr-4">
            <div class="row border-bottom border-3">
                <div class="col"><h3 class="color-header text-uppercase">Szczegóły przepisu</h3></div>
                <div class="col d-flex justify-content-end mb-2"><a href="/app/recipe/list"
                <div class="col d-flex justify-content-end mb-2"><a href="${url}"
                                                                    class="btn btn-color rounded-0 pt-0 pb-0 pr-4 pl-4">Powrót</a>
                </div>
            </div>

            <table class="table borderless">
                <tbody>
                <tr class="d-flex">
                    <th scope="row" class="col-2">Nazwa Przepisu</th>
                    <td class="col-7">
                        ${currentRecipe.name}
                    </td>
                </tr>
                <tr class="d-flex">
                    <th scope="row" class="col-2">Opis przepisu</th>
                    <td class="col-7">${currentRecipe.description}</td>
                </tr>
                <tr class="d-flex">
                    <th scope="row" class="col-2">Przygotowanie (minuty)</th>
                    <td class="col-7">
                        ${currentRecipe.preparationTime}
                    </td>
                </tr>
                </tbody>
            </table>

            <div class="row d-flex">
                <div class="col-5 border-bottom border-3"><h3 class="text-uppercase">Sposób przygotowania</h3></div>
                <div class="col-2"></div>
                <div class="col-5 border-bottom border-3"><h3 class="text-uppercase">Składniki</h3></div>
            </div>
            <div class="row d-flex">
                <div class="col-5 p-4">
                    <p>${currentRecipe.preparation}</p>
                </div>
                <div class="col-2"></div>
                <ul class="col-5 p-4 list-unstyled">
                    ${currentRecipe.ingredients}
                </ul>
            </div>

            <div class="row d-flex">
                <div class="col-20 border-bottom border-3"><h3 class="text-uppercase">Zobacz przygotwanie na
                    YouTube</h3></div>
                <div class="col-2"></div>
              <br>
            </div>
            <div class="row d-flex">
                <div class="col-10 p-6">
                    <iframe width="640" height="360" src="${currentRecipe.urlAddress}" frameborder="0" allowfullscreen></iframe>
            </div>
        </div>

    </div>
</div>
</div>


<jsp:include page="footer.jsp"/>