<%-- 
    Document   : indexContent
    Created on : 14-jun-2016, 13:53:34
    Author     : Agustin Ruiz Linares <arl00029@red.ujaen.es>
--%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<h1 class="page-header">${title}</h1>
<jsp:include page="commons/messagesBox.jsp" />
<form class="form-horizontal" method="post" commandName="placeData">
    <div class="form-group">
        <label for="txtName" class="col-sm-2">Name</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" name="txtName" id="txtName" placeholder="User name" value="${txtName}" maxlength="16" required />
        </div>
    </div>
    <div class="form-group">
        <label for="txtPassword" class="col-sm-2">Password</label>
        <div class="col-sm-10">
            <input type="password" step="any" class="form-control" name="txtPassword" id="txtPassword" placeholder="Password" required />
        </div>
    </div>
    <div class="form-group">
        <label for="txtPassword2" class="col-sm-2">Confirm password</label>
        <div class="col-sm-10">
            <input type="password" step="any" class="form-control" name="txtPassword2" id="txtPassword2" placeholder="Password again" required />
        </div>
    </div>
    <div class="form-group">
        <label for="selRole" class="col-sm-2">Role</label>
        <div class="col-sm-10">
            <select class="form-control" name="selRole" id="selRole" >
                <c:forEach  var="item" varStatus="status" items="${rolesMap}">
                    <option value="${item.key}" <c:if test="${item.key == defaultRole}">selected</c:if> >${item.value}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-success">Save</button>
            <spring:url value="/places" var="placesUrl" />
            <a href="${placesUrl}" class="btn btn-danger" role="button">Cancel</a>
        </div>
    </div>
</form>



