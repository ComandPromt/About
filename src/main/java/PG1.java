import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PG1 {

	static JLabel lab = new JLabel("Ram�n Jes�s G�mez Carmona");

	static JLabel email = new JLabel("smr2gocar@gmail.com");

	public static void main(String[] args) throws InterruptedException {

		JFrame jf = new JFrame("Scroll Effect");

		jf.setTitle("Sobre");

		jf.setIconImage(Toolkit.getDefaultToolkit().getImage(PG1.class.getResource("/images/about.png")));

		JPanel jp = new JPanel();

		jf.setSize(600, 350);

		jp.setSize(800, 600);

		lab.setIcon(new ImageIcon(PG1.class.getResource("/images/dev.png")));

		lab.setBounds(184, 251, 340, 48);

		lab.setHorizontalAlignment(SwingConstants.CENTER);

		lab.setFont(new Font("Arial", Font.PLAIN, 20));

		jp.setLayout(null);

		jp.add(lab);

		jf.getContentPane().add(jp);
		email.setHorizontalAlignment(SwingConstants.CENTER);
		email.setIcon(new ImageIcon(PG1.class.getResource("/images/email.png")));

		email.setFont(new Font("Arial", Font.PLAIN, 20));
		email.setBounds(194, 319, 330, 42);
		jp.add(email);

		JLabel lblNewLabel_1 = new JLabel("Programa creado por");
		lblNewLabel_1.setIcon(new ImageIcon(PG1.class.getResource("/images/created.png")));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(184, 12, 340, 53);
		jp.add(lblNewLabel_1);
		jf.setLocationRelativeTo(null);
		jf.setVisible(true);

		scrollEffect();

	}

	static void scrollEffect() throws InterruptedException {

		int x = -80;

		while (true) {

			if (x == -196) {
				x = -80;

			}

			x--;

			PG1.lab.setBounds(-120, x, 800, 600);

			PG1.email.setBounds(170, x, 300, 700);

			Thread.sleep(20);

		}

	}

}
