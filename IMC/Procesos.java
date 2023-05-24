import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Procesos {

	String nombre="";
	double imc,peso,talla;
	ArrayList<String> nombresList;
	ArrayList<String> resultadosList;
	
	public Procesos() {
		nombresList=new ArrayList<String>();
		resultadosList=new ArrayList<String>();
		iniciar();
	}
		
	public void iniciar() {
		System.out.println("Ingresa al menu");
		
		String menu ="Calculo IMC \n";
		menu += "1. Pedir datos  \n";
		menu += "2. Imprimir Diagnostico \n";
		menu += "3. Buscar paciente por nombre \n";
		menu += "4. Salir \n";
		menu += "5. Ingrese una opción \n";
		
		int opc = 0;
		do {
			
			opc = Integer.parseInt(JOptionPane.showInputDialog(menu));
			crearMenu(opc);
	} while (opc!=4);
}
	
	public void crearMenu (int opcion) {
	
	switch (opcion) {
	case 1 :
		ingresarDatos();		
		break;
	case 2: 
		calcularIMC();
		imprimirListas();
		System.out.println(resultadosList);
		System.out.println(nombresList);
		break;
	case 3:
		if(nombre!=null) {
			consultarPorNombre();
		}else {
			System.out.println("Debe llenar datos");
		}
		break;
	case 4:
		System.out.println("Salir");
		break;
	default: System.out.println("No existe el codigo");
		break;
	}
		
}
	
	
	
	
	private void consultarPorNombre() {
		
		String nombreConsulta=JOptionPane.showInputDialog("Ingrese el nombre a buscar");

		if (nombresList.contains(nombreConsulta)) {
			for (int i = 0; i < nombresList.size(); i++) {
				if (nombresList.get(i).equalsIgnoreCase(nombreConsulta)) {
					System.out.println("Si existe "+nombreConsulta+","
							+ " tiene "+resultadosList.get(i));
				}
			}	
			
			
			for (String elemento : nombresList) {
				int pos=nombresList.indexOf(elemento);
				if (nombresList.get(pos).equalsIgnoreCase(nombreConsulta)) {
					System.out.println(elemento+", resultado= "+resultadosList.get(pos));
					
				}
			}
			
			
		}else {
			System.out.println("El nombre ingresado no existe. intente otra vez.");
		}
	
	}

	public boolean imprimirListas() {
		System.out.println("********RESULTADOS**********");
		for (int i = 0; i < nombresList.size(); i++) {
			System.out.println(nombresList.get(i)+", resultado: "+resultadosList.get(i));
		}
		System.out.println("*****************************");
		return false;
	}

	private void ingresarDatos() {
		nombre=JOptionPane.showInputDialog("Ingrese el nombre");
		nombresList.add(nombre);
		peso=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el peso"));
		talla=Double.parseDouble(JOptionPane.showInputDialog("Ingrese la talla"));
		
	}
	
	private void calcularIMC() {
		imc=peso/(talla*talla);
		System.out.println("El IMC es: "+imc);
		
		String result="";
		
		if (imc<18) {
			result=("Anorexia");
		}else if (imc>=18 && imc <20) {
			result=("Delgadez");
		}else if (imc>=20 && imc <27) {
			result=("Normalidad");
		}else if (imc>=27 && imc <30) {
			result=("Obesidad 1");
		}else if (imc>=30 && imc <35) {
			result=("Obesidad 2");
		}else if (imc>=35 && imc <40) {
			result=("Obesidad 3");
		}else if (imc>=40) {
			result=("Obesidad Morbida");
		}

		resultadosList.add(result);
		System.out.println("El Estado del paciente es: "+result);
	}

}
