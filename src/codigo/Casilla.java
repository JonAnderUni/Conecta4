package codigo;

import java.util.Observable;

public class Casilla extends Observable {
	
	protected int valor = 0;
	
	protected int posX;
	protected int posY;
	
	public Casilla() {
		valor = 0;
	}
	
	public int getC() {
		return valor;
	}
	
	public void setC(int v) {
		this.valor = v;
		setChanged();
		notifyObservers(this);
	}
	
	public int getValor() {
		return valor;
	}
	
	public void setValor(int v) {
		valor = v;
	}
	
	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}
	
	public void setX(int x) {
		posX = x;
	}

	public void setY(int y) {
		posY = y;
	}
}
