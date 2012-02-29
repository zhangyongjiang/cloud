<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags/common" prefix="o" %>
<%@ taglib tagdir="/WEB-INF/tags/gaoshin" prefix="g" %>

<div class="page-header">Create New Configuration</div>

<form method="post" onSubmit="return createConf();">
	<table>
		<o:text-input-tr label="Name" id="name"></o:text-input-tr>
		<o:text-input-tr label="Value" id="value"></o:text-input-tr>
		<o:submit-tr value="Create" cancel="window.history.back()"></o:submit-tr>
	</table>
</form>

<script type="text/javascript">
function createConf() {
	var req = {
		name: $("#name").val(),
		value: $("#value").val()
	};
	
    var json = JSON.stringify(req);
    $.ajax({
            url : base + "/conf/create",
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