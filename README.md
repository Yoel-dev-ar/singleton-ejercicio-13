Ejercicio 3: Catálogo Compartido de Libros (Patrón Singleton)
Temática
Gestión de Biblioteca — Sincronización de altas, búsquedas y existencias de libros entre las pantallas de personal y consulta.

Consigna

Catálogo Compartido de Libros

Contexto del problema: Una biblioteca dispone de dos pantallas: una para el personal y otra para consultar el catálogo. Cada pantalla mantiene su propia lista de libros, por lo que los títulos incorporados por el personal no aparecen inmediatamente en la consulta.

Objetivo de aprendizaje: Administrar una colección compartida mediante una instancia Singleton con operaciones controladas.

Requisitos funcionales:

Incorporar libros con código único, título, autor y cantidad de ejemplares.

Buscar libros por título o autor.

Actualizar la cantidad de ejemplares de un libro.

Consultar desde ambas pantallas el mismo catálogo actualizado.

Restricciones técnicas:

El catálogo debe administrarse mediante una única instancia Singleton.

No se deben aceptar códigos duplicados, títulos vacíos ni cantidades negativas.

La colección de libros debe permanecer encapsulada.

Se debe demostrar que un libro agregado desde la pantalla del personal aparece en la pantalla de consulta sin volver a cargar los datos.



Explicación lógica
Atributos: En la clase CatalogoLibros se declara librosPorCodigo (private final Map<String, Libro>) para almacenar los libros indexados por su código único y instancia (private static CatalogoLibros) para compartir el mismo catálogo entre ambas pantallas.

Instancia única: El constructor private impide crear catálogos paralelos con new, mientras que getInstancia() garantiza que tanto la pantalla del personal como la de consulta operen sobre el mismo estado en memoria.

Asignación y Acceso: En Main, la pantalla del personal agrega libros y actualiza cantidades de ejemplares validando códigos únicos, títulos no vacíos y cantidades no negativas; al consultar o buscar por título o autor desde la otra pantalla, los cambios aparecen al instante sin recargar datos.

Estructura del ejercicio
Libro.java: Representa cada libro con código único, título, autor y cantidad de ejemplares validada.

CatalogoLibros.java: Implementa el Singleton con altas controladas, búsquedas y actualización de stock.

Main.java: Simula la interacción entre pantalla de personal y de consulta sobre la misma instancia.