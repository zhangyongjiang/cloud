<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags/common" prefix="o" %>
<%@ taglib tagdir="/WEB-INF/tags/gaoshin" prefix="g" %>

<%
	String taskId = request.getParameter("taskId");
	String url = "/ws/v1/job/task/details?format=object&var=task&id=" + taskId;
	request.getRequestDispatcher(url).include(request, response);
%>

<div class="page-header">Add configuration for task ${task.name } of job <g:job-link job="${task.job }"/></div>

<form method="post" onSubmit="return createTaskConf();">
	<table>
		<o:text-input-tr label="Key" id="name" ></o:text-input-tr>
		<o:textarea-tr label="Value" id="value"></o:textarea-tr>
		<o:text-input-tr label="Is Password?" id="password"></o:text-input-tr>
		<o:submit-tr value="Add" cancel="window.history.back()"></o:submit-tr>
	</table>
</form>

<script type="text/javascript">
function createTaskConf() {
	var req = {
		name: $("#name").val(),
		value: $("#value").val(),
		password: $("#password").val(),
		ownerId: "<%=taskId%>"
	};
	
    var json = JSON.stringify(req);
    $.ajax({
            url : base + "/ws/v1/job/job-conf/create",
            type : "POST",
            data : json,
            contentType : "application/json; charset=utf-8",
            dataType : "json",
            complete : function(transport) {
                    if (transport.status == 200) {
                            window.location = base + "/job/details/index.jsp.oo?id=${task.job.id}";
                    } else {
                            alert('Error: ' + transport.status + ", "
                                            + transport.responseText);
                    }
            }
    });

    return false;
}
</script>