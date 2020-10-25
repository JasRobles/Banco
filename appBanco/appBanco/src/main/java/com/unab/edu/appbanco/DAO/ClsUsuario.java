/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.appbanco.DAO;

import com.unab.edu.appbanco.Conexion.Conexion;
import com.unab.edu.appbanco.Entidades.CuentasUsuario;
import com.unab.edu.appbanco.Entidades.Usuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author 14-ck0013lab
 */
public class ClsUsuario {

    Conexion con = new Conexion();
    Connection coneccion = con.retornarConexion();
    public boolean resultado;
    public int TipoUsu;
    public int IdUsu;

    public boolean login(String usu, String pass) {

        ArrayList<Usuario> listaUsuariopass = new ArrayList<>();
        ArrayList<Usuario> ListaPass = new ArrayList<>();
        try {
            CallableStatement call = coneccion.prepareCall("Call SP_S_LOGIN(?,?)");
            call.setString("pUsuario", usu);
            call.setString("pPass", pass);
            ResultSet resul = call.executeQuery();
            while (resul.next()) {
                Usuario usuario = new Usuario();
                usuario.setUsuario(resul.getString("Usuario"));
                usuario.setPassWord(resul.getString("PassWord"));
                usuario.setIdUsuario(resul.getInt("idUsuario"));
                usuario.setId(resul.getInt("tipoUsuario"));
                
                listaUsuariopass.add(usuario);
            }

            String usuBase = "";
            String passBase = "";
            for (var i : listaUsuariopass) {
                usuBase = i.getUsuario();
                passBase = i.getPassWord();
                IdUsu=i.getIdUsuario();
                TipoUsu=i.getId();
              
            }
            CallableStatement call2 = coneccion.prepareCall("call SP_S_CRIP(?)");
            call2.setString("PcripPass", pass);
            ResultSet rs2 = call2.executeQuery();
            while (rs2.next()) {
                Usuario escrip = new Usuario();
                escrip.setPassWord(rs2.getString("crip"));
                ListaPass.add(escrip);
            }
            String Passencriptada = null;
            for(var i : ListaPass){
            Passencriptada = i.getPassWord();
            pass = Passencriptada;
            }
                
            if (usuBase != null && passBase != null) {
                if (usuBase.equals(usu) && passBase.equals(pass)) {
                    resultado = true;
                } else {
                    resultado = false;

                }
            }
            coneccion.close();

        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return resultado;
        
    }
}
