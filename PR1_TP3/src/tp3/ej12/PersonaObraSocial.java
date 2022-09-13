package tp3.ej12;

public class PersonaObraSocial extends Persona {
	private String nombrePrestador;
	private int numeroAFiliado;
	
	public PersonaObraSocial(String dni, String nombre, String apellido, int edad, MotivoTest motivo,
			String nombrePrestador, int numeroAFiliado) {
		super(dni, nombre, apellido, edad, motivo);
		this.nombrePrestador = nombrePrestador;
		this.numeroAFiliado = numeroAFiliado;
	}
	
	
}