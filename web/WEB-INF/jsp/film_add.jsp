<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>

<div class="page-header">
    <h1 class="text-center">Добавить фильм</h1>
</div>

<form:form modelAttribute="film" method="POST" action="film_add.form">

<div class="input-group">
    <span class="input-group-addon" id="basic-addon1">Название</span>
    <form:input path="name"/>
</div>
<div class="input-group">
    <span class="input-group-addon" id="basic-addon2">Компания</span>
    <form:input path="company"/>
</div>
<div class="input-group">
    <span class="input-group-addon" id="basic-addon3">Режиссер</span>
    <form:input path="producer"/>
</div>
<div class="input-group">
    <span class="input-group-addon" id="basic-addon4">Дата</span>
    <input type="text" path="date" class= "date" name = "date" value = "<fmt:formatDate value="${cForm.date}" pattern="MM-dd-yyyy" />"/>
</div>
<div class="input-group">
    <span class="input-group-addon" id="basic-addon5">Цена на cd</span>
    <form:input path="cdCost"/>
</div>
<div class="input-group">
    <span class="input-group-addon" id="basic-addon6">Цена на кассету</span>
    <form:input path="casetteCost"/>
</div>

    <button type="submit" class="btn btn-default">Готово</button>

    <a href="films.form" class="btn btn-default" role="button">
        Отмена
    </a>
</form:form>
<%@ include file="/WEB-INF/jsp/footer.jsp" %>