<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="/header.jsp"/>
<jsp:include page="/topsection_login.jsp"/>
<jsp:include page="/sidemenu_login.jsp"/>

<div class="m-4 p-3 width-medium text-color-darker">
  <div class="m-4 border-dashed view-height">
    <div class="mt-4 ml-4 mr-4">
      <!-- fix action, method -->
      <!-- add name attribute for all inputs -->
      <form method="post">

        <div class="row border-bottom border-3">
          <div class="col"><h3 class="color-header text-uppercase">Zmień hasło</h3></div>
          <div class="col d-flex justify-content-end mb-2">
            <button type="submit" class="btn btn-color rounded-0 pt-0 pb-0 pr-4 pl-4">Zapisz
            </button>
          </div>
        </div>

        <table class="table borderless">
          <tbody>
          <tr class="d-flex">
            <th scope="row" class="col-2"><h4>Nowe hasło</h4></th>
            <td class="col-7">
              <input class="w-100 p-1" type="password" name="password" value="">
            </td>
          </tr>
          <tr class="d-flex">
            <th scope="row" class="col-2"><h4>Powtórz hasło</h4></th>
            <td class="col-7">
              <input class="w-100 p-1" type="password" name="password2" value="">
            </td>
          </tr>
          </tbody>
        </table>
      </form>
      <p><c:if test="${not empty messege}">${messege}</c:if></p>
    </div>
  </div>

</div>
</div>
</section>

<jsp:include page="footer.jsp"/>