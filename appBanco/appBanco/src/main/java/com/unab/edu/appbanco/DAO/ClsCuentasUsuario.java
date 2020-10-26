/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.appbanco.DAO;

import com.unab.edu.appbanco.Conexion.Conexion;
import com.unab.edu.appbanco.Entidades.CuentasUsuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author 14-ck0013lab
 */
public class ClsCuentasUsuario {

    Conexion con = new Conexion();
    Connection conectar = con.retornarConexion();

    public void InsertarAbono(CuentasUsuario cuentas) {
        try {
            CallableStatement call = conectar.prepareCall("call SP_I_ABONO(?,?,?)");
            call.setInt("Pid", cuentas.getIdUsuario());
            call.setDouble("pSaldo", cuentas.getSaldo());
            call.setDate("pFecha", new java.sql.Date(cuentas.getFecha().getTime()));
            call.execute();
            JOptionPane.showMessageDialog(null, "El Abono se ha Realizado con Exito");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void InsertarRetiro(CuentasUsuario cuentas) {
        try {
            CallableStatement call = conectar.prepareCall("call SP_I_RETIRO(?,?)");
            call.setInt("Pid", cuentas.getIdUsuario());
            call.setDouble("pSaldo", cuentas.getSaldo());
            call.execute();
            JOptionPane.showMessageDialog(null, "El retiro se ha Realizado con Exito");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public  ArrayList<CuentasUsuario>lista (CuentasUsuario cuen){
    ArrayList<CuentasUsuario>ListaCuentas= new ArrayList<>();
        try {
            CallableStatement call = conectar.prepareCall("call SP_S_TRANSACCIONES(?)");
           call.setInt("pId", cuen.getIdUsuario());
            ResultSet resultado= call.executeQuery();
            while(resultado.next()){
            CuentasUsuario c = new CuentasUsuario();
            c.setFecha(resultado.getDate("fecha"));
            c.setTransaccion(resultado.getInt("transaccion"));
            c.setSaldo(resultado.getDouble("saldo"));
            ListaCuentas.add(c);
            }
            
        } catch (Exception e) {
        }
        System.out.println(ListaCuentas.size());
    return ListaCuentas;
    }
}