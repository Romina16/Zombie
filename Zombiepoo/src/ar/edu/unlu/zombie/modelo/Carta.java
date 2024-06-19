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
// retorna un string con tipo y num de carta	
	public String valorCarta() {
		return (this.tipo == null) ? ("Comodin") : ("Numero "+ this.numero.toString() + " Tipo: " + this.tipo.toString());
	}
}

