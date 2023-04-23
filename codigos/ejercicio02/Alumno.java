package ejercicio02;

import java.time.LocalDate;
import java.util.Objects;

public class Alumno {

	private String dni;
	private String nombre;
	private String apellidos;
	private String ciclo;
	private int curso;
	private LocalDate fechaNac;

	public Alumno(String dni, String nombre, String apellidos, String ciclo, int curso, LocalDate fechaNac) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.ciclo = ciclo;
		this.curso = curso;
		this.fechaNac = fechaNac;
	}

	public String getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public String getCiclo() {
		return ciclo;
	}

	public int getCurso() {
		return curso;
	}

	public LocalDate getFechaNac() {
		return fechaNac;
	}

	@Override
	public String toString() {
		return "Alumno [dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", ciclo=" + ciclo
				+ ", curso=" + curso + ", fechaNac=" + fechaNac + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		return Objects.equals(dni, other.dni);
	}

	
	
}
