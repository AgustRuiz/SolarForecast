<%-- 
    Document   : indexContent
    Created on : 14-jun-2016, 13:53:34
    Author     : Agustin Ruiz Linares <arl00029@red.ujaen.es>
--%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<h1 class="page-header">${title}</h1>
<h2 class="sub-header">${serviceStatusTitle}</h2>
<div class="table-responsive">
    <table class="table table-striped">
        <thead>
            <tr>
                <th>Service</th>
                <th>Status</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <tr class="${forecastServiceStatusClass}">
                <td>${forecastServiceStatusLabel}</td>
                <td>${forecastServiceStatusValue}</td>
                <spring:url value="${btnForecastServiceUrl}" var="actionServiceForecast" />
                <td><a href="${actionServiceForecast}" class="btn btn-default">${forecastServiceBtnLabel}</a></td>
            </tr>
        </tbody>
    </table>
</div>