package br.com.JoaoPCarv.Java2022a.factories;

import br.com.JoaoPCarv.Java2022a.enums.ManagerEnum;
import br.com.JoaoPCarv.Java2022a.interfaces.manager;
import br.com.JoaoPCarv.Java2022a.managers.ClienteManager;

public abstract class ManagerFactory {

	public static manager getManager(String arg) {
		
		if(arg == ManagerEnum.CLIENTE.getName()) {
			
			return new ClienteManager();
			
		}
		
		return null;
		
	}
	
}
