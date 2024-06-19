package ar.edu.unlu.zombie.modelo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

class Mazo {
	private Stack<Carta> mazo = new Stack<Carta>();
	
	public Mazo() {
		inicializar();
		mezclar();
	}
	
//-------------------------------------------------
//carga de mazo
	public void inicializar() { 
		for (int i= 1; i < 12; i++) { //for de numeros de carta
			Tipo[] valores = Tipo.values();//pongo valores de enum tipo en array
			for (Tipo tipoDeCarta: valores) { // for de tipo
				Carta cartaMazo = new Carta(tipoDeCarta,i); 
				mazo.add(cartaMazo); //agrego al mazo todos los tipos de un n
			}
		}
		Carta comodin = new Carta(); // comodin no tiene valor ni numero
		mazo.add(comodin); // carta nro 49
	}  
//mezclar
		public void mezclar() {
			Collections.shuffle(mazo);
		}
	
	
	
}
