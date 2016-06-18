<%-- 
    Document   : indexContent
    Created on : 14-jun-2016, 13:53:34
    Author     : Agustin Ruiz Linares <arl00029@red.ujaen.es>
--%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<h1 class="page-header">${title}</h1>
<div class="table-responsive">
    <table class="table">
        <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Coords</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:if test="${not empty placesList}">
                <c:forEach var="item" varStatus="status" items="${placesList}">
                    <tr>
                        <td>${item.value.id}</td>
                        <td>${item.value.name}</td>
                        <td>${item.value.latitude}, ${item.value.longitude}</td>
                        <td></td>
                    </tr>
                </c:forEach>
            </c:if>
            <c:if test="${empty placesList}">
                <tr>
                    <td class="text-center" colspan="4"><em>No places</em></td>
                </tr>
            </c:if>
        </tbody>
    </table>
</div>