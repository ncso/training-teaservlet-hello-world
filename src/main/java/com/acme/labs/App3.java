
package com.acme.labs;

import org.teatrove.trove.util.PropertyMap;

import org.teatrove.teaservlet.Application;
import org.teatrove.teaservlet.ApplicationConfig;
import org.teatrove.teaservlet.ApplicationRequest;
import org.teatrove.teaservlet.ApplicationResponse;

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
        _bar = props.getString("bar", "hello world!");
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
        return _context;
    }
}
