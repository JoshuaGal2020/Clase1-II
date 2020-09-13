/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.DAO;

import com.unab.edu.conexionamysql.ConexionBd;
import com.unab.edu.entidades.Profesor;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author patty
 */
public class ClsProfesor {

    ConexionBd claseConectar = new ConexionBd();
    Connection conectar = claseConectar.RetornarConexion();

    public boolean LoguinProfesor(String usuario, String Pass) {
        ArrayList<Profesor> ListaUsuarios = new ArrayList<>();
        ArrayList<Profesor> ListarContra = new ArrayList<>();
        try {
            CallableStatement Statement = conectar.prepareCall("call SP_S_LOGUINPROFESOR(?,?)");
            Statement.setString("PUsu", usuario);
            Statement.setString("PPass", Pass);
            ResultSet resultadoDeConsulta = Statement.executeQuery();
            while (resultadoDeConsulta.next()) {
                Profesor PS = new Profesor();
                PS.setUsu(resultadoDeConsulta.getString("USU"));
                PS.setPass(resultadoDeConsulta.getString("PASS"));
                ListaUsuarios.add(PS);
            }
            String usuariodebasedatos = null;
            String passdebasedatos = null;
            for (var iterador : ListaUsuarios) {
                usuariodebasedatos = iterador.getUsu();
                passdebasedatos = iterador.getPass();
            }
            
            CallableStatement st2 = conectar.prepareCall("call PcripPass2(?)");
            st2.setString("PcripPass2",Pass);
            ResultSet rs2 = st2.executeQuery();
            while (rs2.next()) {
                Profesor escrip = new Profesor();

                escrip.setPass(rs2.getNString("crip2"));
                ListarContra.add(escrip);
            }
            String passcrip = null;
            for (var iterador : ListarContra) {

                passcrip = iterador.getPass();

                Pass = passcrip;
            }
            if (usuariodebasedatos != null && passdebasedatos != null) {
                if (usuariodebasedatos.equals(usuario) && passdebasedatos.equals(Pass)) {
                    return true;
                }
            }

            conectar.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e);
        }
        return false;
    }
}
