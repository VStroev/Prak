<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>


<div class="page-header">
    <h1><c:out value="${film.name}" /></h1>
</div>
<div class="list-group">
    <li class="list-group-item">
        <h4 class="list-group-item-heading">Компания</h4>
        <p class="list-group-item-text">${film.company}</p>
    </li>
    <li class="list-group-item">
        <h4 class="list-group-item-heading">Режиссер</h4>
        <p class="list-group-item-text">${film.producer}</p>
    </li>
    <li class="list-group-item">
        <h4 class="list-group-item-heading">Дата</h4>
        <p class="list-group-item-text">${film.date}</p>
    </li>
    <li class="list-group-item">
        <h4 class="list-group-item-heading">Цена на cd</h4>
        <p class="list-group-item-text">${film.cdCost}</p>
    </li>
    <li class="list-group-item">
        <h4 class="list-group-item-heading">Цена на кассету</h4>
        <p class="list-group-item-text">${film.casetteCost}</p>
    </li>
    <a href="copys.form?id=${film.id}" class="list-group-item">Экземпляры</a>
    <a href="film_del.form?id=${film.id}" class="list-group-item list-group-item-danger">Удалить</a>
</div>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>