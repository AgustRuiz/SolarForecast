<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>

<div class="col-sm-3 col-md-2 sidebar">
    <ul class="nav nav-sidebar">
        <spring:url value="/home" var="homeUrl" />
        <li <c:if test="${navActiveItem=='home'}">class="active"</c:if>><a href="${homeUrl}">Home</a></li>
        <spring:url value="/places" var="placesUrl" />
        <li <c:if test="${navActiveItem=='places'}">class="active"</c:if>><a href="${placesUrl}">Places</a></li>
        <spring:url value="/log" var="logUrl" />
        <li <c:if test="${navActiveItem=='log'}">class="active"</c:if>><a href="${logUrl}">Log</a></li>
    </ul>
</div>
