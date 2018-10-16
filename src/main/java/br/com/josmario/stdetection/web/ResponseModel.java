/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.josmario.stdetection.web;

import io.dropwizard.jackson.JsonSnakeCase;
import java.io.Serializable;

/**
 *
 * @author josmario
 */
@JsonSnakeCase
public class ResponseModel implements Serializable {

    public String url;
    public double red, green, blue, textF, textM;
    public String decision;

}
