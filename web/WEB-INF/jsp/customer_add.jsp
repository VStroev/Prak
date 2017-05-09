<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>

<div class="page-header">
    <h1 class="text-center">Добавить фильм</h1>
</div>

<form:form modelAttribute="customer" method="POST" action="customer_add.form">

    <div class="input-group">
        <span class="input-group-addon" id="basic-addon1">Фамилия</span>
        <form:input path="surname"/>
    </div>
    <div class="input-group">
        <span class="input-group-addon" id="basic-addon2">Имя</span>
        <form:input path="firstName"/>
    </div>
    <div class="input-group">
        <span class="input-group-addon" id="basic-addon3">Отчество</span>
        <form:input path="patronymic"/>
    </div>
    <div class="input-group">
        <span class="input-group-addon" id="basic-addon4">Адрес</span>
        <form:input path="address"/>
    </div>
    <div class="input-group">
        <span class="input-group-addon" id="basic-addon5">Номер телефона</span>
        <form:input path="phone"/>
    </div>


    <button type="submit" class="btn btn-default">Готово</button>

    <a href="films.form" class="btn btn-default" role="button">
        Отмена
    </a>
</form:form>
<%@ include file="/WEB-INF/jsp/footer.jsp" %>