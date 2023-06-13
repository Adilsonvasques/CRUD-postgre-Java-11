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

public class AgenciaDAO {
    private static final String INSERT = "INSERT INTO agencia(codigo, razaoSocial, cnpj, banco_id) " +
            "VALUES(?, ?, ?, ?)";

    private static final String FIND_ALL = "SELECT a.id, a.codigo, a.razaoSocial, a.cnpj, " +
            "b.id AS banco_id, b.nome AS banco_nome " +
            "FROM agencia a INNER JOIN banco b ON a.banco_id = b.id";

    private static final String FIND_BY_ID =
            "SELECT a.id, a.codigo, a.razaoSocial, a.cnpj, b.id AS banco_id, b.nome AS banco_nome " +
                    "FROM agencia a INNER JOIN banco b ON a.banco_id = b.id WHERE a.id = ?";

    private static final String DELETE_BY_ID =
            "DELETE FROM agencia WHERE id = ?";

    private static final String UPDATE = "UPDATE agencia SET codigo = ?, razaoSocial = ?, cnpj = ?, banco_id = ? " +
            "WHERE id = ?";

    public List<Agencia> findAll() throws SQLException {
        List<Agencia> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_ALL);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Agencia agencia = new Agencia();
                agencia.setId(rs.getInt("id"));
                agencia.setCodigo(rs.getString("codigo"));
                agencia.setRazaoSocial(rs.getString("razaoSocial"));
                agencia.setCnpj(rs.getString("cnpj"));

                Banco banco = new Banco();
                banco.setId(rs.getInt("banco_id"));
                banco.setNome(rs.getString("banco_nome"));

                agencia.setBanco(banco);

                retorno.add(agencia);
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

    public Agencia findById(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Agencia retorno = null;

        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                retorno = new Agencia();
                retorno.setId(rs.getInt("id"));
                retorno.setCodigo(rs.getString("codigo"));
                retorno.setRazaoSocial(rs.getString("razaoSocial"));
                retorno.setCnpj(rs.getString("cnpj"));

                Banco banco = new Banco();
                banco.setId(rs.getInt("banco_id"));
                banco.setNome(rs.getString("banco_nome"));

                retorno.setBanco(banco);
            }
        } finally {
            if (rs != null)
                rs.close();

            if (pstmt != null)
                pstmt.close();

            if (conn != null)
                conn.close();
        }

        return retorno;
    }

    public void insert(Agencia agencia) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setString(1, agencia.getCodigo());
            pstmt.setString(2, agencia.getRazaoSocial());
            pstmt.setString(3, agencia.getCnpj());
            pstmt.setInt(4, agencia.getBanco().getId());

            pstmt.executeUpdate();
        } finally {
            if (conn != null)
                conn.close();

            if (pstmt != null)
                pstmt.close();
        }
    }

    public void update(Agencia agencia) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setString(1, agencia.getCodigo());
            pstmt.setString(2, agencia.getRazaoSocial());
            pstmt.setString(3, agencia.getCnpj());
            pstmt.setInt(4, agencia.getBanco().getId());
            pstmt.setInt(5, agencia.getId());

            pstmt.executeUpdate();
        } finally {
            if (pstmt != null)
                pstmt.close();

            if (conn != null)
                conn.close();
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
            if (pstmt != null)
                pstmt.close();

            if (conn != null)
                conn.close();
        }
    }
}
