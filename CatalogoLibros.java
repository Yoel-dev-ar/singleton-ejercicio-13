import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CatalogoLibros {
    private static CatalogoLibros instancia;
    private final Map<String, Libro> librosPorCodigo;

    private CatalogoLibros() {
        this.librosPorCodigo = new LinkedHashMap<>();
    }

    public static CatalogoLibros getInstancia() {
        if (instancia == null) {
            instancia = new CatalogoLibros();
        }
        return instancia;
    }

    public void agregarLibro(String codigo, String titulo, String autor, int cantidad) {
        Libro nuevo = new Libro(codigo, titulo, autor, cantidad);
        if (librosPorCodigo.containsKey(nuevo.getCodigo())) {
            throw new IllegalArgumentException("Ya existe un libro con el código: " + nuevo.getCodigo());
        }
        librosPorCodigo.put(nuevo.getCodigo(), nuevo);
    }

    public List<Libro> buscarPorTitulo(String texto) {
        String filtro = texto == null ? "" : texto.trim().toLowerCase();
        List<Libro> resultados = new ArrayList<>();
        for (Libro libro : librosPorCodigo.values()) {
            if (libro.getTitulo().toLowerCase().contains(filtro)) {
                resultados.add(libro);
            }
        }
        return resultados;
    }

    public List<Libro> buscarPorAutor(String texto) {
        String filtro = texto == null ? "" : texto.trim().toLowerCase();
        List<Libro> resultados = new ArrayList<>();
        for (Libro libro : librosPorCodigo.values()) {
            if (libro.getAutor().toLowerCase().contains(filtro)) {
                resultados.add(libro);
            }
        }
        return resultados;
    }

    public void actualizarCantidad(String codigo, int nuevaCantidad) {
        if (codigo == null || !librosPorCodigo.containsKey(codigo.trim())) {
            throw new IllegalArgumentException("No se encontró el libro con código: " + codigo);
        }
        librosPorCodigo.get(codigo.trim()).setCantidadEjemplares(nuevaCantidad);
    }

    public List<Libro> listarTodos() {
        return new ArrayList<>(librosPorCodigo.values());
    }
}