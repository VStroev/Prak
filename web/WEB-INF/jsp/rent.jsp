<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>


<div class="page-header">
    <h1>Выдача</h1>
</div>
<div class="list-group">
    <c:forEach items="${customers}" var="c">
        <button type="button" class="list-group-item">${c.id} ${c.surname} ${c.firstName} ${c.patronymic}</button>
    </c:forEach>
</div>

<form:form modelAttribute="rent" method="POST" action="rent.form">
    <div class="input-group">
        <span class="input-group-addon" id="basic-addon1">Покупатель (id)</span>
        <form:input path="customer.id"/>
    </div>
    <div class="input-group">
        <span class="input-group-addon" id="basic-addon1">Оплата</span>
        <form:input path="payed"/>
    </div>
    <div class="input-group">
        <span class="input-group-addon" id="basic-addon1">Оплата</span>
        <form:input path="payed"/>
    </div>
    <div class="input-group">
        <span class="input-group-addon" id="basic-addon1">Оплата</span>
        <form:input path="payed"/>
    </div>
    <div class="input-group">
        <span class="input-group-addon" id="basic-addon4">Дата</span>
        <input type="text" path="date" class= "date" name = "date" value = "<fmt:formatDate value="${cForm.date}" pattern="MM-dd-yyyy" />"/>
    </div>

    <button type="submit" class="btn btn-default">Готово</button>

    <a href="films.form" class="btn btn-default" role="button">
        Отмена
    </a>
</form:form>
<%@ include file="/WEB-INF/jsp/footer.jsp" %>