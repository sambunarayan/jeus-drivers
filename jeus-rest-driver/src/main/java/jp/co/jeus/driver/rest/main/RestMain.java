/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeus.driver.rest.main;

import java.io.IOException;
import jp.co.jeus.driver.rest.constants.RequestMethod;
import jp.co.jeus.driver.rest.logic.SendRequestLogic;
import jp.co.jeus.driver.rest.props.DriverSettingsProperties;

/**
 *
 * @author soyou
 */
public class RestMain {

    public static void main(String[] args) throws IOException {
        System.out.println(DriverSettingsProperties.get(DriverSettingsProperties.Keys.URL));
        System.out.println("Driver Started.");
        switch (RequestMethod.getMethod(args[0])) {
            case GET:
                new SendRequestLogic().requestGet();
                break;
            case POST:
                new SendRequestLogic().requestPost(args[1]);
                break;
            default:
                System.out.println("Not applicable");
                break;
        }

    }
}
