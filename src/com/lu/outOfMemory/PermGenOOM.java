package com.lu.outOfMemory;


import java.io.File;
import java.lang.reflect.Proxy;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

/**
 * VM Args: -XX:MaxMetaspaceSize=10M -XX:+HeapDumpOnOutOfMemoryError
 * Created by yuanchen on 16-10-18.
 * MaxPermSize is ignored
 *
 */
public class PermGenOOM {

    public static void main(String[] args) {
        URL url = null;
        List<Class> classList = new ArrayList<>();
        int index = 0;

        try {
            url = new File("/tmp").toURI().toURL();
            URL[] urls = {url};

            while (true) {
                ClassLoader loader = new URLClassLoader(urls);
                Class proxyClass= Proxy.getProxyClass(loader,new Class<?>[]{InterfaceA.class});
                classList.add(proxyClass);
                index++;
            }
        } catch (Throwable e) {
            System.out.println("index:" + index);
            e.printStackTrace();
        }
    }
}
