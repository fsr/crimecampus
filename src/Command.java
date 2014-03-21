import java.util.StringTokenizer;
import java.util.List;
import java.util.LinkedList;
import java.util.Scanner;

public class Command {
	
	private User user;
	private List<User> userstack;
	private int errorcounter;
	
	Command(User user){
		this.user = user;
		userstack = new LinkedList<User>();
		userstack.add(user);
		errorcounter = 0;
	}
	
	private void ls(){
		user.getCurrentDir().printFolder();
	}
	
	private void logout(){
		int i = userstack.lastIndexOf(user);
		if (i > 0){
			user = userstack.get(i-1);
			userstack.remove(i);
		} else
			System.out.println("bash: logout: Keine Login Shell: Mit exit abmelden.");
	}
	
	private void help(){
		System.out.println("1) einfache Befehle");
		System.out.println("");
		System.out.println("   ls");
		System.out.println(" > zeigt den Inhalt des aktuellen Ordners an");
		System.out.println("");
		System.out.println("   help");
		System.out.println(" > ruft die Hilfe auf");
		System.out.println("");
		System.out.println("2) Befehler mit Parameter");
		System.out.println("");
		System.out.println("   less (DATEI)");
		System.out.println(" > zeigt die Datei mit dem Namen (DATEI) an, sofern sie vorhanden ist");
		System.out.println("");
		System.out.println("   cd (ORDNER)");
		System.out.println(" > wechselt in den Ordner mit dem Namen (ORDNER), sofern dieser vorhanden ist.");
		System.out.println(" > \"cd ..\" geht einen Ordner zurueck.");
		System.out.println("");
		System.out.println("   ssh (NUTZER)@(ADRESSE)");
		System.out.println(" > meldet den Computer als Nutzer mit dem Namen (NUTZER) an den Computer/Server");
		System.out.println("   mit der Adresse (ADRESSE) an");
		System.out.println("");
		System.out.println("   lpr (DATEI)");
		System.out.println(" > druckt die Textdatei mit dem Namen (DATEI) aus");
		System.out.println("");
	}
	
	private void less(String parameter){
		if (user.getCurrentDir().containsFile(parameter)){
			user.getCurrentDir().getFile(parameter).printFile();
		} else
			System.out.println(parameter + " : No such file or directory");
	}
	
	private void hash(String parameter){
		System.out.println(parameter + " : " + hashvalue(parameter));
	}
	
	private void cd(String parameter){
		if (parameter.equals("..") || parameter.equals("../"))
			user.setCurrentDir(user.getCurrentDir().getParentFolder());
		else if (parameter.equals("~") || parameter.equals("~/"))
			user.setCurrentDir(user.getHomeDir());
		else {
			if (user.getCurrentDir().containsFolder(parameter))
				user.setCurrentDir(user.getCurrentDir().getFolder(parameter));
			else
				System.out.println(parameter + " : No such file or directory");
		}
	}
	
	private void mkdir(String parameter){
		user.getCurrentDir().addFolder(parameter);
	}
	
	private void rmdir(String parameter){
		user.getCurrentDir().removeFolder(parameter);
	}
	
	private void rm(String parameter){
		user.getCurrentDir().removeFile(parameter);
	}
	
	private void ssh(String parameter){
		Scanner scanner = new Scanner(System.in);
		
		if (parameter.equals("admin@194.98.26.222") || parameter.equals("guest@194.98.26.222")){
			if (parameter.startsWith("admin")){
				System.out.print("Passwort ");
				String pass = scanner.nextLine();
				if (hashvalue(pass) == hashvalue("Orangenbaum")){
					user = new User("admin");
					userstack.add(user);
				} else
					System.out.println("Permission denied, please try again.");
			} else if (parameter.startsWith("guest")){
				user = new User("guest");
				userstack.add(user);
			}
		} else
			System.out.println("ssh: Could not resolve hostname " + parameter + ": Name or service not known");
	}
	
	private void lpr(String parameter){
		if (user.getCurrentDir().containsFile(parameter)){
			if (user.getName().equals("admin")){
				if (parameter.equals("zuender")){
					System.out.println("Der Code ist 98432");
				}
			} else
				System.out.println("lpr: could not find printer");
		} else
			System.out.println(parameter + " : No such file or directory");
	}
	
	private void complexRun(StringTokenizer commandTokenizer){
		String instruction = commandTokenizer.nextToken();
		String parameter = commandTokenizer.nextToken();
		while (commandTokenizer.hasMoreTokens())
			parameter += " " + commandTokenizer.nextToken();
		
		if (instruction.equals("less")){
			less(parameter);
			errorcounter = 0;
		} else if (instruction.equals("more")){
			less(parameter);
			errorcounter = 0;
		} else if (instruction.equals("cat")){
			less(parameter);
			errorcounter = 0;
		} else if (instruction.equals("nano")){
			less(parameter);
			errorcounter = 0;
		} else if (instruction.equals("vim")){
			less(parameter);
			errorcounter = 0;
		} else if (instruction.equals("emacs")){
			// EASTEREGG
			System.out.println("real programmers use butterflies");
			System.out.println("");
			System.out.println("'course there's an emacs command to do that");
			System.out.println("C-x M-c M-butterfly...");
			errorcounter = 0;
		} else if (instruction.equals("hash")){
			hash(parameter);
			errorcounter = 0;
		} else if (instruction.equals("cd")){
			cd(parameter);
			errorcounter = 0;
		} else if (instruction.equals("mkdir")){
			mkdir(parameter);
			errorcounter = 0;
		} else if (instruction.equals("rmdir")){
			rmdir(parameter);
			errorcounter = 0;
		} else if (instruction.equals("rm")){
			rm(parameter);
			errorcounter = 0;
		} else if (instruction.equals("ssh")){
			ssh(parameter);
			errorcounter = 0;
		} else if (instruction.equals("lpr")){
			lpr(parameter);
			errorcounter = 0;
		} else {
			System.out.println("read man "+ instruction + " to get more information");
			errorcounter++;
		}
	}

	private void simpleRun(String instruction){
		if (instruction.equals("ls")){
			ls();
			errorcounter = 0;
		} else if (instruction.equals("logout")){
			logout();
			errorcounter = 0;
		} else if (instruction.equals("help")){
			help();
			errorcounter = 0;
		} else{
			System.out.println(instruction + " isn't a valid instruction");
			errorcounter++;
		}
	}
	
	public void run(String command){
		StringTokenizer tokenizer = new StringTokenizer(command);
		if (tokenizer.countTokens() > 1)
			complexRun(tokenizer);
		else if (tokenizer.countTokens() == 1)	
			simpleRun(command);
		if (errorcounter >= 5){
			System.out.println("");
			System.out.println("!!! Frage doch die anwesenden Leute um Hilfe");
			System.out.println("");
			errorcounter = 0;
		}
		System.out.print(user.getPrefix());
	}
	
	private int hashvalue(String parameter){
		int hashvalue = 0;
		for (int i = 0; i < parameter.length() ; i++)
			hashvalue += (int) parameter.codePointAt(i);
		return hashvalue % 16;
	}
}
