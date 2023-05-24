package mascotas;

import java.util.ArrayList;
import java.util.HashMap;


import javax.swing.JOptionPane;

public class Procesos {
		HashMap<Integer, Mascotas>mapMascotas;
	
	public Procesos() {
		
		mapMascotas=new HashMap<Integer, Mascotas>();
		iniciar();
	}

	private void iniciar() {
		System.out.println("Inicio exitoso");
		
		String menu ="GESTION DE MASCOTAS \n" ;
		menu += "1. Registrar Mascota \n";
		menu += "2. Imprimir datos de mascotas\n";
		menu += "3. Buscar Mascota por ID\n";
		menu += "4. Salir \n";
		
		int opc = 0;
		
		do {
			opc=Integer.parseInt(JOptionPane.showInputDialog(menu));
			crearMenu(opc);
		} while (opc!=4);	
			
	}
	
	
		
	private void crearMenu(int opc) {
		switch (opc) {
		case 1:
			registrarMascota();
			break;
		case 2:
			imprimirMascotas();
			break;
		case 3:
			consultarPorId();
			break;
		case 4:
			System.out.println("Salio del sistema");
			break;
		default: 
			System.out.println("No existe el codigo");
			break;
		}
		
	}

	private void consultarPorId() {
		 int idConsulta = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la identificacion de la mascota a consultar"));
		if (mapMascotas.containsKey(idConsulta)) {
			Mascotas mascotaTemporal = mapMascotas.get(idConsulta);
			System.out.println("la mascota si existe en la base de datos. Su nombre es: "+ mascotaTemporal.nombre);
			
		}else {System.out.println("La mascota no existe o no  se encuentra registrada");
		
		}
	}
		
	

	private void imprimirMascotas() {
		Mascotas mascotaTemporal;
		for (Integer id : mapMascotas.keySet()) {
			System.out.println(id);
			mascotaTemporal=mapMascotas.get(id);
			mascotaTemporal.imprimirDatos();
			mascotaTemporal.emitirSonido();
			
			
		}
		
		System.out.println();
		
		for (Mascotas mascota1 : mapMascotas.values()) {
			System.out.println(mascota1);
			mascota1.imprimirDatos();
			
		}
																																																																																																																									
	}

	public void registrarMascota() {
		Mascotas mascota1; 
		String resp;
		
		
		do {
			mascota1 = new Mascotas();
			mascota1.ingresarDatos();
			mapMascotas.put(mascota1.id, mascota1);
			resp=JOptionPane.showInputDialog("Ingrese si para registrar otra mascota");
		} while (resp.equalsIgnoreCase("si"));
		
		
		
		
		
	}

	
	
	
}
