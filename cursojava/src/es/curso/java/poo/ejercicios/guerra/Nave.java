package es.curso.java.poo.ejercicios.guerra;

import java.util.List;

import es.curso.java.poo.ejercicios.guerra.excepcionts.LimiteValoresException;

public class Nave extends VehiculoGuerra {
	
	/**
	 * @param nombre
	 * @param ataque
	 * @param defensa
	 * @param guerreros
	 * @param puntosVida
	 */
	public Nave(String nombre, int ataque, int defensa, List<Guerrero> guerreros, int puntosVida) {
		super(nombre, ataque, defensa, guerreros, puntosVida);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param nombre
	 * @param ataque
	 * @param defensa
	 * @param puntosVida
	 * @throws LimiteValoresException
	 */
	public Nave(String nombre, int ataque, int defensa, int puntosVida) throws LimiteValoresException {
		super(nombre, ataque, defensa, puntosVida);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param nombre
	 * @param ataque
	 * @param defensa
	 * @throws LimiteValoresException
	 */
	public Nave(String nombre, int ataque, int defensa) throws LimiteValoresException {
		super(nombre, ataque, defensa);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param nombre
	 * @throws LimiteValoresException
	 */
	public Nave(String nombre) throws LimiteValoresException {
		super(nombre);
		// TODO Auto-generated constructor stub
	}


	
	@Override
	public int atacar() {
		int ataqueTotalGuerreros = 0;
	    for (Guerrero guerrero : this.getGuerreros()) {
	    	ataqueTotalGuerreros += guerrero.getFuerza();
	    }
		return (int)(this.getAtaque()*Math.random() + ataqueTotalGuerreros * Math.random()/2);
	}

	@Override
	public int defender(int ataque) {
		int defensaTotalGuerreros = 0;
	    for (Guerrero guerrero : this.getGuerreros()) {
	    	defensaTotalGuerreros += guerrero.getResistencia();
	    }
	    int defensa = (int)(this.getAtaque()*Math.random() + defensaTotalGuerreros * Math.random()/2);
		return ataque-defensa;
	}
	
	

}
