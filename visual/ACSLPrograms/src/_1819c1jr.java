import java.util.*;
public class _1819c1jr {
	static Scanner in;
	
	static String s1, s2, s3, s4, s5;
	
	static String output;
	
	public static void main(String[] args) {
		input();
		solve();
		output();
	}
	
	public static void input() {
		in = new Scanner(System.in);
		
		s1 = in.next();
		s2 = in.next();
		s3 = in.next();
		s4 = in.next();
		s5 = in.next();
		
		output = "";
	}
	
	public static void solve() {
		int count1 = s1.length();
		output += count1 + "\n";
		
		int count2 = 0;
		for(int i = 0;i<s2.length();i++) {
			char c = s2.charAt(i);
			count2 += c - '0';
		}
		output += count2 + "\n";
	}
	
	public static void output() {
		System.out.println(output);
	}
}
