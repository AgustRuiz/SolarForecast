<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>

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