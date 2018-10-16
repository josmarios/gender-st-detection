/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.josmario.stdetection.web;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

/**
 *
 * @author josmario
 */
public class WebApplication extends Application<WebConfiguration> {

    public static void main(String[] args) throws Exception {
        new WebApplication().run(args);
    }

    @Override
    public void run(WebConfiguration t, Environment e) throws Exception {
        final WebResource resource = new WebResource();
        e.jersey().register(resource);
    }

}
