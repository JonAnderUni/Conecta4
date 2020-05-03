package codigo;

import java.awt.*;
import java.applet.*;


public class Tablero {

	public Casilla[][] tablero = new Casilla[16][9];
	public Jugador j1;
	public Jugador j2;
	public Jugador ultimoTurno;
	public int CVacias = 0;
	public Jugador ganador = null;
	
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
	
	public void turnoDificil() {
		int mejorJugada, jugada, aux;
		mejorJugada = 0;
		jugada = 8;
		for(int col = 1; col <= 16; col++) {
			aux = puntuacionJugada(col);
			if(aux >= mejorJugada) {
				jugada = col;
				mejorJugada = aux;
			}
		}
	}
	
	private int puntuacionJugada(int col) {
		Casilla[][]  tableroTemporal = tablero;//new Casilla[16][9]; 
		
		return 0;
		
	}
	/*
	 * puntuaciones posibles:
	 * --ganar la partida o hacer 4 en raya: 15
	 * --evitar la victoria del rival que tien 3 de cuatro en raya : 14
	 * --el rival tiene 2 fichas seguidas y podria rellenar 4 en liena por ambis lados : 10
	 * --la ia tiene 2 fichas seguidas
	 * --la ia tiene una ficha
	 * */
	private Boolean hacer4EnRaya(Casilla[][] t, int c) {
		int aux = 1;
		while ((t[c][aux].getValor() != 0) && (aux != 1)) {
			aux++;
		}
		if(aux < 9) {
			t[c][aux].setValor(1);
		}
		return comprobarVictoria(t);
		
	}
	private Boolean evitarVictoriaDelRival(Casilla[][] t, int c) {
		int aux = 1;
		while ((t[c][aux].getValor() != 0) && (aux != 1)) {
			aux++;
		}
		if(aux < 9) {
			t[c][aux].setValor(1);
		}
		Boolean seEvita;
		
		return null;
	}
	private Boolean rival2FichasConHuecos2Lados(Casilla[][] t, int c) {
		return null;
		
	}
	private Boolean IA2FichasSeguidas(Casilla[][] t, int c) {
		return null;
		
	}
	private Boolean IA1ficha(Casilla[][] t, int c) {
		return null;
		
	}
	
	public void turnoJugador() { 
		int boton = 0;//aqui hay que meter boton de la interfaz
		rellenarCasilla(boton);
	}
	
	public Boolean comprobarVictoria(Casilla[][] t) {
		int cont = 0;
		Boolean vict = false;
		for(int col = 1; col <= 16; col++) {
			for(int piso = 1; piso <= 9; piso++) {
				if((t[col][piso].getValor() != 0) && (ganador == null)) {
					comprobarHorizontal(t, col, piso);
					comprobarVertical(t, col, piso);
					comprobarDiagUp(t, col, piso);
					comprobarDiagDown(t, col, piso);
				}else if(t[col][piso].getValor() == 0) {
					cont++;
				}
			}
		}
		CVacias = cont;
		if((ganador != null) || (CVacias == 0)) {
			vict = true;
		}
		return vict;
	}
	
	private Boolean comprobarHorizontal(Casilla[][] t, int col, int piso) {
		int cont = 1;
		int jug;if(t[col][piso].getValor() == 1) { jug = 1;}else {jug = 2;}
		while((col < 16) && (cont < 4)) {
			col++;
			if(t[col][piso].getValor() == jug) {
				cont++;
			}else {
				return false;
			}
		}
		if(jug == 1) {
			ganador = j1;
		}else {
			ganador = j2;
		}
		return true;
	}
	private Boolean comprobarVertical(Casilla[][] t, int col, int piso) {
		int cont = 1;
		int jug;if(t[col][piso].getValor() == 1) { jug = 1;}else {jug = 2;}
		while((piso < 9) && (cont < 4)) {
			piso++;
			if(t[col][piso].getValor() == jug) {
				cont++;
			}else {
				return false;
			}
		}
		if(jug == 1) {
			ganador = j1;
		}else {
			ganador = j2;
		}		
		return true;
	}
	private Boolean comprobarDiagUp(Casilla[][] t, int col, int piso) {
		int cont = 1;
		int jug;if(t[col][piso].getValor() == 1) { jug = 1;}else {jug = 2;}
		while((piso < 9) && (col < 16) && (cont < 4)) {
			piso++;
			col++;
			if(t[col][piso].getValor() == jug) {
				cont++;
			}else {
				return false;
			}
		}
		if(jug == 1) {
			ganador = j1;
		}else {
			ganador = j2;
		}		
		return true;
	}
	private Boolean comprobarDiagDown(Casilla[][] t, int col, int piso) {
		int cont = 1;
		int jug;if(t[col][piso].getValor() == 1) { jug = 1;}else {jug = 2;}
		while((piso > 0) && (col < 16) && (cont < 4)) {
			piso--;
			col++;
			if(t[col][piso].getValor() == jug) {
				cont++;
			}else {
				return false;
			}
		}
		if(jug == 1) {
			ganador = j1;
		}else {
			ganador = j2;
		}		
		return true;
	}
	public void iniciarPartida() { }
}
