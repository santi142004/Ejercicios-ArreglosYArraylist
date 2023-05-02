import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ProcesosArraylist {
	ArrayList<String> nombres;
	ArrayList<Integer> edades;

	public void empezar() {

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
		nombres = new ArrayList<>();
		edades = new ArrayList<>();
		for (int i = 0; i < tam; i++) {
			String nombreEst = JOptionPane.showInputDialog("Ingrese el nombre del estudiante " + (i + 1));
			nombres.add(nombreEst);
			int edadesEst = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad de " + nombres.get(i)));
			edades.add(edadesEst);
		}
	}

	public void imprimirDatos() {
		for (int i = 0; i < nombres.size(); i++) {
			System.out.println(nombres.get(i) + ", " + edades.get(i));
		}

	}

	public void promedio() {
		int suma = 0;
		double promedio = 0;
		for (int i = 0; i < edades.size(); i++) {
			suma += edades.get(i);
		}
		promedio = suma / edades.size();
		System.out.println("El promedio de las edades es de: " + promedio);

	}

	public void mayorEdad() {
		int edadMaxima = 0;
		String nombreMayor = "";
		for (int i = 0; i < edades.size(); i++) {
			if (edades.get(i) > edadMaxima) {
				edadMaxima = edades.get(i);
				nombreMayor = nombres.get(i);
			} else if (edades.get(i) == edadMaxima) {
				nombreMayor += ", " + nombres.get(i);
			}
		}
		JOptionPane.showMessageDialog(null,
				"Los estudiantes de mayor edad son: " + nombreMayor + " con " + edadMaxima + " años.");
	}

	public void menorEdad() {
		int edadMinima = Integer.MAX_VALUE;
		String nombreMenor = "";
		for (int i = 0; i < edades.size(); i++) {
			if (edades.get(i) < edadMinima) {
				edadMinima = edades.get(i);
				nombreMenor = nombres.get(i);
			} else if (edades.get(i) == edadMinima) {
				nombreMenor += ", " + nombres.get(i);
			}
		}
		JOptionPane.showMessageDialog(null,
				"Los estudiantes de menor edad son: " + nombreMenor + " con " + edadMinima + " años.");
	}

	public void mayorDeEdad() {
		int contador = 0;
		for (int i = 0; i < edades.size(); i++) {
			if (edades.get(i) >= 18) {
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

		for (int i = 0; i < nombres.size(); i++) {
			if (nombres.get(i).equalsIgnoreCase((nombreBuscar))) {
				cont++;
				estudiantes = i;
			}
		}

		if (estudiantes != -1) {
			System.out.println(
					"Encontro a " + nombreBuscar + " con edad de " + edades.get(estudiantes) + ", " + cont + " veces");
		} else {
			System.out.println("No encuentra a " + nombreBuscar);
		}

	}

	public void buscarPorEdad() {
        int edadBuscada = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad de los estudiantes que desea buscar:"));
        ArrayList<String> estudiantesEncontrados = new ArrayList<>();
        for (int i = 0; i < edades.size(); i++) {
            if (edades.get(i) == edadBuscada) {
                estudiantesEncontrados.add(nombres.get(i));
            }
        }
        if (estudiantesEncontrados.size() > 0) {
            String mensaje = "Los estudiantes con edad " + edadBuscada + " son:\n";
            for (String estudiante : estudiantesEncontrados) {
                mensaje += "- " + estudiante + "\n";
            }
            JOptionPane.showMessageDialog(null, mensaje);
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró ningún estudiante con la edad " + edadBuscada + ".");
        }

	}
}
