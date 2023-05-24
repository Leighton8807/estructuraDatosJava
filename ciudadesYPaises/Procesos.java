package ciudadesYPaises;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

public class Procesos {
	String nombrePais, nombreCiudad;
	
	HashMap<String, ArrayList<String>>mapPaises;
	ArrayList<String>listCiudades;
	
	

	public Procesos(){
		mapPaises = new HashMap<String, ArrayList<String>>();
		listCiudades = new ArrayList<String>();
		
		iniciar();
	}
	
	private void iniciar() {
		System.out.println("Inicio exitoso");
		System.out.println("bienvenido");
		
		String menu ="GESTION DE PAISES \n" ;
		menu += "1. Registrar Pais \n";
		menu += "2. Buscar Pais\n";
		menu += "3. Buscar Ciudad\n";
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
			registrarPais();
			break;
		case 2:
			buscarPais();
			break;
		case 3:
			buscarCiudad();
			break;
		case 4:
			System.out.println("Salio del sistema");
			break;
		default: 
			System.out.println("No existe el codigo");
			break;
		}		
	}
	
	private void registrarPais() {
		nombrePais=JOptionPane.showInputDialog("Ingrese el nombre del País");
		mapPaises.put(nombrePais, listCiudades);
		
		
		String resp ="";
		do {
			nombreCiudad=JOptionPane.showInputDialog("Ingrese el nombre de la ciudad");
			listCiudades.add(nombreCiudad);
			resp=JOptionPane.showInputDialog("Escriba \"si\" si quiere ingresar otra ciudad ");
		} while (resp.equalsIgnoreCase("si"));	
		System.out.println(mapPaises);
		System.out.println(listCiudades);
	}
	
	
	
	private void buscarPais() {
		String nombrePais=JOptionPane.showInputDialog("Ingrese el Pais a buscar");

		if (mapPaises.containsKey(nombrePais)) {
			ArrayList<String> ciudades = mapPaises.get(nombrePais);
			
	        System.out.println("El país " + nombrePais + " si existe tiene las siguientes ciudades:");
	        for (String ciudad : ciudades) {
	            System.out.println(ciudad);
	        }
	    } else {
	        System.out.println("El país ingresado no existe. Intente otra vez.");
	    }
		
	}
	
	private void buscarCiudad() {
		 nombreCiudad=JOptionPane.showInputDialog("Ingrese la Ciudad a buscar");
	  
	    if (mapPaises.containsKey(nombrePais)) {
	    	ArrayList<String> listCiudades = mapPaises.get(nombrePais);
	        
	  
	        if (listCiudades.contains(nombreCiudad)) {
	            System.out.println("La ciudad " + nombreCiudad + " pertenece al país " + nombrePais);
	        } else {
	            System.out.println("La ciudad " + nombreCiudad + " no pertenece al país " + nombrePais);
	        }
	    } else {
	        System.out.println("El país ingresado no existe. Intente otra vez.");
	    }
	}
	
	public void imprimirDatos() {
		System.out.println(mapPaises);
		System.out.println(listCiudades);
		
		}

	
	
	
}



