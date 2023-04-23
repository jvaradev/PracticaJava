package ejercicio02;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Ejercicio02 {

	private static final String FORMATO_FECHA = "dd/MM/yyyy";
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMATO_FECHA);
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		int eleccionUsuario;
		ArrayList<Alumno> listaAlumnos = new ArrayList<>();

		do {
			menu();
			eleccionUsuario = Integer.parseInt(scanner.nextLine());
			switch (eleccionUsuario) {
			case 1: {
				listarAlumnos(listaAlumnos);
				break;
			}
			case 2: {
				aniadirAlumno(listaAlumnos);
				break;
			}
			case 3: {
				eliminarAlumno(listaAlumnos);
				break;
			}
			case 4: {
				mostrarAlumno(listaAlumnos);
				break;
			}
			case 0: {
				System.out.println("Saliendo del programa...");
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + eleccionUsuario);
			}
		} while (eleccionUsuario != 0);
	}

	public static void listarAlumnos(ArrayList<Alumno> listaAlumnos) { //Método que muestra todos los alumnos
		System.out.println("Lista de alumnos.");
		for (Alumno alumno : listaAlumnos) {
			System.out.println(alumno.toString());
		}
		System.out.println("-".repeat(150));
	}

	public static void aniadirAlumno(ArrayList<Alumno> listaAlumnos) { //Método que añade un alumno si no existe en el ArrayList
		Alumno alumnoAniadir = pedirDatos();
		int contador = 0;
		for (Alumno alumno : listaAlumnos) {
			if (alumno.equals(alumnoAniadir)) {
				contador++;
			}
		}
		if (contador==0) {
			System.out.println("Añadiendo alumno...");
			listaAlumnos.add(alumnoAniadir);
		}else
			System.out.println("Alumno ya existente.");
		System.out.println("-".repeat(150));
	}

	public static void mostrarAlumno(ArrayList<Alumno> listaAlumnos) { //Método que muestra un alumno si existe en el ArrayList
		Alumno alumnoMostrar = pedirDatos();
		int contador = 0;
		for (Alumno alumno : listaAlumnos) {
			if (alumno.equals(alumnoMostrar)) {
				contador++;
			} 
			
		}
		if (contador>0) {
			System.out.println("Mostrando alumno...");
			System.out.println(alumnoMostrar.toString());
		}else {
			System.out.println("No existe el alumno");
		}
		System.out.println("-".repeat(150));
	}

	public static void eliminarAlumno(ArrayList<Alumno> listaAlumnos) { //Método que elimina un alumno si existe en el ArrayList
		Alumno alumnoEliminar = pedirDatos();
		int contador = 0;
		for (Alumno alumno : listaAlumnos) {
			if (alumno.equals(alumnoEliminar)) {
				contador++;
			} 
			
		}
		if (contador>0) {
			System.out.println("Eliminando alumno...");
			listaAlumnos.remove(alumnoEliminar);
		}else {
			System.out.println("No existe el alumno");
		}
		System.out.println("-".repeat(150));
	}

	public static Alumno pedirDatos() { //Método que pide los datos y crea un objeto Alumno
		System.out.print("Indica el NIF/NIE: ");
		String dni = scanner.nextLine();
		System.out.print("Indica el nombre: ");
		String nombre = scanner.nextLine();
		System.out.print("Indica los apellidos: ");
		String apellidos = scanner.nextLine();
		System.out.print("Indica el ciclo formativo: ");
		String ciclo = scanner.nextLine();
		System.out.print("Indica el curso: ");
		int curso = Integer.parseInt(scanner.nextLine());
		System.out.print("Indica la fecha de nacimiento: ");
		LocalDate fechaNac = LocalDate.parse(scanner.nextLine(),formatter);
		
		Alumno alumno = new Alumno(dni, nombre, apellidos, ciclo, curso, fechaNac);
		
		return alumno;
	}

	public static void menu() { // Método que muestra el menú del programa de gestión de alumnos.
		System.out.println("GESTIÓN DE ALUMNOS");
		System.out.println("-".repeat(150));
		System.out.println("[1] Listar alumnos.\n" + "[2] Añadir alumno.\n" + "[3] Eliminar alumno.\n"
				+ "[4] Mostrar alumno.\n" + "[0] Salir");
	}

}
