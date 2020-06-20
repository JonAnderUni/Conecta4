package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

public class IU_Victoria extends JFrame {

	private JPanel contentPane;
	private URL url;
	private JPanel panelGif;
	private JPanel panelBoton;
	private JButton btnNewButton;
	private JLabel lblGif;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IU_Victoria frame = new IU_Victoria();
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
	public IU_Victoria() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanelGif(), BorderLayout.CENTER);
		contentPane.add(getPanelBoton(), BorderLayout.SOUTH);
		
		try {
			
		}catch(Exception e) {
			
		}
	}

	private JPanel getPanelGif() {
		if (panelGif == null) {
			panelGif = new JPanel();
			panelGif.add(getLblGif());
		}
		return panelGif;
	}
	private JPanel getPanelBoton() {
		if (panelBoton == null) {
			panelBoton = new JPanel();
			panelBoton.add(getBtnNewButton());
		}
		return panelBoton;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Ok");
		}
		return btnNewButton;
	}
	private JLabel getLblGif() {
		if (lblGif == null) {
			lblGif = new JLabel("");
		}
		return lblGif;
	}
}
