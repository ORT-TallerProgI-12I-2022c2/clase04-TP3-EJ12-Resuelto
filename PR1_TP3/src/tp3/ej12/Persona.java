package tp3.ej12;

public class Persona implements Notificable, Priorizable {

	private static int EDAD_MAX_PRI = 60;
	private String dni;
	private String nombre;
	private String apellido;
	private int edad;
	private MotivoTest motivo;
	
	public Persona(String dni, String nombre, String apellido, int edad, MotivoTest motivo) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.motivo = motivo;
	}
	
	public String nombreCompleto() {
		return nombre + " " + apellido;
	}

	@Override
	public void notificar(String mensaje) {
		System.out.println(nombreCompleto() + ": " + mensaje);		
	}

	@Override
	public int getPrioridad() {	
		int p;
		if (edad >= EDAD_MAX_PRI || motivo == MotivoTest.CONTACTO_ESTRECHO || !tieneObraSocial()) {
			p = PRIORIDAD_MAX;
		} else {
			p = PRIORIDAD_MIN;
		}
		return p;
	}
	
	public int getEdad() {	
		return edad;
	}

	public boolean tieneObraSocial() {
		return this instanceof PersonaObraSocial;
	}
	
	
}