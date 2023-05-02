import javax.swing.JOptionPane;

public class ProcesosArreglos {
	String nombres[];
	int edades[];

	public void iniciar() {
		System.out.println("Iniciar");

		String menu = "GESTION ESTUDIANTES\n";
		menu += "1. Pedir datos estudiante\n";
		menu += "2. Imprimir estudiantes\n";
		menu += "3. Promedio de edades de estudiantes\n";
		menu += "4. Estudiantes de mayor edad\n";
		menu += "5. Estudiantes de menor edad\n";
		menu += "6. Estudiantes mayores de edad\n";
		menu += "7. Buscar estudiante por nombre\n";
		menu += "8. Buscar estudiantes por edad\n";
		menu += "9. Salir\n";
		menu += "Ingrese una opcion";

		int opc = 0;

		do {
			opc = Integer.parseInt(JOptionPane.showInputDialog(menu));
			crearMenu(opc);
		} while (opc != 9);
	}

	public void crearMenu(int opc) {
		System.out.println("Crear menu");
		switch (opc) {
		case 1:
			llenarDatos();
			break;
		case 2:
			if (validarLlenado()) {
				imprimirDatos();
			}
			break;
		case 3:
			if (validarLlenado()) {
				promedio();
			}
			break;
		case 4:
			if (validarLlenado()) {
				mayorEdad();
			}
			break;
		case 5:
			if (validarLlenado()) {
				menorEdad();
			}
			break;
		case 6:
			if (validarLlenado()) {
				mayorDeEdad();
			}
			break;
		case 7:
			if (validarLlenado()) {
				buscarPorNombre();
			}
			break;
		case 8:
			if (validarLlenado()) {
				buscarPorEdad();
			}
			break;
		case 9:
			System.out.println("Gracias y adios");
			break;
		default:
			System.out.println("No existe el codigo");
			break;
		}
	}

	public boolean validarLlenado() {
		if (nombres != null) {
			return true;
		} else {
			System.out.println("Debe llenar datos");
			return false;
		}
	}

	public void llenarDatos() {
		System.out.println("Llenar el arreglo");
		int tam = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de estudiantes"));
		nombres = new String[tam];
		edades = new int[tam];
		for (int i = 0; i < nombres.length; i++) {
			nombres[i] = JOptionPane.showInputDialog("Ingrese el nombre");
			edades[i] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese las edades"));
		}
	}

	public void imprimirDatos() {
		System.out.println("Imprimir info");
		for (int i = 0; i < nombres.length; i++) {
			System.out.println(nombres[i] + ", " + edades[i]);
		}

	}

	public void promedio() {
		int suma = 0;
		double promedio = 0;
		for (int i = 0; i < edades.length; i++) {
			suma += edades[i];
		}
		promedio = suma / edades.length;
		System.out.println("El promedio de las edades es de: " + promedio);

	}

	public void mayorEdad() {
		int edadMaxima = 0;
		String nombreMayor = "";
		for (int i = 0; i < edades.length; i++) {
			if (edades[i] > edadMaxima) {
				edadMaxima = edades[i];
				nombreMayor = nombres[i];
			} else if (edades[i] == edadMaxima) {
				nombreMayor += ", " + nombres[i];
			}
		}
		JOptionPane.showMessageDialog(null,
				"Los estudiantes de mayor edad son: " + nombreMayor + " con " + edadMaxima + " años.");

	}

	public void menorEdad() {
		int edadMinima = Integer.MAX_VALUE;
		String nombreMenor = "";
		for (int i = 0; i < edades.length; i++) {
			if (edades[i] < edadMinima) {
				edadMinima = edades[i];
				nombreMenor = nombres[i];
			} else if (edades[i] == edadMinima) {
				nombreMenor += ", " + nombres[i];
			}
		}
		JOptionPane.showMessageDialog(null,
				"Los estudiantes de menor edad son: " + nombreMenor + " con " + edadMinima + " años.");
	}

	public void mayorDeEdad() {
		int contador = 0;
		for (int i = 0; i < edades.length; i++) {
			if (edades[i] >= 18) {
				contador++;
			}
		}
		if (contador > 0) {
			JOptionPane.showMessageDialog(null, "Los estudiantes mayores de edad son: " + contador);
		} else {
			JOptionPane.showMessageDialog(null, "No hay estudiantes mayores de edad");
		}

	}

	public void buscarPorNombre() {
		int cont = 0;
		int estudiantes = -1;
		String nombreBuscar = JOptionPane.showInputDialog("Ingrese el nombre a buscar");

		for (int i = 0; i < nombres.length; i++) {
			if (nombres[i].equalsIgnoreCase((nombreBuscar))) {
				cont++;
				estudiantes = i;
			}
		}

		if (estudiantes != -1) {
			System.out.println(
					"Encontro a " + nombreBuscar + " con edad de " + edades[estudiantes] + ", " + cont + " veces");
		} else {
			System.out.println("No encuentra a " + nombreBuscar);
		}

	}

	public void buscarPorEdad() {
		int cont = 0;
		int edadBuscar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese edad a buscar"));
		for (int i = 0; i < edades.length; i++) {

			if (edades[i] == edadBuscar) {
				cont++;
			} 
		}
		JOptionPane.showMessageDialog(null, "Los estudiantes con edad " + edadBuscar + " son " + cont);

	}
}
