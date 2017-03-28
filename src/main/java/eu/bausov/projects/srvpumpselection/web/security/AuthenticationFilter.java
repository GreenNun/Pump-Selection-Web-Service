package eu.bausov.projects.srvpumpselection.web.security;

import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AuthenticationFilter extends AbstractPreAuthenticatedProcessingFilter {

    @Override
    protected Object getPreAuthenticatedPrincipal(HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession();

        String resultRolesCommaSeparated = "ADMIN";
       /* if (session != null) {
            String role = (String) session.getAttribute("role");
            resultRolesCommaSeparated = CollectionUtil.collectionToString(SupportedRoles.getAllAllowedRoles(role), "");
        } else {
            resultRolesCommaSeparated = SupportedRoles.ANONYMOUS.toString();
        }*/

        return resultRolesCommaSeparated;
    }

    @Override
    protected Object getPreAuthenticatedCredentials(HttpServletRequest httpServletRequest) {
        return "N/A";
    }
}
