/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.appbanco.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author 14-ck0013lab
 */
public class Conexion {
     private Connection conexion;

    public Conexion () {

        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/appbanco", "root", "root");
            System.out.println("Conexion exitosa");

        } catch (Exception e) {
            System.out.println("error" + e);
        }

    }
    public Connection retornarConexion() {
        return conexion;
    }
}
