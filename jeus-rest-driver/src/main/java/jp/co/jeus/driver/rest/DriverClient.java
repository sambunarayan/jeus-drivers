/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeus.driver.rest;

import com.google.gson.Gson;
import java.util.concurrent.TimeUnit;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import jp.co.jeus.driver.rest.dto.TestDto;
import jp.co.jeus.driver.rest.props.DriverSettingsProperties;

/**
 *
 * @author soyou
 */
public class DriverClient {

    private static final String getPath = "test-service1/todo/findAll";

    private static final String postPath = "test-service1/todo/findByKey";

    private WebTarget webTarget;

    private void initialize() {
        Client client = ClientBuilder.newBuilder()
                .connectTimeout(Long.parseLong(DriverSettingsProperties.get(DriverSettingsProperties.Keys.CONNECT_TIMEOUT)), TimeUnit.MILLISECONDS)
                .readTimeout(Long.parseLong(DriverSettingsProperties.get(DriverSettingsProperties.Keys.READ_TIMEOUT)), TimeUnit.MILLISECONDS)
                .build();
        this.webTarget = client.target(DriverSettingsProperties.get(DriverSettingsProperties.Keys.URL));
    }

    protected WebTarget getWebTarget() {
        if (this.webTarget == null) {
            initialize();
        }
        return this.webTarget;
    }

    public void post(TestDto testDto) {
        System.out.println("POST");
        Response response = getWebTarget()
                .path(postPath)
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.<String>entity(new Gson().toJson(testDto), MediaType.APPLICATION_JSON));

        System.out.println(" Response HttpStatus:" + response.getStatus());
        System.out.println(" Response HttpStatus:" + response.readEntity(String.class));
    }

    public void get() {
        System.out.println("GET");
        Response response = getWebTarget()
                .path(getPath)
                .request(MediaType.APPLICATION_JSON)
                .get();

        System.out.println(" Response HttpStatus:" + response.getStatus());
        System.out.println(" Response Entity:" + response.readEntity(String.class));
    }
}
