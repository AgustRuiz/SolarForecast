<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<jsp:include page="commons/header.jsp" />
<jsp:include page="commons/topNav.jsp" />
<jsp:include page="commons/sideNav.jsp" />
<c:choose>
    <c:when test="${action == 'create'}">
        <jsp:include page="usersCreate.jsp" />
    </c:when>
    <c:otherwise>
        <jsp:include page="usersList.jsp" />
    </c:otherwise>
</c:choose>
<jsp:include page="commons/footer.jsp" />