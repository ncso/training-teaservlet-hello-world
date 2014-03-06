
package com.acme.labs;

import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

public class Context5 {
    private static final Logger LOG = Log.getLogger(Context5.class);
    private final String _sessionId;
    private final int _counter;
    Context5(String sessionId, int counter) {
        _sessionId = sessionId;
        _counter = counter;
    }
    public String getSessionId() {
        return _sessionId;
    }
    public int getCounter() {
        return _counter;
    }
}
