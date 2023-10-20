package es.curso.java.poo.ejercicios.guerra;

import java.util.ArrayList;
import java.util.List;

import es.curso.java.poo.ejercicios.guerra.excepcionts.LimiteValoresException;
import es.curso.java.poo.ejercicios.guerra.excepcionts.UnidadesPermitadasException;

public class GuerraGetafe {

	public static void main(String[] args) {
		
	}
	
	
	public void iniciarGuerra(VehiculoGuerra vehiculo) {
		
		List<Guerrero> guerrerosEnNave = new ArrayList<Guerrero>();
		VehiculoGuerra[] nave = construyeVehiculos();
		    for (VehiculoGuerra vehiculoGuerra : nave) {
		        guerrerosEnNave.addAll(vehiculoGuerra.getGuerreros());
		    }
		
		
		Nave nave1 = (Nave)nave[1];
		nave1.atacar();  
		Nave nave2 = (Nave)nave[2];
		nave2.defender();
		
		
	}

	
	VehiculoGuerra [] construyeVehiculos(){
		
		
		Nave naveGuerra1 = null;
		Nave naveGuerra2 = null;
		
		try {		
			naveGuerra1 = new Nave("Humanos", 5, 5);
			naveGuerra1.embarcarGuerrero(new Guerrero("Guerrero1", "Soldado", 7, 3));
			naveGuerra1.embarcarGuerrero(new Guerrero("Guerrero2", "Soldado", 4, 6));
			naveGuerra1.embarcarGuerrero(new Guerrero("Guerrero3", "Soldado", 5, 1));
			naveGuerra1.embarcarGuerrero(new Guerrero("Guerrero4", "Soldado", 1, 9));
			naveGuerra1.embarcarGuerrero(new Guerrero("Guerrero5", "Soldado", 4, 3));
			naveGuerra1.embarcarGuerrero(new Guerrero("Guerrero6", "Soldado", 8, 1));
			naveGuerra1.embarcarGuerrero(new Guerrero("Guerrero7", "Soldado", 2, 7));
			naveGuerra1.embarcarGuerrero(new Guerrero("Guerrero8", "Soldado", 1, 6));
			naveGuerra1.embarcarGuerrero(new Guerrero("Guerrero9", "Soldado", 2, 8));
			naveGuerra1.embarcarGuerrero(new Guerrero("Guerrero1", "Soldado", 7, 3));
			
			naveGuerra2 = new Nave("Humanos", 4, 6);
			naveGuerra2.embarcarGuerrero(new Guerrero("Guerrero1", "Soldado", 5, 5));
			naveGuerra2.embarcarGuerrero(new Guerrero("Guerrero2", "Soldado", 4, 6));
			naveGuerra2.embarcarGuerrero(new Guerrero("Guerrero3", "Soldado", 5, 4));
			naveGuerra2.embarcarGuerrero(new Guerrero("Guerrero4", "Soldado", 1, 7));
			naveGuerra2.embarcarGuerrero(new Guerrero("Guerrero5", "Soldado", 4, 5));
			naveGuerra2.embarcarGuerrero(new Guerrero("Guerrero6", "Soldado", 6, 1));
			naveGuerra2.embarcarGuerrero(new Guerrero("Guerrero7", "Soldado", 2, 8));
			naveGuerra2.embarcarGuerrero(new Guerrero("Guerrero8", "Soldado", 3, 6));
			naveGuerra2.embarcarGuerrero(new Guerrero("Guerrero9", "Soldado", 2, 8));
			naveGuerra2.embarcarGuerrero(new Guerrero("Guerrero1", "Soldado", 7, 3));

			
		}catch(LimiteValoresException e) {
			System.out.println(e.getMessage());
		}catch(UnidadesPermitadasException f) {
			System.out.println(f.getMessage());
		}
		Nave [] naves = {naveGuerra1, naveGuerra2};	
		return naves;
	}
	
	
	
	
	VehiculoGuerra vehiculosBasedeDatos(){
		
		return null;
	}
	
	
	
}
