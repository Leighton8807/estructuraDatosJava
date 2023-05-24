/* 
 Haga un algoritmo que solicite el nombre y edad de n 
 estudiantes y realice lo siguiente:
 - imprima la lista de estudiantes con su edad
 indique el promedio de edades de estudiantes
 indique cual o cuales son los estudiantes de mayor edad de todo el grupo
 indique cual o cuales son los estudiantes de menor edad de todo el grupo
 indique cuantos estudiantes son mayores de edad,
  siendo mayor con una edad igual o superior a 18 años
  -permita realizar la busqueda por nombre indicando cual es el estudiante encontrado y cual es su edad
  permita realizar la busqueda por edades, indicando todos los estudiantes con la edad ingresada.
 */

package taller02052023;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;



public class Procesos {
ArrayList<String> listEstudiantes;
ArrayList <Integer> listEdades;
ArrayList<Integer> mayores;
ArrayList<Integer> menores;
int cantMayores = 0, cantMenores = 0, edad=0, totalMayores=0, totalMenores;
double promedio = 0;
String nombre = "";

public Procesos() {
	listEstudiantes = new ArrayList<String>();
	listEdades = new ArrayList <Integer>();
	mayores = new ArrayList<Integer>();
	menores = new ArrayList <Integer>();

	
}


public void Iniciar() {
	System.out.println("bienvenido");
	String menu ="GESTION DE ESTUDIANTES \n";
	menu += "1. Pedir datos estudiante \n";
	menu += "2. Imprimir estudiantes \n";
	menu += "3. promedio de edades \n";
	menu += "4. estudiante(s) de mayor edad \n";
	menu += "5. Estudiante(s) de menor edad \n";
	menu += "6. Estudiantes mayores de edad \n";
	menu += "7. Buscar por nombre \n";
	menu += "8. Buscar por edades \n";
	menu += "9. Salir \n";
	
	
	int opc = 0;
	
	do {
		opc=Integer.parseInt(JOptionPane.showInputDialog(menu));
		crearMenu(opc);
	} while (opc!=9);
	
}

public void crearMenu(int opcion) {
	System.out.println("crear menu");
	
	switch (opcion) {
		case 1: 
			llenarDatos();
			break;
		
		case 2:
			imprimirDatos();
			break;
		case 3:
			promediarEdades();
			break;
		case 4: 
			//mayorEdad();
			break;
		case 5:
			//menorEdad();
			break;
		case 6:
			//estudiantesMayores();
		case 7:
			//buscarNombre();
			break;
		case 8:
			//buscarEdades();
			break;
		case 9:
			System.out.println("Bye!");
	
		default:
			System.out.println("No existe el codigo");
			break;
	}
	
}




public void llenarDatos() {
	System.out.println("Llenar el arreglo");
	int cantEstudiantes=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de estudiantes"));
	for (int i = 0; i < cantEstudiantes; i++) {
		nombre = JOptionPane.showInputDialog("Ingrese el nombre del estudiante");
		listEstudiantes.add(nombre);
		edad= Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del estudiante"));
		listEdades.add(edad);	
	}
	
	if(listEstudiantes.size() > 0 && listEdades.size() > 0) {
		imprimirDatos();
	}
	
	
}

public void imprimirDatos() {
	for (int i = 0; i < listEstudiantes.size(); i++) {
		System.out.println("Nombre estudiante "+listEstudiantes.get(i));
		System.out.println("Edad estudiante "+listEdades.get(i));
		validateEdad(listEdades.get(i), listEstudiantes.get(i));
	}
	promediarEdades();	
}

public void validateEdad(int edad, String name) {
	if(edad > 18) {
		System.out.println("El estudiante "+name+" es mayor de edad");
		totalMayores += edad;
		mayores.add(edad);
	}else {
		System.out.println("El estudiante "+name+" es menor de edad");
		totalMenores += edad;
		menores.add(edad);
	}
}
	
public void promediarEdades() {
	System.out.println("El promedio de los mayores es: "+totalMayores/mayores.size());
	System.out.println("El promedio de los menores es: "+totalMenores/menores.size());
}
	
	
	
	
}
