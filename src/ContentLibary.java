import java.util.List;
import java.util.LinkedList;

public class ContentLibary {
	
	private List<String> content;
	
	ContentLibary(){
		content = new LinkedList<String>();
	}

	public List<String> getContent(String name){
		content.clear();
		if (name.equals("zuender")){
			content.add("Name      | Beschreibung              | Verfuegbar | Code");
			content.add("--------- | ------------------------- | ---------- | ------");
			content.add("X-3010    | Piept                     | Nein       | 12345");
			content.add("A3799T    | Unentschaerfbar           | Nein       | 09134");
			content.add("A300-Mini | sehr Klein                | Ja         | 98432");
			content.add("NF500X    | Der mit dem roten Draht   | Nein       | 72630");
			content.add("----------------------------------------------------------");
			content.add("Bringe den richtigen Code nun zum Maschinenwesen!");
		} else if (name.equals("passwd")){
			content.add("user     password");
			content.add("-----    -----------");
			content.add("admin    Orangenbaum");
			content.add("guest    {empty}");
		} else if (name.equals("version")){
			content.add("Crime Campus");
			content.add("am Dies Academicus");
			content.add("");
			content.add("Software by Frank Hedecke =)");
		} else if (name.equals("mail1")){
			content.add("Hey,");
			content.add("Unser Admin ist leider nicht erreichbar und wir kommen nicht an den");
			content.add("Zuendcode ran. Aber er ist ziemlich schusselig, der hat bestimmt");
			content.add("irgendwo etwas liegen, was dir weiterhilft. Vllt. gibt es ja einen");
			content.add("Account ohne gesetztes Passwort. Probiere mal \"unknown\" oder \"guest\"");
			content.add("Vielleicht kommst du so ins System rein. Die Adresse des Servers");
			content.add("ist \"194.98.26.222\" und mit \"ssh\" kannst du dich sicher dort einloggen.");
			content.add("");
			content.add("Viel Erfolg.");
		} else {}
		return content;
	}
}
