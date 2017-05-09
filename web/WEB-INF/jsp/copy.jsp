<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>


<div class="page-header">
    <h1>${len}</h1>
</div>

<div class="list-group">
    <a href="rent.form?id=${copy.id}" class="list-group-item">Выдать</a>
</div>

<div class="panel-heading">История
</div>
<table class="table">
    <thead>
    <tr>
        <th>surname</th>
        <th>firstName</th>
        <th>patronymic</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${customers}" var="c">
        <tr>
            <td><c:out value="${c.surname}" /></td>
            <td><c:out value="${c.firstName}" /></td>
            <td><c:out value="${c.patronymic}" /></td>
            <td>
                <a href="customer.form?id=${c.id}" class="btn btn-default" role="button">
                    <span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>
                </a>
            </td>
        </tr>

    </c:forEach>

    </tbody>
</table>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>