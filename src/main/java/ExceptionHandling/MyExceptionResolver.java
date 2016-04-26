package ExceptionHandling;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
 * If instantiated, this bean intercepts all exeptions and sets proper error code of the response. 
 */

@Slf4j
@Component
public class MyExceptionResolver extends SimpleMappingExceptionResolver {

    public MyExceptionResolver() {
        log.warn("Resolver starting...");
    }

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response,
                                         Object handler, Exception ex) {
        log.warn("Logging exception: " + ex.getMessage());
        ModelAndView result = null;
        try {
            if (ex instanceof RuntimeException) response.sendError(HttpServletResponse.SC_EXPECTATION_FAILED);
            if (ex instanceof FileNotFoundException) response.sendError(HttpServletResponse.SC_BAD_GATEWAY);
            if (ex instanceof MyException) response.sendError(HttpServletResponse.SC_CONFLICT);
        } catch (IOException e) {
            //ignore
        }
        return new ModelAndView("alpha");
    }
}
