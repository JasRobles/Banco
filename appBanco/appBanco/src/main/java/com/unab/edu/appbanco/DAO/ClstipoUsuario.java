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
    public ArrayList<TipoUsuario>Mostrar(){
    ArrayList<TipoUsuario>lista = new ArrayList<>();
    try {
        CallableStatement call = coneccion.prepareCall("CALL SP_S_TIPO()");
        ResultSet resul = call.executeQuery();
        while(resul.next()){
        TipoUsuario usu = new TipoUsuario();
        usu.setId(resul.getInt("Id"));
        usu.setTipoUsuario(resul.getString("TipoUser"));
        lista.add(usu);
        }
            coneccion.close();
        } catch (Exception e) {
            System.out.println("error"+e);
        }
    for(var i : lista){
    //    System.out.println(i.getId()+"   "+i.getTipoUsuario());
    
    }
   return lista;
   
    }  
}
