<%-- 
    Document   : indexContent
    Created on : 14-jun-2016, 13:53:34
    Author     : Agustin Ruiz Linares <arl00029@red.ujaen.es>
--%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<spring:url value="/users/suspend/" var="suspendUrl" />
<spring:url value="/users/activate/" var="activateUrl" />
<spring:url value="/users/delete/" var="deleteUrl" />
<h1 class="page-header">${title}</h1>
<jsp:include page="commons/messagesBox.jsp" />
<div class="row">
    <div class="table-responsive">
        <table class="table">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Role</th>
                    <th>State</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:if test="${not empty usersList}">
                    <c:forEach var="item" varStatus="status" items="${usersList}">
                        <tr <c:if test="${item.isSuspendedState()}">class="warning"</c:if> <c:if test="${item.isDeletedState()}">class="danger"</c:if> >
                            <td>${item.id}</td>
                            <td>${item.name}</td>
                            <td></td>
                            <td>
                                <c:choose>
                                    <c:when test="${item.profileState == 'A'}">Active</c:when>
                                    <c:when test="${item.profileState == 'S'}">Suspended</c:when>
                                    <c:when test="${item.profileState == 'D'}">Deleted</c:when>
                                </c:choose>
                            </td>
                            <td>
                                <button type="button" class="btn btn-success btn-xs <c:if test="${item.isActivatedState()}">disabled</c:if>" <c:if test="${!item.isActivatedState()}">onClick="showActivateModal(${item.id}, '${item.name}')"</c:if>>Activate</button>
                                <button type="button" class="btn btn-warning btn-xs <c:if test="${item.isSuspendedState()}">disabled</c:if>" <c:if test="${!item.isSuspendedState()}">onClick="showSuspendModal(${item.id}, '${item.name}')"</c:if>>Suspend</button>
                                <button type="button" class="btn btn-danger btn-xs <c:if test="${item.isDeletedState()}">disabled</c:if>" <c:if test="${!item.isDeletedState()}">onClick="showDeleteModal(${item.id}, '${item.name}')"</c:if>>Delete</button>
                                </td>
                            </tr>
                    </c:forEach>
                </c:if>
                <c:if test="${empty usersList}">
                    <tr>
                        <td class="text-center" colspan="4"><em>No users</em></td>
                    </tr>
                </c:if>
            </tbody>
        </table>
    </div>
</div>
<div class="row">
    <div class="col-sm-12">
        <spring:url value="/users/create" var="createUserUrl" />
        <a class="btn btn-default" href="${createUserUrl}" role="button">Add new user</a>
    </div>
</div>
<!-- Active modal -->
<div class="modal fade" id="activateModal" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="activateModalLabel">Activate user</h4>
            </div>
            <div class="modal-body">
                <p>
                    Are you sure want to activate user "<strong><span id="txtActivateUserName"/></strong>"?
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-success" onClick="activateUser()">Activate</button>
            </div>
        </div>
    </div>
</div>
<!-- End activate modal -->
<!-- Suspend modal -->
<div class="modal fade" id="suspendModal" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="suspendModalLabel">Suspend user</h4>
            </div>
            <div class="modal-body">
                <p>
                    Are you sure want to suspend user "<strong><span id="txtSuspendUserName"/></strong>"?
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-warning" onClick="suspendUser()">Suspend</button>
            </div>
        </div>
    </div>
</div>
<!-- End suspend modal -->
<!-- Delete modal -->
<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="deleteModalLabel">Delete user</h4>
            </div>
            <div class="modal-body">
                <p>
                    Are you sure want to delete user "<strong><span id="txtDeleteUserName"/></strong>"?
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-danger" onClick="deleteUser()">Delete</button>
            </div>
        </div>
    </div>
</div>
<!-- End delete modal -->
<script>
    var currentActionId = -1;

    function showSuspendModal(userId, userName) {
        $("#txtSuspendUserName").text(userName);
        currentActionId = userId;
        $("#suspendModal").modal("show");
    }

    function suspendUser() {
        window.location.href = "${suspendUrl}" + currentActionId;
    }

    function showActivateModal(userId, userName) {
        $("#txtActivateUserName").text(userName);
        currentActionId = userId;
        $("#activateModal").modal("show");
    }

    function activateUser() {
        window.location.href = "${activateUrl}" + currentActionId;
    }

    function showDeleteModal(userId, userName) {
        $("#txtDeleteUserName").text(userName);
        currentActionId = userId;
        $("#deleteModal").modal("show");
    }

    function deleteUser() {
        window.location.href = "${deleteUrl}" + currentActionId;
    }
</script>