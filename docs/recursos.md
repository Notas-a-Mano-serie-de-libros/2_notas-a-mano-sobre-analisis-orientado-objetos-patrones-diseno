# Cómo usar los ejemplos

El repositorio acompaña la primera edición con ejemplos independientes escritos en Java. Puedes leerlos directamente en GitHub, abrir el proyecto en un IDE o compilarlos con Maven.

## Ejecutar en el navegador

Los capítulos 2–7 incluyen un botón contextual para abrir el proyecto en GitHub Codespaces. Necesitas una cuenta de GitHub con acceso a Codespaces, pero no debes instalar Java ni Maven en tu computador. El entorno prepara Java 11, Maven Wrapper y las extensiones necesarias, y verifica el proyecto automáticamente; debajo de cada botón aparece un comando inicial relacionado con el tema del capítulo.

Consulta la guía [Ejecutar en GitHub Codespaces](codespaces.md) antes de la primera apertura. Allí se explican la creación del entorno, las autorizaciones, las herramientas instaladas y la solución de problemas frecuentes.

Introducción y Reflexiones finales no muestran este control porque son capítulos de lectura y no tienen una implementación ejecutable asociada.

## Requisitos para ejecución local

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
