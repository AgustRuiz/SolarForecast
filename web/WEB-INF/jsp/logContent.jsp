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
                        <td>${item.timeDate}</td>
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

