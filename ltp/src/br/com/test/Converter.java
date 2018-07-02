package br.com.test;



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
		
		String texto1 = "Vão obter várias copias pra o desenvolvimento, pro favor atenar as condições para o a realização das respectivas demandas.";
		String t = "<div style=\"width:680px; padding:0 15px 15px 15px;  background:#058ce1;\">\r\n" + 
				"			<!--<img src=\"https://cadastrodeusuario.caixa.gov.br/sicdu/images/alt_img_caixa.gif\" width=\"136\" height=\"31\" /> -->\r\n" + 
				"			<img src=\"#URL_BASE#/img/logo_caixa.png\" width=\"136\" height=\"31\">\r\n" + 
				"			<div style=\"background:#E5EBF8; color:#000; padding:5px; text-align:justify; font-family:Arial, Helvetica, sans-serif; font-size:11px;\">\r\n" + 
				"				<b>ATENÇÃO: MENSAGEM AUTOMÁTICA. FAVOR NÃO RESPONDER NEM ENCAMINHAR MENSAGEM PARA ESTE REMETENTE.</b>\r\n" + 
				"				<br><br>A/C Èáâê{}?<br><b>#NOME_USUARIO#</b><br>\r\n" + 
				"				<p>Esta mensagem foi encaminhada para orientá-lo a respeito do cadastramento/modificação de sua senha para acesso ao(s) sistema(s)/serviço(s) listado(s) abaixo.</p>\r\n" + 
				"				<p>Leia com atenção as orientações antes de efetuar o cadastramento/modificação da senha, a qual deve ser elaborada, obrigatoriamente, de acordo com os critérios que seguem</p>\r\n" + 
				"				<ul>\r\n" + 
				"					<li>Deve [] <> ()ter o tamanho mínimo de 8 caracteres;</li>\r\n" + 
				"					<li>Somente caracteres alfanuméricos podem compor a senha;</li>\r\n" + 
				"					<li>A senha deve conter no mínimo 1 (um) caractere alfabético maiúsculo </li>\r\n" + 
				"					<li>A senha deve conter no mínimo 1 (um) caractere alfabético minúsculo (a-z);</li>\r\n" + 
				"					<li>A senha deve conter no mínimo 1 (um) caractere numérico (0-9);</li>\r\n" + 
				"					<li>A senha não deve conter sequenciais de teclado de 3 (três) caracteres,em qualquer direção. (ex.: qwe, asd);</li>\r\n" + 
				"					<li>A senha não deve conter sequenciais que representem o mês ou ano correntes;</li>\r\n" + 
				"					<li>A senha não deve conter 3 (três) caracteres ou mais idênticos consecutivos (ex.: 777, uuu);</li>\r\n" + 
				"					<li>A senha não deve conter 3 (três) caracteres ou mais alfabéticos sucessivos (ex.: abc, klm);</li>\r\n" + 
				"					<li>Senhas facilmente dedutíveis (com caracteres repetidos, por exemplo: 111111) não serão aceitas para concessão de acesso ao sistema;</li>\r\n" + 
				"					<li>Evite senhas vinculadas à data de nascimento ou CPF;</li>\r\n" + 
				"					<li>As últimas cinco senhas utilizadas não serão aceitas pelo sistema.</li>\r\n" + 
				"				</ul>\r\n" + 
				"				<p>A boa qualidade de sua senha é condição indispensável para a segurança de seu acesso, por isso, sugerimos observar as seguintes recomendações:</p>\r\n" + 
				"				<ul type=\"disc\">\r\n" + 
				"					<li>A senha deve ser trocada no intervalo máximo de 100 dias;</li>\r\n" + 
				"					<li>Mais de cinco tentativas com senha inválida revoga o direito de acesso ao sistema.</li>\r\n" + 
				"				</ul>\r\n" + 
				"				<p><b>SEU IDENTIFICADOR: </b>#EMAIL_USUARIO#</p>\r\n" + 
				"				\r\n" + 
				"					#PERFIS#\r\n" + 
				"				\r\n" + 
				"				<p>\r\n" + 
				"					<b>CÓDIGO DE ATIVAÇÃO: </b> \r\n" + 
				"					<font style=\"letter-spacing: 1.5px;\" size=\"4px\" face=\"tahoma\">#TOKEN#</font>\r\n" + 
				"				</p>\r\n" + 
				"				<p>\r\n" + 
				"					<b>CADASTRE SUA NOVA SENHA NO LINK ABAIXO</b>\r\n" + 
				"					<br>\r\n" + 
				"					<a href=\"#URL_CONFIRMACAO#\">Clique Aqui</a>\r\n" + 
				"				</p>\r\n" + 
				"				<p>Para sua segurança inutilize este comunicado após a leitura e seu acesso inicial.</p>\r\n" + 
				"				<p>\r\n" + 
				"					O conteúdo desta mensagem é de uso restrito e confidencial, \r\n" + 
				"					com sigilo protegido por lei. As informações nela contidas não poderão ser divulgadas sem \r\n" + 
				"					prévia autorização escrita. Caso você não seja o destinatário desta mensagem, \r\n" + 
				"					solicitamos que a apague imediatamente e comunique ao remetente. \r\n" + 
				"					Alertamos que este conteúdo transitou por rede pública de comunicações e, \r\n" + 
				"					portanto, está sujeito aos riscos inerentes a essa forma de comunicação. \r\n" + 
				"					A Caixa Econômica Federal não se responsabiliza por possíveis conclusões, \r\n" + 
				"					opiniões ou informações que não se relacionem com sua linha de negócios, \r\n" + 
				"					mas que estejam contidas nesta mensagem.\r\n" + 
				"				</p>\r\n" + 
				"				<p style=\"text-align:right\">CAIXA ECONÔMICA FEDERAL</p>\r\n" + 
				"			</div>\r\n" + 
				"		</div>";
		System.out.println(escapeHTML(t));
		
		
		//Teste do commit
		
	
	}

}
