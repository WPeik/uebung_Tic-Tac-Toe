
public class Main {
	//spieler speichert wer am zug ist 0 ist X 1 ist =
	static int spieler = 0;
	//speichert die symbole der spieler
	static String spielersymbol[] = {"X","O"};
	//speichert den momentanen zug
	static int anzahlzuege = 0;
	//benoetigt zur ermittlung wer gewonnen hat wird um gewinnfeld eingetragen
	static int spielerwert[] = {1,-1};
	//Die spielfelder werden als 2D array gespeichert das "speilfeld" wird den spielern angezeigt das "gewinnfeld" wird zur ermittlung des gewinners benutzt
	static String[][] spielfeld = {				//das spielfeld array ist das Spielfeld. Die Fragezeichen sollen durch X oder O ersetzt werden.
								  {"","",""},
								  {"","",""},
								  {"","",""}
								  };
	static int [][] gewinnfeld = {	
								  {0,0,0},	
								  {0,0,0},
								  {0,0,0}
								  };
	
	public static void main(String[] args) {
		//erschafft die Gui instanz
		new Gui();
	}
	
	//beanspruchung des feldes wenn ein spieler drauf drückt
	public static void aktion(int[] args) {
		
		//zeichen setzung nach wahl der spieler
		spielfeld[args[0]][args[1]] = spielersymbol[spieler];
		gewinnfeld[args[0]][args[1]] = spielerwert[spieler];
		//visuaelle aenderung
		Gui.buttonname(spielfeld);
		//wechselt den spieler
		anzahlzuege++;
		if(spieler == 0) {
			spieler++;
		}
		else {
			spieler--;
		}
		//ueberpruefung ob ein spieler gewonnen hat
		if(anzahlzuege > 4) {
			gewinncheck();
		}
	}
	
	//methode zur ueberpruefung ob ein spieler gewonnen hat
	public static void gewinncheck() {
		//speichert wer gewonnen hat
		int gewinner = -1;
		
		for(int i =0; i < 3; i++) {
			//ermittlung ob 3 gleiche in einer linie 3 oder -3 bedeutet 3 in einer linie
			int horizontal = (gewinnfeld[i][0])+(gewinnfeld[i][1])+(gewinnfeld[i][2]);
			int Vertikal = (gewinnfeld[0][i])+(gewinnfeld[1][i])+(gewinnfeld[2][i]);
			//spieler 1
			if(horizontal == 3 || Vertikal == 3){
				gewinner = 0;
			}
			//spieler 2
			if(horizontal == -3 || Vertikal == -3){
				gewinner = 1;
			}
		}
		
		//ermittlung ob drei gleiche in einer diagonale zu finden sind
		int diagonale1 =(gewinnfeld[0][0])+(gewinnfeld[1][1])+(gewinnfeld[2][2]);
		int diagonale2 = (gewinnfeld[2][0])+(gewinnfeld[1][1])+(gewinnfeld[0][2]);

		if(diagonale1 == 3 ||diagonale2  == 3){
			gewinner = 0;
		}
		if(diagonale1 == -3 || diagonale2 == -3){
			gewinner = 1;
		}
		//übermittlung an das Gui das ein spieler gewonnen hat
		if(gewinner !=-1) {
			Gui.gewinner(spielersymbol[gewinner]);
		}
		//wenn keiner gewonnen hat und acht oder mehr zuege vergangen sind dann ist es unmoglich zu gewinnen und daher ein unentschieden
		else if( anzahlzuege == 9) {
			Gui.unentschieden();
		}
	}
}








