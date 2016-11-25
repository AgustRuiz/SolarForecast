<%-- 
    Document   : indexContent
    Created on : 14-jun-2016, 13:53:34
    Author     : Agustin Ruiz Linares <arl00029@red.ujaen.es>
--%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@taglib prefix="sec" 	uri="http://www.springframework.org/security/tags"%>
<h1 class="page-header">${title}</h1>
<div class="col-md-8 col-md-offset-2 col-sm-10 col-sm-offset-1 ">
    <jsp:include page="commons/messagesBox.jsp" />
    <form class="form-horizontal" commandName="placeData" name='loginForm'
          action="<c:url value='j_spring_security_check' />" method='POST'>
        <div class="form-group">
            <label for="txtUserName" class="col-sm-2">User name</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="txtUserName" id="txtUserName" placeholder="User name" value="${txtUserName}" maxlength="16" required />
            </div>
        </div>
        <div class="form-group">
            <label for="txtPassword" class="col-sm-2">Password</label>
            <div class="col-sm-10">
                <input type="password" step="any" class="form-control" name="txtPassword" id="txtPassword" placeholder="Password" required />
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-success">Login</button>
            </div>
        </div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    </form>
</div>

