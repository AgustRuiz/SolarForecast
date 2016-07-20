<%-- 
    Document   : indexContent
    Created on : 14-jun-2016, 13:53:34
    Author     : Agustin Ruiz Linares <arl00029@red.ujaen.es>
--%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
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
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:if test="${not empty usersList}">
                    <c:forEach var="item" varStatus="status" items="${usersList}">
                        <tr>
                            <td>${item.id}</td>
                            <td>${item.name}</td>
                            <td>${item.profileState}</td>
                            <td>
                                <button type="button" class="btn btn-default btn-sm" onClick="showDeleteModal(${item.id}, '${item.name}')">
                                    Delete
                                </button>
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
<!-- Delete modal -->
<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
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
    var currentDeleteId = -1;

    function showDeleteModal(userId, userName) {
        $("#txtDeleteUserName").text(userName);
        currentDeleteId = userId;
        $("#deleteModal").modal("show");
    }

    function deleteUser() {
        window.location.href = "${deleteUrl}" + currentDeleteId;
    }
</script>