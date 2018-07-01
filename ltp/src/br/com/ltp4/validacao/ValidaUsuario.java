package br.com.ltp4.validacao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidaUsuario {

	public boolean login_maior_que_5(String login) {

		if (login.length() <= 5) {
			return false;

		}

		return true;
	}

	public boolean login_possui_numero(String login) {
		Pattern p = Pattern.compile("[1234567890]");
		Matcher matcher = p.matcher(login);

		if (!matcher.find()) {
			return false;
		}
		return true;
	}

	public boolean senha_com_6_digitos(String senha) {
		if (senha.length() != 6) {
			return false;
		}
		return true;

	}

	public boolean senha_somente_numerada(String senha) {
		Pattern p = Pattern.compile("[a-z]");
		Matcher matcher = p.matcher(senha.toLowerCase());

		if (matcher.find()) {
			return false;
		}
		return true;

	}
}
