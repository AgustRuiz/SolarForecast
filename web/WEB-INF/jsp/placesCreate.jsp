<%-- 
    Document   : indexContent
    Created on : 14-jun-2016, 13:53:34
    Author     : Agustin Ruiz Linares <arl00029@red.ujaen.es>
--%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<h1 class="page-header">${title}</h1>

<c:if test="${not empty msgSuccess}">
    <div class="alert alert-success alert-dismissible" role="alert">
        <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        ${msgSuccess}
    </div>
</c:if>

<c:if test="${not empty msgError}">
    <div class="alert alert-danger alert-dismissible" role="alert">
        <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        ${msgError}
    </div>
</c:if>

<form class="form-horizontal" method="post" commandName="placeData">
    <div class="form-group">
        <label for="txtName" class="col-sm-2">Name</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" name="txtName" id="txtName" placeholder="Place name" value="${txtName}" />
        </div>
    </div>
    <div class="form-group">
        <label for="txtLatitude" class="col-sm-2">Latitude</label>
        <div class="col-sm-10">
            <input type="number" step="any" class="form-control" name="txtLatitude" id="txtLatitude" placeholder="Place latitude" value="${txtLatitude}" />
        </div>
    </div>
    <div class="form-group">
        <label for="txtLongitude" class="col-sm-2">Longitude</label>
        <div class="col-sm-10">
            <input type="number" step="any" class="form-control" name="txtLongitude" id="txtLongitude" placeholder="Place longitude" value="${txtLongitude}" />
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



