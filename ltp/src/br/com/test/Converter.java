package br.com.test;

// Testando o git commit
public class Converter {
	public static String escapeHTML(String s) {
	    StringBuilder out = new StringBuilder(Math.max(16, s.length()));
	    for (int i = 0; i < s.length(); i++) {
	        char c = s.charAt(i);
	        if (c > 127  || c == '&') {//|| c == '<' || c == '>' || c == '"' 
	            out.append("&#");
	            out.append((int) c);
	            out.append(';');
	        } else {
	            out.append(c);
	        }
	    }
	    return out.toString();
	}

	

	public static void main(String[] args) {
		
		String texto1 = "V�o obter v�rias copias pra o desenvolvimento, pro favor atenar as condi��es para o a realiza��o das respectivas demandas.";
		String t = "<div style=\"width:680px; padding:0 15px 15px 15px;  background:#058ce1;\">\r\n" + 
				"			<!--<img src=\"https://cadastrodeusuario.caixa.gov.br/sicdu/images/alt_img_caixa.gif\" width=\"136\" height=\"31\" /> -->\r\n" + 
				"			<img src=\"#URL_BASE#/img/logo_caixa.png\" width=\"136\" height=\"31\">\r\n" + 
				"			<div style=\"background:#E5EBF8; color:#000; padding:5px; text-align:justify; font-family:Arial, Helvetica, sans-serif; font-size:11px;\">\r\n" + 
				"				<b>ATEN��O: MENSAGEM AUTOM�TICA. FAVOR N�O RESPONDER NEM ENCAMINHAR MENSAGEM PARA ESTE REMETENTE.</b>\r\n" + 
				"				<br><br>A/C ����{}?<br><b>#NOME_USUARIO#</b><br>\r\n" + 
				"				<p>Esta mensagem foi encaminhada para orient�-lo a respeito do cadastramento/modifica��o de sua senha para acesso ao(s) sistema(s)/servi�o(s) listado(s) abaixo.</p>\r\n" + 
				"				<p>Leia com aten��o as orienta��es antes de efetuar o cadastramento/modifica��o da senha, a qual deve ser elaborada, obrigatoriamente, de acordo com os crit�rios que seguem</p>\r\n" + 
				"				<ul>\r\n" + 
				"					<li>Deve [] <> ()ter o tamanho m�nimo de 8 caracteres;</li>\r\n" + 
				"					<li>Somente caracteres alfanum�ricos podem compor a senha;</li>\r\n" + 
				"					<li>A senha deve conter no m�nimo 1 (um) caractere alfab�tico mai�sculo </li>\r\n" + 
				"					<li>A senha deve conter no m�nimo 1 (um) caractere alfab�tico min�sculo (a-z);</li>\r\n" + 
				"					<li>A senha deve conter no m�nimo 1 (um) caractere num�rico (0-9);</li>\r\n" + 
				"					<li>A senha n�o deve conter sequenciais de teclado de 3 (tr�s) caracteres,em qualquer dire��o. (ex.: qwe, asd);</li>\r\n" + 
				"					<li>A senha n�o deve conter sequenciais que representem o m�s ou ano correntes;</li>\r\n" + 
				"					<li>A senha n�o deve conter 3 (tr�s) caracteres ou mais id�nticos consecutivos (ex.: 777, uuu);</li>\r\n" + 
				"					<li>A senha n�o deve conter 3 (tr�s) caracteres ou mais alfab�ticos sucessivos (ex.: abc, klm);</li>\r\n" + 
				"					<li>Senhas facilmente dedut�veis (com caracteres repetidos, por exemplo: 111111) n�o ser�o aceitas para concess�o de acesso ao sistema;</li>\r\n" + 
				"					<li>Evite senhas vinculadas � data de nascimento ou CPF;</li>\r\n" + 
				"					<li>As �ltimas cinco senhas utilizadas n�o ser�o aceitas pelo sistema.</li>\r\n" + 
				"				</ul>\r\n" + 
				"				<p>A boa qualidade de sua senha � condi��o indispens�vel para a seguran�a de seu acesso, por isso, sugerimos observar as seguintes recomenda��es:</p>\r\n" + 
				"				<ul type=\"disc\">\r\n" + 
				"					<li>A senha deve ser trocada no intervalo m�ximo de 100 dias;</li>\r\n" + 
				"					<li>Mais de cinco tentativas com senha inv�lida revoga o direito de acesso ao sistema.</li>\r\n" + 
				"				</ul>\r\n" + 
				"				<p><b>SEU IDENTIFICADOR: </b>#EMAIL_USUARIO#</p>\r\n" + 
				"				\r\n" + 
				"					#PERFIS#\r\n" + 
				"				\r\n" + 
				"				<p>\r\n" + 
				"					<b>C�DIGO DE ATIVA��O: </b> \r\n" + 
				"					<font style=\"letter-spacing: 1.5px;\" size=\"4px\" face=\"tahoma\">#TOKEN#</font>\r\n" + 
				"				</p>\r\n" + 
				"				<p>\r\n" + 
				"					<b>CADASTRE SUA NOVA SENHA NO LINK ABAIXO</b>\r\n" + 
				"					<br>\r\n" + 
				"					<a href=\"#URL_CONFIRMACAO#\">Clique Aqui</a>\r\n" + 
				"				</p>\r\n" + 
				"				<p>Para sua seguran�a inutilize este comunicado ap�s a leitura e seu acesso inicial.</p>\r\n" + 
				"				<p>\r\n" + 
				"					O conte�do desta mensagem � de uso restrito e confidencial, \r\n" + 
				"					com sigilo protegido por lei. As informa��es nela contidas n�o poder�o ser divulgadas sem \r\n" + 
				"					pr�via autoriza��o escrita. Caso voc� n�o seja o destinat�rio desta mensagem, \r\n" + 
				"					solicitamos que a apague imediatamente e comunique ao remetente. \r\n" + 
				"					Alertamos que este conte�do transitou por rede p�blica de comunica��es e, \r\n" + 
				"					portanto, est� sujeito aos riscos inerentes a essa forma de comunica��o. \r\n" + 
				"					A Caixa Econ�mica Federal n�o se responsabiliza por poss�veis conclus�es, \r\n" + 
				"					opini�es ou informa��es que n�o se relacionem com sua linha de neg�cios, \r\n" + 
				"					mas que estejam contidas nesta mensagem.\r\n" + 
				"				</p>\r\n" + 
				"				<p style=\"text-align:right\">CAIXA ECON�MICA FEDERAL</p>\r\n" + 
				"			</div>\r\n" + 
				"		</div>";
		System.out.println(escapeHTML(t));
		
		
		//Teste do commit
		// HELLO WORLD
	
	}

}
