/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeus.driver.rest.constants;

/**
 *
 * @author soyou
 */
public enum RequestMethod {
    GET, POST, DELETE, PUT,;

    public static RequestMethod getMethod(String method) {
        if (method == null) {
            return null;
        }
        method = method.toUpperCase();
        for (RequestMethod m : RequestMethod.values()) {
            if (m.name().equals(method)) {
                return m;
            }
        }
        return null;
    }
}
