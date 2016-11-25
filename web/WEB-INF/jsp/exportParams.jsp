<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<fieldset>
    <legend>3. Select parameter</legend>
    <div class="table-responsive">
        <table class="table table-striped table-hover">
            <thead>
                <tr>
                    <th>&nbsp;</th>
                    <th>Field</th>
                    <th>Order</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${paramTitleMap}" var="item" varStatus="status"> 
                    <tr>
                        <td>
                            <input type="hidden" name="paramCheck[]" value="false"/>
                            <input type="checkbox" onchange="$(this).prev().val(this.checked);"
                                   id="paramCheck[${status.count}]"/>
                        </td>
                        <td>
                            <label for="paramCheck[${status.count}]">${item.value}</label>
                            <input type="hidden" value="${item.key}" name="paramValue[]"/>
                        </td>
                        <td>
                            <input type="number" value="${status.count*100}" name="paramOrder[]"/>
                        </td>
                    </tr>
                </c:forEach> 
            </tbody>
        </table>
    </div>
    <div class="well">
        <p><strong>Instructions:</strong></p>
        <p>
            Select the fields you want to get in exporting. Then indicate the fiels sorting put the order in the corresponding field.
        </p>
        <p>
            It does not matter if they are not consecutive, but it is important you must not repeat anyone. That's because the default order value is a multiple of 100: you can type a number in the middle.
        </p>
    </div>
    <div class="form-group">
        <input type="submit" class="btn btn-primary" value="Export"/>
    </div>
</fieldset>