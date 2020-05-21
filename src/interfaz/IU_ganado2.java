package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import codigo.Conecta4;


import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.SwingConstants;
import javax.swing.ScrollPaneConstants;

public class IU_ganado2 extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblHaGanado;
	private JLabel lblGanador;
	private JTextArea area;
//	private JScrollPane scroll;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			IU_ganado2 dialog = new IU_ganado2();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public IU_ganado2() {
		setBounds(100, 100, 514, 407);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getLblHaGanado());
		contentPanel.add(getLblGanador());
	//	contentPanel.add(getScrollPane());
		//scroll = new JScrollPane(area);
		
		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				if(Conecta4.getConecta4().getIdioma().equals("Castellano")){
					JLabel texto = new JLabel("¿Quieres jugar otra partida?                       ");
					buttonPane.add(texto);
				}else{
					JLabel texto = new JLabel("Beste partida bat nahi duzu?                       ");
					buttonPane.add(texto);
				}
				
				
				JButton okButton = new JButton("V");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Conecta4.getConecta4().setFin(true);
						IU_menu1 menu = new IU_menu1();
						menu.setVisible(true);
						setVisible(false);
					}
				});
				
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("X");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		}
	
	private JLabel getLblHaGanado() {
		if (lblHaGanado == null) {
			if(Conecta4.getConecta4().getIdioma().equals("Castellano")){
				lblHaGanado = new JLabel("HA GANADO");
			}else{
				lblHaGanado = new JLabel("IRABAZI DU");
			}			
			lblHaGanado.setHorizontalAlignment(SwingConstants.CENTER);
			lblHaGanado.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblHaGanado.setBounds(12, 32, 472, 36);
		}
		return lblHaGanado;
	}
	private JLabel getLblGanador() {
		if (lblGanador == null) {
			lblGanador = new JLabel(Conecta4.getConecta4().getTablero().getGanador().getNombre());
			if(Conecta4.getConecta4().getTablero().getGanador().getNum()==1){
				lblGanador.setForeground(SystemColor.RED);
			}else{
				lblGanador.setForeground(SystemColor.BLUE);
			}
			lblGanador.setHorizontalAlignment(SwingConstants.CENTER);
			lblGanador.setFont(new Font("Hobo Std", Font.PLAIN, 30));
			lblGanador.setBounds(12, 59, 472, 71);
		}
		return lblGanador;
	}
	
	
}
