<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>


<div class="panel panel-default">
    <!-- Default panel contents -->
    <div class="panel-heading">Клиенты
            <a href="customer_add.form" class="btn btn-default btn-sm" role="button">
                <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
            </a>
    </div>

    <!-- Table -->
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
                <td>
                    <a href="customer_del.form?id=${c.id}" class="btn btn-default" role="button">
                        <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                    </a>
                </td>
            </tr>

        </c:forEach>

        </tbody>
    </table>
</div>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>