package CHAPTER_2;
//예제 2-3
public class P74 {
	public static void main(String[] args) {
		byte b = 127;
		int i = 100;
		System.out.println(b+i); // b가 int 타입으로 자동 변환
		System.out.println(10/4); //정수 나누기이므로 결과는 2
		System.out.println(10.0/4); //4가 4.0으로 자동 변환
		System.out.println((char)0x12340041); //char로 변환 결과 'A'
		System.out.println((byte)(b+i));//b+i는 227, 16진수 0xE3, -29
		System.out.println((int)2.9 + 1.8);
		System.out.println((int)(2.9 + 1.8));
		System.out.println((int)2.9 + (int)1.8);
		System.out.println((byte)(128+128) + (int) 22.9);
	}

}
