package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
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
	private JLabel lblTiempo;
	private JPanel panelPuntuacion;
	private JPanel panelTiempo;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JButton[] tableroBotones;
	private JLabel[][] tableroLabels;
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
	
	@Override
	public void update(Observable o, Object arg) {
		
		
	}
	
	private void crearTablero() {
		
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
			lblPuntuacion = new JLabel("New label");
		}
		return lblPuntuacion;
	}
	private JLabel getLblTiempo() {
		if (lblTiempo == null) {
			lblTiempo = new JLabel("New label");
		}
		return lblTiempo;
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
			panelTiempo.add(getLblTiempo());
			panelTiempo.add(getLblNewLabel_3());
			panelTiempo.add(getLblNewLabel_4());
		}
		return panelTiempo;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("New label");
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("New label");
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("New label");
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("New label");
		}
		return lblNewLabel_3;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("New label");
		}
		return lblNewLabel_4;
	}

	
}
