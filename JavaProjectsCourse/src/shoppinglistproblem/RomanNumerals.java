package shoppinglistproblem;


public class RomanNumerals {
	private static final String[][] listOfRomanNumerals = {{"I","1"},{"IV","4"},{"V","5"},{"IX","9"},{"X","10"},{"XL","40"},{"L","50"},{"XC","90"},{"C","100"},{"CD","400"},{"D","500"},{"CM","900"},{"M","1000"}};
	
    /**
     * Don't let anyone instantiate this class.
     */
	private RomanNumerals(){}

	
	/**
	 * This method return an integer value from specified roman numerals.
	 * @param romanNum roman numerals in string.
	 * @return Integer value of roman numeral.
	 */
	public static int getIntegerEquivalent(String romanNum) {
		int decimalValue = 0;
		int num = 0;
		int previousNum = 0;
		for (int i = romanNum.length() - 1; i >= 0; i--) {
			int picker = 0;
			char x = romanNum.toUpperCase().charAt(i);
			//find which roman numeral is that
	 		while(x != listOfRomanNumerals[picker][0].charAt(0)){
				picker++;
			}
			previousNum = num;
			num = Integer.valueOf(listOfRomanNumerals[picker][1]);
			if (num<previousNum)
			{
				decimalValue = decimalValue - num;
			} else
				decimalValue = decimalValue + num;
		}

		return decimalValue;
	}
	
	
	/**
	 * this method would return true if given string is a valid roman numeral otherwise return false
	 * @param string
	 * @return
	 */
	public static boolean isRoman(String string) {
		for (int i = 0; i < listOfRomanNumerals.length; i++) {
			if(string.contains(listOfRomanNumerals[i][0])){
				return true;
			}
		}
		return false;
	}
	
	
}