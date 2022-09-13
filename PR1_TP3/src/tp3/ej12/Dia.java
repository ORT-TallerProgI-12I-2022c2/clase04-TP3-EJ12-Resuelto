package tp3.ej12;

import java.util.ArrayList;

public class Dia {

	private static String NOTIFICACION = "No hay cupos para hoy";
	private String fecha;
	private boolean esHabil;
	private ArrayList<Persona> personas;
		
	public Dia(String fecha, boolean esHabil) {
		super();
		this.fecha = fecha;
		this.esHabil = esHabil;
		this.personas = new ArrayList<>();
	}

	/**
	 * 
	 * @param capacidad Hasta cuántas personas pueden haber para testearse
	 * @return La cantidad de personas que quedaron fuera (y fueron notificadas)
	 */
	public int revisar (int capacidad) {
		// Asumimos que las personas están ordenadas por prioridad de forma descendente
		int cant = getCantPersonas();
		for (int i = capacidad; i < cant; i++) {
			Persona p = personas.get(i);
			p.notificar(NOTIFICACION);			
		}
		return personas.size() > capacidad ? personas.size() - capacidad : 0;
	}

	public int getCantPersonas() {
		return this.personas.size();
	}

	public int getCantPersonasConPrioridad(int nroPrioridad) {
		int cant = 0;
		for (Persona persona : personas) {
			if (persona.getPrioridad() == nroPrioridad) {
				cant++;
			}
		}
		return cant;
	}
	
	public double promedioEdadPersonasSinOS() {
		double acuEdades = 0;
		int cant = 0;
		for (Persona persona : personas) {
			if (!persona.tieneObraSocial()) {
				acuEdades += persona.getEdad();
				cant++;
			}
		}
		return cant > 0 ? acuEdades / cant : 0;
	}
}