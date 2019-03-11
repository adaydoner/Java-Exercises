package shoppinglistproblem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Shopping {
	
	private ArrayList<String> staffs = new ArrayList<>();
	private ArrayList<Integer> priceOfStaffs = new ArrayList<>();
	private String fileName;
	
	public Shopping(String fileName){
		this.fileName = fileName;
	}
	
	public void processFile() {
		Scanner input = null;
		PrintWriter pw = null;
		try {
			input = new Scanner(new File(fileName));
			String readedLine = ".";
			pw = new PrintWriter(new File("testdata\\output.txt"));
			// getting prices from expressions.
			while(input.hasNextLine()){
				readedLine = input.nextLine();
				if(readedLine.charAt(readedLine.length() - 1) != '?'){
					getPriceFromReadedLine(readedLine);
				} else {
					if(calculatePriceFromReadedLine(readedLine) != "") {
						pw.println(calculatePriceFromReadedLine(readedLine));
					} else {
						continue;
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			input.close();
			pw.close();
		}
		System.out.println("its over.");
	}
	private String calculatePriceFromReadedLine(String readedLine) {
		int totalPrice = 0;
		String returnVal = "";
		if(!readedLine.contains("what is the price of ") && !readedLine.contains("?")){
			return (readedLine + " is an invalid input");
		}
		ArrayList<String> elements = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(readedLine, " ?");
		while(st.hasMoreTokens()){
			elements.add(st.nextToken());
		}
		for (int i = 5; i < elements.size(); i++) {
			if(!staffs.contains(elements.get(i))){
				return (readedLine + " is an invalid input");
			} else {
				returnVal += elements.get(i) + " ";
				totalPrice += priceOfStaffs.get(staffs.indexOf(elements.get(i)));
			}
		}
		return (returnVal + "is " + totalPrice);
	}

	public void getPriceFromReadedLine(String readedLine) {
		if(!readedLine.contains("is")){
			System.out.println(readedLine + " is an invalid input. Sample usage : (apple is V)(apple tomato is XV)");
			return;
		}
		ArrayList<String> elements = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(readedLine, " ");
		while(st.hasMoreTokens()){
			elements.add(st.nextToken());
		}
		elements.remove(String.valueOf("is"));
		if(elements.size() < 3){
			staffs.add(elements.get(0));
			if(RomanNumerals.isRoman(elements.get(1))){
				priceOfStaffs.add(RomanNumerals.getIntegerEquivalent(elements.get(1)));
			} else {
				priceOfStaffs.add(Integer.valueOf(elements.get(1)));
			}
		} else {
			calculateElementPrice(elements);
		}
	}

	private void calculateElementPrice(ArrayList<String> elements) {
		int totalPrice;
		if(RomanNumerals.isRoman(elements.get(elements.size() - 1))){
			totalPrice = RomanNumerals.getIntegerEquivalent(elements.get(elements.size() - 1));
			elements.set(elements.size() - 1, "");
		} else {
			totalPrice = Integer.valueOf(elements.get(elements.size() - 1));
			elements.set(elements.size() - 1, "");
		}
		for (int i = 0; i < elements.size(); i++) {
			if(staffs.contains(elements.get(i))){
				totalPrice -= priceOfStaffs.get(staffs.indexOf(elements.get(i)));
				elements.set(i, "");
			}
		}
		// after alghoritm that stay above , we have one staff left in elements arraylist moreover its price is equal to totalPrice
		for (int i = 0; i < elements.size(); i++) {
			if(elements.get(i) == ""){
				continue;
			} else {
				staffs.add(elements.get(i));
				priceOfStaffs.add(totalPrice);
				break;
			}
		}
	}
}
