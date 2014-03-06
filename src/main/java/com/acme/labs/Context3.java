
package com.acme.labs;

import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

public class Context3 {
    private static final Logger LOG = Log.getLogger(Context3.class);

    private int _foo;
    private String _bar;

    public Context3(Integer foo, String bar) {
        LOG.debug("init");
        _foo = foo != null ? foo : 123;
        _bar = bar != null ? bar : "Hello World!";
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
