/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.DAO;

import com.unab.edu.conexionamysql.ConexionBd;
import com.unab.edu.entidades.Estudiante;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author patty
 */
public class ClsJoinPersonaEstudiante {

    ConexionBd cn = new ConexionBd();
    Connection con = cn.RetornarConexion();

    public ArrayList<Estudiante> MostrarJoinEstudiantePersona() {
        ArrayList<Estudiante> lista = new ArrayList<>();

        try {
            CallableStatement st = con.prepareCall("call SP_S_JOINPERSONAESTUDIANTE ()");

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Estudiante es = new Estudiante();
                es.setNombre(rs.getString("nombre"));
                es.setApellido(rs.getString("apellido"));
                es.setMatricula(rs.getInt("matricula"));

                lista.add(es);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e);
        }
        return lista;
    }

}
