/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.DAO;

import com.unab.edu.conexionamysql.ConexionBd;
import com.unab.edu.entidades.Persona;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author patty
 */
public class ClsPersona {

    ConexionBd claseConectar = new ConexionBd();
    Connection conectar = claseConectar.RetornarConexion();

    public ArrayList<Persona> MostrarPersona() {
        ArrayList<Persona> Personas = new ArrayList<>();
        try {
            CallableStatement Statement = conectar.prepareCall("call SP_S_Persona()");
            ResultSet resultadoDeConsulta = Statement.executeQuery();
            while (resultadoDeConsulta.next()) {
                Persona persona = new Persona();
                persona.setIdpersona(resultadoDeConsulta.getInt("IdPersona"));
                persona.setNombre(resultadoDeConsulta.getString("Nombre"));
                persona.setApellido(resultadoDeConsulta.getString("Apellido"));
                persona.setEdad(resultadoDeConsulta.getInt("Edad"));
                persona.setSexo(resultadoDeConsulta.getString("Sexo"));
                Personas.add(persona);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return Personas;
    }

    public void AgregarPersonas(Persona Per) {
        try {
            CallableStatement Statement = conectar.prepareCall("call SP_I_Persona(?,?,?,?)");
            Statement.setString("PNombre", Per.getNombre());
            Statement.setString("PApellido", Per.getApellido());
            Statement.setInt("PEdad", Per.getEdad());
            Statement.setString("PSexo", Per.getSexo());
            Statement.execute();
            JOptionPane.showMessageDialog(null, "PERSONA GUARDADA CON EXITO");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void BorrarPersona(Persona Per) {
        try {
            CallableStatement Statement = conectar.prepareCall("call SP_D_Persona(?)");

            Statement.setInt("PIdPersonas", Per.getIdpersona());

            Statement.execute();
            JOptionPane.showMessageDialog(null, "PERSONA ELIMINADA CON EXITO");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void ActualizarPersona(Persona Persona) {
        try {
            CallableStatement Statement = conectar.prepareCall("call SP_U_Persona(?,?,?,?,?)");
            Statement.setInt("PIdPersona", Persona.getIdpersona());
            Statement.setString("PNombre", Persona.getNombre());
            Statement.setString("PApellido", Persona.getApellido());
            Statement.setInt("PEdad", Persona.getEdad());
            Statement.setString("PSexo", Persona.getSexo());
            Statement.execute();
            JOptionPane.showMessageDialog(null, "PERSONA ACTUALIZADA CON EXITO");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

}
