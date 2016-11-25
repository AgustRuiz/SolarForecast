<%-- 
    Document   : indexContent
    Created on : 14-jun-2016, 13:53:34
    Author     : Agustin Ruiz Linares <arl00029@red.ujaen.es>
--%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<spring:url value="/log/" var="paginationBaseUrl" />
<spring:url value="/log/clean" var="cleanLogUrl" />
<h1 class="page-header">${title}</h1>
<div class="row">
    <div class="col-lg-12 text-right">
        <a href="${paginationBaseUrl}${currentPage}" class="btn btn-default">Refresh</a>
        <button class="btn btn-danger" onclick="$('#deleteModal').modal('show')">Clean log</button>
    </div>
</div>
<jsp:include page="commons/pagination.jsp" />
<div class="table-responsive">
    <table class="table">
        <thead>
            <tr>
                <th>Time/date</th>
                <th>Level</th>
                <th>From</th>
                <th>Message</th>
            </tr>
        </thead>
        <tbody>
            <c:if test="${not empty logList}">
                <c:forEach var="item" varStatus="status" items="${logList}">
                    <c:choose>
                        <c:when test="${item.mode == 'D'}"><tr class="success"></c:when>
                        <c:when test="${item.mode == 'I'}"><tr class="info"></c:when>
                        <c:when test="${item.mode == 'W'}"><tr class="warning"></c:when>
                        <c:when test="${item.mode == 'E'}"><tr class="danger"></c:when>
                        <c:otherwise><tr></c:otherwise>
                        </c:choose>
                        <td>${item.timeDateString}</td>
                        <td>${item.mode}</td>
                        <td>${item.from}</td>
                        <td>${item.message}</td>
                    </tr>
                </c:forEach>
            </c:if>
            <c:if test="${empty logList}">
                <tr>
                    <td class="text-center" colspan="4"><em>Log is empty</em></td>
                </tr>
            </c:if>
        </tbody>
    </table>
</div>
<jsp:include page="commons/pagination.jsp" />
<!-- Delete modal -->
<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="deleteModalLabel">Clean Log</h4>
            </div>
            <div class="modal-body">
                <p>
                    Are you sure want to delete al log lines? This operation cannot undo!
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <a href="${cleanLogUrl}" role="button" class="btn btn-danger">Delete log</a>
            </div>
        </div>
    </div>
</div>
<!-- End delete modal -->

