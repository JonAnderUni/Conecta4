package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import codigo.Conecta4;
import codigo.Jugador;
import codigo.Tablero;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;

public class IU_juego extends JFrame implements Observer {

	private JPanel contentPane;
	private JPanel panel;

	private JMenuBar menuBarra = new JMenuBar();
	private JMenu archivo = new JMenu();
	private JMenu ayuda = new JMenu();
	private JMenuItem nuevo = new JMenuItem();
	private JMenuItem salir = new JMenuItem();

	private int ancho = 9;
	private int alto = 6;
	private JButton[][] botones = new JButton[ancho][alto];

	private final JPanel panelnorte = new JPanel();
	private final JLabel lblTurnoDe = new JLabel("Turno de:");
	private final JLabel lblTxanda = new JLabel("ren txanda");
	private final JLabel lblJugador = new JLabel();

	private String modo = "";

	private boolean fin = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IU_juego frame = new IU_juego();
					frame.setVisible(true);

					/*
					 * System.out.println("EMPEZAMOS"); Conecta4.getConecta4().empezarPartida();
					 * Conecta4.getConecta4().getTablero().generarTablero();
					 * System.out.println(Conecta4.getConecta4().getTablero().getJugador1().
					 * getNombre()); Conecta4.getConecta4().getTablero().iniciarPartida();
					 */

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public IU_juego() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		contentPane.add(panelnorte, BorderLayout.NORTH);

		if (Conecta4.getConecta4().getIdioma().equals("Castellano")) {
			panelnorte.add(lblTurnoDe);
			lblJugador.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblJugador.setText(Conecta4.getConecta4().getTablero().getJugador1().getNombre());
			lblJugador.setForeground(Color.RED);
			panelnorte.add(lblJugador);
			contentPane.add(getPanelCentro(), BorderLayout.CENTER);
		} else {
			lblJugador.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblJugador.setText(Conecta4.getConecta4().getTablero().getJugador1().getNombre());
			lblJugador.setForeground(Color.RED);
			panelnorte.add(lblJugador);
			panelnorte.add(lblTxanda);
			contentPane.add(getPanelCentro(), BorderLayout.CENTER);
		}

		/*
		 * this.setJMenuBar(menuBarra); archivo.setText("Archivo");
		 * nuevo.setText("Nuevo"); salir.setText("Salir"); ayuda.setText("Ayuda");
		 * 
		 * archivo.add(nuevo); archivo.addSeparator(); archivo.add(salir);
		 * 
		 * menuBarra.add(archivo); menuBarra.add(ayuda);
		 * 
		 */

	}

	private JPanel getPanelCentro() {
		if (panel == null) {
			panel = new JPanel();

			Dimension dim = new Dimension(25, 25);
			panel.setLayout(new GridLayout(alto, ancho, 0, 0));

			ImageIcon fondoBlanco = null;

			Image blanco1 = new ImageIcon("blanco.png").getImage();
			fondoBlanco = new ImageIcon(blanco1.getScaledInstance(50, 50, Image.SCALE_SMOOTH));

			for (int j = 0; j < alto; j++) {
				for (int i = 0; i < ancho; i++) {

					// Conecta4.getConecta4().getTablero().getCasilla(i, j).addObserver(this);

					botones[i][j] = new JButton();
					botones[i][j].setPreferredSize(dim);

					botones[i][j].setMargin(new Insets(0, 0, 0, 0));

					panel.add(botones[i][j]);

					JLabel etiqueta = new JLabel(i + "," + j);
					etiqueta.setVisible(false);
					botones[i][j].add(etiqueta);

					botones[i][j].setIcon(fondoBlanco);

					botones[i][j].addMouseListener(new MouseListener() {

						@Override
						public void mouseReleased(MouseEvent e) {
						}

						@Override
						public void mousePressed(MouseEvent e) {
						}

						@Override
						public void mouseExited(MouseEvent e) {
						}

						@Override
						public void mouseEntered(MouseEvent e) {
						}

						@Override
						public void mouseClicked(MouseEvent e) {
							if (e.getClickCount() == 1) {

								if (e.getButton() == MouseEvent.BUTTON1 && !fin) {

									if (modo.equals("USUARIO")) {

										// System.out.println("click izquierdo");
										e.getSource();

										String cmd = etiqueta.getText();
										// System.out.println(cmd);
										String splitXY = ",";
										String[] data = cmd.split(splitXY);

										int ancho = Integer.parseInt(data[0]);
										int alto = Integer.parseInt(data[1]);

										int nuevoAlto = Conecta4.getConecta4().getTablero().meterFicha(ancho, alto);

										// System.out.println(Conecta4.getConecta4().getTablero().getCasilla(ancho,
										// alto).getC());

										if (nuevoAlto != -1) {
											// String turno = Conecta4.getConecta4().getTablero().getTurno();
											Jugador j = Conecta4.getConecta4().getTablero().getTurnoActual();

											ImageIcon color = null;

											if (j.getNum() == 1) {
												lblJugador.setForeground(Color.BLUE);
												// System.out.println(j.getNombre() + " acaba de meter ficha");
												Image rojo1 = new ImageIcon("img/rojo.png").getImage();
												color = new ImageIcon(
														rojo1.getScaledInstance(50, 50, Image.SCALE_SMOOTH));

											} else {
												lblJugador.setForeground(Color.RED);
												// System.out.println(j.getNombre() + " acaba de meter ficha");
												Image azul1 = new ImageIcon("img/azul.png").getImage();
												color = new ImageIcon(
														azul1.getScaledInstance(50, 50, Image.SCALE_SMOOTH));

											}

											botones[ancho][nuevoAlto].setIcon(color);

											Conecta4.getConecta4().getTablero().cambiarTurno();
											Jugador turnoActual = Conecta4.getConecta4().getTablero().getTurnoActual();

											lblJugador.setText(turnoActual.getNombre());
											Conecta4.getConecta4().getTablero().comprobarVictoria();
											if (Conecta4.getConecta4().getTablero().hayGanador()) {
												Jugador ganador = Conecta4.getConecta4().getTablero().getGanador();
												// System.out.println("Ha ganado " + ganador.getNombre());
												fin = true;
												IU_ganado2 ganado2 = new IU_ganado2();
												setVisible(false);
												ganado2.setVisible(true);
											}

										} else {

											// System.out.println("VUELVE A SELECCIONAR OTRA CASILLA");

										}
										/////////////////////////////////////////////////

									} else if (modo.equals("FACIL")) {

										// System.out.println("ESTAS EN MODO FACIL");
										// System.out.println("click izquierdo");
										e.getSource();

										String cmd = etiqueta.getText();
										// System.out.println(cmd);
										String splitXY = ",";
										String[] data = cmd.split(splitXY);

										int ancho = Integer.parseInt(data[0]);
										int alto = Integer.parseInt(data[1]);

										int nuevoAlto = Conecta4.getConecta4().getTablero().meterFicha(ancho, alto);

										// System.out.println(Conecta4.getConecta4().getTablero().getCasilla(ancho,
										// alto).getC());

										if (nuevoAlto != -1) {
											// String turno = Conecta4.getConecta4().getTablero().getTurno();
											Jugador j = Conecta4.getConecta4().getTablero().getTurnoActual();

											ImageIcon color = null;

											// lblJugador.setForeground(Color.BLUE);
											// System.out.println(j.getNombre() + " acaba de meter ficha");
											Image rojo1 = new ImageIcon("img/rojo.png").getImage();
											color = new ImageIcon(rojo1.getScaledInstance(50, 50, Image.SCALE_SMOOTH));

											botones[ancho][nuevoAlto].setIcon(color);

											Conecta4.getConecta4().getTablero().cambiarTurno();
											Jugador turnoActual = Conecta4.getConecta4().getTablero().getTurnoActual();

											lblJugador.setText(
													Conecta4.getConecta4().getTablero().getJugador1().getNombre());
											Conecta4.getConecta4().getTablero().comprobarVictoria();
											if (Conecta4.getConecta4().getTablero().hayGanador() && !fin) {
												Jugador ganador = Conecta4.getConecta4().getTablero().getGanador();
												// System.out.println("Ha ganado " + ganador.getNombre());
												fin = true;
												// setVisible(false);
												IU_Victoria ganado = new IU_Victoria();
												ganado.setVisible(true);
												setVisible(false);

											}

										} else {

											// System.out.println("VUELVE A SELECCIONAR OTRA CASILLA");

										}

										int[] resultado = Conecta4.getConecta4().getTablero().turnoFacil();
										// System.out.println(resultado[0]);
										// System.out.println(resultado[1]);

										
										ImageIcon color = null;

										Image azul1 = new ImageIcon("img/azul.png").getImage();
										color = new ImageIcon(azul1.getScaledInstance(50, 50, Image.SCALE_SMOOTH));

										botones[resultado[0]][resultado[1]].setIcon(color);

										Conecta4.getConecta4().getTablero().comprobarVictoria();
										if (Conecta4.getConecta4().getTablero().hayGanador() && !fin) {
											Jugador ganador = Conecta4.getConecta4().getTablero().getGanador();
											// System.out.println("Ha ganado " + ganador.getNombre());
											fin = true;
											// setVisible(false);
											IU_ganado ganado = new IU_ganado();
											ganado.setVisible(true);
											setVisible(false);

										}
										Conecta4.getConecta4().getTablero().cambiarTurno();
										
										//////////////////
									} else if (modo.equals("DIFICIL")) {

										// System.out.println("ESTAS EN MODO DIFICIL");
										// System.out.println("click izquierdo");
										e.getSource();

										String cmd = etiqueta.getText();
										// System.out.println(cmd);
										String splitXY = ",";
										String[] data = cmd.split(splitXY);

										int ancho = Integer.parseInt(data[0]);
										int alto = Integer.parseInt(data[1]);

										int nuevoAlto = Conecta4.getConecta4().getTablero().meterFicha(ancho, alto);

										// System.out.println(Conecta4.getConecta4().getTablero().getCasilla(ancho,
										// alto).getC());

										if (nuevoAlto != -1) {
											// String turno = Conecta4.getConecta4().getTablero().getTurno();
											Jugador j = Conecta4.getConecta4().getTablero().getTurnoActual();

											ImageIcon color = null;

											// lblJugador.setForeground(Color.BLUE);
											// System.out.println(j.getNombre() + " acaba de meter ficha");
											Image rojo1 = new ImageIcon("img/rojo.png").getImage();
											color = new ImageIcon(rojo1.getScaledInstance(50, 50, Image.SCALE_SMOOTH));

											botones[ancho][nuevoAlto].setIcon(color);

											
											Jugador turnoActual = Conecta4.getConecta4().getTablero().getTurnoActual();

											lblJugador.setText(
													Conecta4.getConecta4().getTablero().getJugador1().getNombre());
											Conecta4.getConecta4().getTablero().comprobarVictoria();
											if (Conecta4.getConecta4().getTablero().hayGanador()) {
												Jugador ganador = Conecta4.getConecta4().getTablero().getGanador();
												// System.out.println("Ha ganado " + ganador.getNombre());
												fin = true;
												// setVisible(false);
												IU_Victoria ganado = new IU_Victoria();
												ganado.setVisible(true);
												setVisible(false);

											}
											Conecta4.getConecta4().getTablero().cambiarTurno();
										} else {

											// System.out.println("VUELVE A SELECCIONAR OTRA CASILLA");

										}

										// int[] resultado =
										Conecta4.getConecta4().getTablero().turnoDificil();
										// System.out.println(resultado[0]);
										// System.out.println(resultado[1]);

										
										ImageIcon color = null;

										Image azul1 = new ImageIcon("img/azul.png").getImage();
										color = new ImageIcon(azul1.getScaledInstance(50, 50, Image.SCALE_SMOOTH));

										// botones[resultado[0]][resultado[1]].setIcon(new ImageIcon(color));

										Conecta4.getConecta4().getTablero().comprobarVictoria();
										if (Conecta4.getConecta4().getTablero().hayGanador()) {
											Jugador ganador = Conecta4.getConecta4().getTablero().getGanador();
											// System.out.println("Ha ganado " + ganador.getNombre());
											fin = true;
											// setVisible(false);
											IU_ganado ganado = new IU_ganado();
											ganado.setVisible(true);
											setVisible(false);

										}
										Conecta4.getConecta4().getTablero().cambiarTurno();
									}

								}

							}

						}
					});

				}
			}

		}
		return panel;
	}

	public void setModo(String m) {
		modo = m;
	}

	@Override
	public void update(Observable o, Object arg) {

		/*
		 * if(Conecta4.getConecta4().getTablero().getTurno().equals("Jugador 1")){
		 * System.out.println("TURNO JUGADOR1 "); }
		 */
	}

}
