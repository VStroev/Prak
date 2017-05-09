<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>


<div class="page-header">
    <h1>${customer.surname} ${customer.firstName} ${customer.patronymic}</h1>
</div>
<div class="list-group">
    <li class="list-group-item">
        <h4 class="list-group-item-heading">address</h4>
        <p class="list-group-item-text">${customer.address}</p>
    </li>
    <li class="list-group-item">
        <h4 class="list-group-item-heading">phone</h4>
        <p class="list-group-item-text">${customer.phone}</p>
    </li>
    <a href="customer_del.form?id=${customer.id}" class="list-group-item list-group-item-danger">Удалить</a>
</div>

<div class="panel-heading">История
</div>

<!-- Table -->
<table class="table">
    <thead>
    <tr>
        <th>Название</th>
        <th>Выдано</th>
        <th>Возврат</th>
        <th>Оплата</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${rents}" var="r">
        <tr>
            <td><c:out value="${r.copy.film.name}" /></td>
            <td><c:out value="${r.startDate}" /></td>
            <td><c:out value="${r.endDate}" /></td>
            <td><c:out value="${r.payed}" /></td>

    </c:forEach>

    </tbody>
</table>
<%@ include file="/WEB-INF/jsp/footer.jsp" %>