<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags/common" prefix="o" %>
<%@ taglib tagdir="/WEB-INF/tags/gaoshin" prefix="g" %>

<%
	String id = request.getParameter("id");
	String url = "/ws/v1/job/job-conf/details?format=object&var=it&id=" + id;
%>
<jsp:include page="<%=url %>"></jsp:include>

<div class="page-header">Edit Job Configuration for <g:job-link job="${it.job}"/></div>

<form method="post" onSubmit="return updateJobConf();">
	<table>
		<o:text-input-tr label="Key" id="name" value="${it.name }"></o:text-input-tr>
		<o:text-input-tr label="Value" id="value" size="80" value="${it.value }"></o:text-input-tr>
		<o:text-input-tr label="Is Password?" id="password" value="${it.password }"></o:text-input-tr>
		<o:submit-tr value="Update" cancel="window.history.back()"></o:submit-tr>
	</table>
</form>

<script type="text/javascript">
function updateJobConf() {
	var req = {
		name: $("#name").val(),
		value: $("#value").val(),
		password: $("#password").val(),
		id: "<%=id%>",
		ownerId: "${it.jobId}"
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
                            window.location = base + "/job/details/index.jsp.oo?id=${it.jobId}";
                    } else {
                            alert('Error: ' + transport.status + ", "
                                            + transport.responseText);
                    }
            }
    });

    return false;
}
</script>