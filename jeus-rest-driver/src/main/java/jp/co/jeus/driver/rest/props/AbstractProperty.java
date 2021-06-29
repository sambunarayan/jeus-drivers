/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeus.driver.rest.props;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import jp.co.jeus.driver.rest.annotation.PropertyAnnotation;

/**
 *
 * @author soyou
 */
public abstract class AbstractProperty {

    private static final Map<String, String> PROP_HOLDER = new HashMap<>();

    private static final String INIT_FILE_PATH = "src/main/resources/";

    protected static void setBundle(Class<? extends AbstractProperty> clazz) {
        for (Annotation anno : clazz.getAnnotations()) {
            if (anno instanceof PropertyAnnotation) {
                Properties pro = new Properties();
                try {
                    System.out.println();
                    pro.load(Files.newBufferedReader(Paths.get(INIT_FILE_PATH, ((PropertyAnnotation) anno).bundle())));
                    for (Entry<Object, Object> e : pro.entrySet()) {
                        PROP_HOLDER.put(e.getKey().toString(), e.getValue().toString());
                    }
                } catch (IOException ex) {
                    Logger.getLogger(AbstractProperty.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    protected static String get(String key) {
        return PROP_HOLDER.get(key);
    }
}
