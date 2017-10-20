package be.pxl.streams;

import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.IntStream;

public class Challenge2 {
	public static void main(String[] args) {
		// maak een stream met 10 random gehele getallen tussen 0 en 30
		// bekijk hiervoor de methode ints(...) in de klasse Random
		// filter de getallen die deelbaar zijn door 3
		// en geef het maximum 
		// gebruik eventueel peek() om een tussenresultaat van de stream te tonen
		
		Random rand = new Random();
		int[] randomGetallen = new int[10];
		
		for(int i = 0; i < randomGetallen.length; i++){
			randomGetallen[i] = rand.nextInt(29) +1;
		}
		
		OptionalInt max = IntStream.of(randomGetallen).filter(s -> (s % 3 == 0))
								                      .max();
		
		if(max.isPresent()){
			System.out.println(max.getAsInt());
		} else {
			System.out.println("No result");
		}
	}
}
