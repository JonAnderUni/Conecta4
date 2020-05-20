package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import codigo.Conecta4;
import codigo.EnumTipo;
import codigo.Jugador;

import java.awt.FlowLayout;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import java.awt.SystemColor;

public class IU_menu1 extends JFrame {

	private JPanel contentPane;
	private JPanel panelsur;
	private JButton eus;
	private JButton esp;
	
	private String idioma = "Castellano";
	private JPanel panelcentral;
	private JPanel panel;
	private JLabel titulo;
	private JPanel panel_1;
	private JLabel lblSeleccioneModoDe;
	private JRadioButton rdbtn2Jugadores;
	private JLabel lblJugadorVsOrdenador;
	private JRadioButton rdbtnModoFacil;
	private JRadioButton rdbtnModoDificil;
	private JSeparator separator;
	private JButton btnJugar;
	private JButton btnAyuda;
	private JLabel lblSeparador;
	private JLabel lblDebesSeleccionarUn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IU_menu1 frame = new IU_menu1();
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
	public IU_menu1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanelsur(), BorderLayout.SOUTH);
		contentPane.add(getPanelcentral(), BorderLayout.CENTER);
		
		
	}

	private JPanel getPanelsur() {
		if (panelsur == null) {
			panelsur = new JPanel();
			FlowLayout fl_panelsur = (FlowLayout) panelsur.getLayout();
			fl_panelsur.setAlignment(FlowLayout.RIGHT);
			panelsur.add(getBtnAyuda());
			panelsur.add(getLblSeparador());
			panelsur.add(getCastellano());
			panelsur.add(getEuskera());
		}
		return panelsur;
	}
	

	private JButton getBtnAyuda() {
		if (btnAyuda == null) {
			btnAyuda = new JButton();
			btnAyuda.setBackground(Color.BLACK);


			btnAyuda.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					setVisible(false);
					IU_ayuda ayuda = new IU_ayuda();
					ayuda.setVisible(true);
				}
			});
		
		}
		
		Image ayuda = null;
		
		try {
			ayuda = ImageIO.read(getClass().getResource("../img/ayuda.png"));
			ayuda = ayuda.getScaledInstance(25, 40, Image.SCALE_SMOOTH);

			} catch (IOException e1) {
				e1.printStackTrace();
			}
		
		btnAyuda.setIcon(new ImageIcon(ayuda));
		
		return btnAyuda;
	}
	
	
	private JButton getEuskera() {
		if (eus == null) {
			eus = new JButton();
			eus.setBackground(Color.WHITE);
			eus.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					idioma = "Euskera";
					Conecta4.getConecta4().setIdioma("Euskera");
					eus.setBackground(Color.YELLOW);
					esp.setBackground(Color.WHITE);
					titulo.setText("KONEKTATU 4");
					lblSeleccioneModoDe.setText("Joko modu bat aukeratu:");
					rdbtn2Jugadores.setText("2 Jokalari");
					lblJugadorVsOrdenador.setText("Jokalaria VS Ordenagailua");
					rdbtnModoFacil.setText("Modu erraza");
					rdbtnModoDificil.setText("Modu zaila");
				}
			});
			
			
		}
		
		Image euskadi = null;
		
		
			try {
				euskadi = ImageIO.read(getClass().getResource("../img/euskera.png"));
				euskadi = euskadi.getScaledInstance(70, 40, Image.SCALE_SMOOTH);

				} catch (IOException e1) {
					e1.printStackTrace();
				}
			
			eus.setIcon(new ImageIcon(euskadi));
			
			
		return eus;
	}
	private JButton getCastellano() {
		if (esp == null) {
			esp = new JButton();
			esp.setBackground(Color.YELLOW);
			esp.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					idioma = "Castellano";
					Conecta4.getConecta4().setIdioma("Castellano");
					esp.setBackground(Color.YELLOW);
					eus.setBackground(Color.WHITE);
					titulo.setText("CONECTA 4");
					lblSeleccioneModoDe.setText("Seleccione modo de juego:");
					rdbtn2Jugadores.setText("2 Jugadores");
					lblJugadorVsOrdenador.setText("Jugador VS Ordenador");
					rdbtnModoFacil.setText("Modo fácil");
					rdbtnModoDificil.setText("Modo difícil");

				}
			});
		}
		
		Image castellano = null;
		
		
		try {
			castellano = ImageIO.read(getClass().getResource("../img/castellano.png"));
			castellano = castellano.getScaledInstance(70, 40, Image.SCALE_SMOOTH);

			} catch (IOException e1) {
				e1.printStackTrace();
			}
		
		esp.setIcon(new ImageIcon(castellano));
		
		return esp;
	}
	private JPanel getPanelcentral() {
		if (panelcentral == null) {
			panelcentral = new JPanel();
			panelcentral.setLayout(new BorderLayout(0, 0));
			panelcentral.add(getPanel_1(), BorderLayout.NORTH);
			panelcentral.add(getPanel_1_1(), BorderLayout.CENTER);
		}
		return panelcentral;
	}
	private JPanel getPanel_1() {
		if (panel == null) {
			panel = new JPanel();
			panel.add(getTitulo());
		}
		return panel;
	}
	private JLabel getTitulo() {
		if (titulo == null) {
			titulo = new JLabel("CONECTA 4");
			titulo.setFont(new Font("Ink Free", Font.PLAIN, 38));
		}
		return titulo;
	}
	private JPanel getPanel_1_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel_1.add(getLblSeleccioneModoDe());
			panel_1.add(getRdbtn2Jugadores());
			panel_1.add(getLblJugadorVsOrdenador());
			panel_1.add(getRdbtnModoFacil());
			panel_1.add(getRdbtnModoDificil());
			panel_1.add(getSeparator());
			panel_1.add(getBtnJugar());
			
			ButtonGroup btngroup1 = new ButtonGroup();
			btngroup1.add(getRdbtn2Jugadores());
			btngroup1.add(getRdbtnModoFacil());
			btngroup1.add(getRdbtnModoDificil());
			panel_1.add(getLblDebesSeleccionarUn());

		}
		return panel_1;
	}
	private JLabel getLblSeleccioneModoDe() {
		if (lblSeleccioneModoDe == null) {
			lblSeleccioneModoDe = new JLabel("Seleccione modo de juego:");
			lblSeleccioneModoDe.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblSeleccioneModoDe.setHorizontalAlignment(SwingConstants.CENTER);
			lblSeleccioneModoDe.setBounds(54, 13, 286, 28);
		}
		return lblSeleccioneModoDe;
	}
	private JRadioButton getRdbtn2Jugadores() {
		if (rdbtn2Jugadores == null) {
			rdbtn2Jugadores = new JRadioButton("2 Jugadores");
			rdbtn2Jugadores.setFont(new Font("Tahoma", Font.PLAIN, 15));
			rdbtn2Jugadores.setBounds(54, 83, 117, 25);
		}
		return rdbtn2Jugadores;
	}
	private JLabel getLblJugadorVsOrdenador() {
		if (lblJugadorVsOrdenador == null) {
			lblJugadorVsOrdenador = new JLabel("Jugador VS Ordenador");
			lblJugadorVsOrdenador.setForeground(Color.GRAY);
			lblJugadorVsOrdenador.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblJugadorVsOrdenador.setBounds(202, 54, 168, 20);
		}
		return lblJugadorVsOrdenador;
	}
	private JRadioButton getRdbtnModoFacil() {
		if (rdbtnModoFacil == null) {
			rdbtnModoFacil = new JRadioButton("Modo Fácil");
			rdbtnModoFacil.setFont(new Font("Tahoma", Font.PLAIN, 15));
			rdbtnModoFacil.setBounds(216, 83, 127, 25);
		}
		return rdbtnModoFacil;
	}
	private JRadioButton getRdbtnModoDificil() {
		if (rdbtnModoDificil == null) {
			rdbtnModoDificil = new JRadioButton("Modo Difícil");
			rdbtnModoDificil.setFont(new Font("Tahoma", Font.PLAIN, 15));
			rdbtnModoDificil.setBounds(216, 113, 127, 25);
		}
		return rdbtnModoDificil;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setOrientation(SwingConstants.VERTICAL);
			separator.setBounds(179, 54, 14, 86);
		}
		return separator;
	}
	private JButton getBtnJugar() {
		if (btnJugar == null) {
			
			btnJugar = new JButton("");
			btnJugar.setBounds(423, 70, 70, 70);
			btnJugar.setBackground(Color.WHITE);
			
			btnJugar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					if(rdbtn2Jugadores.isSelected()){
						IU_2jugadores nombres = new IU_2jugadores();
						setVisible(false);
						nombres.setVisible(true);
						
						
					}else if(rdbtnModoFacil.isSelected()){
						IU_1jugador interfaz = new IU_1jugador();
						interfaz.ponerDificultad("FACIL");
						setVisible(false);
						interfaz.setVisible(true);
						
						
					}else if(rdbtnModoDificil.isSelected()){
						IU_1jugador interfaz = new IU_1jugador();
						interfaz.ponerDificultad("DIFICIL");
						setVisible(false);
						interfaz.setVisible(true);
						
						
					}else{
						lblDebesSeleccionarUn.setForeground(SystemColor.RED);
					}

				}
			});
		}
		
		Image play = null;
		
		try {
			play = ImageIO.read(getClass().getResource("../img/play.png"));
			play = play.getScaledInstance(50, 50, Image.SCALE_SMOOTH);

			} catch (IOException e1) {
				e1.printStackTrace();
			}
		
		btnJugar.setIcon(new ImageIcon(play));
		return btnJugar;
	}
	
	private JLabel getLblSeparador() {
		if (lblSeparador == null) {
			lblSeparador = new JLabel("                                                                                      ");
		}
		
		return lblSeparador;
	}
	private JLabel getLblDebesSeleccionarUn() {
		if (lblDebesSeleccionarUn == null) {
			lblDebesSeleccionarUn = new JLabel("Debes seleccionar un modo de juego");
			lblDebesSeleccionarUn.setForeground(SystemColor.control);
			lblDebesSeleccionarUn.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
			lblDebesSeleccionarUn.setBounds(326, 20, 234, 16);
		}
		return lblDebesSeleccionarUn;
	}
}
