import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Square extends JButton {
	
	private static final Icon X = new ImageIcon("ic1.jpg");
	private static final Icon O = new ImageIcon("ic2.jpg");
	private static final Icon DEFAULT = new ImageIcon("ic1.jpg");
	
	private int player;
	
	public Square() {
		super();
		player = 0;
		setIcon(DEFAULT);
	}
	
	public int getPlayer() {
		return player;
	}
	
	public boolean isEmpty() {
		return player == 0;
	}
	
	public boolean set(int player) {
		if (this.player == player)
			return false;
		this.player = player;
		if (player == 1)
			setIcon(X);
		if (player == 2)
			setIcon(O);
		return true;
	}
}
