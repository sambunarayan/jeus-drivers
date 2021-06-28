/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeus.driver.rest.main;

import jp.co.jeus.driver.rest.logic.SendRequestLogic;

/**
 *
 * @author soyou
 */
public class RestMain {

    public static void main(String[] args) {
        new SendRequestLogic().execute();
    }
}
