package mascotas;

import javax.swing.JOptionPane;

public class Mascotas {
	Integer id;
	String especie;
	String raza;
	String nombre;
	int edad;
	
	
	public Mascotas(){
		
			
		
	}
	
//	public Mascotas(String especie, String raza, String nombre, int edad, int id) {
//		System.out.println("*******Ingresa al constructor con parametros*******");
//		this.especie = especie;
//		this.raza = raza;
//		this.nombre = nombre;
//		this.edad = edad;
//		this.id=id;
//		
//	}
	
	public void despertar() {
		System.out.println("El "+ especie+" Despierta");
	}
	
	public void caminar() {
		System.out.println("El "+especie+" Camina");
	}
	
	public void comer() {
		System.out.println("El "+especie+" Come");
	}
	
	public void emitirSonido() {
		
		if (especie.equalsIgnoreCase("perro")) {
			System.out.println("¡Guau guau!");
			} else if (especie.equalsIgnoreCase("gato")) {
			System.out.println("El"+ nombre+ " maulla: \"Rauuuuull!!!!\"");
			} else {
			System.out.println("La mascota no hace sonidos conocidos.");
			}

	
	}

	public void imprimirDatos() {
		String mensaje="*************** DATOS MASCOTA ***********\n\n";
		mensaje += "id "+id+", Especie: "+ especie+", Raza: "+raza+"\n";
		mensaje += "Nombre: "+ nombre+", Edad: "+ edad+"\n \n";
		mensaje += "*************************************************";
		System.out.println(mensaje);
	}

	public void ingresarDatos() {
		id=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la identificacion de la mascota"));
		nombre=JOptionPane.showInputDialog("Ingrese el nombre de la mascota");
		especie=JOptionPane.showInputDialog("Ingrese la especie de la mascota");
		raza=JOptionPane.showInputDialog("Ingrese la raza de la mascota");
		edad=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad de la mascota"));
	}
	
}
