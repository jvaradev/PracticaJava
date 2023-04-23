package ejercicio01;

import java.util.*;

public class Ejercicio01 {

	private static final Random random = new Random();
	private static final Scanner scanner = new Scanner(System.in);
	private static final ArrayList<Integer> listaEnt = new ArrayList<>();

	public static void main(String[] args) {

		System.out.print("Que cantidad quieres añadir de números: ");
		int cantidadNum = Integer.parseInt(scanner.nextLine());
		System.out.print("Indica el número máximo que puede aparecer: ");
		int maximo = Integer.parseInt(scanner.nextLine());

		for (int i = 0; i < cantidadNum; i++) {
			listaEnt.add(random.nextInt(0, maximo + 1));
		}

		for (Integer num : listaEnt) {
			System.out.print(num + " ");
		}
		
		System.out.println("La media de la lista es: "+calcularMedia(listaEnt));
		System.out.println("El mínimo de la lista es: "+obtenerMinimo(listaEnt));
		System.out.println("El máximo de la lista es: "+obtenerMaximo(listaEnt));

	}

	public static double calcularMedia(ArrayList<Integer> listaEnt) {
		int total = 0;
		for (Integer integer : listaEnt) {
			total += integer;
		}
		return (double)total / listaEnt.size();
	}

	public static int obtenerMaximo(ArrayList<Integer> listaEnt) {
		int maximo = 0;
		for (Integer integer : listaEnt) {
			if (integer>maximo) {
				maximo=integer;
			}
		}
		return maximo;
	}
	
	public static int obtenerMinimo(ArrayList<Integer> listaEnt) {
		int minimo = listaEnt.get(0);
		for (Integer integer : listaEnt) {
			if (integer<minimo) {
				minimo=integer;
			}
		}
		return minimo;
	}

}
