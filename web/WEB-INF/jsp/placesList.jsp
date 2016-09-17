<%-- 
    Document   : indexContent
    Created on : 14-jun-2016, 13:53:34
    Author     : Agustin Ruiz Linares <arl00029@red.ujaen.es>
--%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<spring:url value="/places/delete/" var="deleteUrl" />
<h1 class="page-header">${title}</h1>
<jsp:include page="commons/messagesBox.jsp" />
<div class="row">
    <div class="table-responsive">
        <table class="table">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Coords</th>
                    <th>Tiempo.com location code</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:if test="${not empty placesList}">
                    <c:forEach var="item" varStatus="status" items="${placesList}">
                        <tr>
                            <td>${item.id}</td>
                            <td>${item.name}</td>
                            <td>${item.latitude}, ${item.longitude}</td>
                            <td>${item.tiempoCom_LocationValue}</td>
                            <td>
                                <button type="button" class="btn btn-default btn-sm" onClick="showDeleteModal(${item.id}, '${item.name}')">
                                    Delete
                                </button>
                            </td>
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
</div>
<div class="row">
    <div class="col-sm-12">
        <spring:url value="/places/create" var="createPlaceUrl" />
        <a class="btn btn-default" href="${createPlaceUrl}" role="button">Add new place</a>
    </div>
</div>
<!-- Delete modal -->
<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="deleteModalLabel">Delete place</h4>
            </div>
            <div class="modal-body">
                <p>
                    Are you sure want to delete "<strong><span id="txtDeletePlaceName"/></strong>" place?
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-danger" onClick="deletePlace()">Delete</button>
            </div>
        </div>
    </div>
</div>
<!-- End delete modal -->
<script>
    var currentDeleteId = -1;

    function showDeleteModal(placeId, placeName) {
        $("#txtDeletePlaceName").text(placeName);
        currentDeleteId = placeId;
        $("#deleteModal").modal("show");
    }

    function deletePlace() {
        window.location.href = "${deleteUrl}" + currentDeleteId;
    }
</script>