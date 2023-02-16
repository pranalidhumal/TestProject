package browser;

public class Generic <H,K> {

	int a;
	
	H b;
	H test(K c) {
		return b;
	}
	public static void main (String[] args) {
		
	
	Generic x = new Generic();
	x.a=56;
	x.b=45;
	System.out.println(x.test(546));
	x.b="panu";
	System.out.println(x.test("ghjj"));
	x.b=45.678;
	System.out.println(x.test(546.78));
	x.b=new Generic();
	System.out.println(x.test(56.87));

//	Generic<String> y = new Generic<String>();
//	y.a=34;
//	y.a = 54;
//	y.b="sona";
//	y.b=65.897;
//	
	Generic<String,Integer> y = new Generic<String,Integer>();
     y.a = 45;
     y.b ="truuj";
     System.out.println(y.test(76));
}
}