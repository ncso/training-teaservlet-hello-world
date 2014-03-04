
package com.acme.labs;

import java.util.concurrent.atomic.AtomicInteger;

import org.teatrove.tea.runtime.Substitution;

import org.teatrove.trove.util.PropertyMap;

import org.teatrove.teaapps.Context;
import org.teatrove.teaapps.ContextConfig;

import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

public class Context4 implements Context {
    private static final Logger LOG = Log.getLogger(Context4.class);

    private int _count;
    private int _current = -1;

    @Override
    public void init(ContextConfig config) {
        LOG.debug("init");
        PropertyMap props = config.getProperties();
        _count = props.getInteger("count", 5);
    }

    public void forEachElement(Substitution substitution) throws Exception {
        for (int i = 0; i < _count; i++) {
            _current = i;
            substitution.substitute();
        }
    }

    public AtomicInteger createAtomicInteger(int initialValue) {
        return new AtomicInteger(initialValue);
    }

    public void forEachElement(AtomicInteger iRef, Substitution substitution) throws Exception {
        for (int i = 0; i < _count; i++) {
            _current = i;
            substitution.substitute();
            iRef.incrementAndGet();
        }
    }

    public int currentElementIndex() {
        return _current;
    }

    public String currentElementDetail() {
        return "Element" + _current;
    }
}
