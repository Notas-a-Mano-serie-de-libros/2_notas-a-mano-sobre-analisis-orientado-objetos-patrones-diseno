# Ejecutar en GitHub Codespaces

GitHub Codespaces permite compilar y ejecutar los ejemplos desde el navegador. La primera apertura puede tardar algunos minutos porque GitHub debe crear el espacio de trabajo, descargar la imagen de desarrollo y preparar las dependencias del proyecto.

## Antes de comenzar

Las siguientes vistas de referencia muestran qué buscar en cada pantalla. La interfaz puede variar ligeramente según el tema, el idioma y las opciones de la cuenta de GitHub.

Necesitas:

- una [cuenta de GitHub](https://github.com/signup), con la sesión iniciada;
- acceso a GitHub Codespaces en esa cuenta y minutos disponibles dentro de su cuota;
- autorizar la creación del Codespace cuando GitHub lo solicite.

No necesitas instalar Java, Maven ni Visual Studio Code en tu computador para usar esta modalidad.

## Qué instala el entorno

El repositorio incluye una configuración reproducible en `.devcontainer/devcontainer.json`. Al crear el Codespace, GitHub prepara automáticamente:

- JDK 11;
- Maven Wrapper, incluido en el repositorio;
- la extensión de Java para Visual Studio Code;
- la extensión de Maven para Visual Studio Code;
- las dependencias declaradas en `pom.xml`.

Al finalizar la creación se ejecuta `./mvnw -q test` para comprobar que el proyecto compile correctamente. La descarga inicial de la imagen y de las dependencias solo es necesaria al crear o reconstruir el entorno.

## Abrir y preparar el proyecto

1. Inicia sesión en GitHub.

<figure class="codespaces-screenshot">
  <img src="../assets/images/codespaces/01-repositorio.svg" alt="Repositorio de GitHub con el botón Code resaltado">
  <figcaption>Vista de referencia del paso 1: repositorio del libro y botón <strong>Code</strong>.</figcaption>
</figure>

2. Desde el capítulo que estás leyendo, selecciona **Ejecutar en GitHub Codespaces**.

<figure class="codespaces-screenshot">
  <img src="../assets/images/codespaces/02-code-dropdown.svg" alt="Menú Code de GitHub con la opción Codespaces resaltada">
  <figcaption>Vista de referencia del paso 2: menú <strong>Code</strong> y opción <strong>Codespaces</strong>.</figcaption>
</figure>

3. En la pantalla de GitHub, selecciona **Create codespace**. Si aparece una solicitud de autorización o aceptación de condiciones, complétala con tu cuenta.

<figure class="codespaces-screenshot">
  <img src="../assets/images/codespaces/03-creando-codespace.svg" alt="Pantalla de creación de Codespaces con la instalación del entorno en progreso">
  <figcaption>Vista de referencia del paso 3: GitHub prepara el contenedor, JDK y extensiones.</figcaption>
</figure>

4. Espera hasta que se abra el editor y termine el proceso de creación mostrado en la terminal.

<figure class="codespaces-screenshot">
  <img src="../assets/images/codespaces/04-terminal-pruebas.svg" alt="Editor de Codespaces con una terminal que muestra BUILD SUCCESS">
  <figcaption>Vista de referencia del paso 4: terminal del editor lista para ejecutar los ejemplos.</figcaption>
</figure>

5. Abre una terminal dentro de Codespaces y verifica el proyecto:

```bash
java -version
./mvnw -version
./mvnw -q test
```

La salida esperada termina con `BUILD SUCCESS`. Si modificas archivos y quieres conservarlos, consulta la siguiente sección antes de cerrar el Codespace.

Después ejecuta el comando indicado debajo del botón del capítulo. Por ejemplo:

```bash
./mvnw -q exec:java \
  -Dexec.mainClass=com.corozco.libro.patrones.creacional.singleton.Cliente
```

## Si GitHub solicita publicar una rama

Para ejecutar los ejemplos no es necesario publicar una rama. Ese aviso aparece cuando modificas archivos dentro del Codespace y quieres conservar o enviar esos cambios al repositorio. Puedes omitirlo si solo estás leyendo y ejecutando el código.

Si quieres guardar tus modificaciones, crea una bifurcación (*fork*) en tu propia cuenta y publica allí la rama. Solo los colaboradores con permisos de escritura pueden enviar cambios directamente al repositorio oficial.

<figure class="codespaces-screenshot">
  <img src="../assets/images/codespaces/05-publicar-rama.svg" alt="Panel Source Control de Codespaces con el botón Publish Branch resaltado">
  <figcaption>Vista de referencia: <strong>Publish Branch</strong> solo es necesario para enviar cambios a tu repositorio o bifurcación.</figcaption>
</figure>

## Solución de problemas

Si la creación no termina o faltan herramientas:

1. abre la paleta de comandos con ++ctrl+shift+p++;
2. ejecuta **Codespaces: Rebuild Container**;
3. espera a que finalice la reconstrucción;
4. vuelve a ejecutar `./mvnw -q test`.

<figure class="codespaces-screenshot">
  <img src="../assets/images/codespaces/06-rebuild-container.svg" alt="Paleta de comandos con Codespaces Rebuild Container seleccionado">
  <figcaption>Vista de referencia de la reconstrucción del contenedor desde la paleta de comandos.</figcaption>
</figure>

Si GitHub informa que no hay cuota disponible, revisa la sección **Billing and plans → Codespaces** de tu cuenta o ejecuta el proyecto [en un entorno local](recursos.md#requisitos-para-ejecucion-local).
