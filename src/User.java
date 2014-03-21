public class User {
	
	private String name;
	private String computer;
	private Folder homeDir;
	private Folder currentDir;
	private ContentLibary content;

	User(String name){
		
		this.name = name;
		homeDir = new Folder("home");
		//TODO maybe register all home directory in an global system
		currentDir = homeDir;
		content = new ContentLibary();
	
		if (name.equals("anonymous")){
			computer = "pc";
			homeDir.addFolder("Dokumente");
			homeDir.addFolder("Postfach");
			homeDir.getFolder("Postfach").addFile("mail1");
			homeDir.getFolder("Postfach").getFile("mail1").appendContent(content.getContent("mail1"));
			homeDir.getFolder("Dokumente").addFile("version");
			homeDir.getFolder("Dokumente").getFile("version").appendContent(content.getContent("version"));
		} else if (name.equals("guest")){
			computer = "194.98.26.222";
			homeDir.addFolder("Webserver");
			homeDir.getFolder("Webserver").addFile("passwd");
			homeDir.getFolder("Webserver").getFile("passwd").appendContent(content.getContent("passwd"));
		} else if (name.equals("admin")){
			computer = "194.98.26.222";
			homeDir.addFolder("Datenbank");
			homeDir.addFolder("Dokumente");
			homeDir.getFolder("Datenbank").addFile("zuender");
			homeDir.getFolder("Datenbank").getFile("zuender").appendContent(content.getContent("zuender"));			
		}
	}
	
	public Folder getCurrentDir(){
		return currentDir;
	}
	
	public Folder getHomeDir(){
		return homeDir;
	}
	
	public String getAbsolutAdress(Folder methodDir){
		if (methodDir != homeDir){
			return getAbsolutAdress(methodDir.getParentFolder()) + methodDir + "/";
		} else
			return "/";
	}
	
	public String getName(){
		return name;
	}
	
	public String getPrefix(){
		return this + "@" + computer + ":~" + getAbsolutAdress(currentDir) + "$ ";
	}
	
	public void setCurrentDir(Folder folder){
		currentDir = folder;
	}
	
	@Override
	public String toString(){
		
		return name;
	}
}
