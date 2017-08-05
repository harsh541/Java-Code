
public class PrintDay {

	public static void main(String[] args) {
		
		
		int d = 1;
		int m = 1;
		int y = 1970;
		
		int y0 = y - (14 - m) / 12;
		int x = y0 + y0/4 - y0/100 + y0/400;
		int m0 = m + 12 * ((14 - m)/ 12) - 2;
		int d0 = (d + x + 31*m0/12) % 7;
		

		String[] dayOfWeek = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
		System.out.println("Unix\'s birthday was on a " + dayOfWeek[d0]);
	}

}
