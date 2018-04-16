import javax.swing.JPanel;
import javax.swing.JTextArea;


@SuppressWarnings("serial")
public class VueAutres extends JPanel implements Observer{
	private CModele model;
	private JTextArea txt;
	VueAutres(CModele m){
		this.model = m;
		m.addObserver(this);
		this.txt = new JTextArea("Player : 1" + "\n" + "Actions left : " + m.getCurrentPlayer().ActionsLeft());
	}
	@Override
	public void update() {
		this.txt.setText("Player : " + Integer.toString(model.getCurrentPlayer().getId()+1) + "\n" + "Actions left : " + model.getCurrentPlayer().ActionsLeft());
	}
	
	public JTextArea getTxt() {
		return this.txt;
	}

}

