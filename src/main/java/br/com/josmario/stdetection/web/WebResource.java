/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.josmario.stdetection.web;

import br.com.josmario.stdetection.core.manager.Manager;
import com.codahale.metrics.annotation.Timed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author josmario
 */
@Path("/bias-checker")
@Produces(MediaType.APPLICATION_JSON)
public class WebResource {

    @GET
    @Timed
    public ResponseModel checkBias(@QueryParam("url") String url) {
        ResponseModel resp = new ResponseModel();

        return Manager.getInstance().processUrl(url);
    }

}
