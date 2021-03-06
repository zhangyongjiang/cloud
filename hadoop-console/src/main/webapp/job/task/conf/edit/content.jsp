<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags/common" prefix="o" %>
<%@ taglib tagdir="/WEB-INF/tags/gaoshin" prefix="g" %>

<%
	String id = request.getParameter("id");
	String url = "/ws/v1/job/task-conf/details?format=object&var=it&id=" + id;
%>
<jsp:include page="<%=url %>"></jsp:include>

<div class="page-header">Edit Configuration for Task ${it.taskDetails.name } of Job <g:job-link job="${it.taskDetails.job}"/></div>

<form method="post" onSubmit="return updateTaskConf();">
	<table>
		<o:text-input-tr label="Key" id="name" value="${it.name }"></o:text-input-tr>
		<o:textarea-tr style="width:660px;height:200px;" label="Value" id="value" value="${it.value }"></o:textarea-tr>
		<o:text-input-tr label="Is Password?" id="password" value="${it.password }"></o:text-input-tr>
		<o:submit-tr value="Update" cancel="window.history.back()"></o:submit-tr>
	</table>
</form>

<script type="text/javascript">
function updateTaskConf() {
	var req = {
		name: $("#name").val(),
		value: $("#value").val(),
		password: $("#password").val(),
		id: "<%=id%>",
		ownerId: "${it.ownerId}"
	};
	
    var json = JSON.stringify(req);
    $.ajax({
            url : base + "/ws/v1/job/job-conf/update",
            type : "POST",
            data : json,
            contentType : "application/json; charset=utf-8",
            dataType : "json",
            complete : function(transport) {
                    if (transport.status == 200) {
                            window.location = base + "/job/details/index.jsp.oo?id=${it.taskDetails.job.id}";
                    } else {
                            alert('Error: ' + transport.status + ", "
                                            + transport.responseText);
                    }
            }
    });

    return false;
}
</script>