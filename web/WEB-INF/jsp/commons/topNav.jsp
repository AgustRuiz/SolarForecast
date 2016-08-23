<%-- 
    Document   : topNav
    Created on : 14-jun-2016, 13:19:16
    Author     : Agustin Ruiz Linares <arl00029@red.ujaen.es>
--%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">${projectName}</a>
            <!--button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button-->
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li>
                    <spring:url value="/quickStopForecastService" var="quickStopForecastServiceUrl" />
                    <spring:url value="/quickStartForecastService" var="quickStartForecastServiceUrl" />
                    <c:if test="${forecastServiceStatus == true}">
                        <a href="${quickStopForecastServiceUrl}">
                            <strong class="text-success">Service
                                <span class="glyphicon glyphicon-ok-sign text-success" aria-hidden="true"></span>
                            </strong> 
                        </a>
                    </c:if>
                    <c:if test="${forecastServiceStatus == false}">
                        <a href="${quickStartForecastServiceUrl}">
                            <strong class="text-danger">Service
                                <span class="glyphicon glyphicon-remove-sign" aria-hidden="true"></span>
                            </strong>
                        </a>
                    </c:if>
                </li>
                <li>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">



                <c:if test="${pageContext.request.userPrincipal.name == null}">
                    <%-- User not logged --%>
                    <li>
                        <a href="<c:url value='/login' />">Login</a>
                    </li>
                </c:if>
                <c:if test="${pageContext.request.userPrincipal.name != null}">
                    <%-- User already logged --%>
                    <li>
                        <a href="#" onClick="$('#logoutForm').submit();">Logout</a>
                        <form id="logoutForm" action="<c:url value='/logout' />" method="post">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        </form>
                    </li>
                </c:if>

            </ul>
        </div>
    </div>
</nav>