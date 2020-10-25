/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.appbanco.DAO;

import com.mysql.cj.protocol.Resultset;
import com.unab.edu.appbanco.Conexion.Conexion;
import com.unab.edu.appbanco.Entidades.TipoUsuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Rafael
 */
public class ClstipoUsuario {
    
    Conexion con = new Conexion();
    Connection coneccion = con.retornarConexion();
    public ArrayList<TipoUsuario>MostrarPersonas(){
    ArrayList<TipoUsuario>lista = new ArrayList<>();
    try {
        CallableStatement call = coneccion.prepareCall("select*from tipousuario");
        ResultSet resul = call.executeQuery();
        while(resul.next()){
        TipoUsuario usu = new TipoUsuario();
        
        
        }
        
        
            
        } catch (Exception e) {
        }
   return lista;
    }  
}
