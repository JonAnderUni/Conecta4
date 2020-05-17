package codigo;


public class Jugador {

	public EnumTipo tipo;
	public String nombre;
	public int num;
	
	
	public Jugador(EnumTipo t, String n, int numero) {
		tipo = t;
		nombre = n;
		num = numero;
	}
	
	public void setTipo(EnumTipo t) {
		tipo = t;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String n) {
		nombre = n;
	}
	
	public EnumTipo getTipo() {
		return tipo;
	}
	
	public int getNum(){
		return num;
	}
	
	public void setNum(int pNum){
		num = pNum;
	}
}
