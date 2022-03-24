/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ito.tecnm.oaxaca.examenunidad1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author maste
 */
@RestController
@RequestMapping("/")
public class IndexController {
    @GetMapping
    public String index(){
    
        return "<h1>Server Running</h1>";
    }
}