import java.util.Scanner;

public class Shell{
	
	public static void main(String args[]){
	
		System.out.println("Hallo");
		System.out.println("Wir haben einen Zuender fuer eine Falle gebaut.");
		System.out.println("Leider wissen wir nicht mehr wo der Start-Code ist.");
		System.out.println("Bitte finde ihn. Ein guter Start ist \"help\"");
		Scanner scanner = new Scanner(System.in);
		User user = new User("anonymous");
		Command command = new Command(user);
		
		System.out.print(user.getPrefix());
		String s1 = scanner.nextLine();
		while(! s1.equals("exit")){
			command.run(s1);
			s1 = scanner.nextLine();
		}
		
		System.out.println("... logout");
	}
}
