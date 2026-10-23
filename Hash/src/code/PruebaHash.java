package code;

import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;

public class PruebaHash {

	  static HashMap<Student, Integer> cache = new HashMap<Student, Integer>(); // <person, targetPriority>

	   public static void main(String[] args) {
	       Student sarah1 = new Student("Sarah","Connor", "Jane", null);
	       Student sarah2 = new Student("Sarah","Connor", "Jane", new Date(1970, 01-1, 01));
	       Student sarah3 = new Student("Sarah","Connor", "Jane", new Date(1959, 02-1, 28)); // date not exists
	       Student john = new Student("John","Connor", "Kyle", new Date(1985, 02-1, 28)); // date not exists
	       Student johnny = new Student("John","Connor", "Kyle", new Date(1985, 02-1, 28)); // date not exists
	       System.out.println(john.hashCode());
	       System.out.println(johnny.hashCode());
	       System.out.println(sarah1.hashCode());
	       System.out.println();
	       cache.put(sarah1, 1);
	       cache.put(sarah2, 2);
	       cache.put(sarah3, 3);
	       System.out.println(new Date(sarah1.birthday));
	       System.out.println();
	       cache.put(john, 5);
	       System.out.println(cache.get(john));
	       System.out.println(cache.get(johnny));
	       cache.put(johnny, 7);
	       System.out.println(cache.get(john));
	       System.out.println(cache.get(johnny));
	   }
	}

