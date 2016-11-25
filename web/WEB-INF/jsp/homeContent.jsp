<%-- 
    Document   : indexContent
    Created on : 14-jun-2016, 13:53:34
    Author     : Agustin Ruiz Linares <arl00029@red.ujaen.es>
--%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<spring:url value="/forecastProvider" var="forecastProviderUrl" />
<h1 class="page-header">${title}</h1>
<jsp:include page="commons/messagesBox.jsp" />
<h2 class="sub-header">Main services</h2>
<div class="table-responsive">
    <table class="table table-striped">
        <thead>
            <tr>
                <th>Service</th>
                <th>Status</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <tr class="${forecastServiceStatusClass}">
                <td class="text-middle">${forecastServiceStatusLabel}</td>
                <td class="text-middle">${forecastServiceStatusValue}</td>
                <spring:url value="${btnForecastServiceUrl}" var="actionServiceForecast" />
                <td class="text-middle"><a href="${actionServiceForecast}" class="btn btn-default">${forecastServiceBtnLabel}</a></td>
            </tr>
        </tbody>
    </table>
</div>

<h2 class="sub-header">Weather forecast configuration</h2>
<div class="table-responsive">
    <table class="table table-striped">
        <thead>
            <tr>
                <th>Weather service</th>
                <th>Num. queries</th>
                <th>Query Frequency</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="provider" items="${forecastProviders}">
                <tr>
                    <td class="text-middle">${provider.key.providerName}</td>
                    <td class="text-middle">${provider.value}</td>
                    <td class="text-middle">
                        <select id="selectFor${provider.key.id}" class="form-control text-center">
                            <c:forEach var="frequency" items="${queryFrequencies}">
                                <option <c:if test="${provider.key.queryFrequencyMillis == frequency.key}">selected</c:if> value="${frequency.key}">${frequency.value}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td class="text-middle">
                        <button class="btn btn-default" onclick="setForecastProviderFrequency('${provider.key.id}','selectFor${provider.key.id}')">Save</button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<script>
    var forecastProviderUrl="${forecastProviderUrl}";
    function setForecastProviderFrequency(providerId, selectHtmlId){
        var selectHtmlElement = $("#"+selectHtmlId);
        window.location.href = forecastProviderUrl+"/"+providerId+"/setQueryFrequency/"+selectHtmlElement.val();
    }
</script>