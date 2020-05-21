package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import codigo.Conecta4;
import codigo.EnumTipo;
import codigo.Jugador;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IU_2jugadores extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField njugador1;
	private JTextField njugador2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			IU_2jugadores dialog = new IU_2jugadores();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public IU_2jugadores() {
		setBounds(100, 100, 353, 264);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			if(Conecta4.getConecta4().getIdioma().equals("Castellano")){
				JLabel lblIntroduceNombrePara = new JLabel("Introduce nombre para Jugador 1:");
				lblIntroduceNombrePara.setBounds(60, 27, 224, 16);
				lblIntroduceNombrePara.setFont(new Font("Tahoma", Font.PLAIN, 14));
				contentPanel.add(lblIntroduceNombrePara);
			}else{
				JLabel lblIntroduceNombrePara = new JLabel("1. Jokalariaren izena idatzi:");
				lblIntroduceNombrePara.setBounds(60, 27, 224, 16);
				lblIntroduceNombrePara.setFont(new Font("Tahoma", Font.PLAIN, 14));
				contentPanel.add(lblIntroduceNombrePara);
			}
			
		}
		{
			njugador1 = new JTextField();
			njugador1.setHorizontalAlignment(SwingConstants.CENTER);
			njugador1.setBounds(39, 57, 245, 22);
			contentPanel.add(njugador1);
			njugador1.setColumns(10);
		}
		{
			if(Conecta4.getConecta4().getIdioma().equals("Castellano")){
				JLabel lblIntroduceNombrePara_1 = new JLabel("Introduce nombre para Jugador 2:");
				lblIntroduceNombrePara_1.setBounds(62, 96, 224, 16);
				lblIntroduceNombrePara_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
				contentPanel.add(lblIntroduceNombrePara_1);
			}else{
				JLabel lblIntroduceNombrePara_1 = new JLabel("2. Jokalariaren izena idatzi:");
				lblIntroduceNombrePara_1.setBounds(62, 96, 224, 16);
				lblIntroduceNombrePara_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
				contentPanel.add(lblIntroduceNombrePara_1);
			}
			
		}
		{
			njugador2 = new JTextField();
			njugador2.setHorizontalAlignment(SwingConstants.CENTER);
			njugador2.setColumns(10);
			njugador2.setBounds(41, 124, 245, 22);
			contentPanel.add(njugador2);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						
						Jugador jugador1 = new Jugador(EnumTipo.USUARIO, njugador1.getText(), 1);
						Jugador jugador2 = new Jugador(EnumTipo.USUARIO, njugador2.getText(), 2);
						
						Conecta4.getConecta4().empezarPartida();
						Conecta4.getConecta4().getTablero().setJugadores(jugador1, jugador2);
						Conecta4.getConecta4().getTablero().generarTablero();
						Conecta4.getConecta4().getTablero().iniciarPartida();
						
						IU_juego juego = new IU_juego();
						juego.setModo("USUARIO");
						

						setVisible(false);
						juego.setVisible(true);
						
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("<<<<");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						IU_menu1 atras = new IU_menu1();
						atras.setVisible(true);
						setVisible(false);
					}
				});
				buttonPane.add(cancelButton);
			}
		}
	}

}
