<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<div class="alert alert-danger">
     <h1 class="page-header">403 - Forbiden!</h1>
    <c:if test="${not empty msg}">
        <h3>${msg}</h3>
    </c:if>
</div>