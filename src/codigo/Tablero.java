package codigo;


public class Tablero {

	public Casilla[][] tablero = new Casilla[16][9];
	public Jugador j1;
	public Jugador j2;
	public Jugador ultimoTurno;
	
	public Tablero(Jugador a, Jugador b) {
		
	}
	
	public void jugarTurno(Jugador j) {
		if(j.getTipo().equals("FACIL")) {
			turnoFacil();
		}else if(j.getTipo().equals("DIFICIL")) {
			turnoDificil();
		}else {
			turnoJugador();
		}
	}
	
	public void turnoFacil() {
		int num = (int) (Math.random()*15);
		rellenarCasilla(num);
	}
	
	public void rellenarCasilla(int columna) {
		Boolean rellenado = false;
		int cont = 0;
		while(rellenado = false) {
			while(rellenado == false) {
				if(tablero[columna][cont].getValor() != 0) {
					cont++;
				}else {
					tablero[columna][cont].setValor(1);
					rellenado = true;
				}
			}
			if(rellenado == false) {
				if(columna == 15) {
					columna = 0;
				}else {
					columna++;
				}
			}
		}
	}
	
	public void turnoDificil() {}
	
	public void turnoJugador() { }
	
	public Boolean comprobarVictoria() {
		Boolean vict = false;
		
		
		return vict;
	}
	
	public void iniciarPartida() { }
}
