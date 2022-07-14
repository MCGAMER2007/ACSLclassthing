import java.util.*;

public class _1819jrc2 {
	static Scanner in;
	
	static String sentence;
	
	static int o1, o2, o3, o4;
	static String o5;
	
	public static void main(String[] args) {
		init();
		solve();
		output();
	}
	
	public static void init() {
		in = new Scanner(System.in);
		
		sentence = in.nextLine();
		
		o1 = 0;
		o2 = 0;
		o3 = 0;
		o4 = 0;
		o5 = "";
	}
	
	public static void solve() {
		
		int count = 0;
		for(char c = 'a';c <= 'z';c++) {
			if(sentence.toLowerCase().indexOf(c) != -1) {
				count++;
			}
		}
		o1 = count;
		
		
	}
	
	public static void output() {
		System.out.println(o1);
	}
}
