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
    private static final String INSERT = "INSERT INTO telefone(numero, operadora, ra, agencia_id, pessoa_id) " +
            "VALUES(?, ?, ?, ?, ?)";

    private static final String FIND_ALL = "SELECT id, numero, operadora, ra, agencia_id, pessoa_id FROM telefone";

    private static final String FIND_BY_ID =
            "SELECT id, numero, operadora, ra, agencia_id, pessoa_id FROM telefone WHERE id = ?";

    private static final String DELETE_BY_ID =
            "DELETE FROM telefone WHERE id = ?";

    private static final String UPDATE = "UPDATE telefone SET numero = ?, operadora = ?, ra = ?, agencia_id = ?, pessoa_id = ? " +
            "WHERE id = ?";

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
                telefone.setId(rs.getInt("id"));
                telefone.setNumero(rs.getString("numero"));
                telefone.setOperadora(rs.getInt("operadora"));
                telefone.setRa(rs.getString("ra"));
                telefone.setAgenciaId(rs.getInt("agencia_id"));
                telefone.setPessoaId(rs.getInt("pessoa_id"));
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
                retorno.setId(rs.getInt("id"));
                retorno.setNumero(rs.getString("numero"));
                retorno.setOperadora(rs.getInt("operadora"));
                retorno.setRa(rs.getString("ra"));
                retorno.setAgenciaId(rs.getInt("agencia_id"));
                retorno.setPessoaId(rs.getInt("pessoa_id"));
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
            pstmt.setString(1, telefone.getNumero());
            pstmt.setInt(2, telefone.getOperadora());
            pstmt.setString(3, telefone.getRa());
            pstmt.setInt(4, telefone.getAgenciaId());
            pstmt.setInt(5, telefone.getPessoaId());
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
            pstmt.setInt(2, telefone.getOperadora());
            pstmt.setString(3, telefone.getRa());
            pstmt.setInt(4, telefone.getAgenciaId());
            pstmt.setInt(5, telefone.getPessoaId());
            pstmt.setInt(6, telefone.getId());
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
