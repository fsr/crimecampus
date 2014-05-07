import java.util.List;
import java.util.LinkedList;
//import java.io.FileReader;
//import java.io.IOException;
//import java.io.Reader;

public class Textfile {
//TODO should be named as Text-File
//TODO write a ParentClass

	private String name;
	private Folder parentFolder;
	private List<String> content;

	Textfile(String name, Folder parentFolder){
		this.name = name;
		this.parentFolder = parentFolder;
		content = new LinkedList<String>();
	}

	public Folder getParentFolder(){
		return parentFolder;
	}

	public void appendContent(List<String> content){
		this.content.addAll(content);
	}

	/* loadFile() doesn't work
	public void loadFile(String file){
		Reader reader = null;
		try{
			reader = new FileReader(file);
			String line = "";
			char character;
			while(true){
				character = (char) reader.read();
				// TODO zeichen suchen
				if (character != 'x')
					line += 'x';
				else{
					content.add(line);
					line = "";
				}
			}
		} catch ( IOException e ) {
			System.err.println( "Fehler beim Lesen der Datei!" );
		} finally {
			try { reader.close(); } catch ( Exception e ) { }
		}
	} */

	public void printFile(){
		if(content.isEmpty())
			System.out.println(this + " is empty");
		else{
			System.out.println(this + ":");
			System.out.println("");
			for(int i = 0; i < content.size(); i++)
				System.out.println(content.get(i));
		}
	}

	@Override
	public String toString(){
		return name;
	}
}
