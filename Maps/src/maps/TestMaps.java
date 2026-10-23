package maps;

import net.datastructures.AVLTreeMap;
import net.datastructures.Entry;
import net.datastructures.SortedMap;
import net.datastructures.SortedTableMap;

public class TestMaps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Alumno a1 = new Alumno("Juan", 111);
		Alumno a2 = new Alumno("Maria",222);
		Alumno a3 = new Alumno("Jose", 333);
		Alumno a4 = new Alumno("Ana", 444);
		
		//Map<Integer,Alumno> map = new UnsortedTableMap<Integer, Alumno>();
		//Map<Integer,Alumno> map = new ChainHashMap<Integer, Alumno>();
		//Map<Integer,Alumno> map = new ProbeHashMap<Integer, Alumno>();
		//SortedMap<Integer, Alumno> map = new TreeMap<Integer, Alumno>();
		//SortedMap<Integer,Alumno> map = new SortedTableMap<Integer, Alumno>();
		SortedMap<Integer, Alumno> map = new AVLTreeMap<Integer, Alumno>();
		
		map.put(111, a1);
		map.put(222, a2);
		map.put(333, a3);
		map.put(444, a4);
		/*
		System.out.println(map.get(222));
		
		map.remove(222);
		
		System.out.println(map.get(222));
		
		*/
		
		/*
		for(int i : map.keySet())
			System.out.println(i);
		
		for(Alumno a : map.values())
			System.out.println(a);
		
		for(Entry<Integer,Alumno> e : map.entrySet())
			System.out.println(e.getKey() + " " + e.getValue());
			*/
		
		Entry<Integer,Alumno> e = map.floorEntry(222);
		
		System.out.println(e.getKey());
		System.out.println(e.getValue());
		
		
		
	}

}
