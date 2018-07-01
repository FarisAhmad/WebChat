
package br.com.ltp4.servlet;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ltp4.modal.UsuarioModal;
import br.com.ltp4.modal.modal.Usuario;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UsuarioModal um = new UsuarioModal();
	
	public UserServlet() {
		super();
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		
		Usuario usuario = new Usuario();

		try {

			String login = request.getParameter("usuario");

			um.validaLogin(login);

			usuario.setLogin(login);

			String senha = request.getParameter("senha");

			 um.validaSenha(senha);
			usuario.setSenha(Integer.parseInt(senha));

			 um.usarioOK(usuario);
			
			//request.getsess
			List<Usuario> lista =  um.listarUsuarios();
			request.setAttribute("listaUsers", lista);
			request.getRequestDispatcher("listaUsuarios.jsp").forward(request, response);

			
		} catch (Exception e) {
			System.err.println(e);
			request.setAttribute("loginErro", e.getMessage());
			request.getRequestDispatcher("erroLogin.jsp").forward(request, response);
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	
		
		
		try {
			
			String nome= request.getParameter("nome");
						
			String dataNascimento= request.getParameter("dataNasc");
			
			converteData(dataNascimento);
			
			String login = request.getParameter("usuario");
			
			 um.validaLogin(login);

			String senha = request.getParameter("senha");

			 um.validaSenha(senha);
			
			Usuario usuario = new Usuario(nome,dataNascimento,login,Integer.parseInt(senha));

			String msgRetorno =  um.adicionaUsuario(usuario);

			
			
			request.setAttribute("mensagem", msgRetorno);
			request.getRequestDispatcher("mensagemCadastro.jsp").forward(request, response);
			
			
			

		} catch (Exception e) {
			System.err.println(e);
			request.setAttribute("loginErro", e.getMessage());
			request.getRequestDispatcher("erroCadastro.jsp").forward(request, response);
			
		}
	}
	
	private void converteData(String datastr) throws IllegalArgumentException {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			sdf.parse(datastr);
		} catch (ParseException e) {

			throw new IllegalArgumentException("Formato da data inválido. Ex : (DD/MM/AAAA)", e);
		}
	}

}
