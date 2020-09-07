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
import java.util.*;
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
            CallableStatement st = conectar.prepareCall("call SP_S_ESTUDIANTE()");
            ResultSet Resulta = st.executeQuery();
            while (Resulta.next()) {
                Estudiante es = new Estudiante();
                es.setId(Resulta.getInt("idestudiante"));
                es.setMatricula(Resulta.getInt("matricula"));
                es.setIdpersona(Resulta.getInt("IdPersona"));
                es.setNombre(Resulta.getString("nombre"));
                es.setUsu(Resulta.getString("USU"));
                es.setPass(Resulta.getString("PASS"));
                es.setNie(Resulta.getInt("NIE"));

                lista.add(es);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR" + e);
        }
        return lista;
    }

    public void AgregarEstudiante(Estudiante EST) {
        try {
            CallableStatement Statement = conectar.prepareCall("call SP_I_ESTUDIANTE(?,?,?,?,?)");
            Statement.setInt("EMatricula", EST.getMatricula());
            Statement.setInt("EIdPersona", EST.getIdpersona());
            Statement.setString("EUsuario", EST.getUsu());
            Statement.setString("EPass", EST.getPass());
            Statement.setInt("ENie", EST.getNie());
            Statement.execute();
            conectar.close();
            JOptionPane.showMessageDialog(null, "ESTUDIANTE GUARDAD@ CON EXITO");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void BorrarEstudiante(Estudiante EST) {
        try {
            CallableStatement Statement = conectar.prepareCall("call SP_D_ESTUDIANTE(?)");

            Statement.setInt("GIdEstudiantes", EST.getId());

            Statement.execute();
            conectar.close();
            JOptionPane.showMessageDialog(null, "ESTUDIANTE ELIMINAD@ CON EXITO");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void ActualizarEstudiante(Estudiante Estudiante) {
        try {
            CallableStatement Statement = conectar.prepareCall("call SP_U_ESTUDIANTE(?,?,?,?,?,?)");
            Statement.setInt("PIdEstudiante", Estudiante.getId());
            Statement.setInt("PMatricula", Estudiante.getMatricula());
            Statement.setInt("PIdPersona", Estudiante.getIdpersona());
            Statement.setString("PUsu", Estudiante.getUsu());
            Statement.setString("PPass", Estudiante.getPass());
            Statement.setInt("PNie", Estudiante.getNie());
            Statement.execute();
            conectar.close();
            JOptionPane.showMessageDialog(null, "ESTUDIANTE ACTUALIZAD@ CON EXITO");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
