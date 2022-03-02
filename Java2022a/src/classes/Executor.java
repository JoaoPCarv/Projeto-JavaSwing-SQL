//----**PROJETO Java-Swing-SQL**----
//Feito por: Jo�o Pedro Lima Affonso de Carvalho
//Vers�o: 1.0
//Data: 02/03/2022
//Briefing: Projeto simples que consiste de uma interface gr�fica conectada a um banco de dados.
//Proposta: O usu�rio deste applet poder� gerenciar clientes, criando, deletando e consultando-os.

package classes;

import managers.ClienteManager;

public class Executor {
	
	public static void main(String args[]) {
		
		ClienteManager mng1 = new ClienteManager();
		mng1.startManager(); 
	};
}
