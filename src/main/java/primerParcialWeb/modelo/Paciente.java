package primerParcialWeb.modelo;

import java.io.Serializable;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paciente implements Serializable {

	private Integer id;

	private Integer documento;

	private String nombre;

	private String apellido;

	private String email;

	private String genero;

	private String fechaNacimiento;

	private String telefono;

	private String direccion;

	private Integer peso;

	private float estatura;

	public Paciente(Integer documento, String nombre, String apellido, String email, String genero,
			String fechaNacimiento, String telefono, String direccion, Integer peso, float estatura) {
		super();
		this.documento = documento;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.genero = genero;
		this.fechaNacimiento = fechaNacimiento;
		this.telefono = telefono;
		this.direccion = direccion;
		this.peso = peso;
		this.estatura = estatura;

	}

	public void IMC() {

		double resultado = 0;

		resultado = getPeso() / getEstatura() * getEstatura();

		if (resultado < 18.5) {

			System.out.println(" Estas bajo de peso ");

		} else if (resultado > 18.5 || resultado < 24.9) {

			System.out.println(" Estas normal de peso ");

		} else if (resultado > 25 || resultado < 29.9) {

			System.out.println(" Estas en sobrepeso ");

		} else if (resultado > 30 || resultado < 34.9) {

			System.out.println(" Estas en obesidad 1 ");

		} else if (resultado > 35 || resultado < 39.9) {

			System.out.println(" Estas en sobrepeso 2 ");

		} else if (resultado > 40) {

			System.out.println(" Estas en sobrepeso 3 ");

		}
		
	}
	


}
