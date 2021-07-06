/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeus.driver.rest.logic;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import jp.co.jeus.driver.rest.DriverClient;
import jp.co.jeus.driver.rest.dto.TestDto;

/**
 *
 * @author soyou
 */
public class SendRequestLogic {

    private DriverClient client = new DriverClient();

    public void requestGet() {
        client.get();
    }

    public void requestPost(String path) throws IOException {
        Files.readAllLines(Paths.get(path)).forEach(o -> {
            TestDto dto = new TestDto();
            dto.setId(o);
            client.post(dto);
        });
    }
}
