
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
@SuppressWarnings("serial")

public class Gui extends JFrame implements ActionListener{
	
	static JButton button0;
	static JButton button1;
	static JButton button2;
	static JButton button3;
	static JButton button4;
	static JButton button5;
	static JButton button6;
	static JButton button7;
	static JButton button8;
	static JLabel text;
	static JLabel fueller1;
	static JLabel fueller2;
	Gui(){
		
		this.setVisible(true);
		this.setResizable(false);
		this.setSize(600,600);
		this.setTitle("Tic-Tac-Toe");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Font einstellungen des textes
		UIManager.put("Button.font", new Font("Arial", Font.BOLD, 80));
		UIManager.put("Label.font", new Font("Arial", Font.BOLD, 25));
		//alles wird in ein raster 4 hoch und 3 weit einsotiert
		GridLayout grid = new GridLayout(4, 3);
		
		//im text label soll angegeben werden wer gewonnen hat die anderen beiden sind nur dafuer da damit das text label in der mitte ist
		this.setLayout(grid);
		fueller1 = new JLabel();
		this.add(fueller1);
		text = new JLabel("", SwingConstants.CENTER);
		this.add(text);
		fueller2 = new JLabel();
		this.add(fueller2);


		// erstellung aller knoepfe und hinzufuegen deren action listener
		button0 = new JButton(Main.spielfeld[0][0]);
		button0.addActionListener (this);
		this.add(button0);
		button1 = new JButton(Main.spielfeld[0][1]);
		button1.addActionListener (this);
		this.add(button1);
		button2 = new JButton(Main.spielfeld[0][2]);
		button2.addActionListener (this);
		this.add(button2);
		button3 = new JButton(Main.spielfeld[1][0]);
		button3.addActionListener (this);
		this.add(button3);
		button4 = new JButton(Main.spielfeld[1][1]);
		button4.addActionListener (this);
		this.add(button4);
		button5 = new JButton(Main.spielfeld[1][2]);
		button5.addActionListener (this);
		this.add(button5);
		button6 = new JButton(Main.spielfeld[2][0]);
		button6.addActionListener (this);
		this.add(button6);
		button7 = new JButton(Main.spielfeld[2][1]);
		button7.addActionListener (this);
		this.add(button7);
		button8 = new JButton(Main.spielfeld[2][2]);
		button8.addActionListener (this);
		this.add(button8);
	}
	
	//methode fuer wenn einer der knoepfe gedrueckt wird
	public void actionPerformed(ActionEvent e) {
		//knopf wird ausgeschaltet und die aktion methode wird mit der position des knopfes aufgerufen
		if(e.getSource()==button0) {
			int knopfposi[] = {0,0};
			Main.aktion(knopfposi);
			button0.setEnabled(false);
		}
		if(e.getSource()==button1) {
			int knopfposi[] = {0,1};
			Main.aktion(knopfposi);
			button1.setEnabled(false);
		}
		if(e.getSource()==button2) {
			int knopfposi[] = {0,2};
			Main.aktion(knopfposi);
			button2.setEnabled(false);
		}
		if(e.getSource()==button3) {
			int knopfposi[] = {1,0};
			Main.aktion(knopfposi);
			button3.setEnabled(false);
		}
		if(e.getSource()==button4) {
			int knopfposi[] = {1,1};
			Main.aktion(knopfposi);
			button4.setEnabled(false);
		}
		if(e.getSource()==button5) {
			int knopfposi[] = {1,2};
			Main.aktion(knopfposi);
			button5.setEnabled(false);
		}
		if(e.getSource()==button6) {
			int knopfposi[] = {2,0};
			Main.aktion(knopfposi);
			button6.setEnabled(false);
		}
		if(e.getSource()==button7) {
			int knopfposi[] = {2,1};
			Main.aktion(knopfposi);
			button7.setEnabled(false);
		}
		if(e.getSource()==button8) {
			int knopfposi[] = {2,2};
			Main.aktion(knopfposi);
			button8.setEnabled(false);
		}
	}
	//methode zur aenderung des textes der knoepfe z.B. von nichts zu X oder O
	public static void buttonname(String[][] spielfeld) {
		Gui.button0.setText(spielfeld[0][0]);
		Gui.button1.setText(spielfeld[0][1]);
		Gui.button2.setText(spielfeld[0][2]);
		Gui.button3.setText(spielfeld[1][0]);
		Gui.button4.setText(spielfeld[1][1]);
		Gui.button5.setText(spielfeld[1][2]);
		Gui.button6.setText(spielfeld[2][0]);
		Gui.button7.setText(spielfeld[2][1]);
		Gui.button8.setText(spielfeld[2][2]);
	}
	//anzeige wer gewonnen hat
	public static void gewinner(String args) {
		Gui.text.setText(args +" hat gewonnen");
	}
	public static void unentschieden() {
		Gui.text.setText("Unentschieden");
	}
}