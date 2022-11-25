<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="vet">
    <h2>Vet Information</h2>
    <table class="table table-striped">
        <tr>
            <th>Name</th>
            <td><b><c:out value="${vet.firstName} ${vet.lastName}"/></b></td>
        </tr>
    </table>
    <spring:url value="{vetId}/memos/new.html" var="addMemoUrl">
        <spring:param name="vetId" value="${vet.id}"/>
    </spring:url>
    <a href="${fn:escapeXml(addMemoUrl)}" class="btn btn-default">Add New Memo</a>
    <br/>
    <br/>
    <br/>
    <h2>Memos</h2>
    <table class="table table-striped">

        <tr>

            <td valign="top">
                <table class="table-condensed">
                    <thead>
                    <tr>
                        <th>Memo Date</th>
                        <th>Description</th>
                    </tr>
                    </thead>
                    <c:forEach var="memo" items="${vet.memos}">
                        <tr>
                            <td><petclinic:localDate date="${memo.date}"
                                                     pattern="yyyy-MM-dd"/></td>
                            <td><c:out value="${memo.description}"/></td>
                        </tr>
                    </c:forEach>
                </table>
            </td>
        </tr>
    </table>
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
                        <th>Pet Name</th>
                    </tr>
                    </thead>
                    <c:forEach var="operation" items="${vet.operations}">
                        <tr>
                            <td><petclinic:localDate date="${operation.date}"
                                                     pattern="yyyy-MM-dd"/></td>
                            <td><c:out value="${operation.description}"/></td>
                            <td><c:out value="${operation.pet.name}"/></td>
                        </tr>
                    </c:forEach>
                </table>
            </td>
        </tr>
    </table>
</petclinic:layout>
