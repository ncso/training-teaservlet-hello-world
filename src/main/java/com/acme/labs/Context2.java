
package com.acme.labs;

import org.teatrove.trove.util.PropertyMap;

import org.teatrove.teaapps.Context;
import org.teatrove.teaapps.ContextConfig;

import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

public class Context2 implements Context {
    private static final Logger LOG = Log.getLogger(Context2.class);

    private int _foo;
    private String _bar;

    @Override
    public void init(ContextConfig config) {
        LOG.debug("init");
        PropertyMap props = config.getProperties();
        _foo = props.getInteger("foo", 123);
        _bar = props.getString("bar", "Hello World!");
    }

    public int getFoo() {
        LOG.debug("getFoo()");
        return _foo;
    }
    public String getBar() {
        LOG.debug("getBar()");
        return _bar;
    }

    public String whoami() {
        return getClass().getName();
    }
}
