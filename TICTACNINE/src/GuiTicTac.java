import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class GuiTicTac implements ItemListener, ActionListener {

	boolean circle;
	JButton[][] buttonArrArr = new JButton[9][9];
	Boolean[][] emptyArrArr = new Boolean[9][9];

	JButton restart;

	Icon ic1 = new ImageIcon("ic1.jpg");
	Icon ic2 = new ImageIcon("ic2.jpg");

	public static void main(String[] args) {
		new GuiTicTac();

	}

	public GuiTicTac() {
		// we could do other non-GUI work here if needed
		initialize(); // our method to setup the GUI
	}

	private void initialize() {

		JFrame frame = new JFrame();// creating instance of JFrame
		// JCheckBox a = new JCheckBox();//creating instance of JButton
		for (int j = 0; j < 9; j++) {
			int c = 10 + (j % 3) * 160;
			int d = 10 + (j / 3) * 160;
			for (int i = 0; i < 9; i++) {
				String s = Integer.toString(i + 9 * j);
				buttonArrArr[j][i] = new JButton(s);
				int a = c + (i % 3) * 50;
				int b = d + (i / 3) * 50;
				buttonArrArr[j][i].setBounds(a, b, 50, 50);
				buttonArrArr[j][i].addActionListener(this);
				frame.add(buttonArrArr[j][i]);
				emptyArrArr[j][i] = true;
			}
		}

		// restart = new JButton("Restart");// creating instance of JButton
		// restart.setBounds(230, 400, 100, 30);// x axis, y axis, width, height
		// restart.addActionListener(this);
		// frame.add(restart);// adding button in JFrame

		frame.setSize(530, 540);// 400 width and 500 height
		frame.setLayout(null);// using no layout managers
		frame.setVisible(true);// making the frame visible

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton but = (JButton) e.getSource();
		int i = Integer.parseInt(but.getText())%9;
		int j = Integer.parseInt(but.getText())/9;

		if (emptyArrArr[i][j]) {
			if (circle) {
				but.setIcon(ic1);
				circle = false;
			} else {
				but.setIcon(ic2);
				circle = true;
			}
		}
		emptyArrArr[i][j] = false;

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub

	}
}
