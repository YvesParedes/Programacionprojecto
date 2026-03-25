package work;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Factura extends JFrame {

	public Factura() {
		this.setSize(600, 750);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		this.setLocationRelativeTo(null);
		this.setTitle("Facturas");		
		this.setLayout(null);		
		
		try {
			Image IconImage = ImageIO.read(getClass().getResource("/assets/fantasma.png"));
			this.setIconImage(IconImage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		this.principal();
		
		this.setVisible(true);
		this.repaint();
	}
	
	public void principal() {
		
		JPanel header = new JPanel();
		header.setBackground(new Color(0, 102, 153));
		header.setBounds(0, 0, 600, 60);
		header.setLayout(null);
		this.add(header);
		
		JLabel tag_title = new JLabel("Facturas");
		tag_title.setBounds(20, 10, 450, 25);
		tag_title.setForeground(Color.WHITE);
		tag_title.setFont(new Font("Arial", Font.BOLD, 16));
		header.add(tag_title);
		
		JLabel tag_sub = new JLabel("[Sin Base de datos]");
		tag_sub.setBounds(20, 30, 200, 20);
		tag_sub.setForeground(Color.WHITE);
		header.add(tag_sub);

		JPanel pnl_cliente = new JPanel();
		pnl_cliente.setBorder(BorderFactory.createTitledBorder("Datos del cliente"));
		pnl_cliente.setBounds(10, 70, 565, 90);
		pnl_cliente.setLayout(null);
		this.add(pnl_cliente);

		JLabel lbl_doc = new JLabel("Documento:");
		lbl_doc.setBounds(15, 25, 80, 25);
		pnl_cliente.add(lbl_doc);
		
		JTextField txt_doc = new JTextField("123456");
		txt_doc.setBounds(100, 25, 150, 25);
		pnl_cliente.add(txt_doc);
		
		JLabel lbl_nom = new JLabel("Nombres:");
		lbl_nom.setBounds(270, 25, 80, 25);
		pnl_cliente.add(lbl_nom);
		
		JTextField txt_nom = new JTextField("Marco Perez");
		txt_nom.setBounds(340, 25, 210, 25);
		pnl_cliente.add(txt_nom);
		
		JLabel lbl_dir = new JLabel("Dirección:");
		lbl_dir.setBounds(15, 55, 80, 25);
		pnl_cliente.add(lbl_dir);
		
		JTextField txt_dir = new JTextField("Calle 1 # 123");
		txt_dir.setBounds(100, 55, 150, 25);
		pnl_cliente.add(txt_dir);
		
		JLabel lbl_tel = new JLabel("Teléfono:");
		lbl_tel.setBounds(270, 55, 80, 25);
		pnl_cliente.add(lbl_tel);
		
		JTextField txt_tel = new JTextField("5540933");
		txt_tel.setBounds(340, 55, 210, 25);
		pnl_cliente.add(txt_tel);

		JPanel pnl_factura = new JPanel();
		pnl_factura.setBorder(BorderFactory.createTitledBorder("Datos de factura"));
		pnl_factura.setBounds(10, 170, 565, 60);
		pnl_factura.setLayout(null);
		this.add(pnl_factura);

		JLabel lbl_numf = new JLabel("N° Factura:");
		lbl_numf.setBounds(15, 20, 80, 25);
		pnl_factura.add(lbl_numf);
		
		JLabel val_numf = new JLabel("1");
		val_numf.setBounds(100, 20, 50, 25);
		val_numf.setFont(new Font("Arial", Font.BOLD, 14));
		pnl_factura.add(val_numf);

		JLabel lbl_fec = new JLabel("Fecha:");
		lbl_fec.setBounds(270, 20, 80, 25);
		pnl_factura.add(lbl_fec);
		
		JLabel val_fec = new JLabel("2091/12/22");
		val_fec.setBounds(340, 20, 150, 25);
		val_fec.setFont(new Font("Arial", Font.BOLD, 14));
		pnl_factura.add(val_fec);

		JButton btn_listado = new JButton("Ver listado de facturas"); 
		btn_listado.setBounds(10, 240, 180, 30);
		this.add(btn_listado);
		
		JButton btn_add = new JButton("Añadir"); 
		btn_add.setBounds(400, 240, 80, 30);
		this.add(btn_add);
		
		JButton btn_del = new JButton("Eliminar"); 
		btn_del.setBounds(490, 240, 80, 30);
		this.add(btn_del);

		String[] columnas = {"Producto", "Cantidad", "Valor", "Sub Total"};
		Object[][] datos = {
				{"Agua", "2", "500", "1000.0"},
				{"Cereal", "5", "1000", "5000.0"},
				{"Leche", "2", "300", "600.0"}
		};
		
		DefaultTableModel modelo = new DefaultTableModel(datos, columnas);
		JTable tabla_productos = new JTable(modelo);
		JScrollPane scroll = new JScrollPane(tabla_productos);
		scroll.setBounds(10, 280, 565, 120);
		this.add(scroll);

		JLabel tag_subt = new JLabel("SubTotal:");
		tag_subt.setBounds(40, 410, 100, 25);
		this.add(tag_subt);
		
		JLabel val_subt = new JLabel("6600.0");
		val_subt.setBounds(140, 410, 100, 25);
		val_subt.setFont(new Font("Arial", Font.BOLD, 13));
		this.add(val_subt);

		JLabel tag_desc = new JLabel("% Descuento:");
		tag_desc.setBounds(40, 440, 100, 25);
		this.add(tag_desc);
		
		JTextField input_desc = new JTextField("5");
		input_desc.setBounds(140, 440, 40, 25);
		this.add(input_desc);
		
		JCheckBox check_desc = new JCheckBox();
		check_desc.setBounds(190, 440, 30, 25); 
		check_desc.setSelected(true);
		this.add(check_desc);
		
		JLabel tag_vdesc = new JLabel("Valor descontado:");
		tag_vdesc.setBounds(240, 440, 120, 25);
		this.add(tag_vdesc);
		
		JLabel val_vdesc = new JLabel("330.0");
		val_vdesc.setBounds(370, 440, 100, 25);
		val_vdesc.setFont(new Font("Arial", Font.BOLD, 13));
		this.add(val_vdesc);

		JLabel tag_iva = new JLabel("IVA 19%:");
		tag_iva.setBounds(40, 470, 100, 25);
		this.add(tag_iva);
		
		JLabel val_iva = new JLabel("1254.0");
		val_iva.setBounds(140, 470, 100, 25);
		val_iva.setFont(new Font("Arial", Font.BOLD, 13));
		this.add(val_iva);

		JLabel tag_total = new JLabel("Total Factura:");
		tag_total.setBounds(40, 500, 100, 25);
		this.add(tag_total);
		
		JLabel val_total = new JLabel("7524.0");
		val_total.setBounds(140, 500, 100, 25);
		val_total.setFont(new Font("Arial", Font.BOLD, 13));
		this.add(val_total);

		JButton btn_finalizar = new JButton("Finalizar factura");
		btn_finalizar.setBounds(425, 540, 150, 30);
		this.add(btn_finalizar);
	}

	public static void main(String[] args) {
		new Factura();
	}
}