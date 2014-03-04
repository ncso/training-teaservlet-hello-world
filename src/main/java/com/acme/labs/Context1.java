
package com.acme.labs;

import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

public class Context1 {
    private static final Logger LOG = Log.getLogger(Context1.class);

    private int _foo = 123;
    private String _bar = "Hello World!";

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
