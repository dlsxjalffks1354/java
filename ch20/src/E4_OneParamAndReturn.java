interface HowLong {
	int len(String s);		// 값을 반환하는 메소드 	
}


public class E4_OneParamAndReturn {

	public static void main(String[] args) {
		HowLong hl = s -> s.length();
		//int num = hl.len("I am so Happy");  // 이와 같은 연산 결과가 남는다.
		System.out.println(hl.len("I am so Happy"));
	}

}
