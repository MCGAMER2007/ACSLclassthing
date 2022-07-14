import java.util.*;
public class _2021jrc1 {


	static Scanner in;
	
	static int s, d, r;
	
	static int sum;
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		for(int i =0;i<10;i++) {
			init();
			solve();
			output();
		}
	}
	
	public static void init() {
		s = in.nextInt();
		d = in.nextInt();
		r = in.nextInt();
		sum = 0;
	}
	
	public static void solve() {
		int[] row = new int[r];
		int val = s;
		for(int limit = 1;limit <= r;limit++) {
			for(int i = 0;i<limit;i++) {
				row[i] = transform(val);
				val += d;
			}
		}
		
		for(int i = 0;i<r;i++) {
			sum += row[i];
		}
	}
	
	public static void output() {
		System.out.println(sum);
	}
	
	public static int transform(int num) {
		while(num > 9) {
			int sum = 0;
			while(num > 0) {
				sum += num % 10;
				num /= 10;
			}
			num = sum;
		}
		return num;
	}
}
