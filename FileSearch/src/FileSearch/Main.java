package FileSearch;

public class Main {

	public static void main(String[] args) {
		ApacheLocation sd = new ApacheLocation(args[0], args[1], args[2]);
		sd.processLocationFile();
	}
}