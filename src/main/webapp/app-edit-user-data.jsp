<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="/header.jsp"/>
<jsp:include page="/topsection_login.jsp"/>
<jsp:include page="/sidemenu_login.jsp"/>

<div class="m-4 p-3 width-medium text-color-darker">
    <div class="m-4 border-dashed view-height">
        <!-- fix action, method -->
        <!-- add name attribute for all inputs -->
        <div class="mt-4 ml-4 mr-4">
            <form method="post">
                <div class="row border-bottom border-3">
                        <div class="col"><h3 class="color-header text-uppercase">Edytuj dane</h3></div>
                        <div class="col d-flex justify-content-end mb-2">
                            <button type="submit" class="btn btn-color rounded-0 pt-0 pb-0 pr-4 pl-4">Zapisz
                            </button>
                        </div>
                </div>

                <table class="table borderless">
                    <tbody>
                    <tr class="d-flex">
                        <th scope="row" class="col-2"><h4>Imię</h4></th>
                        <td class="col-7">
                            <input class="w-100 p-1" name="firstName" value="${admin.firstName}">
                        </td>
                    </tr>
                    <tr class="d-flex">
                        <th scope="row" class="col-2"><h4>Nazwisko</h4></th>
                        <td class="col-7">
                            <input class="w-100 p-1" name="lastName" value="${admin.lastName}">
                        </td>
                    </tr>
                    <tr class="d-flex">
                        <th scope="row" class="col-2"><h4>Email</h4></th>
                        <td class="col-3">
                            <input class="p-1 w-100" type="text" name="email" value="${admin.email}">
                        </td>
                    </tr>
                    </tbody>
            </table>
            </form>
        </div>
    </div>
</div>
</div>
</section>

<jsp:include page="footer.jsp"/>
