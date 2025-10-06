package module_7;


import java.util.*;


public class ArraysBasics {

	public static void main(String[] args) {
			
		
		Scanner console = new Scanner(System.in);
		
		//Get how many temperature user wants to process
		System.out.print("How many dya's temprature: ");
		int numDays = console.nextInt();
		
		int [] tempDays = new int[numDays];
		
		int avarageTemp = sumOfTemperatures(tempDays);
		
		System.out.println("Avarage Temperature is = " + avarageTemp);
		
		console.close();
	}

	
	
	//-------------------- sumOfTemperatures Function --------------------
	public static int sumOfTemperatures (int [] temperatures) {
		int sum = 0;
		int avarage = temperatures.length;
		Scanner console = new Scanner(System.in);
		
		
		for (int i = 0; i < temperatures.length; i++) {
			System.out.print("Day " + (i+1)+ "'s high temperature: ");
			temperatures[i] = console.nextInt();
			sum += temperatures[i];
		}
		console.close();
		
		avarage = sum / avarage;
		
		
		
		return avarage;
	}
	
	
}



// Declaring an Array

//int []temp;



// Constructing an Array. Because Array is an object, we need to construct the array as follow:
//double [] temp1 = new double[10];
//System.out.println(temp1.length);
//*********************************************************************************************	