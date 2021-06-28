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

/**
 *
 * @author soyou
 */
public class DriverClient {

    private static final String servicePath = "test-service1/connection-test";

    private WebTarget webTarget;

    private void initialize() {
        Client client = ClientBuilder.newBuilder()
                .connectTimeout(1000, TimeUnit.MILLISECONDS)
                .readTimeout(10000, TimeUnit.MILLISECONDS)
                .build();
        this.webTarget = client.target("http://172.22.0.3:8080/WebAppOnDocker-1.0.0");
    }

    protected WebTarget getWebTarget() {
        if (this.webTarget == null) {
            initialize();
        }
        return this.webTarget;
    }

    public void post(TestDto testDto) {
        System.out.println("post");
        Response response = getWebTarget()
                .path(servicePath)
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.<String>entity(new Gson().toJson(testDto), MediaType.APPLICATION_JSON));

        System.out.println(" Response HttpStatus:" + response.getStatus());
        System.out.println(" Response HttpStatus:" + response.getEntity());
    }

    public void get() {
        System.out.println("GET");
        Response response = getWebTarget()
                .path(servicePath)
                .request(MediaType.APPLICATION_JSON)
                .get();

        System.out.println(" Response HttpStatus:" + response.getStatus());
        System.out.println(" Response Entity:" + new Gson().toJson(response.getEntity()));
    }
}
