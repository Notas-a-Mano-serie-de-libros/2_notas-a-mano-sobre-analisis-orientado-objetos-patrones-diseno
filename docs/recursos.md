# Cómo usar los ejemplos

El repositorio acompaña la primera edición con ejemplos independientes escritos en Java. Puedes leerlos directamente en GitHub, abrir el proyecto en un IDE o compilarlos con Maven.

## Requisitos

- JDK 11 o posterior.
- Git, si deseas clonar el repositorio.
- No es necesario instalar Maven: el proyecto incluye Maven Wrapper.

## Compilar y verificar

=== "macOS o Linux"

    ```bash
    ./mvnw clean test
    ```

=== "Windows"

    ```powershell
    .\mvnw.cmd clean test
    ```

## Recorrido recomendado

1. Localiza el tema en la [correspondencia libro-código](correspondencia.md).
2. Lee el `README.md` del paquete para reconocer la intención del ejemplo.
3. Compara las variantes y observa cómo cambian las responsabilidades entre clases.
4. Ejecuta la clase principal del ejemplo desde tu IDE cuando exista.
5. Regresa al capítulo y evalúa las consecuencias de aplicar la solución.

!!! tip "No memorices la estructura"
    Un patrón sirve como vocabulario de diseño y punto de partida. La decisión importante es reconocer el problema, las fuerzas en tensión y las consecuencias de la solución.

## Sitio local

Para ejecutar este complemento digital:

```bash
python -m venv .venv
.venv/bin/pip install -r requirements-docs.txt
.venv/bin/mkdocs serve
```

Abre `http://127.0.0.1:8000/` en el navegador.
