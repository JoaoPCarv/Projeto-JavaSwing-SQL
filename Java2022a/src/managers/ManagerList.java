package managers;

public enum ManagerList {

CLIENTE("Cliente");
	
	public final String name;
	
	 ManagerList(String arg) {
		 
		 this.name = arg;
		 
	 }
	 
	 public String getName() {
		 
		 return this.name;
		 
	 }
	
}
