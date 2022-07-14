import java.util.*;
public class _1920jrc3 {
	
	static Combination[] priorities = {
			new Combination(15, 15, "0"),
			new Combination(15, 0, "B"),
			new Combination(0, 15, "~B"),
			new Combination(12, 12, "A"),
			new Combination(6, 6, "C"),
			new Combination(3, 3, "~A"),
			new Combination(9, 9, "~C"),
			new Combination(12, 0, "AB"),
			new Combination(6, 0, "BC"),
			new Combination(3, 0, "~AB"),
			new Combination(0, 12, "A~B"),
			new Combination(0, 6, "~BC"),
			new Combination(0, 3, "~A~B"),
			new Combination(8, 8, "A~C"),
			new Combination(4, 4, "AC"),
			new Combination(2, 2, "~AC"),
			new Combination(1, 1, "~A~C"),
			new Combination(9, 0, "B~C"),
			new Combination(0, 9, "~B~C"),
			new Combination(8, 0, "AB~C"),
			new Combination(4, 0, "ABC"),
			new Combination(2, 0, "~ABC"),
			new Combination(1, 0, "~AB~C"),
			new Combination(0, 8, "A~B~C"),
			new Combination(0, 4, "A~BC"),
			new Combination(0, 2, "~A~BC"),
			new Combination(0, 1, "~A~B~C")
	};
	

	
	static Scanner in;
	
	static int digit1, digit2;
	
	static String expression;
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		
		for(int i = 0;i<10;i++) {
			init();
			solve();
			output();
		}
	}
	
	public static void init() {
		
		String input = in.next();
		
		digit1 = input.charAt(0) - '0';
		if(Character.isAlphabetic(input.charAt(0))) {
			digit1 = input.charAt(0) - 'A' + 10;
		}
		
		digit2 = input.charAt(1) - '0';
		if(Character.isAlphabetic(input.charAt(1))) {
			digit2 = input.charAt(1) - 'A' + 10;
		}
		
		
		expression = "";
	}
	
	public static void solve() {
		for(int i = 0;i<priorities.length;i++) {
			Combination c = priorities[i];
			if(c.matches(digit1, digit2)) {
				if(expression.length() > 0) {
					expression += " + ";
				}
				expression += c.expression;
				
				digit1 = digit1 & ~c.d1;
				digit2 = digit2 & ~c.d2;
			}
		}
	}
	
	public static void output() {
		System.out.println(expression);
	}
	
}

class Combination{
	int d1, d2;
	String expression;
	
	public Combination(int d1, int d2, String exp) {
		this.d1 = d1;
		this.d2 = d2;
		expression = exp;
	}
	
	public boolean matches(int digit1, int digit2) {
		if((digit1 & d1) == d1 && (digit2 & d2) == d2) {
			return true;
		}
		return false;
	}
}
