package com.pccasa.unipar.central.teste;


import com.pccasa.unipar.central.models.Pais;
import com.pccasa.unipar.central.utils.DataBaseUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Teste {
    private static final String FIND_ALL = "SELECT id, NOME, SIGLA, RA FROM pais WHERE id = 2";

    public static void main(String[] args) throws SQLException {
        ArrayList<Pais> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_ALL);
            rs = pstmt.executeQuery();
            while(rs.next()){
                Pais pais = new Pais();//para utilizar para setar no arraylist de retorno
                pais.setId(rs.getInt("ID"));
                pais.setNome(rs.getString("NOME"));
                pais.setRa(rs.getString("RA"));
                pais.setSigla(rs.getString("SIGLA"));

                retorno.add(pais);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally{
            if(rs != null){
                rs.close();
            }

            if(pstmt != null){
                pstmt.close();
            }

            if(conn != null){
                conn.close();
            }
        }

        System.out.println(retorno);

    }
}
