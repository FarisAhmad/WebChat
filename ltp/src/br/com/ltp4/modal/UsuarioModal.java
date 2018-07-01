package br.com.ltp4.modal;

import java.util.InputMismatchException;
import java.util.List;


import br.com.ltp4.dao.UsuarioDao;
import br.com.ltp4.enums.MensagemBancoEnum;
import br.com.ltp4.modal.modal.Usuario;
import br.com.ltp4.validacao.ValidaUsuario;

public class UsuarioModal {



	public void validaLogin(String login) {
		ValidaUsuario validaUsuario = new ValidaUsuario();
		if (login.equals(null) || login.equals("")) {
			throw new InputMismatchException("Login não pode ser nulo !");
		} else if (!validaUsuario.login_maior_que_5(login)) {
			throw new InputMismatchException("Login deve ter pelo menos 6 dígitos !");
		} else if (!validaUsuario.login_possui_numero(login)) {
			throw new InputMismatchException("Login deve ter pelo menos 1 número ");
		}

	}

	public void validaSenha(String senha) {
		ValidaUsuario validaUsuario = new ValidaUsuario();

		if (senha.equals(null) || senha.equals("")) {
			throw new InputMismatchException("Senha não pode ser nula !");
		} else if (!validaUsuario.senha_somente_numerada(senha)) {
			throw new InputMismatchException("Senha deve ser composta somente por números ");
		} else if (!validaUsuario.senha_com_6_digitos(senha)) {
			throw new InputMismatchException("Senha deve ter exatamente 6 dígitos");
		}
	}

	public String adicionaUsuario(Usuario usuario) {
		UsuarioDao ud = new UsuarioDao();
		
		String resposta = ud.adiciona(usuario);

		if (resposta.equals(MensagemBancoEnum.Error.getCodigo())) {
			throw new InputMismatchException("Error ao adcionar Usuário !");
		} else if (resposta.equals(MensagemBancoEnum.PK_EXISTENTE.getCodigo())) {
			throw new InputMismatchException("Login já existe na base de dados");
		}
		return "Usuário adcionado com sucesso !!";
	}

	public List<Usuario> listarUsuarios() {
		UsuarioDao ud = new UsuarioDao();

		return ud.recuperaLista();

	}
	
	public void usarioOK(Usuario usuario) {
		UsuarioDao ud = new UsuarioDao();
		Usuario usuarioRecuperado = ud.recuperaUsuario(usuario);
		
		
		if ( !usuario.getLogin().equals(usuarioRecuperado.getLogin()) || usuario.getSenha() != usuarioRecuperado.getSenha() ) {
			throw new RuntimeException("Usuário ou senha Incorreto !");
		}
		
	}

}
