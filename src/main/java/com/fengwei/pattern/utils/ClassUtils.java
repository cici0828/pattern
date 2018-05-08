package com.fengwei.pattern.utils;

import org.junit.Test;

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
            try {
                List<Class> allClass = getClasses(packageName);
                for(int i=0; i<allClass.size(); i++){
                    if(clzz.isAssignableFrom(allClass.get(i))){
                        System.out.println("a:" + allClass.get(i).getName());
                        if(!clzz.equals(allClass.get(i))){
                            classList.add(allClass.get(i));
                        }
                    }
                    else{
                        System.out.println("b:" + allClass.get(i).getName());
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }

        return  classList;
    }

    private static List<Class> getClasses(String packageName) throws IOException, ClassNotFoundException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String path = packageName.replace(".", "/");
        Enumeration<URL> urlEnumeration = classLoader.getResources(path);
        List<File> dirs = new ArrayList<File>();
        while(urlEnumeration.hasMoreElements()){
            URL resource = urlEnumeration.nextElement();
            dirs.add(new File(resource.getFile()));
        }
        ArrayList<Class> classes = new ArrayList<Class>();
        for(File directory: dirs){
            classes.addAll(findClasses(directory, packageName));
        }
        return classes;
    }

    private static List<Class> findClasses(File directory, String packageName) throws ClassNotFoundException {
        List<Class> classList = new ArrayList<Class>();
        if(!directory.exists()){
            return classList;
        }
        File[] files = directory.listFiles();
        for(File file: files){
            if(file.isDirectory()){
                assert !file.getName().contains(".");
                classList.addAll(findClasses(file, packageName + "." + file.getName()));
            }
            else if(file.getName().endsWith(".class")){
                classList.add(Class.forName(packageName + "." + file.getName().substring(0, file.getName().length() - 6)));
            }
        }
        return classList;

    }
}
