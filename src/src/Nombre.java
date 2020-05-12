package src;

public class Nombre implements Comparable<Nombre> {
	private String nombre;
	private Integer apariciones;

	public Nombre(String nombre, Integer apariciones) {
		this.nombre = nombre;
		this.apariciones = apariciones;
	}

	@Override
	public int compareTo(Nombre o) {
		return this.nombre.compareTo(o.nombre);
	};

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getApariciones() {
		return apariciones;
	}

	public void setApariciones(Integer apariciones) {
		this.apariciones = apariciones;
	}

	@Override
	public String toString() {
		return "Nombre [nombre=" + nombre + ", apariciones=" + apariciones + "]";
	}

}
