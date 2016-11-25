<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<spring:url value="/places/delete/" var="deleteUrl" />
<h1 class="page-header">${title}</h1>
<jsp:include page="commons/messagesBox.jsp" />

<form class="form-horizontal" method="post" id="exportForm">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    <fieldset>
        <legend>1. Select place and forecast provider</legend>
        <div class="form-group">
            <label for="selForecastPlace" class="col-sm-2">Forecast place</label>
            <div class="col-sm-10">
                <select id="selPlace" name="selPlace" class="form-control text-center" onchange="$(this).closest('form').trigger('submit');">
                    <c:if test="${placeId == -1}"><option value="-1" selected disabled>Choose a forecast place</option></c:if>
                    <c:forEach var="place" varStatus="status" items="${fPlaces}">
                        <option value="${place.id}" <c:if test="${place.id == placeId}">selected</c:if>>${place.name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <c:if test="${placeId != -1}">

            <div class="form-group">
                <label for="selProvider" class="col-sm-2">Forecast provider</label>
                <div class="col-sm-10">
                    <select id="selProvider" name="selProvider" class="form-control text-center" onchange="$(this).closest('form').trigger('submit');">
                        <c:if test="${providerId == -1}"><option value="-1" selected disabled>Choose a forecast provider</option></c:if>
                        <c:forEach var="provider" varStatus="status" items="${fProviders}">
                            <option value="${provider.id}" <c:if test="${provider.id == providerId}">selected</c:if>>${provider.providerName}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>

        </c:if>        
    </fieldset>

    <c:if test="${placeId != -1 && providerId != -1}">

        <fieldset>
            <legend>2. Select dates</legend>
            <div class="form-group">
                <div class="col-sm-6">
                    <label for="selFromDate">From (included)</label>
                    <select class="form-control text-center" id="selFromDate" name="selFromDate">
                        <c:forEach var="item" varStatus="status" items="${dateTimeList}">
                            <option value="${item.key}">${item.value}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-sm-6">
                    <label for="selToDate">To (included)</label>
                    <select class="form-control text-center" id="selToDate" name="selToDate">
                        <c:forEach var="item" varStatus="status" items="${dateTimeList}">
                            <option value="${item.key}">${item.value}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
        </fieldset>
        <jsp:include page="exportParams.jsp" />
    </c:if>
</form>
<script>
    var loadFunction = function () {
        // Default options for select
        $("#selFromDate option:first").attr("selected", "selected");
        $("#selToDate option:last").attr("selected", "selected");

        // Change events
        $("#selFromDate").change(function () {
            var fromDate = $("#selFromDate").val();
            $("#selToDate > option").each(function () {
                var that = $(this);
                if (that.val() <= fromDate) {
                    that.attr("disabled", "disabled");
                } else {
                    that.removeAttr("disabled");
                }
            });
        });
        $("#selToDate").change(function () {
            var toDate = $("#selToDate").val();
            $("#selFromDate > option").each(function () {
                var that = $(this);
                if (that.val() >= toDate) {
                    that.attr("disabled", "disabled");
                } else {
                    that.removeAttr("disabled");
                }
            });
        });
    }

    if (window.addEventListener) {
        window.addEventListener('load', loadFunction);
    } else {
        window.attachEvent('onload', loadFunction);
    }
</script>