package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import codigo.Tablero;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;

public class IU_juego extends JFrame implements Observer{

	private JPanel contentPane;
	private JPanel panelNorte;
	private JPanel panelOeste;
	private JPanel panelEste;
	private JPanel panelSur;
	private JPanel panelCentro;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem menuItemCambiarModo;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	private JLabel lblPuntuacion;
	private JLabel lblTiempoC;
	private JPanel panelPuntuacion;
	private JPanel panelTiempo;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblTiempoD;
	private JLabel lblTiempoU;
	private JButton[][] tableroBotones;
	private int cont;
	private Timer timer;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IU_juego frame = new IU_juego();
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
	public IU_juego() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanelNorte(), BorderLayout.NORTH);
		contentPane.add(getPanelOeste(), BorderLayout.WEST);
		contentPane.add(getPanelEste(), BorderLayout.EAST);
		contentPane.add(getPanelSur(), BorderLayout.SOUTH);
		contentPane.add(getPanelCentro(), BorderLayout.CENTER);
		
		// Para centrar frame en la mitad de la pantalla
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setTitle("Conecta 4");
		ImageIcon imagen = new ImageIcon("img/greymine.png");
		this.setIconImage(imagen.getImage());
	}
	
	public void crearTablero() {
		Tablero.getTablero().eliminarTablero();
		
		
		//getPanelCentro().setSize((faltan dimension x),(falta dimension y));
		//setSize();  faltan dimensiones
		
		
		if (timer != null) {
			cont = 0;
			ImageIcon imgD = new ImageIcon("img/r0.png");
			java.awt.Image timerD = imgD.getImage();
			java.awt.Image sizeD = timerD.getScaledInstance(20, 25, 0);
			ImageIcon contador = new ImageIcon(sizeD);
			getLblTiempoC().setIcon(contador);
			getLblTiempoD().setIcon(contador);
			getLblTiempoU().setIcon(contador);

			redimensionarContadorTimer();
			timer.stop();
			timer.restart();
		}
		contadorTimer();
		
		getPanelCentro().removeAll();
		
		tableroBotones = new JButton[6][9];
		for (int i = 0; i < tableroBotones.length; i++) {
			for (int j = 0; j < tableroBotones[0].length; j++) {
				JButton jb = new JButton();
				jb.setBackground(Color.LIGHT_GRAY);
				jb.setBorderPainted(true);
				tableroBotones[i][j] = jb;
				tableroBotones[i][j].addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent arg0) {
						
					}
					
				});
				
				getPanelCentro().add(jb);
			}
		}
	}
	
	@Override
	public void update(Observable o, Object arg) {
		
		
	}
	
	private Timer iniciarTimer() {
		// Inicia el contador del timer

		cont = 0;

		
		if (timer == null) {
			timer = new Timer(1000, new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					cont++;
					contadorTimer();
				}
			});
			timer.start();
		}
		return timer;
	}

	private void contadorTimer() {

	
		int centenas = cont / 100;
		int decenas = (cont - (centenas * 100)) / 10;
		int unidades = cont - (centenas * 100 + decenas * 10);

		ImageIcon imgD = new ImageIcon("img/r" + decenas + ".png");
		ImageIcon imgU = new ImageIcon("img/r" + unidades + ".png");
		ImageIcon imgC = new ImageIcon("img/r" + centenas + ".png");

		java.awt.Image timerC = imgC.getImage();
		java.awt.Image sizeC = timerC.getScaledInstance(20, 25, 0);
		ImageIcon centena = new ImageIcon(sizeC);

		java.awt.Image timerD = imgD.getImage();
		java.awt.Image sizeD = timerD.getScaledInstance(20, 25, 0);
		ImageIcon decena = new ImageIcon(sizeD);

		java.awt.Image timerU = imgU.getImage();
		java.awt.Image sizeU = timerU.getScaledInstance(20, 25, 0);
		ImageIcon unidad = new ImageIcon(sizeU);

		getLblTiempoC().setIcon(centena);
		getLblTiempoD().setIcon(decena);
		getLblTiempoU().setIcon(unidad);
	
		redimensionarContadorTimer();
	}
	
	private void redimensionarContadorTimer() {

		int width = (getPanelNorte().getWidth()) / 3;
		int inicio = (50 * width) / 100;

		getLblTiempoC().setBounds(inicio - 30, 1, 20, panelNorte.getHeight());
		getLblTiempoD().setBounds(inicio - 10, 1, 20, panelNorte.getHeight());
		getLblTiempoU().setBounds(inicio + 10, 1, 20, panelNorte.getHeight());

	}
	
	private JPanel getPanelNorte() {
		if (panelNorte == null) {
			panelNorte = new JPanel();
			panelNorte.setLayout(new GridLayout(1, 0, 0, 0));
			panelNorte.add(getPanelPuntuacion());
			panelNorte.add(getPanelTiempo());
		}
		return panelNorte;
	}
	private JPanel getPanelOeste() {
		if (panelOeste == null) {
			panelOeste = new JPanel();
		}
		return panelOeste;
	}
	private JPanel getPanelEste() {
		if (panelEste == null) {
			panelEste = new JPanel();
		}
		return panelEste;
	}
	private JPanel getPanelSur() {
		if (panelSur == null) {
			panelSur = new JPanel();
		}
		return panelSur;
	}
	private JPanel getPanelCentro() {
		if (panelCentro == null) {
			panelCentro = new JPanel();
			panelCentro.setLayout(new GridLayout(6, 9, 0, 0));
			
			
		}
		return panelCentro;
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnNewMenu());
		}
		return menuBar;
	}
	private JMenu getMnNewMenu() {
		if (mnNewMenu == null) {
			mnNewMenu = new JMenu("New menu");
			mnNewMenu.add(getMenuItemCambiarModo());
			mnNewMenu.add(getMntmNewMenuItem_1());
			mnNewMenu.add(getMntmNewMenuItem_2());
		}
		return mnNewMenu;
	}
	private JMenuItem getMenuItemCambiarModo() {
		if (menuItemCambiarModo == null) {
			menuItemCambiarModo = new JMenuItem("Cambiar Modo");
		}
		return menuItemCambiarModo;
	}
	private JMenuItem getMntmNewMenuItem_1() {
		if (mntmNewMenuItem_1 == null) {
			mntmNewMenuItem_1 = new JMenuItem("New menu item");
		}
		return mntmNewMenuItem_1;
	}
	private JMenuItem getMntmNewMenuItem_2() {
		if (mntmNewMenuItem_2 == null) {
			mntmNewMenuItem_2 = new JMenuItem("New menu item");
		}
		return mntmNewMenuItem_2;
	}
	private JLabel getLblPuntuacion() {
		if (lblPuntuacion == null) {
			lblPuntuacion = new JLabel("");
		}
		return lblPuntuacion;
	}
	private JLabel getLblTiempoC() {
		if (lblTiempoC == null) {
			lblTiempoC = new JLabel("");
			lblTiempoC.setBounds(106, 5, 0, 0);
		}
		return lblTiempoC;
	}
	private JPanel getPanelPuntuacion() {
		if (panelPuntuacion == null) {
			panelPuntuacion = new JPanel();
			panelPuntuacion.add(getLblPuntuacion());
			panelPuntuacion.add(getLblNewLabel());
			panelPuntuacion.add(getLblNewLabel_1());
			panelPuntuacion.add(getLblNewLabel_2());
		}
		return panelPuntuacion;
	}
	private JPanel getPanelTiempo() {
		if (panelTiempo == null) {
			panelTiempo = new JPanel();
			panelTiempo.setLayout(null);
			panelTiempo.add(getLblTiempoC());
			panelTiempo.add(getLblTiempoD());
			panelTiempo.add(getLblTiempoU());
		}
		return panelTiempo;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("");
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("");
		}
		return lblNewLabel_2;
	}
	private JLabel getLblTiempoD() {
		if (lblTiempoD == null) {
			lblTiempoD = new JLabel("");
			lblTiempoD.setBounds(111, 5, 0, 0);
		}
		return lblTiempoD;
	}
	private JLabel getLblTiempoU() {
		if (lblTiempoU == null) {
			lblTiempoU = new JLabel("");
			lblTiempoU.setBounds(116, 5, 0, 0);
		}
		return lblTiempoU;
	}

	
}
