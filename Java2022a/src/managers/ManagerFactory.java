package managers;

import interfaces.manager;

public abstract class ManagerFactory {

	public static manager getManager(String arg) {
		
		if(arg == ManagerList.CLIENTE.getName()) {
			
			return new ClienteManager();
			
		}
		
		return null;
		
	}
	
}
