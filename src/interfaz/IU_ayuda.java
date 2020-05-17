package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import codigo.Conecta4;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IU_ayuda extends JFrame {

	private JPanel contentPane;
	private JLabel lblAyuda;
	private JLabel lblInstrucciones1;
	private JLabel lblInstrucciones2;
	private JLabel lblInstrucciones3;
	private JButton rdbtnAtras;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IU_ayuda frame = new IU_ayuda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public IU_ayuda() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 546, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblAyuda());
		contentPane.add(getLblInstrucciones1());
		contentPane.add(getLblInstrucciones2());
		contentPane.add(getLblInstrucciones3());
		contentPane.add(getRdbtnAtras());
	}

	private JLabel getLblAyuda() {
		if (lblAyuda == null) {
			if(Conecta4.getConecta4().getIdioma().equals("Castellano")){
				lblAyuda = new JLabel("AYUDA");
			}else{
				lblAyuda = new JLabel("LAGUNTZA");
			}
			lblAyuda.setHorizontalAlignment(SwingConstants.CENTER);
			lblAyuda.setBounds(24, 26, 464, 28);
			lblAyuda.setFont(new Font("Tahoma", Font.BOLD, 25));
		}
		return lblAyuda;
	}
	private JLabel getLblInstrucciones1() {
		if (lblInstrucciones1 == null) {
			if(Conecta4.getConecta4().getIdioma().equals("Castellano")){
				lblInstrucciones1 = new JLabel("<html>El Conecta4 es un juego en el que 2 jugadores tratan de hacer una línea con 4 fichas antes que el rival en una matriz 6*9.<html>");
			}else{
				lblInstrucciones1 = new JLabel("<html>4Konektatu 2 jokalari lerro bat egin behar duten joko bat da. Lerro hori egiteko, 4 fitxa behar dira, eta aurkaria egin baino lehen izan behar da 6x9 trokel batean.");
			}
				
			lblInstrucciones1.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblInstrucciones1.setVerticalAlignment(SwingConstants.TOP);
			lblInstrucciones1.setBounds(24, 77, 464, 60);
		}
		return lblInstrucciones1;
	}
	private JLabel getLblInstrucciones2() {
		if (lblInstrucciones2 == null) {
			
			if(Conecta4.getConecta4().getIdioma().equals("Castellano")){
				lblInstrucciones2 = new JLabel("<html>Para poder meter una ficha en el tablero, deberás seleccionar una columna, y automáticamente se bajará la ficha a la posición que le corresponda, siempre encima de la última ficha metida en esa columna.<html>");
			}else{
				lblInstrucciones2 = new JLabel("<html>Fitxa bat sartzeko, kolumna bat aukeratu behar duzu, eta fitxa automatikoki jaitsiko da bere tokira, beti kolumna horretara sartu zen azken fitxaren gainean.<html>");
			}
			
			lblInstrucciones2.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblInstrucciones2.setVerticalAlignment(SwingConstants.TOP);
			lblInstrucciones2.setBounds(24, 159, 464, 86);
		}
		return lblInstrucciones2;
	}
	private JLabel getLblInstrucciones3() {
		if (lblInstrucciones3 == null) {
			if(Conecta4.getConecta4().getIdioma().equals("Castellano")){
				lblInstrucciones3 = new JLabel("<html>En el juego se podrá jugar en modo 2 jugadores y un jugador. Cuando un jugador quiera jugar solo, podrá seleccionar el nivel de dificultad.<html>");
			}else{
				lblInstrucciones3 = new JLabel("<html>Jokoa 2 jokalarari eta jokalari bakarra moduak ditu. Jokalari bat bakarrik jolastu nahi badu, zailtasun maila aukeratu ahal du.<html>");
			}
			lblInstrucciones3.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblInstrucciones3.setVerticalAlignment(SwingConstants.TOP);
			lblInstrucciones3.setBounds(24, 252, 464, 85);
		}
		return lblInstrucciones3;
	}
	private JButton getRdbtnAtras() {
		if (rdbtnAtras == null) {
			rdbtnAtras = new JButton("< Atrás");
			rdbtnAtras.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					IU_menu1 menu = new IU_menu1();
					menu.setVisible(true);
				}
			});
			rdbtnAtras.setBounds(403, 339, 97, 25);
		}
		return rdbtnAtras;
	}
}
