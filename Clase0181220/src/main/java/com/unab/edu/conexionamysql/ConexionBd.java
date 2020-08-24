/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.conexionamysql;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author patty
 */
public class ConexionBd {
    
    private Connection conexion;
            
    public ConexionBd ()
    {
    try{
        conexion = DriverManager.getConnection("jdbc:mysql://localhost/clase1","root","root");
        System.out.println("Conectado a la bd");
        
    }catch (Exception e)
    {
        System.out.println("Error de conexion "+ e);
    }
    }
    public Connection RetornarConexion(){   
    return conexion;   
    }    
}
