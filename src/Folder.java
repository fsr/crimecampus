import java.util.HashMap;
import java.util.Map;

public class Folder {
//TODO write a ParentClass

	private String name;
	private Folder parentFolder;
	private Map<String,Folder> containedFolders;
	private Map<String,Textfile> containedFiles;


	Folder(String name){
		this.name = name;
		containedFolders = new HashMap<String,Folder>();
		containedFiles = new HashMap<String,Textfile>();
		this.parentFolder = this;
	}

	Folder(String name, Folder parentFolder){
		this(name);
		this.parentFolder = parentFolder;
	}

	public boolean containsFolder(String name){
		return containedFolders.containsKey(name);
	}

	public boolean containsFile(String name){
		return containedFiles.containsKey(name);
	}

	public void addFolder(String name){
		if (!containedFolders.containsKey(name)){
			containedFolders.put(name, new Folder(name,this));
		}
	}

	public void addFile(String name){
		if (!containedFiles.containsKey(name)){
			containedFiles.put(name, new Textfile(name,this));
		}
	}

	public void removeFolder(String name){
		if (containedFolders.containsKey(name)){
			containedFolders.remove(name);
		} else
			System.out.println(name + " : No such file or directory");
	}

	public void removeFile(String name){
		if (containedFiles.containsKey(name)){
			containedFiles.remove(name);
		} else
			System.out.println(name + " : No such file or directory");
	}

	public void printFolder(){
		//TODO make a standard output function, even for less
		for (String name : containedFolders.keySet())
			System.out.println("[ORDNER]  " + name);
		for (String name : containedFiles.keySet())
			System.out.println("[DATEI]   " + name);
	}

	public Folder getFolder(String name){
		//TODO die Prüfung ob es den Ordner gibt sollte hier her verlegt werden
		return containedFolders.get(name);
	}

	public Textfile getFile(String name){
		//TODO prüfen ob es die Textfile gibt
		return containedFiles.get(name);
	}

	public Folder getParentFolder(){
		return parentFolder;
	}

	@Override
	public String toString(){
		return name;
	}
}
