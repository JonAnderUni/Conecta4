package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class IU_Victoria extends JFrame {

	private JPanel contentPane;
	private URL url;
	private JPanel panelGif;
	private JPanel panelBoton;
	private JButton btnOK;
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
			Icon icon = new ImageIcon("img/VictoryGif.gif");
			getLblGif().setIcon(icon);
			getLblGif().setSize(100,100);
			panelGif.add(getLblGif());
			
		}
		return panelGif;
	}
	private JPanel getPanelBoton() {
		if (panelBoton == null) {
			panelBoton = new JPanel();
			panelBoton.add(getBtnOK());
			
			
		}
		return panelBoton;
	}
	private JButton getBtnOK() {
		if (btnOK == null) {
			btnOK = new JButton("Ok");
			
			btnOK.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					IU_ganado ganado = new IU_ganado();
					ganado.setVisible(true);
					setVisible(false);
				}
			});
		}
		return btnOK;
	}
	private JLabel getLblGif() {
		if (lblGif == null) {
			lblGif = new JLabel("");
			
		}
		return lblGif;
	}
	
}
