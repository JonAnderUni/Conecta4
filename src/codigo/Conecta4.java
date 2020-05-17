package codigo;

public class Conecta4{
	
	private static Tablero unTablero;
	private static Conecta4 miConecta4 = null;
	
	private String idioma = "Castellano";
	
	
	
	private Conecta4() {
	}

	public static Conecta4 getConecta4() {
		if (miConecta4 == null) {
			miConecta4 = new Conecta4();
		}
		return miConecta4;
	}
	
	public Tablero getTablero(){
		return unTablero;
	}
	
	public String getIdioma(){
		return this.idioma;
	}
	
	public void setIdioma(String pIdioma){
		this.idioma = pIdioma;
	}
	
	public void empezarPartida(){
		
		
		unTablero = DirectorTablero.getDirectorTablero().generarTablero();
		
	}
	
}