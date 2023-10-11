package es.curso.java.poo.ejercicios.dispositivos;

public class Usuario {
	
	private Movil movil;
	private Moto moto;
	private Coche coche;
	private Television television;
	
	
	
	public Usuario() {
		super();
	}

	public Usuario(Movil movil, Moto moto, Coche coche, Television television) {
		super();
		this.movil = movil;
		this.moto = moto;
		this.coche = coche;
		this.television = television;
	}

	public static void main(String[] args) {
		
		Usuario usuario1 = new Usuario();
		usuario1.dispositivosUsuario();
		
		
	}
	
	public void dispositivosUsuario() {
		
		Coche coche1 = new Coche (1,"2039DYC","Opel",4);
		Moto moto1 = new Moto (2,"3847DSH","Vespa",2);
		Movil movil1 = new Movil (3, 480.90,"Samsung", "Android");
		Television television1 = new Television (4,975.50,"LG",3);
		
//		Usuario usuario1 = new Usuario (movil1,moto1,coche1,television1);
//		usuario1.movil.encender();
//		usuario1.moto.encender();
//		usuario1.coche.encender();
//		usuario1.television.encender();
		
		encenderDispositivo(movil1);
		encenderDispositivo(moto1);
		encenderDispositivo(coche1);
		encenderDispositivo(television1);
		
	}
	
	public void encenderDispositivo(SistemaEncendido dispositivo) {
		dispositivo.encender();
	}

}
