<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>


<div class="panel-heading">Фильмы
    <a href="film_add.form" class="btn btn-default btn-sm" role="button">
        <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
    </a>
</div>

<!-- Table -->
<table class="table">
    <thead>
    <tr>
        <th>name</th>
        <th>cdCost</th>
        <th>casetteCost</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${films}" var="f">
        <tr>
            <td><c:out value="${f.name}" /></td>
            <td><c:out value="${f.cdCost}" /></td>
            <td><c:out value="${f.casetteCost}" /></td>
            <td>
                <a href="film.form?id=${f.id}" class="btn btn-default" role="button">
                    <span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>
                </a>
            </td>
            <td>
                <a href="copys.form?id=${f.id}" class="btn btn-default" role="button">
                    <span class="glyphicon glyphicon-usd" aria-hidden="true"></span>
                </a>
            </td>
            <td>
                <a href="film_del.form?id=${f.id}" class="btn btn-default" role="button">
                    <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                </a>
            </td>
        </tr>

    </c:forEach>

    </tbody>
</table>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>