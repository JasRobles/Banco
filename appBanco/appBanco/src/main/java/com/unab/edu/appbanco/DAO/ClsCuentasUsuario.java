/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.appbanco.DAO;

import com.unab.edu.appbanco.Conexion.Conexion;
import com.unab.edu.appbanco.Entidades.CuentasUsuario;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author 14-ck0013lab
 */
public class ClsCuentasUsuario {
    
    Conexion con = new Conexion();
    Connection conectar = con.retornarConexion();
    
    public void InsertarAbono(CuentasUsuario cuentas){ 
        try {
            java.sql.CallableStatement call = conectar.prepareCall("call SP_I_ABONO(?,?,?)");
             call.setInt("Pid", cuentas.getId());
             call.setDouble("pSaldo", cuentas.getSaldo());
             call.setDate("pFecha", new java.sql.Date(cuentas.getFecha().getTime()));
             call.execute();
            JOptionPane.showMessageDialog(null, "El Abono se ha Realizado con Exito");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
