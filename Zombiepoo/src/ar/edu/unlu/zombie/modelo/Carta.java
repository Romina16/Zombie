package ar.edu.unlu.zombie.modelo;

class Carta {
	private Tipo tipo;
	private Integer numero;
	
//---------------------------------------------------
//constructor carta comun
	public Carta(Tipo tip,int Numero) {
		tipo = tip;
		numero = Numero;
	}
//constructor carta comodin
	public Carta() {
		tipo = null;
		numero = 0;
	}
//---------------------------------------------------
// getters y setters
	public Tipo getTipo() {
		return tipo;
	}
	public Integer getNumero() {
		return numero;
	}
//---------------------------------------------------
// retorna un string con tipo y numero de carta	
	public String valorCarta() {
		return (this.tipo == null) ? ("Comodin") : ("Numero "+ this.numero.toString() + " Tipo: " + this.tipo.toString());
	}
//carta comodin	
	public boolean EsComodin() {
		boolean esComodin = false;
		if (this.numero == 0) {
			esComodin = true;
		}
		return esComodin;
	}
// carta compara su numero para ver si es pareja de otra carta	
	public boolean esPareja(Carta otraCarta) {
	 	boolean esPareja = false;
		if (this.numero == otraCarta.numero) {
			esPareja = true;
		}
		return esPareja;
	}
	
}

