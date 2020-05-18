package codigo;

public class DirectorTablero {

	private static DirectorTablero miDirectorTablero;
	private Tablero tablero;

	private DirectorTablero() {
	}

	public static DirectorTablero getDirectorTablero() {
		if (miDirectorTablero == null) {
			miDirectorTablero = new DirectorTablero();
		}
		return miDirectorTablero;
	}



	public Tablero generarTablero() {
		//System.out.println("Holaaa");
		tablero = new Tablero(9, 6);
		//Tablero tablero = new Tablero(9, 6);
		//System.out.println("HOLAAAA2");
		return tablero;
		
	}
}
