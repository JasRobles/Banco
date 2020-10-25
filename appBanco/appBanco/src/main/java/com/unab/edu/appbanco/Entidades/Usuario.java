/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.appbanco.Entidades;

import lombok.*;

/**
 *
 * @author 14-ck0013lab
 */
@Data
public class Usuario extends TipoUsuario{
    private int idUsuario;
    private String usuario;
    private String PassWord;
   

    
}
