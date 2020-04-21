
public class Tablero {

	public Casilla[][] tablero = new Casilla[16][9];
	public Jugador j1;
	public Jugador j2;
	public Jugador ultimoTurno;
	
	public Tablero(Jugador a, Jugador b) {
		
	}
	
	public void jugarTurno(Jugador j) {
		if(j.getTipo() == "FACIL") {
			turnoFacil();
		}else if(j.getTipo() == "DIFICIL") {
			turnoDificil();
		}else {
			turnoJugador();
		}
	}
	
	public void turnoFacil() {
		int num = (Math.random()*15);
		rellenarCasilla(num);
	}
	
	public void rellenarCasilla(int columna) {
		Boolean rellenado = False;
		int cont = 0;
		while(rellenado = False) {
			while(rellenado == False) {
				if(tablero[columna][cont] != 0) {
					cont++;
				}else {
					tablero[columna][cont] = 1;
					rellenado = True;
				}
			}
			if(rellenado == False) {
				if(columna = 15) {
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
		Boolean vict = False;
		
		
		return vict;
	}
	
	public void iniciarPartida() { }
}
