
package com.acme.labs;

import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;

import org.teatrove.teaservlet.TeaServlet;

import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

@WebServlet(
            value="/s02/*",
            initParams = {
                @WebInitParam(name="debug", value="true"),
                @WebInitParam(name="properties.file", value="/WEB-INF/s02-teaservlet.properties"),
            },
            loadOnStartup=1)
public class Servlet02 extends TeaServlet {
    private static final Logger LOG = Log.getLogger(Servlet02.class);
}
