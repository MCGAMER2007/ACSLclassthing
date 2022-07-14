import java.util.*;


public class _1920jrc2 {
	static Scanner in;
	
	static String a, b;
	
	static String output;
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		for(int i = 0;i<5;i++) {
			init();
			solve();
			output();
		}
	}
	
	public static void init() {
		
		a = in.next();
		b = in.next();
		
		output = "";
	}
	
	public static void solve() {
		//delete the second consonants
		for(int i = 0;i<a.length()-1;i++) {
			if(a.charAt(i) == a.charAt(i + 1) && !isVowel(a.charAt(i))) {
				a = deleteChar(a, i + 1);
			}
		}
		for(int i = 0;i<b.length()-1;i++) {
			if(b.charAt(i) == b.charAt(i + 1) && !isVowel(b.charAt(i))) {
				b = deleteChar(b, i + 1);
			}
		}
		/*
		System.out.println(a);
		System.out.println(b);
		System.out.println();
		*/
		
		//delete every vowel
		for(int i = 1;i<a.length();i++) {
			if(isVowel(a.charAt(i))) {
				a = deleteChar(a, i);
				i--;
			}
		}
		for(int i = 1;i<b.length();i++) {
			if(isVowel(b.charAt(i))) {
				b = deleteChar(b, i);
				i--;
			}
		}
		
		//align left and delete in like positions
		String smaller = a;
		String larger = b;
		if(a.length() > b.length()) {
			smaller = b;
			larger = a;
		}
		for(int i = 0;i<smaller.length();i++) {
			if(smaller.charAt(i) == larger.charAt(i)) {
				smaller = deleteChar(smaller, i);
				larger = deleteChar(larger, i);
				i--;
			}
		}
		
		//align right and delete in like positions
		for(int i = 0;i<smaller.length();i++) {
			int si = smaller.length() - 1 - i;
			int li = larger.length() - 1 - i;
			if(smaller.charAt(si) == larger.charAt(li)) {
				smaller = deleteChar(smaller, si);
				larger = deleteChar(larger, li);
				i--;
			}
		}
		
		if(smaller.length() == larger.length()) {
			if(smaller.compareTo(larger) > 0) {
				output = larger;
			}
			else {
				output = smaller;
			}
		}
		else {
			output = smaller;
		}
	}
	
	public static void output() {
		System.out.println(output);
	}
	
	public static String deleteChar(String s, int index) {
		return s.substring(0, index) + s.substring(index + 1);
	}
	
	public static boolean isVowel(char c) {
		return c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
	}
}
