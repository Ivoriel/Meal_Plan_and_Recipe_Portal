<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="/header.jsp"/>
<jsp:include page="/topsection_login.jsp"/>
<jsp:include page="/sidemenu_login.jsp"/>

<div class="m-4 p-3 width-medium">
    <div class="m-4 p-3 border-dashed view-height">

        <div class="row border-bottom border-3 p-1 m-1">
            <div class="col noPadding">
                <h3 class="color-header text-uppercase">LISTA UŻYTKOWNIKÓW</h3>
            </div>
            <div class="col d-flex justify-content-end mb-2 noPadding">
                <a href="/dashboard" class="btn btn-success rounded-0 pt-0 pb-0 pr-4 pl-4">Powrót</a>
            </div>
        </div>

        <div class="schedules-content">
            <table class="table">
                <thead>
                <tr class="d-flex">
                    <th class="col-1">ID</th>
                    <th class="col-3">IMIĘ</th>
                    <th class="col-6">NAZWISKO</th>
                    <th class="col-2 center">AKCJE</th>
                </tr>
                </thead>
                <tbody class="text-color-lighter">
                <c:forEach items="${adminList}" var="admin">
                    <tr class="d-flex">
                        <td class="col-1">${admin.id}</td>
                        <td class="col-3">${admin.firstName}</td>
                        <td class="col-6">${admin.lastName}</td>
                        <td class="col-2 center">
                            <a href="/app/admin/user/block?id=${admin.id}"
                               class="btn btn-danger rounded-0 text-light m-1">Blokuj</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <c:if test="${not empty param.message}">
                <div>
                    <h5 class="text-color-darker" style="color:Tomato"> ${param.message}</h5>
                </div>
            </c:if>
        </div>
    </div>
</div>
</div>
</section>

<jsp:include page="footer.jsp"/>