import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Sobre implements ActionListener, ChangeListener, Runnable {

	private JLabel lab;

	private JLabel email;

	private JLabel lblNewLabel_1;

	private int w;

	private JFrame jf;

	private int sleep;

	public void setIconoTitulo(Icon icon) {

		try {

			lblNewLabel_1.setIcon(icon);

		}

		catch (Exception e) {

		}

	}

	public void setIconoTexto(Icon icon) {

		try {

			lab.setIcon(icon);

		}

		catch (Exception e) {

		}

	}

	public void setIconoEmail(Icon icon) {

		try {

			email.setIcon(icon);

		}

		catch (Exception e) {

		}

	}

	public void setAlineacionTitulo(int alineacion) {

		try {

			lblNewLabel_1.setHorizontalAlignment(alineacion);

		}

		catch (Exception e) {

		}

	}

	public void setAlineacionTexto(int alineacion) {

		try {

			lab.setHorizontalAlignment(alineacion);

		}

		catch (Exception e) {

		}

	}

	public void setAlineacionEmail(int alineacion) {

		try {

			email.setHorizontalAlignment(alineacion);

		}

		catch (Exception e) {

		}

	}

	public Sobre(String titulo, String nombre, String correo, int ancho, int alto, int sleep) {

		if (sleep < 1) {

			sleep = 100;

		}

		this.sleep = sleep;

		if (titulo == null || titulo.isEmpty()) {

			titulo = "Programa creado por";

		}

		lab = new JLabel(nombre);

		email = new JLabel(correo);

		if (ancho < 1) {

			ancho = 600;

		}

		if (alto < 1) {

			alto = 200;

		}

		w = ancho;

		jf = new JFrame();

		jf.getContentPane().addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				lab.setBounds(0, lab.getY(), w, lab.getHeight());

				email.setBounds(0, email.getY(), w, email.getHeight());

				lblNewLabel_1.setBounds(0, lblNewLabel_1.getY(), w, lblNewLabel_1.getHeight());

			}

		});

		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		jf.setAlwaysOnTop(true);

		jf.setIconImage(Toolkit.getDefaultToolkit().getImage(Sobre.class.getResource("/imagenes/about.png")));

		JPanel jp = new JPanel();

		jp.setSize(ancho, alto);

		jf.setSize(623, 264);

		jf.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));

		lab.setIcon(new ImageIcon(Sobre.class.getResource("/imagenes/dev.png")));

		lab.setBounds(0, 251, 862, 48);

		lab.setHorizontalAlignment(SwingConstants.CENTER);

		lab.setFont(new Font("Arial", Font.PLAIN, 20));

		jp.setLayout(null);

		jp.add(lab);

		jf.getContentPane().add(jp);

		email.setHorizontalAlignment(SwingConstants.CENTER);

		email.setIcon(new ImageIcon(Sobre.class.getResource("/imagenes/email.png")));

		email.setFont(new Font("Arial", Font.PLAIN, 20));

		email.setBounds(0, 319, 862, 42);

		jp.add(email);

		lblNewLabel_1 = new JLabel(titulo);

		lblNewLabel_1.setIcon(new ImageIcon(Sobre.class.getResource("/imagenes/created.png")));

		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);

		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));

		lblNewLabel_1.setBounds(0, 12, 862, 53);

		jp.add(lblNewLabel_1);

		jf.setVisible(true);

		jf.setLocationRelativeTo(null);

		Thread thread = new Thread(this);

		thread.start();

	}

	@Override
	public void run() {

		int y = jf.getHeight();

		while (!Thread.currentThread().isInterrupted()) {

			if (y <= (lblNewLabel_1.getHeight() + 15)) {

				y = jf.getHeight();

			}

			y -= 5;

			lab.setBounds(0, y, w, lab.getHeight());

			email.setBounds(0, y + 80, w, email.getHeight());

			try {

				Thread.sleep(sleep);

			}

			catch (InterruptedException e) {

				Thread.currentThread().interrupt();

				break;

			}

		}

	}

	public void stateChanged(ChangeEvent arg0) {

	}

	public void actionPerformed(ActionEvent arg0) {

	}

}
