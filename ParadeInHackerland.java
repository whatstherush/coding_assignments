package payPalOnlineCodingRound;

import java.util.HashSet;

public class ParadeInHackerland {

	static HashSet<Integer> positionOf01Pair;

	static HashSet<Integer> findPositionOf01Pair(String str) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < str.length()-1; i++) { //last element jo bhi fark ni padta, hence no need to check 
				if (str.charAt(i) == '0' && str.charAt(i + 1) == '1') {
					set.add(i);
			}
		}
		return set;
	}


	static String swap(String str, int i, int j) {
		char[] arr = str.toCharArray();
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		return new String(arr);
	}

	static int getSwapTime(String color) {
		int count = 0;
		positionOf01Pair = findPositionOf01Pair(color);
		boolean isHaving01pair = false;
		if (positionOf01Pair.isEmpty())
			isHaving01pair = false;

		else
			isHaving01pair = true;
		while (isHaving01pair) {
			for (int i : positionOf01Pair) {
				color = swap(color, i, i + 1);
			}
			count++;
			positionOf01Pair = findPositionOf01Pair(color);
			if (positionOf01Pair.isEmpty())
				isHaving01pair = false;

			else
				isHaving01pair = true;
		}
		return count;

	}

	public static void main(String[] args) {
		System.out.println(getSwapTime("1000"));
	}

}
