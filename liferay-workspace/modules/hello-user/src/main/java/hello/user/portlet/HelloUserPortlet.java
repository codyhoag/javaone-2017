package hello.user.portlet;

import hello.user.constants.HelloUserPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionMessages;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Hello User Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + HelloUserPortletKeys.HelloUser,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class HelloUserPortlet extends MVCPortlet {

	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {

		PortletPreferences prefs = actionRequest.getPreferences();
		String userName = actionRequest.getParameter("userName");

		if (userName != null) {
			prefs.setValue("userName", userName);
			prefs.store();
			SessionMessages.add(actionRequest, "request_processed",
				"Your name saved successfully! Click 'Back' to view it.");
		}

		super.processAction(actionRequest, actionResponse);
	}
}