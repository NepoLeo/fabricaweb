package br.com.fabricaweb.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.fabricaweb.entidade.Usuario;

public class UsuarioDAO {

	private Connection con;

	public UsuarioDAO() {
		con = ConexaoFactory.getConnection();
		try {
			con.setAutoCommit(false);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void cadastrar(Usuario u) {
		String sql = "insert into usuario (nome,login,senha) values (?,?,?)";

		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, u.getNome());
			stmt.setString(2, u.getLogin());
			stmt.setString(3, u.getSenha());
			stmt.execute();
			con.commit();
		} catch (SQLException e) {
			try {
				con.rollback();
				throw new RuntimeException(e);
			} catch (SQLException e1) {
				throw new RuntimeException(e);
			}
		}
	}

	public void alterar(Usuario u) {
		String sql = "update usuario set nome = ?, login = ?, senha = ? where id = ?";

		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, u.getNome());
			stmt.setString(2, u.getLogin());
			stmt.setString(3, u.getSenha());
			stmt.setInt(4, u.getId());
			stmt.execute();
			con.commit();
		} catch (SQLException e) {
			try {
				con.rollback();
				throw new RuntimeException(e);
			} catch (SQLException e1) {
				throw new RuntimeException(e);
			}
		}
	}

	public void excluir(Usuario u) {
		String sql = "delete from usuario where id = ?";

		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, u.getId());
			stmt.execute();
			con.commit();
		} catch (SQLException e) {
			try {
				con.rollback();
				throw new RuntimeException(e);
			} catch (SQLException e1) {
				throw new RuntimeException(e);
			}
		}
	}
}
