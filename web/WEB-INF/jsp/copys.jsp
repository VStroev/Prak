<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>


<div class="panel panel-default">
    <!-- Default panel contents -->
    <div class="panel-heading">Экземпляры
        <a href="copy_add.form?id=${fId}&type=true" class="btn btn-default btn-sm" role="button">
            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
            <span class="glyphicon glyphicon-cd" aria-hidden="true"></span>
        </a>
        <a href="copy_add.form?id=${fId}&type=false" class="btn btn-default btn-sm" role="button">
            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
        </a>
    </div>

    <!-- Table -->
    <table class="table">
        <thead>
        <tr>
            <th>id</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach items="${copys}" var="c">
            <tr>
                <td><c:out value="${c.id}" /></td>
                <td>
                    <c:if test="${c.isCd}">
                        <span class="glyphicon glyphicon-cd" aria-hidden="true"></span>
                    </c:if>
                </td>
                <td>
                    <a href="error.form" class="btn btn-default" role="button">
                        <span class="glyphicon glyphicon-usd" aria-hidden="true"></span>
                    </a>
                </td>
                <td>
                    <a href="copy.form?id=${c.id}" class="btn btn-default" role="button">
                        История
                    </a>
                </td>
                <td>
                    <a href="copy_del.form?id=${c.id}" class="btn btn-default" role="button">
                        <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                    </a>
                </td>
            </tr>

        </c:forEach>

        </tbody>
    </table>
</div>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>