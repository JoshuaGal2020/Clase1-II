/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.entidades;

import java.util.Date;
import lombok.Data;
/**
 *
 * @author patty
 */
@Data
public class Persona {
    
    
    private int Idpersona;
    private String Nombre;
    private String Apellido;
    private int Edad;
    private String Sexo;
    protected Date Fecha;
}
