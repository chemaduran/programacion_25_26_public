package U4_poo.resolucion_clase.festival;

public class Cancion {
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public TipoGenero getGenero() {
		return genero;
	}

	public void setGenero(TipoGenero genero) {
		this.genero = genero;
	}

	public Cantante getAutor() {
		return autor;
	}

	public void setAutor(Cantante autor) {
		this.autor = autor;
	}

	private String titulo;
	private int duracion;
	private TipoGenero genero;
	private Cantante autor;

	@Override
	public String toString() {
		return "Cancion{" +
						"titulo='" + titulo + '\'' +
						", duracion=" + duracion +
						", genero=" + genero +
						", autor=" + autor +
						'}';
	}


}
