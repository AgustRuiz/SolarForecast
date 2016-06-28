<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>

<div>
    <div class="col-xs-3 text-left">
        <c:if test="${newerPage <= 0}">
            <a href="#" class="btn btn-default disabled" role="button">&larr; Newer</a>
        </c:if>
        <c:if test="${newerPage > 0}">
            <a href="${paginationBaseUrl}${newerPage}" class="btn btn-default" role="button">&larr; Newer</a>
        </c:if>

    </div>
    <div class="col-xs-6 text-center">
        <select if="selectPage" class="form-control text-center" onchange="goToPage(this)">
            <c:forEach var="i" begin="1" end="${numPages}">
                <option value="${i}" <c:if test="${i == currentPage}">selected</c:if>>Page ${i}</option>
            </c:forEach>
        </select>
    </div>
    <div class="col-xs-3 text-right">
        <c:if test="${olderPage > numPages}">
            <a href="#" class="btn btn-default disabled" role="button">Older &rarr;</a>
        </c:if>
        <c:if test="${olderPage <= numPages}">
            <a href="${paginationBaseUrl}${olderPage}" class="btn btn-default" role="button">Older &rarr;</a>
        </c:if>
    </div>
</div>
<script>
    function goToPage(select) {
        window.location.href = "${paginationBaseUrl}" + select.value;
    }
</script>