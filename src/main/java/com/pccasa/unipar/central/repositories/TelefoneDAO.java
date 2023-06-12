package com.pccasa.unipar.central.repositories;

import com.pccasa.unipar.central.models.Telefone;
import com.pccasa.unipar.central.utils.DataBaseUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TelefoneDAO {
    private static final String INSERT = "INSERT INTO TELEFONE(id, numero) " +
            "VALUES(?, ?)";

    private static final String FIND_ALL = "SELECT ID, NUMERO FROM TELEFONE";

    private static final String FIND_BY_ID =
            "SELECT ID, NUMERO FROM TELEFONE WHERE ID = ?";

    private static final String DELETE_BY_ID =
            "DELETE FROM TELEFONE WHERE ID = ?";

    private static final String UPDATE = "UPDATE TELEFONE SET NUMERO = ? " +
            "WHERE ID = ?";

    public List<Telefone> findAll() throws SQLException {
        List<Telefone> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_ALL);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Telefone telefone = new Telefone();
                telefone.setId(rs.getInt("ID"));
                telefone.setNumero(rs.getString("NUMERO"));
                retorno.add(telefone);
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

    public Telefone findById(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Telefone retorno = null;

        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                retorno = new Telefone();
                retorno.setId(rs.getInt("ID"));
                retorno.setNumero(rs.getString("NUMERO"));
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

    public void insert(Telefone telefone) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setInt(1, telefone.getId());
            pstmt.setString(2, telefone.getNumero());
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

    public void update(Telefone telefone) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setString(1, telefone.getNumero());
            pstmt.setInt(2, telefone.getId());
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
