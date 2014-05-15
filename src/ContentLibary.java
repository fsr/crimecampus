import java.util.List;
import java.util.LinkedList;

public class ContentLibary {

	private List<String> content;

	ContentLibary(){
		content = new LinkedList<String>();
	}

	public List<String> getContent(String name){
		content.clear();
		if (name.equals("version")){
			content.add("Crime Campus");
			content.add("am Dies Academicus");
			content.add("");
			content.add("Software (mostly) by Frank Hedecke =)");
		} else if (name.equals("pwlist")){
			content.add("1	123456");
			content.add("2	password");
			content.add("3	12345678");
			content.add("4	qwerty");
			content.add("5	abc123");
			content.add("6	123456789");
			content.add("7	111111");
			content.add("8	1234567");
			content.add("9	iloveyou");
			content.add("10	adobe123");
			content.add("11	123123");
			content.add("12	admin");
			content.add("13	1234567890");
			content.add("14	letmein");
			content.add("15	photoshop");
			content.add("16	1234");
			content.add("17	monkey");
			content.add("18	shadow");
			content.add("19	sunshine");
			content.add("20	12345");
			content.add("21	password1");
			content.add("22	princess");
			content.add("23	azerty");
			content.add("24	trustno1");
			content.add("25	000000");
		} else if (name.equals("mail1")){
			content.add("Hey Willi,");
			content.add("wegen dieser Sache... wir müssen uns da mal zusammensetzen.");
			content.add("Soll ja erstmal möglichst unauffällig starten ;-)");
		} else if (name.equals("mail2")){
			content.add("Sir/Madam,");
			content.add("");
			content.add("I am PRINCE AZU ZUBBY the Chief Accountant of the Nigerian National");
			content.add("Petroleum Corporation (NNPC) headquarters in Lagos , Nigeria. I reliably");
			content.add("got your contact from Nigeria Chamber of Commerce. I have no reason to");
			content.add("doubt your honesty and credibility hence I make this proposal to you.");
			content.add("Please, treat with utmost confidence and excuse me for the embarrassment");
			content.add("this letter might cause you as we have not met or known each other before. ");
			content.add("");
			content.add("I have the mandate of my colleagues in office to solicite for your");
			content.add("assistance for a deal we want to execute, My Corporation (NNPC) awarded a");
			content.add("contract of US$86,700,000.00 (Eighty - Six Million, Seven Hundred Thousand");
			content.add("U.S Dollars) to a Foreign firms to supply Rig & Drilling Equipment for");
			content.add("Kaduna Refinery here in Nigeria but because of my position, this contract");
			content.add("was over invoiced to US$115,300,000.00 (One Hundred and Fifteen Million,");
			content.add("Three Hundred Thousand United State Dollars). The origina the contractors");
			content.add("that executed the project, now we are left with the over- invoice sum of");
			content.add("US$28,600,000.00 (Twenty Eight Million, Six Hundred Thousand U.S. Dollars");
			content.add("Only). ");
			content.add("");
			content.add("PLEASE, INCLUDE YOUR TELEPHONE AND FAX NUMBER FOR EASY COMMUNICATION .");
			content.add("");
			content.add("I look forward to hearing from you.");
			content.add("");
			content.add("Best Regards");
			content.add("");
			content.add("PRINCE AZU ZUBBY.");
		} else if (name.equals("mail3")){
			content.add("Alles klar, ich kümmere mich da schon drum. Hab aber heute erstmal noch ne");
			content.add("Verabredung mit Wilma und so ;)");
			content.add("");
			content.add("Willi");
		} else {}
		return content;
	}
}
