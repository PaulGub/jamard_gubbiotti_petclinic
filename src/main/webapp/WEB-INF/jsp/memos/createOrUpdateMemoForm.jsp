<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>


<petclinic:layout pageName="memos">
 <jsp:attribute name="customScript">
 <script>
     $(function () {
         $("#date").datepicker({dateFormat: 'yy/mm/dd'});
     });
 </script>
 </jsp:attribute>
    <jsp:body>
        <h2><c:if test="${memo['new']}">New </c:if>Memo</h2>
        <b>Vet</b>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
            </tr>
            </thead>
            <tr>
                <td><c:out value="${memo.vet.firstName}"/></td>
                <td><c:out value="${memo.vet.lastName}"/></td>
            </tr>
        </table>
        <form:form modelAttribute="memo" class="form-horizontal">
            <div class="form-group has-feedback">
                <petclinic:inputField label="Date" name="date"/>
                <petclinic:inputField label="Description" name="description"/>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">

                    <button class="btn btn-default" type="submit">Add Memo</button>
                </div>
            </div>
        </form:form>

    </jsp:body>
</petclinic:layout>
