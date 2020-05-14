package codigo;

import java.util.Observable;

public class Casilla extends Observable {
	private int valor;
	
	public Casilla() {
		valor = 0;
	}
	
	public int getC() {
		return valor;
	}
	
	public void setC(int v) {
		valor = v;
	}
	
	public int getValor() {
		return valor;
	}
	
	public void setValor(int v) {
		valor = v;
	}
}
