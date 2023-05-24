import javax.swing.JOptionPane;

public class Procesos {
	String nombre="";
	double imc,peso,talla;
	String[] nombresList;
	String[] resultadosList;
	int contador;
	public Procesos() {
		nombresList= new String[100];
		resultadosList=new String[100];;
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
		calcularIMC(peso, talla);
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
        String nombreConsulta = JOptionPane.showInputDialog("Ingrese el nombre a buscar");

        boolean encontrado = false;
        for (int i = 0; i < contador; i++) {
            if (nombresList[i].equalsIgnoreCase(nombreConsulta)) {
                System.out.println("Si existe " + nombreConsulta + ", tiene " + resultadosList[i]);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("El nombre ingresado no existe. Intente nuevamente.");
        }
    }

	public boolean imprimirListas() {
		System.out.println("********RESULTADOS**********");
		for (int i = 0; i < nombresList.length; i++) {
			System.out.println(nombresList[i]+", resultado: "+resultadosList[i]);
		}
		System.out.println("*****************************");
		return false;
	}

	private void ingresarDatos() {
		nombre=JOptionPane.showInputDialog("Ingrese el nombre");
		nombresList[contador]=nombre;
		peso=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el peso"));
		talla=Double.parseDouble(JOptionPane.showInputDialog("Ingrese la talla"));
		
		double imc = calcularIMC(peso, talla);
		String resultado = obtenerResultado(imc);
		
	}
	
	private double calcularIMC(double peso, double talla) {
		return peso/(talla*talla);
		
		
	}
	
	private String obtenerResultado(double imc) {
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
		System.out.println("El Estado del paciente es: "+result);
		return resultadosList[contador]=result;
		
	}
}
