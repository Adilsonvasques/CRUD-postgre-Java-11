package com.pccasa.unipar.central.repositories;

import com.pccasa.unipar.central.models.Estado;
import com.pccasa.unipar.central.models.Pais;
import com.pccasa.unipar.central.utils.DataBaseUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstadoDAO {
    private static final String INSERT = "INSERT INTO ESTADO(id, nome, sigla, pais_id)" +
            "VALUES(?, ?, ?, ?)";

    private static final String FIND_ALL = "SELECT e.ID, e.NOME, e.SIGLA, p.ID AS PAIS_ID, p.NOME AS PAIS_NOME " +
            "FROM ESTADO e INNER JOIN PAIS p ON e.PAIS_ID = p.ID";

    private static final String FIND_BY_ID =
            "SELECT e.ID, e.NOME, e.SIGLA, p.ID AS PAIS_ID, p.NOME AS PAIS_NOME " +
                    "FROM ESTADO e INNER JOIN PAIS p ON e.PAIS_ID = p.ID WHERE e.ID = ?";

    private static final String DELETE_BY_ID =
            "DELETE FROM ESTADO WHERE ID = ?";

    private static final String UPDATE = "UPDATE ESTADO SET NOME = ?, SIGLA = ?, PAIS_ID = ? " +
            "WHERE ID = ?";

    public List<Estado> findAll() throws SQLException {

        ArrayList<Estado> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{

            conn = new DataBaseUtils().getConnection();

            pstmt = conn.prepareStatement(FIND_ALL);

            rs = pstmt.executeQuery();//executa FIND_ALL, retorna o resultado

            while(rs.next()){//enquanto não acabar
                Estado estado = new Estado();//para utilizar para setar no arraylist de retorno
                estado.setId(rs.getInt("ID"));//getInt - pq id é inteiro
                estado.setNome(rs.getString("NOME"));
                estado.setSigla(rs.getString("SIGLA"));

                Pais pais = new Pais();
                pais.setId(rs.getInt("PAIS_ID"));
                pais.setNome(rs.getString("PAIS_NOME"));

                estado.setPais(pais);

                retorno.add(estado);
            }

        }finally{

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

        return retorno;

    }

    public Estado findById(int id) throws SQLException{

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Estado retorno = null;

        try{

            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();

            while(rs.next()){
                retorno = new Estado();
                retorno.setId(rs.getInt("ID"));//getInt - pq id é inteiro
                retorno.setNome(rs.getString("NOME"));
                retorno.setSigla(rs.getString("SIGLA"));

                Pais pais = new Pais();
                pais.setId(rs.getInt("PAIS_ID"));
                pais.setNome(rs.getString("PAIS_NOME"));

                retorno.setPais(pais);
            }

        }finally{

            if(rs != null)
                rs.close();

            if(pstmt != null)
                pstmt.close();

            if(conn != null)
                conn.close();

        }

        return retorno;

    }

    public void insert(Estado estado) throws SQLException{

        Connection conn = null;
        PreparedStatement pstmt = null;

        try{

            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setInt(1, estado.getId());
            pstmt.setString(2, estado.getNome());
            pstmt.setString(3, estado.getSigla());
            pstmt.setInt(4, estado.getPais().getId());

            pstmt.executeUpdate();

        }finally{

            if(conn != null)
                conn.close();

            if(pstmt != null)
                pstmt.close();

        }

    }

    public void update(Estado estado) throws SQLException{

        Connection conn = null;
        PreparedStatement pstmt = null;

        try{

            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setString(1, estado.getNome());
            pstmt.setString(2, estado.getSigla());
            pstmt.setInt(3, estado.getPais().getId());
            pstmt.setInt(4, estado.getId());

            pstmt.executeUpdate();

        }finally{

            if(pstmt != null)
                pstmt.close();

            if(conn != null)
                conn.close();

        }

    }

    public void delete(int id) throws SQLException{

        Connection conn = null;
        PreparedStatement pstmt = null;

        try{

            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(DELETE_BY_ID);
            pstmt.setInt(1, id);

            pstmt.executeUpdate();

        }finally{

            if(pstmt != null)
                pstmt.close();

            if(conn != null)
                conn.close();

        }

    }
}
