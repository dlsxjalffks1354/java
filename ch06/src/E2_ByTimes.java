
public class E2_ByTimes {

	public static void main(String[] args) {
		for(int i = 2; i < 10; i++) {
			System.out.println("---------------------------------");
			for(int j = 1; j < 10; j++) {
				System.out.printf("%d x %d = %d\n", i, j, i * j);
			}
		}
	}

}
