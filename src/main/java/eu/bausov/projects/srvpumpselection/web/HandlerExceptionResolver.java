package eu.bausov.projects.srvpumpselection.web;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.hibernate.ObjectNotFoundException;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class HandlerExceptionResolver extends AbstractHandlerExceptionResolver {

    @Override
    protected ModelAndView doResolveException(HttpServletRequest request,
                                              HttpServletResponse response, Object handler, Exception ex) {
        response.setCharacterEncoding("UTF-8");

        if (ex instanceof AccessDeniedException) {
            return processAccessDeniedException(request, response, (AccessDeniedException) ex);
        } else if (ex instanceof HttpMessageNotWritableException) {
            return processNotWritableException(response, (HttpMessageNotWritableException) ex);
        } else {
            return processOtherExceptions(response, ex);
        }
    }

    private ModelAndView processNotWritableException(HttpServletResponse response, HttpMessageNotWritableException ex) {
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        response.setContentType(MediaType.TEXT_PLAIN_VALUE);

        Throwable th = ex;
        while (th.getCause() != null) {
            th = th.getCause();
        }

        //Output stream is closed already, couldn't use it
        if (th instanceof ObjectNotFoundException) {
            response.setHeader("Error-msg", "Requested object is not found");
        } else {
            response.setHeader("Error-msg", th.getMessage());
        }

        logger.info("Full stack trace", ex);

        return new ModelAndView();
    }

    private ModelAndView processAccessDeniedException(HttpServletRequest request,
                                                      HttpServletResponse response, AccessDeniedException ex) {

        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.setContentType(MediaType.TEXT_PLAIN_VALUE);

        HttpSession session = request.getSession();
        boolean loggedOut = session == null || session.getAttribute("role") == null;

        writeResponseMessage(response, ex.getMessage() + (loggedOut ? " [logged out]" : ""));

        return new ModelAndView();
    }

    private ModelAndView processOtherExceptions(HttpServletResponse response, Exception ex) {
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        response.setContentType(MediaType.TEXT_PLAIN_VALUE);

        Throwable cause = ex.getCause();
        if (cause instanceof InvalidFormatException) {
            writeResponseMessage(response, "Unexpected :" + ((InvalidFormatException) cause).getValue());
        } else {
            writeResponseMessage(response, generateErrorMessage(ex));
        }


        return new ModelAndView();
    }

    private void writeResponseMessage(HttpServletResponse response, String message) {
        PrintWriter responseWriter = null;
        try {
            responseWriter = response.getWriter();
            responseWriter.write(message);
        } catch (IOException e) {
            logger.error("Unable to write error into response", e);
        } finally {
            if (responseWriter != null) {
                responseWriter.flush();
            }
        }
    }

    private String generateErrorMessage(Exception ex) {

        String message = ex.getMessage();
        String message2 = null;

        if (ex.getCause() != null && ex.getCause().getMessage() != null) {
            message2 = "Cause: " + ex.getCause().getMessage();
            if (message2.endsWith("\n")) {
                message2 = message2.substring(0, message2.length() - 1);
            }
        }

        if (message != null && message.endsWith("\n")) {
            message = message.substring(0, message.length() - 1);
        }

        logger.info(message + (message2 == null ? "" : (" " + message2)));
        logger.info("Full stack trace", ex);

        if (message2 != null) {
            message += "\n" + message2;
        }

        return message;
    }

}
