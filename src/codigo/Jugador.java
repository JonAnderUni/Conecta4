package codigo;


public class Jugador {

	public EnumTipo tipo;
	public String nombre;
	
	
	public Jugador(EnumTipo t, String n) {
		tipo = t;
		nombre = n;
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
}
