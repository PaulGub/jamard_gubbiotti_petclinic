<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="pet">
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
    <spring:url value="{petId}/operation/" var="addOperationUrl">
        <spring:param name="petId" value="${pet.id}"/>
    </spring:url>
    <a href="${fn:escapeXml(addOperationUrl)}" class="btn btn-default">Add New Operation</a>
    <br/>
    <br/>
    <br/>
    <h2>Operations</h2>
    <table class="table table-striped">

        <tr>

            <td valign="top">
                <table class="table-condensed">
                    <thead>
                    <tr>
                        <th>Operation Date</th>
                        <th>Description</th>
                    </tr>
                    </thead>
                    <c:forEach var="operation" items="${pet.operations}">
                        <tr>
                            <td><petclinic:localDate date="${operation.date}"
                                                     pattern="yyyy-MM-dd"/></td>
                            <td><c:out value="${operation.description}"/></td>
                        </tr>
                    </c:forEach>
                </table>
            </td>
        </tr>
    </table>
</petclinic:layout>
