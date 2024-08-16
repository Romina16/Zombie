package ar.edu.unlu.zombie.modelo;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.ArrayList;

import ar.edu.unlu.zombie.observador.IObservador;
import ar.edu.unlu.zombie.observador.IObservable;

public class Zombie implements IObservable {
	private Queue <Jugador> turnosJugadores = new LinkedList<Jugador>();// cola para manejar turnos
	private LinkedList<Jugador> Jugadores = new LinkedList<Jugador>();
	private Mazo mazo;
	private ArrayList<IObservador> observadores ;
	// constructor
	public Zombie() {
		turnosJugadores = new LinkedList<Jugador>();
		Jugadores = new LinkedList<Jugador>();
		mazo = new Mazo();
		observadores = new ArrayList<IObservador>();
	} 
	//DEBERIA CREAR EL JUEGO Y LUEGO ADD JUGADOR Y LUEGO INICIALIZAR?
	//----------------------------------------------------------
	//Agregar Jugador al juego
	public void agregarJugador(String nombre) {
		Jugadores.add(new Jugador(nombre));//creo Jugador nuevo
		this.notificar(Evento.AGREGAR_JUGADOR);//indica que se agrego un jugador
	}
	//Repartir
		public void Repartir() {
			LinkedList<LinkedList<Carta>> listaDeManos = new LinkedList<LinkedList<Carta>>();
			LinkedList<Carta> manoARecibir = new  LinkedList<Carta>();
			listaDeManos = mazo.repartirCartas(Jugadores.size()); // LLamo a que se repartan las cartas
			for (int indice = 0; indice < Jugadores.size(); indice++) {//entrego mano a cada jugador
				manoARecibir = listaDeManos.get(indice);
				Jugadores.get(indice).recibirMano(manoARecibir);
			}
		}
		//Descartar
		public void Descartar() {
			for (Jugador jugador : Jugadores) {
				 jugador.descarteInicial();
			}
		}
	
	//inicio
	public void inicio() {
		//Zombie juego = new Zombie();		
		this.Repartir();
		this.Descartar();
		this.notificar(Evento.DESCARTE_INICIAL_TERMINADO);
	}
	
	
//------------------------------------------------------------------------------------------------------------------------
	@Override
	public void notificar(Object Evento) {
		for(IObservador o : this.observadores) {
			o.actualizar(Evento, this);
		}
	}
	@Override
	public void agregadorObservador(IObservador observador) {
		this.observadores.add(observador);
	}
		
	
}
