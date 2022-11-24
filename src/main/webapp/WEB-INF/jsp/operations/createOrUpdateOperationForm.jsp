<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>


<petclinic:layout pageName="operations">
 <jsp:attribute name="customScript">
 <script>
     $(function () {
         $("#date").datepicker({dateFormat: 'yy/mm/dd'});
     });
 </script>
 </jsp:attribute>
    <jsp:body>
        <h2><c:if test="${operation['new']}">New </c:if>Operation</h2>
        <b>Pet Information</b>
        <table class="table table-striped" aria-describedby="petInformation">
            <tr>
                <th id="name">Name</th>
                <td headers="name"><strong><c:out value="${operation.pet.name}"/></strong></td>
            </tr>
            <tr>
                <th id="birthDate">Birth Date</th>
                <td headers="birthDate"><c:out value="${operation.pet.birthDate}"/></td>
            </tr>
        </table>

        <b>Vet Information</b>
        <table class="table table-striped">
            <tr>
                <th>Name</th>
                <td><b><c:out value="${operation.vet.firstName} ${operation.vet.lastName}"/></b></td>
            </tr>
        </table>

        <form:form modelAttribute="operation" class="form-horizontal">
            <div class="form-group has-feedback">
                <petclinic:inputField label="Date" name="date"/>
                <petclinic:inputField label="Description" name="description"/>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">

                    <button class="btn btn-default" type="submit">Add Operation</button>
                </div>
            </div>
        </form:form>

    </jsp:body>
</petclinic:layout>

