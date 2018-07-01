package br.com.ltp4.banco;


import java.util.ArrayList;
import java.util.List;

import br.com.ltp4.modal.modal.Usuario;

public class BancoUsuario {
	List<Usuario> usuarios = new ArrayList<Usuario>();
	Usuario user = new Usuario("Faris Saleh Ahmad", "22/03/1998", "faris22", 123321);

	public void initBD() {
		this.usuarios.add(user);
	}

	public boolean usuario_senha_existe(Usuario usuario) {
		for (int i = 0; i < usuarios.size(); i++) {
			if (usuarios.get(i).getLogin().equals(usuario.getLogin())
					&& usuarios.get(i).getSenha() == usuario.getSenha()) {
				return true;
			}
		}

		return false;

	}

	public Usuario getUsuario(Usuario usuario) {
		for (int i = 0; i < usuarios.size(); i++) {
			if (usuarios.get(i).getLogin().equals(usuario.getLogin())
					&& usuarios.get(i).getSenha() == usuario.getSenha()) {
				return usuarios.get(i);
			}
		}

		return null;

	}

	public String addUsuario(Usuario usuario) {

		if (getUsuario(usuario) == null) {
			this.usuarios.add(usuario);
			return "Usario adicionado com SUCESSO !!";
		} else {

			return "Usario já existe !!";
		}

	}
	
	public List<Usuario> listarUsuarios(){
		if(usuarios.isEmpty()) {
			initBD();
		}
		return this.usuarios;
		
	}
}
