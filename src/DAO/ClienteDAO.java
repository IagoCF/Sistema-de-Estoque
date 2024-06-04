package DAO;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Modelo.Cliente;

public class ClienteDAO {
    private Connection conexao;

    public ClienteDAO(Connection conexao) {
        this.conexao = conexao;
    }

    //Insert
    public void adicionarCliente(Cliente cliente) throws SQLException {
        String query = "INSERT INTO cliente (nome, cpf, dataNascimento, email) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(query)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf().toString());
            stmt.setDate(3, new java.sql.Date(cliente.getDataNascimento().getTime()));
            stmt.setString(4, cliente.getEmail());
            stmt.executeUpdate();
        }
    }

    //Update
    public void atualizarCliente(Cliente cliente) throws SQLException {
        String query = "UPDATE cliente SET nome=?, dataNascimento=?, email=? WHERE cpf=?";
        try (PreparedStatement stmt = conexao.prepareStatement(query)) {
            stmt.setString(1, cliente.getNome());
            stmt.setDate(2, new java.sql.Date(cliente.getDataNascimento().getTime()));
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getCpf().toString());
            stmt.executeUpdate();
        }
    }

    //Delete
    public void removerCliente(BigInteger cpf) throws SQLException {
        String query = "DELETE FROM cliente WHERE cpf = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(query)) {
            stmt.setString(1, cpf.toString());
            stmt.executeUpdate();
        }
    }

    /*Select
    public Cliente buscarCliente(Integer cpf) throws SQLException {
        String query = "SELECT * FROM cliente WHERE cpf=?";
        try (PreparedStatement stmt = conexao.prepareStatement(query)) {
            stmt.setInt(1, cpf);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String nome = rs.getString("nome");
                    java.util.Date dataNascimento = rs.getDate("data_nascimento");
                    String email = rs.getString("email");
                    return new Cliente(cpf, nome, email, dataNascimento);
                }
            }
        }
        return null;
    }*/
}

