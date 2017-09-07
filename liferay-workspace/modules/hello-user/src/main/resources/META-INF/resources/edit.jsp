<%@ include file="/init.jsp" %>

<%
PortletPreferences prefs = renderRequest.getPreferences();
String userName = (String)prefs.getValue(
"userName", "User");
%>

<portlet:actionURL var="editNameURL">
	<portlet:param name="jspPage" value="/edit.jsp" />
</portlet:actionURL>

<aui:form action="<%= editNameURL %>" method="post">
	<aui:input label="User Name" name="userName" type="text" value="<%= userName %>" />
	<aui:button type="submit" />
</aui:form>

<portlet:renderURL var="viewNameURL">
	<portlet:param name="jspPage" value="/view.jsp" />
</portlet:renderURL>

<aui:button-row>
	<aui:button onClick="<%= viewNameURL %>" value="Back"></aui:button>
</aui:button-row>
