<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<petclinic:layout pageName="pets">
    <h2 id="veterinarians">Pets</h2>

    <div class="row">
        <table id="petsTable" class="table table-striped" aria-describedby="pets">
            <thead>
            <tr>
                <th scope="col">Name</th>
                <th scope="col">Birth Date</th>
                <th scope="col">Owner Name</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${pets.petList}" var="pet">
                <tr>
                    <td>
                        <spring:url value="/pets/{petId}" var="petUrl">
                            <spring:param name="petId" value="${pet.id}"/>
                        </spring:url>
                        <a href="${fn:escapeXml(petUrl)}">
                            <c:out value="${pet.name}"/>
                        </a>
                    </td>
                    <td>
                        <petclinic:localDate date="${pet.birthDate}" pattern="yyyy-MM-dd"/>
                    </td>
                    <td>
                        <c:out value="${pet.owner.firstName} ${pet.owner.lastName}"/>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</petclinic:layout>
