<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@page session="true"%>
<jsp:include page="commons/header.jsp" />
<jsp:include page="commons/topNav.jsp" />
<jsp:include page="commons/sideNav.jsp" />
<c:choose>
    <c:when test="${action == 'create'}">
        <jsp:include page="placesCreate.jsp" />
    </c:when>
    <c:otherwise>
        <jsp:include page="placesList.jsp" />
    </c:otherwise>
</c:choose>
<jsp:include page="commons/footer.jsp" />