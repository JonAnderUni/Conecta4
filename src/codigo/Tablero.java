package codigo;

import java.awt.Image;
import java.io.IOException;
import java.util.Observable;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import interfaz.IU_juego;

public class Tablero extends Observable{

	private Casilla[][] tablero;
	private Jugador j1;
	private Jugador j2;
	//private Jugador ultimoTurno;
	private Jugador turnoActual;
	private int CVacias = 54;
	private int Rank = 0;
	private Jugador ganador = null;
	private static Tablero mTablero;
	private String idioma = "Castellano";
	
	private String turno;	//Jugador1 o Jugador2
	
	
	private static int ancho = 9;
	private static int alto = 6;
	
	public Tablero(int pAncho, int pAlto) {
		this.ancho = pAncho;
		this.alto = pAlto;
		this.tablero = new Casilla[ancho][alto];
		System.out.println("Se ha generado el tablero");
	}
	
	public Casilla getCasilla(int pAncho, int pAlto) {
		return tablero[pAncho][pAlto];
	}
	
	public void setCasilla(int rAncho, int rAlto, Casilla nuevaCas) {
		tablero[rAncho][rAlto] = nuevaCas;
	}
	

	
	
	public static Tablero getTablero() {
		if(mTablero == null) {
			mTablero = new Tablero(ancho, alto);
		}
		return mTablero;
	}

/*	public Casilla[][] getTablero() {
		return this.tablero;
	}
*/
	
	public Casilla[][] getT(){
		return this.tablero;
	}
	
	public Jugador getJugador1(){
		return j1;
	}
	
	public Jugador getJugador2(){
		return j2;
	}
	
	
	public void setJugadores(Jugador a, Jugador b) {
		j1 = a;
		j2 = b;
	}
	
	public Jugador getTurnoActual(){
		return this.turnoActual;
	}
	
	public void setTurno(String pTurno){
		this.turno = pTurno;
	}
	
	public void cambiarTurno(){
		if(turnoActual.getNum()==1){
			turnoActual = j2;
		}else{
			turnoActual = j1;
		}	
	}
	
	public void generarTablero() {
		int ancho = 9;
		int alto = 6;
		
		//Rellenar el tablero con 6x9 casillas con valor 0 (NO NULL)
		for(int x = 0; x<ancho; x++){
			for(int y = 0; y<alto; y++){
				Casilla nuevaCasilla = new Casilla();
				this.setCasilla(x, y, nuevaCasilla);
				nuevaCasilla.setX(x);
				nuevaCasilla.setY(y);
				tablero[x][y].setC(0);
			}
			
		}
		
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
	
	public int[] turnoFacil() {
		int num = (int) (Math.random()*9);
		int[] r = new int[2];
		r = rellenarCasilla(num);
		
		return r;
	}
	
	public int[] rellenarCasilla(int columna) {
		Boolean rellenado = false;
		int cont = 5;		//fila
		
		while(!rellenado) {
			
			//Bajamos la ficha hasta donde podamos
			if(tablero[columna][cont].getC()!=0){		//Ya habia una ficha ahi
				cont--;
			}else{
				tablero[columna][cont].setC(2);
				rellenado=true;
				}
		}
			
	/*		while(rellenado == false) {
				if(tablero[columna][cont].getC() != 0) {
					cont++;
				}else {
					tablero[columna][cont].setC(2);
					rellenado = true;
				}
			}
			if(rellenado == false) {
				if(columna == 5) {
					columna = 0;
				}else {
					columna++;
				}
			}*/
	
		
		int x = 0;
		int[] resultado = new int[2];
		resultado[x]=columna;
		resultado[x+1]=cont;
		
		return resultado;
		
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
	private Boolean hacer4EnRaya(int c) {
		int aux = 1;
		while ((tablero[c][aux].getC() != 0) && (aux != 1)) {
			aux++;
		}
		if(aux < 9) {
			tablero[c][aux].setC(1);
		}
		return comprobarVictoria();
		
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
	
	
	
	public boolean hayGanador(){
		if(ganador!=null){
			return true;
		}else{
			return false;
		}
	}
	
	public Jugador getGanador(){
		return ganador;
	}
	
	public int getFichasMetidas(){
		int x = 0;
		
		for(int fila = 0; fila < 6; fila ++){
			for(int columna = 0; columna < 9; columna ++){
				if(tablero[columna][fila].getC()!=0){
					x ++;
				}
			}
		}
		
		return x;
		
	}
	
	
	public Boolean comprobarVictoria() {
		int cont = 0;
		Boolean vict = false;
		if(getFichasMetidas()>6){
		//	for(int col = 0; col <9; col++) {
		//		for(int piso = 0; piso <6; piso++) {
		//			if((tablero[col][piso].getC() != 0) && (ganador == null)) {
		//				System.out.println(col + ", " + piso);
						comprobarHorizontal();
						comprobarVertical();
						comprobarDiagonalUp();
						comprobarDiagonalDown();
						//comprobarDiagUp(t, col, piso);
						//comprobarDiagDown(t, col, piso);
		//			}else if(tablero[col][piso].getC() == 0) {
		//				cont++;
		//			}
		//		}
		//	}
		}
		
		CVacias = cont;
		if((ganador != null)) {	//|| (CVacias == 0)) {
			vict = true;
			Rank = calcularPuntuacionRanking();
			System.out.println("HAS GANADO");
		}
		return vict;
	}
	
	//////////////////////////////////////////
	
	private boolean comprobarHorizontal(){
		boolean victoria = false;
		int[] linea = new int[9];
		
		for (int fila = 0; fila < alto; fila++) {
            for (int columna = 0; columna < ancho; columna++) {
                linea[columna] = tablero[columna][fila].getC();
            }
            if (comprobarLinea(linea)) {
            	System.out.println("h");
            	if(turnoActual.getNum()==1){
					ganador=j2;
				}else{
					ganador=j1;
				}
                return true;
                
            }

            resetVector(linea);
        }
		
		
		return victoria;
	}
	
	
	
	
	private boolean comprobarVertical(){
		boolean victoria = false;
		int[] linea = new int[6];
		
		for (int columna = 0; columna < ancho; columna++) {
			for (int fila = 0; fila < alto; fila++){
				linea[fila] = tablero[columna][fila].getC();
			}
	        
			if (comprobarLinea(linea)) {
				System.out.println("v");
				if(turnoActual.getNum()==1){
					ganador=j2;
				}else{
					ganador=j1;
				}
				return true;
	        }
        }
		
		
		return victoria;
	}
	
	
	
	
	public boolean comprobarDiagonalUp(){
		boolean victoria = false;
		
		//Empezamos por la fila 3
		int[] linea = new int[4];
		int x = 0;
		int fila = 3;
		int columna = 0;
		
		while(columna < 4 && fila > -1){
			linea[x]=tablero[columna][fila].getC();
			x++;
			columna ++;
			fila --;
		}
		
		if (comprobarLinea(linea)) {
				System.out.println("d");
				if(turnoActual.getNum()==1){
					ganador=j2;
				}else{
					ganador=j1;
				}
				return true;
				
		}else{
			x=0;
			linea = new int[5];
			fila = 4;
			columna = 0;
			
			while(columna < 5 && fila > -1){
				linea[x]=tablero[columna][fila].getC();
				x++;
				columna ++;
				fila --;
			}
			
			if (comprobarLinea(linea)) {
					System.out.println("d");
					if(turnoActual.getNum()==1){
						ganador=j2;
					}else{
						ganador=j1;
					}
					return true;
			
			}else{
				x=0;
				linea = new int[6];
				fila = 5;
				columna = 0;
				
				while(columna < 6 && fila > -1){
					linea[x]=tablero[columna][fila].getC();
					x++;
					columna ++;
					fila --;
				}
				
				if (comprobarLinea(linea)) {
						System.out.println("d");
						if(turnoActual.getNum()==1){
							ganador=j2;
						}else{
							ganador=j1;
						}
						return true;
				
				}else{
					x=0;
					linea = new int[6];
					fila = 5;
					columna = 1;
					
					while(columna < 7 && fila > -1){
						linea[x]=tablero[columna][fila].getC();
						x++;
						columna ++;
						fila --;
					}
					
					if (comprobarLinea(linea)) {
							System.out.println("d");
							if(turnoActual.getNum()==1){
								ganador=j2;
							}else{
								ganador=j1;
							}
							return true;
					
					}else{
						x=0;
						linea = new int[6];
						fila = 5;
						columna = 2;
						
						while(columna < 8 && fila > -1){
							linea[x]=tablero[columna][fila].getC();
							x++;
							columna ++;
							fila --;
						}
						
						if (comprobarLinea(linea)) {
								System.out.println("d");
								if(turnoActual.getNum()==1){
									ganador=j2;
								}else{
									ganador=j1;
								}
								return true;
						
						}else{
							x=0;
							linea = new int[6];
							fila = 5;
							columna = 3;
							
							while(columna < 9 && fila > -1){
								linea[x]=tablero[columna][fila].getC();
								x++;
								columna ++;
								fila --;
							}
							
							if (comprobarLinea(linea)) {
									System.out.println("d");
									if(turnoActual.getNum()==1){
										ganador=j2;
									}else{
										ganador=j1;
									}
									return true;
							
							
							} else{
								x=0;
								linea = new int[5];
								fila = 5;
								columna = 4;
								
								while(columna < 9 && fila > 0){
									linea[x]=tablero[columna][fila].getC();
									x++;
									columna ++;
									fila --;
								}
								
								if (comprobarLinea(linea)) {
										System.out.println("d");
										if(turnoActual.getNum()==1){
											ganador=j2;
										}else{
											ganador=j1;
										}
										return true;
								
								}else{
									x=0;
									linea = new int[4];
									fila = 5;
									columna = 5;
									
									while(columna < 9 && fila > 1){
										linea[x]=tablero[columna][fila].getC();
										x++;
										columna ++;
										fila --;
									}
									
									if (comprobarLinea(linea)) {
											System.out.println("d");
											if(turnoActual.getNum()==1){
												ganador=j2;
											}else{
												ganador=j1;
											}
											return true;
									
									}
								}
							}
						}
					}
				}
			}
			
			
		}
		
		
		return victoria;
	}
	
	
	public boolean comprobarDiagonalDown(){
		boolean victoria = false;
		
		//Empezamos por la fila 3
		int[] linea = new int[4];
		int x = 0;
		int fila = 2;
		int columna = 0;
		
		while(columna < 4 && fila < 6){
			linea[x]=tablero[columna][fila].getC();
			x++;
			columna ++;
			fila ++;
		}
		
		if (comprobarLinea(linea)) {
				System.out.println("d");
				if(turnoActual.getNum()==1){
					ganador=j2;
				}else{
					ganador=j1;
				}
				return true;
				
		}else{
			x=0;
			linea = new int[5];
			fila = 1;
			columna = 0;
			
			while(columna < 5 && fila < 6){
				linea[x]=tablero[columna][fila].getC();
				x++;
				columna ++;
				fila ++;
			}
			
			if (comprobarLinea(linea)) {
					System.out.println("d");
					if(turnoActual.getNum()==1){
						ganador=j2;
					}else{
						ganador=j1;
					}
					return true;
			
			}else{
				x=0;
				linea = new int[6];
				fila = 0;
				columna = 0;
				
				while(columna < 6 && fila < 6){
					linea[x]=tablero[columna][fila].getC();
					x++;
					columna ++;
					fila ++;
				}
				
				if (comprobarLinea(linea)) {
						System.out.println("d");
						if(turnoActual.getNum()==1){
							ganador=j2;
						}else{
							ganador=j1;
						}
						return true;
				
				}else{
					x=0;
					linea = new int[6];
					fila = 0;
					columna = 1;
					
					while(columna < 7 && fila < 6){
						linea[x]=tablero[columna][fila].getC();
						x++;
						columna ++;
						fila ++;
					}
					
					if (comprobarLinea(linea)) {
							System.out.println("d");
							if(turnoActual.getNum()==1){
								ganador=j2;
							}else{
								ganador=j1;
							}
							return true;
					
					}else{
						x=0;
						linea = new int[6];
						fila = 0;
						columna = 2;
						
						while(columna < 8 && fila < 6){
							linea[x]=tablero[columna][fila].getC();
							x++;
							columna ++;
							fila ++;
						}
						
						if (comprobarLinea(linea)) {
								System.out.println("d");
								if(turnoActual.getNum()==1){
									ganador=j2;
								}else{
									ganador=j1;
								}
								return true;
						
						}else{
							x=0;
							linea = new int[6];
							fila = 0;
							columna = 3;
							
							while(columna < 9 && fila < 6){
								linea[x]=tablero[columna][fila].getC();
								x++;
								columna ++;
								fila ++;
							}
							
							if (comprobarLinea(linea)) {
									System.out.println("d");
									if(turnoActual.getNum()==1){
										ganador=j2;
									}else{
										ganador=j1;
									}
									return true;
							
							
							} else{
								x=0;
								linea = new int[5];
								fila = 0;
								columna = 4;
								
								while(columna < 9 && fila < 5){
									linea[x]=tablero[columna][fila].getC();
									x++;
									columna ++;
									fila ++;
								}
								
								if (comprobarLinea(linea)) {
										System.out.println("d");
										if(turnoActual.getNum()==1){
											ganador=j2;
										}else{
											ganador=j1;
										}
										return true;
								
								}else{
									x=0;
									linea = new int[4];
									fila = 0;
									columna = 5;
									
									while(columna < 9 && fila < 4){
										linea[x]=tablero[columna][fila].getC();
										x++;
										columna ++;
										fila ++;
									}
									
									if (comprobarLinea(linea)) {
											System.out.println("d");
											if(turnoActual.getNum()==1){
												ganador=j2;
											}else{
												ganador=j1;
											}
											return true;
									
									}
								}
							}
						}
					}
				}
			}
			
			
		}
		
		
		return victoria;
	}
	
	

	
	
	private void resetVector(int[] vector) {
        for (int it = 0; it < vector.length; it++) //Resetea vector
        {
            vector[it] = 0;
        }
    }
	
	private boolean comprobarLinea(int[] linea){
		int contador = 0;
        if (linea[0] != 0) {
            contador = 1;
        }
        for (int it = 1; it < linea.length; it++) {
            if (linea[it] != 0 && linea[it] == linea[it - 1]) {
                contador++;
                if (contador == 4) {
                    return true;
                }
            } else if (linea[it] != 0) {
                contador = 1;
            } else {
                contador = 0;
            }
        }
        return false;
	}
	
	//////////////////////////////////////////

	
		
	
	public int meterFicha(int pAncho, int pAlto){
		
		int valor = 0;
		
		if(turnoActual.getNum()==1){
			valor = 1;
		}else{
			valor = 2;
		}
		
		if(pAlto==-1){
			System.out.println("No puedes meter una ficha ahi");
			
		} else{

			int nuevoAlto = bajarFicha(pAncho, pAlto);
			
			if(nuevoAlto!=-1){
				tablero[pAncho][nuevoAlto].setC(valor);
				return nuevoAlto;
			}
		}
		
		return -1;
	}
	
	
	
	public boolean columnaLlena(int pAncho, int pAlto){
		if(tablero[pAncho][0].getC()!=0){		//La columna esta llena
			return true;
		}
		return false;
	}

	
	public int bajarFicha(int pAncho, int pAlto){
		
		boolean encontrado = false;
		int nuevoAlto = -1;
		
		if(columnaLlena(pAncho, pAlto)){
			System.out.println("NO SE PUEDE METER LA FICHA");
		}else{
			nuevoAlto=5;
			while(!encontrado){
				if(tablero[pAncho][nuevoAlto].getC()!=0){
					nuevoAlto--;
				}
				else{
					//Ahi lo puedo poner
					encontrado=true;
				}
			}
		}

		return nuevoAlto;
	}
	
	public int calcularPuntuacionRanking() {
		int p = CVacias * 18;
		return p;
	}
	
	public void iniciarPartida() {
		
		turnoActual = j1;
		
		
		
		setChanged();
		notifyObservers(this);
		
	}
}
