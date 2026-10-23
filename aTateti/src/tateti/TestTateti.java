package tateti;
import java.util.Scanner;


public class TestTateti {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Ingrese el tamaño del tablero: ");
		int tamaño = 0;
		while ( tamaño < 3) {
			try {
				tamaño = Integer.parseInt(scanner.nextLine().trim());
				if (tamaño < 3)
					System.out.print("El tamaño minimo es 3. Ingrese nuevamente: ");
			} catch (NumberFormatException e) {
				System.out.print("Valor invalido. Ingrese un numero: ");
			}
			
		}
		
		TaTeTi game = new TaTeTi(tamaño);
		
		while (true) {
			System.out.println("\n" + game);
			String playerName = (game.getPlayer() == TaTeTi.X) ? "Jugador X" : "Jugador 0";
			System.out.println("Turno de " + playerName);
			
			int fila = -1, colum = -1;
			boolean validMove = false;
			
			while(!validMove) {
				try {
					 System.out.print("  Fila (0-" + (tamaño - 1) + "): ");
					 fila = Integer.parseInt(scanner.nextLine().trim());
					 System.out.print( " Columna (0-" + (tamaño - 1) + "): ");
					 colum = Integer.parseInt(scanner.nextLine().trim());
					 game.putMark(fila, colum);
					 validMove = true;
				} catch (IllegalArgumentException e) {
					System.out.println(" Movimiento invalido: " + e.getMessage() + "Intente nuevamente. ");
				}
			}
			int win = game.winner();
			if(win == TaTeTi.X || win == TaTeTi.O) {
				System.out.println("\n" + game);
				String winner = (win == TaTeTi.X) ? "Jugador X" : "Jugador O";
				System.out.println("¡" + winner + " gana!");
				break;
			}
			
			if(game.isFull()) {
				System.out.println("\n" + game);
				System.out.println("Empate. No quedan posiciones libres.");
				break;
			}
		}
		
		scanner.close();
	}

}
