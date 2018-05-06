package com.fengwei.pattern.utils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class ClassUtils {
    public static List<Class> getAllClassByInterface(Class clzz){
        List<Class> classList = new ArrayList<Class>();

        if(clzz.isInterface()){
            String packageName = clzz.getPackage().getName();
            System.out.println(packageName);
            //List<Class> allClass =

        }

        return  classList;
    }

    private static List<Class> getClasses(String packageName) throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String path = packageName.replace(".", "/");
        Enumeration<URL> urlEnumeration = classLoader.getResources(path);
        List<File> dirs = new ArrayList<File>();
        return null;
    }
}
