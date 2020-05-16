package codigo;


public class Tablero {

	private Casilla[][] tablero;
	private Jugador j1;
	private Jugador j2;
	private Jugador ultimoTurno;
	private int CVacias = 0;
	private Jugador ganador = null;
	private static Tablero mTablero;
	
	private Tablero() {
		
	}
	
	public static Tablero getTablero() {
		if(mTablero == null) {
			mTablero = new Tablero();
		}
		return mTablero;
	}
	
	public void setJugadores(Jugador a, Jugador b) {
		j1 = a;
		j2 = b;
	}
	
	public void generarTablero() {
		tablero = new Casilla[6][9];
	}
	
	public void eliminarTablero() {
		tablero = null;
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
		int num = (int) (Math.random()*5);
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
				if(columna == 5) {
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
		for(int col = 1; col <= 9; col++) {
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
		int aux = 1;
		while ((t[c][aux].getValor() != 0) && (aux != 1)) {
			aux++;
		}
		if(aux < 9) {
			t[c][aux].setValor(1);
		}
		
		Boolean dosFichas = false;
		
		// comprobar margenes izquierda
		if( (c - 2) > 0 ) {
			//Comprobar si las dos casillas a la izquierda son de la ia
			if ( (t[c - 1][aux].getValor() == 2) && (t[c - 2][aux].getValor() == 2) ) {
				dosFichas = true;
			}
		}
		
		// comprobar margenes derecha
		if( (c + 2) < 9 ) {
			//comprobar si las dos casillas a la derecha son de la ia
			if ( (t[c + 1][aux].getValor() == 2) && (t[c + 2][aux].getValor() == 2) ) {
				dosFichas = true;
			}
		
		}
		
		return dosFichas;
		
	}
	private Boolean IA2FichasSeguidas(Casilla[][] t, int c) {
		int aux = 1;
		while ((t[c][aux].getValor() != 0) && (aux != 1)) {
			aux++;
		}
		if(aux < 9) {
			t[c][aux].setValor(1);
		}
		
		Boolean dosFichas = false;
		
		// 2 fichas en vertical
		// comprobar margenes izquierda
		if( (c - 2) > 0 ) {
			//Comprobar si las dos casillas a la izquierda son de la ia
			if ( (t[c - 1][aux].getValor() == 1) && (t[c - 2][aux].getValor() == 1) ) {
				dosFichas = true;
			}
		}
		
		// comprobar margenes derecha
		if( (c + 2) < 9 ) {
			//comprobar si las dos casillas a la derecha son de la ia
			if ( (t[c + 1][aux].getValor() == 1) && (t[c + 2][aux].getValor() == 1) ) {
				dosFichas = true;
			}
		
		}
		
		// 2 fichas en horizontal
		// comprobar margenes abajo
		if( (aux - 2) > 0 ) {
			//Comprobar si las dos casillas de debajo son de la ia
			if ( (t[c][aux - 1].getValor() == 1) && (t[c][aux - 2].getValor() == 1) ) {
				dosFichas = true;
			}
		}
		
		return dosFichas;
		
	}
	private Boolean IA1ficha(Casilla[][] t, int c) {
		int aux = 1;
		while ((t[c][aux].getValor() != 0) && (aux != 1)) {
			aux++;
		}
		if(aux < 9) {
			t[c][aux].setValor(1);
		}
		
		Boolean dosFichas = false;
		
		// 1 ficha en vertical
		// comprobar margenes izquierda
		if( (c - 2) > 0 ) {
			//Comprobar si las dos casillas a la izquierda son de la ia
			if ( (t[c - 1][aux].getValor() == 1) && (t[c - 2][aux].getValor() == 1) ) {
				dosFichas = true;
			}
		}
		
		// comprobar margenes derecha
		if( (c + 2) < 9 ) {
			//comprobar si las dos casillas a la derecha son de la ia
			if ( (t[c + 1][aux].getValor() == 1) && (t[c + 2][aux].getValor() == 1) ) {
				dosFichas = true;
			}
		
		}
		
		// 2 fichas en horizontal
		// comprobar margenes abajo
		if( (aux - 2) > 0 ) {
			//Comprobar si las dos casillas de debajo son de la ia
			if ( (t[c][aux - 1].getValor() == 1) && (t[c][aux - 2].getValor() == 1) ) {
				dosFichas = true;
			}
		}
		
		//Comprobar si existe otra ficha de la ia alrededor
		//izquierda
		if( ((c - 1) > 0) && (t[c - 1][aux].getValor() == 1) ) {
			dosFichas = true;
		}
		//derecha
		if( ((c + 1) < 9) && (t[c + 1][aux].getValor() == 1) ) {
			dosFichas = true;
		}
		//abajo
		if( ((aux - 1) < 0) && (t[c][aux - 1].getValor() == 1) ) {
			dosFichas = true;
		}
		
		return dosFichas;
		
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
