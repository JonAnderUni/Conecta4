package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import codigo.Conecta4;
import codigo.EnumTipo;
import codigo.Jugador;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class IU_1Jugador extends JFrame {

	private JPanel contentPane;
	private JPanel panelTexto;
	private JPanel panelBtn;
	private JTextField nJugador;
	private JLabel lblNombre;
	private JButton btnAceptar;
	private JButton btnAtras;
	private String level = "";
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IU_1Jugador frame = new IU_1Jugador();
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
	public IU_1Jugador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 384, 255);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanelTexto(), BorderLayout.CENTER);
		contentPane.add(getPanelBtn(), BorderLayout.SOUTH);
	}
	
	public void ponerDificultad(String lvl) {
		level = lvl;
	}

	private JPanel getPanelTexto() {
		if (panelTexto == null) {
			panelTexto = new JPanel();
			panelTexto.setLayout(null);
			panelTexto.add(getLblNombre());
			panelTexto.add(getNJugador());
		}
		return panelTexto;
	}
	private JPanel getPanelBtn() {
		if (panelBtn == null) {
			panelBtn = new JPanel();
			panelBtn.add(getBtnAceptar());
			panelBtn.add(getBtnAtras());
		}
		return panelBtn;
	}
	private JTextField getNJugador() {
		if (nJugador == null) {
			nJugador = new JTextField();
			nJugador.setBounds(81, 100, 180, 20);
			nJugador.setColumns(10);
		}
		return nJugador;
	}
	private JLabel getLblNombre() {
		if (lblNombre == null) {
			if(Conecta4.getConecta4().getIdioma().equals("Castellano")){
				lblNombre = new JLabel("Introduzca su nombre/apodo");
				lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblNombre.setBounds(81, 46, 180, 14);
			}else {
				lblNombre = new JLabel("Idatzi zure izena/gaitzizena");
				lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblNombre.setBounds(81, 46, 180, 14);
			}
			
		}
		return lblNombre;
	}
	private JButton getBtnAceptar() {
		if (btnAceptar == null) {
			btnAceptar = new JButton("Ok");
			btnAceptar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Jugador persona = new Jugador(EnumTipo.USUARIO, getNJugador().getText(),1);
					Jugador maquina;
					if(level.equals("FACIL")) {
						 maquina = new Jugador(EnumTipo.FACIL, "maquina", 2);
					}else {
						 maquina = new Jugador(EnumTipo.DIFICIL, "maquina", 2);
					}
					Conecta4.getConecta4().empezarPartida();
					Conecta4.getConecta4().getTablero().setJugadores(persona, maquina);
					Conecta4.getConecta4().getTablero().generarTablero();
					Conecta4.getConecta4().getTablero().iniciarPartida();
					
					IU_juego juego = new IU_juego();
					

					setVisible(false);
					juego.setVisible(true);
				}
			});
		}
		return btnAceptar;
	}
	private JButton getBtnAtras() {
		if (btnAtras == null) {
			btnAtras = new JButton("Atr\u00E1s");
		}
		return btnAtras;
	}
}
