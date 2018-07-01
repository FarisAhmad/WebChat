package br.com.ltp4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.ltp4.connectionFactory.ConnectionFactory;
import br.com.ltp4.enums.MensagemBancoEnum;
import br.com.ltp4.modal.modal.Usuario;

public class UsuarioDao {
	private Connection connection;

	public UsuarioDao() {
		this.connection = new ConnectionFactory().getConnection();

	}

	public String adiciona(Usuario user) {

		String insertTableSQL = "INSERT INTO LTP.USUARIOS"
				+ "(lg_usuario, nm_usuario, dtNsc_usuario, senha_usuario) VALUES" + "(?,?,?,?)";
		try {

			PreparedStatement preparedStatement = connection.prepareStatement(insertTableSQL);
			preparedStatement.setString(1, user.getLogin());
			preparedStatement.setString(2, user.getNome());
			preparedStatement.setString(3, user.getDataNascimento());
			preparedStatement.setString(4, Integer.toString(user.getSenha()));

			preparedStatement.executeUpdate();
			preparedStatement.close();

			return MensagemBancoEnum.OK.getCodigo();

		} catch (SQLIntegrityConstraintViolationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MensagemBancoEnum.PK_EXISTENTE.getCodigo();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MensagemBancoEnum.Error.getCodigo();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public Usuario recuperaUsuario(Usuario user) {

		String selectTableSQL = "select lg_usuario,senha_usuario from LTP.USUARIOS" + " where lg_usuario = '"
				+ user.getLogin() + "'";
		try {

			Statement stmt = connection.createStatement();

			ResultSet rs = stmt.executeQuery(selectTableSQL);

			Usuario userRecuperado = new Usuario();
			while (rs.next()) {

				userRecuperado.setLogin(rs.getString("lg_usuario"));
				userRecuperado.setSenha(Integer.parseInt(rs.getString("senha_usuario")));

			}

			stmt.close();

			return userRecuperado;

		} catch (Exception e) {
			System.out.println("Error na query select ");
			return null;
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public List<Usuario> recuperaLista() {

		String selectTableSQL = "select lg_usuario,nm_usuario,dtnsc_usuario from LTP.USUARIOS";
		List<Usuario> listaUsers = new ArrayList<Usuario>();
		
		try {

			Statement stmt = connection.createStatement();

			ResultSet rs = stmt.executeQuery(selectTableSQL);

			Usuario usuario = null;
			while (rs.next()) {
				
				usuario = new Usuario();
				usuario.setLogin(rs.getString("lg_usuario"));
				usuario.setDataNascimento(rs.getString("dtnsc_usuario"));
				usuario.setNome(rs.getString("nm_usuario"));

				listaUsers.add( usuario);
				
			}

			stmt.close();
			rs.close();

			return listaUsers;

		} catch (Exception e) {
			System.out.println("Error na query select ");
			return null;
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
