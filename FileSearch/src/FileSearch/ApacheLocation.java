package FileSearch;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ApacheLocation {
	private String port;
	private String uri;
	private String sunApacheHomeFolder;
	private String balancerId = "";

	public ApacheLocation(String sunApacheHomeFolder,String port, String uri) {
		this.port = port;
		this.uri = uri;
		this.sunApacheHomeFolder = sunApacheHomeFolder;
	}

	public void processLocationFile() {
		boolean isPortExistInAnyFile = false;
		File folder = new File(sunApacheHomeFolder);
		File[] listOfFiles = folder.listFiles();
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				balancerId = Factor.getBalancerIdIfPortExists(port, sunApacheHomeFolder + "\\" + listOfFiles[i].getName());
				if (balancerId != null) { // specified port matched with the one on file.
					isPortExistInAnyFile = true;
					if (Factor.isUriExists(uri, sunApacheHomeFolder + "\\" + listOfFiles[i].getName())) {
						System.out.println("This location entry with given port already exists.");
					} else {
						updateFile(port, balancerId, uri, sunApacheHomeFolder + "\\" + listOfFiles[i].getName());
						System.out.println(sunApacheHomeFolder + "\\" + listOfFiles[i].getName() + " is updated.");
					}
				}
			}
		}
		if(!isPortExistInAnyFile){
			createFile(port, uri, sunApacheHomeFolder);
			System.out.println("new config file is created.");
		}
	}
	
	public void updateFile(String port, String balancerId, String uri, String filePath) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File(filePath), true));
			bw.append(System.lineSeparator() + System.lineSeparator() + "<Location " + uri + ">");
			bw.append(System.lineSeparator() + "\tProxyPass \"balancer://" + balancerId + uri + "\"");
			bw.append(System.lineSeparator() + "\tProxyPassReverse \"balancer://" + balancerId + uri + "\"");
			bw.append(System.lineSeparator() + "</Location>");
			bw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void createFile(String port, String uri, String filePath) {
		String fileName = "port" + port;
		try {
			BufferedWriter bw = new BufferedWriter(
					new FileWriter(new File(filePath + "\\" + fileName + ".conf"), true));

			bw.append("<Proxy \"balancer://port" + port + ">");
			bw.append(System.lineSeparator() + "\tBalancerMember \"http://${server01}:" + port + "\"");
			bw.append(System.lineSeparator() + "\tBalancerMember \"http://${server02}:" + port + "\"");
			bw.append(System.lineSeparator() + "</Proxy>");
			bw.append(System.lineSeparator() + System.lineSeparator() + "<Location " + uri + ">");
			bw.append(System.lineSeparator() + "\tProxyPass \"balancer://port" + port + uri + "\"");
			bw.append(System.lineSeparator() + "\tProxyPassReverse \"balancer://port" + port + uri + "\"");
			bw.append(System.lineSeparator() + "</Location>");
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}