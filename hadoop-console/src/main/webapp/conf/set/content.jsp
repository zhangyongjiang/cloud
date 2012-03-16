<%@page import="com.gaoshin.configuration.Configuration"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags/common" prefix="o" %>
<%@ taglib tagdir="/WEB-INF/tags/gaoshin" prefix="g" %>

<%
	String id = request.getParameter("confId");
	if(id != null) {
	    String url = "/ws/v1/conf/get/" + id + "?format=object";
	    request.getRequestDispatcher(url).include(request, response);
	}
	else {
	    request.setAttribute("it", new Configuration());
	}
%>

<div class="page-header">Create New Configuration</div>

<form method="post" onSubmit="return createConf();">
	<table>
		<o:text-input-tr label="Name" id="name" value="${it.name }"></o:text-input-tr>
		<o:text-input-tr label="Value" id="value" value="${it.value }"></o:text-input-tr>
		<o:submit-tr value="Create" cancel="window.history.back()"></o:submit-tr>
	</table>
</form>

<script type="text/javascript">
function createConf() {
	<c:if test="${not empty it.id}">
		var req = {
				id: '${it.id}',
				name: $("#name").val(),
				value: $("#value").val()
			};
	</c:if>
	<c:if test="${empty it.id}">
	var req = {
			name: $("#name").val(),
			value: $("#value").val()
		};
	</c:if>
	
    var json = JSON.stringify(req);
    $.ajax({
            url : base + "/ws/v1/conf/set",
            type : "POST",
            data : json,
            contentType : "application/json; charset=utf-8",
            dataType : "json",
            complete : function(transport) {
                    if (transport.status == 200) {
                            window.location = base + "/conf/list/index.jsp.oo";
                    } else {
                            alert('Error: ' + transport.status + ", "
                                            + transport.responseText);
                    }
            }
    });

    return false;
}
</script>