package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import domain.portsin.IDispositivo;
import domain.portsin.ITarjeta;
import domain.portsin.Observers;
import domain.portsin.Producto;

public class Facturacion extends JFrame {

	private JPanel              contentPane;
	private IDispositivo        dispositivo;
	private JComboBox<Producto> comboBoxPlatos;
	private JComboBox<Producto> comboBoxBebidas;
	private JComboBox<ITarjeta> comboBoxTarjetas;
	private List<ITarjeta>      tarjetas;
	private JLabel              lblsubtotal;
	private JLabel              lblprecioTotal;
	private List<Observers>     observadores;

	public Facturacion(IDispositivo dispositivo, List<ITarjeta> tarjetas, List<Observers> observadores) {
		var frame = new JFrame("Facturacion");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 490, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		this.dispositivo  = dispositivo;
		this.tarjetas     = tarjetas;
		this.observadores = observadores;
		labels();
		buttons();
		comboBox();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

	public void labels() {
		JLabel lblPlatos = new JLabel("PLATOS");
		lblPlatos.setBounds(10, 11, 62, 22);
		contentPane.add(lblPlatos);
		// ----------------------------------------------------------
		JLabel lblBebidas = new JLabel("BEBIDAS");
		lblBebidas.setBounds(10, 44, 62, 22);
		contentPane.add(lblBebidas);
		// ----------------------------------------------------------
		lblsubtotal = new JLabel("$...");
		lblsubtotal.setBounds(233, 105, 115, 33);
		contentPane.add(lblsubtotal);
		// ----------------------------------------------------------
		JLabel lblNewLabel = new JLabel("SubTotal: ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(54, 105, 113, 33);
		contentPane.add(lblNewLabel);
		// ----------------------------------------------------------
		JLabel lblElegirTarjeta = new JLabel("ELEGIR TARJETA");
		lblElegirTarjeta.setBounds(64, 138, 113, 22);
		contentPane.add(lblElegirTarjeta);
		// ----------------------------------------------------------
		lblprecioTotal = new JLabel("$...");
		lblprecioTotal.setBounds(233, 177, 115, 22);
		contentPane.add(lblprecioTotal);

	}

	public void buttons() {

		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Producto plato  = (Producto) comboBoxPlatos.getSelectedItem();
				Producto bebida = (Producto) comboBoxBebidas.getSelectedItem();
				dispositivo.agregarBebida(bebida, 1);
				dispositivo.agregarPlato(plato, 1);

				lblsubtotal.setText(" $ " + dispositivo.subTotal());

			}
		});
		btnNewButton.setBounds(54, 73, 383, 33);
		contentPane.add(btnNewButton);
		// ----------------------------------------------------------
		JButton btnFacturar = new JButton("FACTURAR");
		btnFacturar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Observers observador : observadores) {
					observador.mostrar(" $ " + dispositivo.calculo());
				}
			}
		});

		btnFacturar.setBounds(116, 210, 294, 40);
		contentPane.add(btnFacturar);

		// ----------------------------------------------------------

		JButton btnNewButton_1 = new JButton("TOTAL");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ITarjeta tarjeta = (ITarjeta) comboBoxTarjetas.getSelectedItem();
				dispositivo.seleccionarTarjeta(tarjeta);
				float total = dispositivo.calculo();

				lblprecioTotal.setText(" $ " + total);
			}
		});
		btnNewButton_1.setBounds(54, 171, 113, 28);
		contentPane.add(btnNewButton_1);

	}

	public void comboBox() {
 
		comboBoxPlatos = new JComboBox<Producto>();
		comboBoxPlatos.setBounds(82, 11, 206, 22);
		contentPane.add(comboBoxPlatos);
		dispositivo.platos().forEach(plato -> comboBoxPlatos.addItem(plato));

		comboBoxBebidas = new JComboBox<Producto>();
		comboBoxBebidas.setBounds(82, 44, 206, 22);
		contentPane.add(comboBoxBebidas);
		dispositivo.bebidas().forEach(bebiba -> comboBoxBebidas.addItem(bebiba));

		comboBoxTarjetas = new JComboBox<ITarjeta>();
		comboBoxTarjetas.setBounds(203, 138, 145, 22);
		contentPane.add(comboBoxTarjetas); 
		tarjetas.forEach(tarjeta -> comboBoxTarjetas.addItem(tarjeta));

	}

	 
	

}
