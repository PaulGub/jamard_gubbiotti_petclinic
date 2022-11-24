<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<petclinic:layout pageName="vetsOperationList">

    <h2>Pet Information</h2>
    <table class="table table-striped" aria-describedby="petInformation">
        <tr>
            <th id="name">Name</th>
            <td headers="name"><strong><c:out value="${pet.name}"/></strong></td>
        </tr>
        <tr>
            <th id="birthDate">Birth Date</th>
            <td headers="birthDate"><c:out value="${pet.birthDate}"/></td>
        </tr>
    </table>

    <h2 id="veterinarians">Select a Veterinarian</h2>

    <div class="row">
        <table id="vetsTable" class="table table-striped" aria-describedby="veterinarians">
            <thead>
            <tr>
                <th scope="col">Name</th>
                <th scope="col">Specialties</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${vets.vetList}" var="vet">
                <tr>
                    <td>
                        <spring:url value="{vetId}/new.html" var="addOperationForm">
                            <spring:param name="vetId" value="${vet.id}"/>
                        </spring:url>
                        <a href="${fn:escapeXml(addOperationForm)}">
                            <c:out value="${vet.firstName} ${vet.lastName}"/>
                        </a>
                    </td>
                    <td>
                        <c:forEach var="specialty" items="${vet.specialties}">
                            <c:out value="${specialty.name} "/>
                        </c:forEach>
                        <c:if test="${vet.nrOfSpecialties == 0}">none</c:if>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</petclinic:layout>
