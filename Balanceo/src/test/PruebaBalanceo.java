package test;

import pila.*;

public class PruebaBalanceo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String expresion1 = "{[(5+3)]}";
		String expresion2 = "{[(5+3])}";

		System.out.println(Balanceo.isMatched(expresion1));
		System.out.println(Balanceo.isMatched(expresion2));
	}

}
