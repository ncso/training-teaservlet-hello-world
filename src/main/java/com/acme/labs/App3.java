
package com.acme.labs;

import java.util.Map;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponseWrapper;

import org.teatrove.trove.util.PropertyMap;

import org.teatrove.teaservlet.Application;
import org.teatrove.teaservlet.ApplicationConfig;
import org.teatrove.teaservlet.ApplicationRequest;
import org.teatrove.teaservlet.ApplicationResponse;

import org.teatrove.tea.runtime.TemplateLoader;

import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

public class App3 implements Application {
    private static final Logger LOG = Log.getLogger(App3.class);

    private int _foo;
    private String _bar;

    private Context3 _context;

    @Override
    public void init(ApplicationConfig config) {
        LOG.debug("init");
        PropertyMap props = config.getProperties();
        _foo = props.getInteger("foo", 123);
        _bar = props.getString("bar", "Hello World!");
        _context = new Context3(_foo,_bar);
    }

    @Override
    public void destroy() {
        LOG.debug("destroy");
        _context = null;
    }

    @Override
    public Class<?> getContextType() {
        LOG.debug("get context type");
        return Context3.class;
    }

    @Override
    public Object createContext(ApplicationRequest request,
                                    ApplicationResponse response) {
        LOG.debug("create context");

        LOG.debug("Is request instance of HttpServletRequest? " + (request instanceof HttpServletRequest));
        LOG.debug("Is request instance of HttpServletRequestWrapper? " + (request instanceof HttpServletRequestWrapper));
        LOG.debug("Is response instance of HttpServletResponse? " + (response instanceof HttpServletResponse));
        LOG.debug("Is response instance of HttpServletResponseWrapper? " + (response instanceof HttpServletResponseWrapper));

        /* request.getApplicationContextTypes() */
        Map<?,?> m = request.getApplicationContextTypes();
	if (!m.isEmpty()) {
            LOG.debug("listing {application,context-type} mapping");
            Iterator<? extends Map.Entry<?,?>> iter = m.entrySet().iterator();
            Map.Entry<?,?> i;
            while (iter.hasNext()) {
                i = iter.next();
                LOG.debug("  [" + i.getKey() + "] -> [" + i.getValue() + "]");
            }
            LOG.debug("done listing");
        } else {
            LOG.debug("no {application,context-type} mapping");
        }

        /* request.getIdentifier() */
        LOG.debug("request identifier: [" + request.getIdentifier() + "]");

        /* request.getTemplate() */
        TemplateLoader.Template tmpl = request.getTemplate();
        LOG.debug("request template: [" + tmpl.getName() + "]");

        return _context;
    }
}
