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
			homeDir.getFolder("Dokumente").addFile("version");
			homeDir.getFolder("Dokumente").getFile("version").appendContent(content.getContent("version"));
			homeDir.getFolder("Dokumente").addFile("passwoerter");
			homeDir.getFolder("Dokumente").getFile("passwoerter").appendContent(content.getContent("pwlist"));
		} else if (name.equals("max")){
			computer = "mailhost";
			homeDir.addFolder("Mails");
			homeDir.getFolder("Mails").addFile("mail1");
			homeDir.getFolder("Mails").getFile("mail1").appendContent(content.getContent("mail1"));
			homeDir.getFolder("Mails").addFile("mail2");
			homeDir.getFolder("Mails").getFile("mail2").appendContent(content.getContent("mail2"));
			homeDir.getFolder("Mails").addFile("mail3");
			homeDir.getFolder("Mails").getFile("mail3").appendContent(content.getContent("mail3"));
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
		return this + "@" + computer + ":~" + getAbsolutAdress(currentDir) + "> ";
	}

	public void setCurrentDir(Folder folder){
		currentDir = folder;
	}

	@Override
	public String toString(){

		return name;
	}
}
