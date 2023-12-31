package com.pccasa.unipar.central.repositories;

import com.pccasa.unipar.central.models.Agencia;
import com.pccasa.unipar.central.models.Banco;
import com.pccasa.unipar.central.utils.DataBaseUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BancoDAO {
    private static final String INSERT = "INSERT INTO BANCO (id, nome, agencia_id) VALUES (?, ?, ?)";

    private static final String FIND_ALL = "SELECT ID, NOME, AGENCIA_ID FROM BANCO";

    private static final String FIND_BY_ID = "SELECT ID, NOME, AGENCIA_ID FROM BANCO WHERE ID = ?";

    private static final String DELETE_BY_ID = "DELETE FROM BANCO WHERE ID = ?";

    private static final String UPDATE = "UPDATE BANCO SET NOME = ?, AGENCIA_ID = ? WHERE ID = ?";

    public List<Banco> findAll() throws SQLException {
        List<Banco> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_ALL);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Banco banco = new Banco();
                banco.setId(rs.getInt("ID"));
                banco.setNome(rs.getString("NOME"));
                retorno.add(banco);
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return retorno;
    }

    public Banco findById(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Banco retorno = null;

        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                retorno = new Banco();
                retorno.setId(rs.getInt("ID"));
                retorno.setNome(rs.getString("NOME"));
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return retorno;
    }

    public void insert(Banco banco) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setInt(1, banco.getId());
            pstmt.setString(2, banco.getNome());
            pstmt.executeUpdate();
        } finally {
            if (conn != null) {
                conn.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
        }
    }

    public void update(Banco banco) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setString(1, banco.getNome());
            pstmt.setInt(2, banco.getId());
            pstmt.executeUpdate();
        } finally {
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    public void delete(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(DELETE_BY_ID);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } finally {
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
}
