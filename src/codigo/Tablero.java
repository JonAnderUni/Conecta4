package codigo;

import java.awt.*;
import java.applet.*;


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
	
	public void turnoJugador() { 
		int boton = 0;//aqui hay que meter boton de la interfaz
		rellenarCasilla(boton);
	}
	
	public Boolean comprobarVictoria() {
		Boolean vict = false;
		
		
		return vict;
	}
	
	private Boolean comprobarHorizontal(int col, int piso) {
		int cont = 1;
		int jug;if(tablero[col][piso].getValor() == 1) { jug = 1;}else {jug = 2;}
		while((col < 16) && (cont < 4)) {
			col++;
			if(tablero[col][piso].getValor() == jug) {
				cont++;
			}else {
				break;
			}
		}
		if(cont == 4) {
			return true;
		}else {
			return false;
		}
	}
	private Boolean comprobarVertical(int col, int piso) {
		int cont = 1;
		int jug;if(tablero[col][piso].getValor() == 1) { jug = 1;}else {jug = 2;}
		while((piso < 9) && (cont < 4)) {
			piso++;
			if(tablero[col][piso].getValor() == jug) {
				cont++;
			}else {
				break;
			}
		}
		if(cont == 4) {
			return true;
		}else {
			return false;
		}
	}
	private Boolean comprobarDiagUp() {
		Boolean si = null;
		return si;
	}
	private Boolean comprobarDiagDown() {
		Boolean si = null;
		return si;
	}
	public void iniciarPartida() { }
}
