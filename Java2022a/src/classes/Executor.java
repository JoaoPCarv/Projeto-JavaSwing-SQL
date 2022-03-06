//----**PROJETO Java-Swing-SQL**----
//Feito por: João Pedro Lima Affonso de Carvalho
//Versão: 1.0
//Data: 02/03/2022
//Briefing: Projeto simples que consiste de uma interface gráfica conectada a um banco de dados.
//Proposta: O usuário deste applet poderá gerenciar clientes, criando, deletando e consultando-os.

package classes;

import managers.ManagerFactory;

public class Executor {
	
	public static void main(String args[]) {
		
		ManagerFactory.getManager("Cliente").startManager();
	};
}
