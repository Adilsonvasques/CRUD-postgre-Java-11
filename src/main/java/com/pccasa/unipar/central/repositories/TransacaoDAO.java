package com.pccasa.unipar.central.repositories;

import com.pccasa.unipar.central.models.Transacao;
import com.pccasa.unipar.central.utils.DataBaseUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransacaoDAO {
    private static final String INSERT = "INSERT INTO TRANSACAO(id, datahora, valor) " +
            "VALUES(?, ?, ?)";

    private static final String FIND_ALL = "SELECT ID, DATAHORA, VALOR FROM TRANSACAO";

    private static final String FIND_BY_ID =
            "SELECT ID, DATAHORA, VALOR FROM TRANSACAO WHERE ID = ?";

    private static final String DELETE_BY_ID =
            "DELETE FROM TRANSACAO WHERE ID = ?";

    private static final String UPDATE = "UPDATE TRANSACAO SET DATAHORA = ?, VALOR = ? " +
            "WHERE ID = ?";

    public List<Transacao> findAll() throws SQLException {
        List<Transacao> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_ALL);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Transacao transacao = new Transacao();
                transacao.setId(rs.getInt("ID"));
                transacao.setDataHora(rs.getTimestamp("DATAHORA"));
                transacao.setValor(rs.getDouble("VALOR"));
                retorno.add(transacao);
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

    public Transacao findById(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Transacao retorno = null;

        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                retorno = new Transacao();
                retorno.setId(rs.getInt("ID"));
                retorno.setDataHora(rs.getTimestamp("DATAHORA"));
                retorno.setValor(rs.getDouble("VALOR"));
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

    public void insert(Transacao transacao) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setInt(1, transacao.getId());
            pstmt.setTimestamp(2, transacao.getDataHora());
            pstmt.setDouble(3, transacao.getValor());
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

    public void update(Transacao transacao) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setTimestamp(1, transacao.getDataHora());
            pstmt.setDouble(2, transacao.getValor());
            pstmt.setInt(3, transacao.getId());
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
