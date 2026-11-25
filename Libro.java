public class Libro {
    private final String codigo;
    private final String titulo;
    private final String autor;
    private int cantidadEjemplares;

    public Libro(String codigo, String titulo, String autor, int cantidadEjemplares) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("El código del libro no puede estar vacío.");
        }
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("El título del libro no puede estar vacío.");
        }
        if (autor == null || autor.trim().isEmpty()) {
            throw new IllegalArgumentException("El autor del libro no puede estar vacío.");
        }
        if (cantidadEjemplares < 0) {
            throw new IllegalArgumentException("La cantidad de ejemplares no puede ser negativa.");
        }
        this.codigo = codigo.trim();
        this.titulo = titulo.trim();
        this.autor = autor.trim();
        this.cantidadEjemplares = cantidadEjemplares;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getCantidadEjemplares() {
        return cantidadEjemplares;
    }

    public void setCantidadEjemplares(int cantidadEjemplares) {
        if (cantidadEjemplares < 0) {
            throw new IllegalArgumentException("La cantidad de ejemplares no puede ser negativa.");
        }
        this.cantidadEjemplares = cantidadEjemplares;
    }

    @Override
    public String toString() {
        return "[" + codigo + "] \"" + titulo + "\" - " + autor + " (Ejemplares: " + cantidadEjemplares + ")";
    }
}