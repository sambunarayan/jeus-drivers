/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeus.driver.rest.logic;

import jp.co.jeus.driver.rest.DriverClient;
import jp.co.jeus.driver.rest.dto.TestDto;
import jp.co.jeus.driver.rest.props.DriverSettingsProperties;

/**
 *
 * @author soyou
 */
public class SendRequestLogic {

    private DriverClient client = new DriverClient();

    public void execute() {
        System.out.println(DriverSettingsProperties.get(DriverSettingsProperties.Keys.URL));
        System.out.println("Driver Started.");
        TestDto dto = new TestDto();
        dto.setId("abc");
        client.get();
    }
}
