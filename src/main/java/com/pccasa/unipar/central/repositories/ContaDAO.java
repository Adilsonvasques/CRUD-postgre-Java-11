package com.pccasa.unipar.central.repositories;

import com.pccasa.unipar.central.models.Conta;
import com.pccasa.unipar.central.utils.DataBaseUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContaDAO {
    private static final String INSERT = "INSERT INTO CONTA(id, conta, agencia, tipo, digito, saldo) " +
            "VALUES(?, ?, ?, ?, ?, ?)";

    private static final String FIND_ALL = "SELECT ID, conta, agencia, tipo, digito, saldo FROM CONTA";

    private static final String FIND_BY_ID =
            "SELECT ID, conta, agencia, tipo, digito, saldo FROM CONTA WHERE ID = ?";

    private static final String DELETE_BY_ID =
            "DELETE FROM CONTA WHERE ID = ?";

    private static final String UPDATE = "UPDATE CONTA SET conta = ?, agencia = ?, tipo = ?, digito = ?, saldo = ? " +
            "WHERE ID = ?";


}
