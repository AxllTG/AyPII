package test;

import hospital.*;

public class PruebaHospital {

	public static void main(String[] args) {
		Medico m1 = new Medico(1, "Dr. Fercho", 5);
		Medico m2 = new Medico(2, "Dra. Cintia", 10);
		Enfermero e1 = new Enfermero(3, "Enf. Ramirez", 3);
		Enfermero e2 = new Enfermero(4, "Enf. Rodrigez", 7);

		Personal[] personal = { m1, m2, e1, e2 };

		System.out.println("Sueldo del Personal:");
		for (Personal p : personal) {
			System.out.printf("%-30s Sueldo: $%.2f%n", p.toString(), p.calcularSueldo());

		}

		Paciente p1 = new Paciente("Ana Perez", "13434543");
		Paciente p2 = new Paciente("Juan Lopez", "32132445");

		Turno[] turnos = { new Turno("2024-03-12", "02:00", p1, m1), new Turno("2024-13-11", "13:32", p2, m2)

		};
		Medico medicoBuscado = m1;
		System.out.println("\nPaciente Del " + medicoBuscado);
		for (Turno t : turnos) {
			if (t.getMedico().getLegajo() == medicoBuscado.getLegajo()) {
				System.out.println(" -  " + t.getPaciente() + " | Fecha: " + t.toString());
			}
		}

	}

}
