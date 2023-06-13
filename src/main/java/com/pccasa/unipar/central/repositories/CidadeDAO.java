package com.pccasa.unipar.central.repositories;

import com.pccasa.unipar.central.models.Cidade;
import com.pccasa.unipar.central.models.Estado;
import com.pccasa.unipar.central.utils.DataBaseUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CidadeDAO {
    private static final String INSERT = "INSERT INTO cidade(id, nome, ra, estado_id)" +
            " VALUES(?, ?, ?, ?)";

    private static final String FIND_ALL = "SELECT c.ID, c.NOME, c.RA, e.ID AS ESTADO_ID, e.NOME AS ESTADO_NOME " +
            "FROM CIDADE c INNER JOIN ESTADO e ON c.ESTADO_ID = e.ID";

    private static final String FIND_BY_ID =
            "SELECT c.ID, c.NOME, c.RA, e.ID AS ESTADO_ID, e.NOME AS ESTADO_NOME " +
                    "FROM cidade c INNER JOIN ESTADO e ON c.ESTADO_ID = e.ID WHERE c.ID = ?";

    private static final String DELETE_BY_ID =
            "DELETE FROM cidade WHERE ID = ?";

    private static final String UPDATE = "UPDATE cidade SET NOME = ?, RA = ?, ESTADO_ID = ?" +
            " WHERE ID = ?";

    public List<Cidade> findAll() throws SQLException {
        List<Cidade> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_ALL);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Cidade cidade = new Cidade();
                cidade.setId(rs.getInt("ID"));
                cidade.setNome(rs.getString("NOME"));
                cidade.setRa(rs.getString("RA"));

                Estado estado = new Estado();
                estado.setId(rs.getInt("ESTADO_ID"));
                estado.setNome(rs.getString("ESTADO_NOME"));

                cidade.setEstado(estado);

                retorno.add(cidade);
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

    public Cidade findById(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Cidade retorno = null;

        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                retorno = new Cidade();
                retorno.setId(rs.getInt("ID"));
                retorno.setNome(rs.getString("NOME"));
                retorno.setRa(rs.getString("RA"));

                Estado estado = new Estado();
                estado.setId(rs.getInt("ESTADO_ID"));
                estado.setNome(rs.getString("ESTADO_NOME"));

                retorno.setEstado(estado);
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

    public void insert(Cidade cidade) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setInt(1, cidade.getId());
            pstmt.setString(2, cidade.getNome());
            pstmt.setString(3, cidade.getRa());
            pstmt.setInt(4, cidade.getEstado().getId());

            pstmt.executeUpdate();
        } finally {
            if (conn != null)
                conn.close();
            if (pstmt != null)
                pstmt.close();
        }
    }

    public void update(Cidade cidade) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setString(1, cidade.getRa());
            pstmt.setString(2, cidade.getNome());
            pstmt.setInt(3, cidade.getEstado().getId());
            pstmt.setInt(4, cidade.getId());

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
