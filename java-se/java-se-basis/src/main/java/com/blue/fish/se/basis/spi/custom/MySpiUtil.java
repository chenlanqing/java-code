package com.blue.fish.se.basis.spi.custom;

import com.blue.fish.se.basis.common.UserService;
import com.blue.fish.se.basis.common.UserServiceImpl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author bluefish 2019-05-21
 * @version 1.0.0
 */
public class MySpiUtil {

    /**
     * 自定义了加载配置的文件夹
     */
    private static final String SPI_DIR = "META-INF/idea/";

    private Map<String, Class<?>> classMap = new ConcurrentHashMap<>();

    public void loadDirectory(Class clazz) {
        String fileName = SPI_DIR + clazz.getName();

        ClassLoader classLoader = this.getClass().getClassLoader();

        try {
            Enumeration<URL> resources = classLoader.getResources(fileName);
            if (resources != null) {
                while (resources.hasMoreElements()) {
                    URL url = resources.nextElement();
                    loadResource(classLoader, url);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadResource(ClassLoader classLoader, URL url) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), StandardCharsets.UTF_8));

            String line;

            while ((line = reader.readLine()) != null) {
                int c = line.indexOf("#");
                // 没有注释
                if (c <= 0) {
                    line = line.trim();
                    if (line.length() > 0) {
                        int splitIndex = line.indexOf("=");
                        String name = line.substring(0, splitIndex).trim();
                        String className = line.substring(splitIndex + 1).trim();
                        classMap.put(name, Class.forName(className, true, classLoader));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        MySpiUtil mySpiUtil = new MySpiUtil();
        mySpiUtil.loadDirectory(UserService.class);
        UserServiceImpl userService = (UserServiceImpl) mySpiUtil.classMap.get("UserService").newInstance();
        userService.say();
    }
}
