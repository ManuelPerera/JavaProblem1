package problem1;

import java.math.BigInteger;


public class Main  {
	
	public static boolean isDouble(String str) { //comprueba si el número es decimal
	  return str.matches("-?\\d+(\\.\\d+)");
	}
	
	public static boolean isInteger(String str) { //comprueba si el número es entero
	  return str.matches("-?\\d+?");
	}
	
	public static BigInteger factBig(long iunput) { //factorial con BigInteger para números > 20, que superan la capacidad de long. Más caro que el normal
	    BigInteger factorial = BigInteger.ONE;
	    BigInteger factz = BigInteger.valueOf(iunput);

	    if(iunput == 0 || iunput == 1) {
	        return factorial;
	    } else {
	        return factz.multiply(factBig(iunput-1));
	    }
	}
	
	static long factEnt(long n) { //factorial normal para números <= 20. 
		long factorial;
       if(n == 0 || n == 1) return 1;

       factorial = factEnt(n-1)*n;
       return factorial;
    }
	
	public static void main(String[] args) {
		long resultLong = 0;
		BigInteger resultBig = BigInteger.ZERO;
		long inputLong = 0;
		
		if(args.length == 1) { //un solo parámetro
			if (isInteger(args[0])) { 
				inputLong = Long.parseLong(args[0]);
				if (inputLong < 0) System.out.println("El factorial de un numero negativo no puede calcularse\n"); //número negatico
				else if(inputLong < 20){
					if(args[0].equals("0") || args[0].equals("1")) {
						resultLong = 1;
					} else resultLong = factEnt(inputLong);
					System.out.println("El factorial de "+inputLong+" es "+resultLong+"\n"); //caso base, para ahorrar tiempo
				} else {
					resultBig = factBig(inputLong);
					System.out.println("El factorial de "+inputLong+" es "+resultBig+"\n"); //caso normal
				}
			}
			
			else if (isDouble(args[0])) System.out.println("Error: El programa no esta pensado para funcionar con números decimales "
					+ "ya que para ello haría falta trabajar con funciones gamma de librerías externas, de apache, y no se si eso está permitido "
					+ "en esta prueba.\n"); //Caso de número decimal. Se podría llegar a implementar
			else System.out.println("Error: Por favor, introduce un número entero.\n"); //el parámetro no es un número
		} 
		
		else if(args.length > 1) System.out.println("Error: Demasiados argumentos. Introduce un único número entero.\n"); //demasiados parametros
		
		else System.out.println("Error: Introduce un único número entero.\n"); //sin parametros
			
	}
}