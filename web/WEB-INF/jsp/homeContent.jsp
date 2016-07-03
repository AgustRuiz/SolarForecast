<%-- 
    Document   : indexContent
    Created on : 14-jun-2016, 13:53:34
    Author     : Agustin Ruiz Linares <arl00029@red.ujaen.es>
--%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
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
                <th>Query Frequency</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td class="text-middle"><em>Forecast service name</em></td>
                <td class="text-middle">
                    <select class="form-control text-center">
                        <option>15 minutes</option>
                        <option>30 minutes</option>
                        <option>45 minutes</option>
                        <option>1 hour</option>
                        <option>2 hours</option>
                        <option>3 hours</option>
                    </select>
                </td>
                <td class="text-middle">
                    <button class="btn btn-default">Save</button>
                </td>
            </tr>
        </tbody>
    </table>
</div>