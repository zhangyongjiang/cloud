<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib tagdir="/WEB-INF/tags/common" prefix="o" %>

<%
	String url = "/ws/v1/conf/list?ownerId=hadoop-conf&format=object";
	request.getRequestDispatcher(url).include(request, response);
%>

<div class="page-header">Hadoop Cluster</div>
<div id="tabs" style="min-height: 480px;">
        <ul>
                <li><a href="#conf">Configuration</a></li>
                <li><a href="#deployment">Deployment</a></li>
                <li><a href="#status">Status</a></li>
        </ul>

        <div id="conf">
			<button onclick="createConf()">Create</button>
			
			<table style="border:solid 1px;">
			<tr><th>Name</th><th>Value</th><th>&nbsp;</th></tr>
			<c:forEach var="conf" items="${it }">
				<tr>
					<td><a href='<c:url value="/conf/set/index.jsp.oo?confId="/>${conf.id}'>${conf.name}</a></td>
					<td><pre>${fn:escapeXml(conf.value)}</pre></td>
					<td><button onclick="remove('${conf.id}')">Remove</button></td></tr>
			</c:forEach>
			</table>
		</div>

        <div id="deployment">
        	deployment details
        </div>
        
        <div id="status">
        	Status details
        </div>
</div>
		

<script type="text/javascript">
$(document).ready(function(){
    $.address.change(function(event){
        $("#tabs").tabs( "select" , window.location.hash )
    });

    $("#tabs").bind("tabsselect", function(event, ui) {
        window.location.hash = ui.tab.hash;
    });

        $( "#tabs" ).tabs();
});

	function createConf() {
		window.location = base + "/conf/set/index.jsp.oo";
	}

	function remove(id) {
		if(!confirm("are you sure?"))
			return;
	    $.ajax({
            url : base + "/ws/v1/conf/remove/" + id,
            type : "POST",
            contentType : "application/json; charset=utf-8",
            dataType : "json",
            complete : function(transport) {
                    if (transport.status == 200) {
                            window.location.reload();
                    } else {
                            alert('Error: ' + transport.status + ", "
                                            + transport.responseText);
                    }
            }
    });
	}
</script>
