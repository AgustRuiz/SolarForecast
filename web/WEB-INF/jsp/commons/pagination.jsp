<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<nav>
    <ul class="pagination pagination-sm">
        <!--<li><a href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>-->
        <c:forEach var="page" varStatus="status" items="${pages}">
            <li <c:if test="${page==currentPage}">class="active"</c:if>><a href="${paginationBaseUrl}${page}">${page}</a></li>
        </c:forEach>
        <!--<li><a href="#" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>-->
    </ul>
</nav>