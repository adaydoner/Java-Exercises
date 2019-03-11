package FileSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Factor {
	private static final String PROXY_STARTED_TAG = "<Proxy";
	private static final String PROXY_END_TAG = "</Proxy>";
	private static final String LOCATION_STARTED_TAG = "<Location";
	private static final String LOCATION_END_TAG = "</Location>";
	
	public static String getBalancerIdIfPortExists(String port, String filePath) {
		String readedLine = "";
		ArrayList<String> proxyBlock = new ArrayList<>();
		String lineWithBalancerId = "";
		String lineWithPort = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			while ((readedLine = br.readLine()) != null) {
				if (isFirstWord(readedLine, PROXY_STARTED_TAG)) {
					proxyBlock.add(readedLine.trim());
					while (!(readedLine = br.readLine()).contains(PROXY_END_TAG)) {
						if (!(isFirstWord(readedLine, PROXY_END_TAG)) && !readedLine.trim().isEmpty()) {
							proxyBlock.add(readedLine.trim());
						}
					}
					if (proxyBlock.size() < 2) {
						proxyBlock.clear();
						continue;
					} else {
						lineWithBalancerId = proxyBlock.get(0);
						lineWithPort = proxyBlock.get(1);
					}
				}
				if (lineWithBalancerId != "" && lineWithPort != "" && lineWithBalancerId.toLowerCase().contains("balancer://") && lineWithPort.toLowerCase().contains("balancermember")) {
					break;
				} else {
					proxyBlock.clear();
				}
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (getPortValue(lineWithPort).equals(String.valueOf(port))) {// Port's location file found..
			return getBalancerId(lineWithBalancerId);
		}

		return null;
	}
	
	public static boolean isUriExists(String uri, String filePath) {
		String readedLine = "";
		ArrayList<String> locationBlock = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			while ((readedLine = br.readLine()) != null) {
				if (isFirstWord(readedLine, LOCATION_STARTED_TAG)) {
					locationBlock.add(readedLine.trim());
					while (!(readedLine = br.readLine()).contains(LOCATION_END_TAG)) {
						if (!isFirstWord(readedLine, LOCATION_END_TAG) && !readedLine.trim().isEmpty()) {
							locationBlock.add(readedLine.trim());
						}
					}
					if (locationBlock.size() < 3) {
						locationBlock.clear();
						continue;
					} else {
						if (locationBlock.get(0).toLowerCase().contains(uri.toLowerCase()) && locationBlock.get(1).toLowerCase().contains(uri.toLowerCase()) && locationBlock.get(2).toLowerCase().contains(uri.toLowerCase())) {
							return true;
						} else {
							locationBlock.clear();
							continue;
						}
					}
				}
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	private static String getPortValue(String lineWithPort) {
		String portValueInText = "";
		StringTokenizer st = new StringTokenizer(lineWithPort, " \":}\\s\t\n\r\f");
		while (st.hasMoreTokens()) {
			portValueInText = st.nextToken();
		}
		return portValueInText;
	}
	
	private static boolean isFirstWord (String line,String startedWord){
		ArrayList<String> partOfLines = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(line, " \t");
		while (st.hasMoreTokens()) {
			partOfLines.add(st.nextToken());
		}
		if(doesStringHaveThisManyColumn(line, startedWord.length())){
			if((partOfLines.get(0).equalsIgnoreCase(String.valueOf(startedWord.charAt(0))) && startedWord.contains(partOfLines.get(1))) || partOfLines.get(0).equalsIgnoreCase(startedWord)){
				return true;
			}
		}
		return false;
	}
	private static boolean doesStringHaveThisManyColumn(String line, int column){
		return (line.length() >= column) ? true : false;
		
	}

	private static String getBalancerId(String lineWithBalancerId) {
		String balancerIdValueInText = "";
		StringTokenizer st = new StringTokenizer(lineWithBalancerId, " \"\t\n\r\f/:\\s}><");
		while (st.hasMoreTokens()) {
			balancerIdValueInText = st.nextToken();
		}
		return balancerIdValueInText;
	}
	
}
