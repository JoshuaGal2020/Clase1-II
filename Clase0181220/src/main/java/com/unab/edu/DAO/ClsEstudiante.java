/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.DAO;

import com.unab.edu.conexionamysql.ConexionBd;
import com.unab.edu.entidades.Estudiante;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author patty
 */
public class ClsEstudiante {

    ConexionBd claseConectar = new ConexionBd();
    Connection conectar = claseConectar.RetornarConexion();

    public boolean LoguinEstudiante(String usuario, String Pass) {
        ArrayList<Estudiante> ListaUsuariosPass = new ArrayList<>();
        try {
            CallableStatement Statement = conectar.prepareCall("call SP_S_LOGUIESTUDIANTE(?,?)");
            Statement.setString("pusuario", usuario);
            Statement.setString("ppass", Pass);
            ResultSet resultadoDeConsulta = Statement.executeQuery();
            while (resultadoDeConsulta.next()) {
                Estudiante es = new Estudiante();
                es.setUsu(resultadoDeConsulta.getString("USU"));
                es.setPass(resultadoDeConsulta.getString("PASS"));
                ListaUsuariosPass.add(es);
            }
            String usuariodebasedatos = null;
            String passdebasedatos = null;
            for (var iterador : ListaUsuariosPass) {
                usuariodebasedatos = iterador.getUsu();
                passdebasedatos = iterador.getPass();

            }
            if (usuariodebasedatos.equals(usuario) && passdebasedatos.equals(Pass)) {
                return true;
            }
            

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return false;
    }

    public ArrayList<Estudiante> MostrarEstudiante() {
        ArrayList<Estudiante> lista = new ArrayList<>();

        try {
            CallableStatement st = conectar.prepareCall("call SP_S_ESTUDIANTE (?,?,?,?,?,?,?)");
            ResultSet Resulta = st.executeQuery();
            while (Resulta.next()) {
                Estudiante es = new Estudiante();
                es.setId(Resulta.getInt("Idestudiante"));
                es.setMatricula(Resulta.getInt("matricula"));
                es.setIdpersona(Resulta.getInt("idPersona"));
                es.setNombre(Resulta.getString("nombre"));
                es.setUsu(Resulta.getString("USU"));
                es.setPass(Resulta.getString("PASS"));

                lista.add(es);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e);
        }
        return lista;
    }
}
