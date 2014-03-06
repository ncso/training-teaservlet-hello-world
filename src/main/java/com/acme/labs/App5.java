
package com.acme.labs;

import javax.servlet.http.HttpSession;

import org.teatrove.teaservlet.Application;
import org.teatrove.teaservlet.ApplicationConfig;
import org.teatrove.teaservlet.ApplicationRequest;
import org.teatrove.teaservlet.ApplicationResponse;

import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

public class App5 implements Application {
    private static final Logger LOG = Log.getLogger(App5.class);

    private static String COUNTER_KEY = App5.class.getName() + ".counter";

    private Context5 _context;

    @Override
    public void init(ApplicationConfig config) {
        LOG.debug("init");
    }

    @Override
    public void destroy() {
        LOG.debug("destroy");
        _context = null;
    }

    @Override
    public Class<?> getContextType() {
        LOG.debug("get context type");
        return Context5.class;
    }

    @Override
    public Object createContext(ApplicationRequest request,
                                    ApplicationResponse response) {
        LOG.debug("create context, COUNTER_KEY = \"" + COUNTER_KEY + "\"");

        HttpSession session = request.getSession();

        /* application implements logic and raw data do context */
        Integer counter = (Integer)session.getAttribute(COUNTER_KEY);
        counter = counter == null ? 1 : counter + 1;
        session.setAttribute(COUNTER_KEY, counter);

        /* context expose the application to templates */
        Context5 appContext = new Context5(session.getId(), counter);
        return appContext;
    }
}
