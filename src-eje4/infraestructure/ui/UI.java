package infraestructure.ui;

import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import domain.portsin.DomainException;
import domain.portsin.Usuarios;

public class UI extends JFrame {

	private JTextField nombre;
	private JTextField telefono;
	private JTextField region;
	private JTextField email;
	private Usuarios   registro;

	public UI(Usuarios registro) {

		this.registro = registro;

		setupUIComponents();
	}

	private void setupUIComponents() {
		setTitle("Add Participant");
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.nombre   = new JTextField(10);
		this.telefono = new JTextField(10);
		this.region   = new JTextField(10);
		this.email    = new JTextField(10);
		this.nombre.setText("");
		this.telefono.setText("");
		this.region.setText("China");
		this.email.setText("");
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new FlowLayout());
		contentPane.add(new JLabel("Nombre: "));
		contentPane.add(nombre);
		contentPane.add(new JLabel("Telefono: "));
		contentPane.add(telefono);
		contentPane.add(new JLabel("Region: "));
		contentPane.add(region);
		contentPane.add(new JLabel("Email: "));
		contentPane.add(email);
		JButton botonCargar = new JButton("Cargar");

		botonCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					onBotonCargar();
				} catch (DomainException e1) {
					JOptionPane.showMessageDialog(contentPane, "Error en la carga.");
				}
			}
		});

		contentPane.add(botonCargar);
		setContentPane(contentPane);
		contentPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		pack();
		setVisible(true);
	}

	private void onBotonCargar() throws DomainException {

//		Participante participante = new Participante(nombre.getText(), telefono.getText(), region.getText());
//
//		repositorio.registrar(participante.datos());
		registro.nuevoRegistro(nombre.getText(), telefono.getText(), region.getText(), email.getText());

	}

	//

}
