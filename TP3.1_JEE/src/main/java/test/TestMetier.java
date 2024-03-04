package test;

import java.util.List;

import metier.Boisson;
import metier.MetierImpl;

public class TestMetier {

	public static void main(String[] args) {
		MetierImpl metier= new MetierImpl();
		List<Boisson> bois = metier.getBoissonsParMotCle("jus");
		for (Boisson b : bois)
		System.out.println(b.getNomBoisson());
		}

	}


