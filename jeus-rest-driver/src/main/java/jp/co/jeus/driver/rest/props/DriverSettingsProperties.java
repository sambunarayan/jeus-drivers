/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeus.driver.rest.props;

import jp.co.jeus.common.lib.props.AbstractProperty;
import jp.co.jeus.common.lib.dto.annotation.PropertyAnnotation;

/**
 *
 * @author soyou
 */
@PropertyAnnotation(bundle = "DriverSettings")
public class DriverSettingsProperties extends AbstractProperty {

    static {
        setBundle(DriverSettingsProperties.class);
    }

    public enum Keys {
        URL("url"),
        CONNECT_TIMEOUT("connect.timeout"),
        READ_TIMEOUT("read.timeout"),;

        private final String value;

        private Keys(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }
    }

    public static String get(Keys key) {
        return get(DriverSettingsProperties.class, key.getValue());
    }
}
