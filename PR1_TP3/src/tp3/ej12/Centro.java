package tp3.ej12;

import java.util.ArrayList;

public class Centro {

	private static int CAPACIDAD = 50;
	private ArrayList<Dia> dias;
	
	public Centro() {
		super();
		this.dias = new ArrayList<>();
	}

	public double revisar() {
		int acuPersonasAfuera = 0;
		int cantTotalPersonas = 0;
		for (Dia dia : dias) {
			acuPersonasAfuera += dia.revisar(CAPACIDAD);
			cantTotalPersonas += dia.getCantPersonas();
		}
		return cantTotalPersonas > 0 ? acuPersonasAfuera * 100.0 / cantTotalPersonas : 0;
	}
	
	public void mostrarDiaConMasPrioritarios(int nroPrioridad) {
		int max = -1;
		Dia diaMayor = null;
		for (Dia dia : dias) {
			int cantPrioritarios = dia.getCantPersonasConPrioridad(nroPrioridad);
			if (cantPrioritarios > max) {
				max = cantPrioritarios;
				diaMayor = dia;
			}
		}
		System.out.println("El día con más personas de prioridad " + nroPrioridad + " es " + diaMayor);
	}
}