package com.pccasa.unipar.central.repositories;

import com.pccasa.unipar.central.models.Endereco;
import com.pccasa.unipar.central.utils.DataBaseUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EnderecoDAO {
    private static final String INSERT = "INSERT INTO ENDERECO(id, logradouro, numero, bairro, cep, complemento) VALUES(?, ?, ?, ?, ?, ?)";

    private static final String FIND_ALL = "SELECT ID, LOGRADOURO, NUMERO, BAIRRO, CEP, COMPLEMENTO FROM ENDERECO";

    private static final String FIND_BY_ID =
            "SELECT ID, LOGRADOURO, NUMERO, BAIRRO, CEP, COMPLEMENTO FROM ENDERECO WHERE ID = ?";

    private static final String DELETE_BY_ID =
            "DELETE FROM ENDERECO WHERE ID = ?";

    private static final String UPDATE = "UPDATE ENDERECO SET LOGRADOURO = ?, NUMERO = ?, BAIRRO = ?, CEP = ?, COMPLEMENTO = ?" +
            " WHERE ID = ?";

    public List<Endereco> findAll() throws SQLException {
        List<Endereco> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_ALL);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Endereco endereco = new Endereco();
                endereco.setId(rs.getInt("ID"));
                endereco.setLogradouro(rs.getString("LOGRADOURO"));
                endereco.setNumero(rs.getInt("NUMERO"));
                endereco.setBairro(rs.getString("BAIRRO"));
                endereco.setCep(rs.getInt("CEP"));
                endereco.setComplemento(rs.getString("COMPLEMENTO"));

                retorno.add(endereco);
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

    public Endereco findById(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Endereco retorno = null;

        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                retorno = new Endereco();
                retorno.setId(rs.getInt("ID"));
                retorno.setLogradouro(rs.getString("LOGRADOURO"));
                retorno.setNumero(rs.getInt("NUMERO"));
                retorno.setBairro(rs.getString("BAIRRO"));
                retorno.setCep(rs.getInt("CEP"));
                retorno.setComplemento(rs.getString("COMPLEMENTO"));
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

    public void insert(Endereco endereco) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setInt(1, endereco.getId());
            pstmt.setString(2, endereco.getLogradouro());
            pstmt.setInt(3, endereco.getNumero());
            pstmt.setString(4, endereco.getBairro());
            pstmt.setString(5, String.valueOf(endereco.getCep())); // Convertendo para String
            pstmt.setString(6, endereco.getComplemento());

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

    public void update(Endereco endereco) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setString(1, endereco.getLogradouro());
            pstmt.setInt(2, endereco.getNumero());
            pstmt.setString(3, endereco.getBairro());
            pstmt.setInt(4, endereco.getCep());
            pstmt.setString(5, endereco.getComplemento());
            pstmt.setInt(6, endereco.getId());

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
