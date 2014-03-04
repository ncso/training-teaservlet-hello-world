
package com.acme.labs.utils;

import java.util.List;
import java.util.ArrayList;

public class JvmInfo {
    public static String[] getJavaInfo() {
        List<String> list = new ArrayList<String>();
        list.add(System.getProperty("java.runtime.name"));
        list.add(System.getProperty("java.runtime.version"));
        list.add(System.getProperty("java.vm.name"));
        list.add(System.getProperty("java.vm.version"));
        list.add(System.getProperty("java.vm.info"));
        return list.toArray(new String[]{});
    }
}
