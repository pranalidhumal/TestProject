package browser;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;


public class Collection {

	//INSERTION
	//RETRIEVAL
	//DELETION
	public static void main(String[] args) {
		//heterogeneous collection
//		ArrayList a = new ArrayList();
//		a.add(54);
//		a.add("dihbb");
//		a.add(54.897);
//		a.add('%');
//		
//		for(int i = 0;i<a.size();i++) {
//			//retrieval
//			System.out.println(a.get(i));
//		}
//		
//		
//		//HOMEGENEOUS COLLECTION
//		ArrayList<String> x = new ArrayList<String>();
//		x.add("trupti");
//		x.add("debbi");
//		x.add("lioj");
//		//x.add(65);
//		for(int i=0;i<x.size();i++) {
//			System.out.println(x.get(i));
//		}
//		//Deletion
//		x.remove(2);
//
//		for(int i=0;i<x.size();i++) {
//			System.out.println(x.get(i));
//		}
////		//up casting
////		List b = new ArrayList();
////		b.add(45);
////		b.add("gfgf");
////		b.add('f');
////		//
//		
//		//Advance for loop
//		for(String s : x)
//		{
//			
//		System.out.println(s);
		
		HashSet<Integer> s = new HashSet<Integer>();
		//Insertion
		s.add(34);
		s.add(356);
		s.add(3498);
		s.add(38);
//Retrieval
		for(int m :s)
		{
			System.out.println(m);
	}
		System.out.println("======");
		
	
	//retrieval
		Iterator<Integer> i = s.iterator();
		
		//i.next();
		//i.hasnext();
		for(int m :s)
		{
			System.out.println(i.next());
	}
		System.out.println("======");
		
		i=s.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}
}
}