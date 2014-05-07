import java.util.Scanner;

public class Shell{

	public static void main(String args[]){

		System.out.println("Hallo");
		System.out.println("Die meisten Leute sind dumm.");
		System.out.println("Sie lassen ihre geheimsten und privatesten Informationen...");
		System.out.println("...einfach so in ihrem Postfach liegen...");
		System.out.println("...und wählen dann auch noch eins der unsichersten Passwörter -");
		System.out.println("ich habe in meinen Dokumenten eine Liste dieser am häufigsten");
		System.out.println("verwendeten Passwörter gespeichert.");
		System.out.println("Wenn man nun ihren Mailanbieter weiß, ist es viel zu einfach,");
		System.out.println("sich auf dieses fremde System zu ssh'en... tipp mal 'help' ein.");
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
