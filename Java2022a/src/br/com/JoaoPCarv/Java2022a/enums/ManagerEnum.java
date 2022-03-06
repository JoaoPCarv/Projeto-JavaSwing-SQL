package br.com.JoaoPCarv.Java2022a.enums;

public enum ManagerEnum {

CLIENTE("Cliente");
	
	public final String name;
	
	 ManagerEnum(String arg) {
		 
		 this.name = arg;
		 
	 }
	 
	 public String getName() {
		 
		 return this.name;
		 
	 }
	
}
