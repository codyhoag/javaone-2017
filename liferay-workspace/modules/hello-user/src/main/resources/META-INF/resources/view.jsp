<%@ include file="/init.jsp" %>

<%
PortletPreferences prefs = renderRequest.getPreferences();
String userName = (String)prefs.getValue(
"userName", "User");
%>

<p>
<b><h2>Hello <%= userName %>!</h2></b>
</p>

<portlet:renderURL var="editNameURL">
	<portlet:param name="jspPage" value="/edit.jsp" />
</portlet:renderURL>

<aui:button onClick="<%= editNameURL %>" value="Edit Name"></aui:button>