public class Main {
    public static void main(String[] args) {
        // Simulamos dos pantallas usando la misma instancia Singleton
        CatalogoLibros pantallaPersonal = CatalogoLibros.getInstancia();
        CatalogoLibros pantallaConsulta = CatalogoLibros.getInstancia();

        pantallaPersonal.agregarLibro("LIB-01", "Introducción a Java", "Herbert Schildt", 4);

        // La pantalla de consulta ve el libro sin recargar nada
        System.out.println("Consulta inicial:");
        pantallaConsulta.listarTodos().forEach(System.out::println);

        pantallaPersonal.agregarLibro("LIB-02", "Patrones de Diseño", "Erich Gamma", 2);
        pantallaPersonal.actualizarCantidad("LIB-01", 6);

        System.out.println("\nBúsqueda por autor 'Gamma' desde pantalla de consulta:");
        pantallaConsulta.buscarPorAutor("Gamma").forEach(System.out::println);

        System.out.println("\nCatálogo actualizado en pantalla de consulta:");
        pantallaConsulta.listarTodos().forEach(System.out::println);
    }
}