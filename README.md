<div align="center">

# Notas a mano sobre análisis orientado a objetos y patrones de diseño

### Principios, buenas prácticas y patrones de diseño con ejemplos Java

[![GitHub Pages](https://github.com/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/actions/workflows/pages.yml/badge.svg)](https://github.com/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/actions/workflows/pages.yml)
[![Java 11](https://img.shields.io/badge/Java-11-ED8B00?logo=openjdk&logoColor=white)](pom.xml)
[![Licencia CC BY-NC 4.0](https://img.shields.io/badge/Licencia-CC%20BY--NC%204.0-EF9421?logo=creativecommons&logoColor=white)](LICENSE.MD)

Material complementario de la **primera edición (2025)** de Carlos Eduardo Orozco Garcés, César Jesús Pardo Calvache y Eydy del Carmen Suárez Brieva.

[Visitar el sitio de la obra](https://notas-a-mano-serie-de-libros.github.io/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/) · [Explorar los capítulos](#ruta-de-aprendizaje) · [Empezar en local](#ejecución-local) · [Ver el libro](https://a.co/d/9rEY0dC)

</div>

---

## Complemento digital de la obra

El **libro** contiene el desarrollo conceptual completo. El **sitio de la obra** organiza la lectura por capítulos y conecta principios, prácticas y patrones con sus implementaciones. El **repositorio** conserva el código fuente; **GitHub Codespaces** permite ejecutarlo desde el navegador sin preparar un entorno local.

<p align="center">
  <a href="https://notas-a-mano-serie-de-libros.github.io/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/">
    <img src="./assets/qr/pages-inicio.png" width="168" alt="Código QR del complemento digital de la obra">
  </a>
  <br>
  <strong><a href="https://notas-a-mano-serie-de-libros.github.io/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/">Leer el complemento digital</a></strong>
</p>

La ruta recomendada es: **leer el capítulo en la obra → consultar su síntesis en Pages → abrir Codespaces desde el botón del capítulo → ejecutar y comparar las implementaciones**.

## Acerca del proyecto

La obra avanza desde los fundamentos del diseño orientado a objetos hasta la asignación de responsabilidades con GRASP, los principios SOLID, las buenas prácticas y las tres familias de patrones del catálogo GoF.

El repositorio conserva ejemplos Java independientes para observar cómo cambian el acoplamiento, la cohesión, las dependencias y la distribución de responsabilidades. La introducción y las reflexiones finales completan el recorrido editorial, mientras los capítulos 2–7 ofrecen acceso contextual a la ejecución remota.

El contenido mantiene el orden y la numeración de la primera edición. Los ejemplos acompañan la explicación del libro y no sustituyen el análisis de contexto, consecuencias y límites de cada solución.

## Empieza aquí

```bash
# Compilar y verificar todo el proyecto
./mvnw -q test

# Ejecutar un ejemplo concreto
./mvnw -q exec:java \
  -Dexec.mainClass=com.corozco.libro.patrones.creacional.singleton.Cliente
```

> [!TIP]
> Si no quieres instalar Java, abre el capítulo correspondiente en Pages y utiliza su botón **Ejecutar en GitHub Codespaces**. Necesitas una cuenta de GitHub con acceso a Codespaces; revisa la [guía de preparación y uso](docs/codespaces.md) antes de la primera apertura.

## Ejecución en GitHub Codespaces

Para ejecutar los ejemplos en el navegador necesitas una **cuenta de GitHub**, tener la sesión iniciada y disponer de acceso o cuota para GitHub Codespaces. En la primera apertura, GitHub solicitará crear y autorizar el espacio de trabajo; la preparación puede tardar algunos minutos.

El archivo `.devcontainer/devcontainer.json` instala automáticamente JDK 11 y las extensiones de Java y Maven. El repositorio incluye Maven Wrapper, por lo que no es necesario instalar Maven manualmente. Cuando se abra el entorno, espera a que termine el proceso de creación y ejecuta:

```bash
./mvnw -q test
```

La guía [Ejecutar en GitHub Codespaces](docs/codespaces.md) contiene el procedimiento completo, los comandos de verificación y las soluciones para problemas de autorización, cuota o reconstrucción del entorno.

## Ruta de aprendizaje

| Capítulo | Tema | Leer en Pages | Recursos técnicos |
| :---: | --- | :---: | :---: |
| **1** | Introducción | [Síntesis](https://notas-a-mano-serie-de-libros.github.io/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/capitulos/capitulo-1/) | Lectura |
| **2** | Diseño orientado a objetos | [Síntesis](https://notas-a-mano-serie-de-libros.github.io/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/capitulos/capitulo-2/) | [Código Java](src/main/java/com/corozco/libro/README.md) |
| **3** | Principios GRASP y SOLID | [Síntesis](https://notas-a-mano-serie-de-libros.github.io/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/capitulos/capitulo-3/) | [Ejemplos](src/main/java/com/corozco/libro/buenas_practicas/README.md) |
| **4** | Buenas prácticas de diseño | [Síntesis](https://notas-a-mano-serie-de-libros.github.io/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/capitulos/capitulo-4/) | [Ejemplos](src/main/java/com/corozco/libro/buenas_practicas/README.md) |
| **5** | Patrones creacionales | [Síntesis](https://notas-a-mano-serie-de-libros.github.io/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/capitulos/capitulo-5/) | [Ejemplos](src/main/java/com/corozco/libro/patrones/creacional/README.md) |
| **6** | Patrones estructurales | [Síntesis](https://notas-a-mano-serie-de-libros.github.io/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/capitulos/capitulo-6/) | [Ejemplos](src/main/java/com/corozco/libro/patrones/estructural/README.md) |
| **7** | Patrones de comportamiento | [Síntesis](https://notas-a-mano-serie-de-libros.github.io/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/capitulos/capitulo-7/) | [Ejemplos](src/main/java/com/corozco/libro/patrones/comportamiento/README.md) |
| **8** | Reflexiones finales | [Síntesis](https://notas-a-mano-serie-de-libros.github.io/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/capitulos/capitulo-8/) | Lectura |

## Qué encontrarás

| Recurso | Propósito |
| --- | --- |
| **Ejemplos comparativos** | Contrastar implementaciones antes y después de aplicar un principio. |
| **Principios GRASP y SOLID** | Evaluar responsabilidades, dependencias, cohesión y capacidad de extensión. |
| **Buenas prácticas** | Reconocer duplicación, complejidad accidental y conocimiento innecesario. |
| **Patrones GoF** | Estudiar intención, participantes, colaboración y consecuencias. |
| **Ejecución en Codespaces** | Compilar y ejecutar los ejemplos desde el navegador. |

## Ejecución local

### 1. Preparar el proyecto

Requiere JDK 11 o posterior. Maven Wrapper descarga la versión necesaria de Maven automáticamente.

```bash
git clone https://github.com/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno.git
cd 2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno
./mvnw clean test
```

En Windows:

```powershell
.\mvnw.cmd clean test
```

### 2. Ejecutar una implementación

```bash
./mvnw -q exec:java \
  -Dexec.mainClass=com.corozco.libro.patrones.comportamiento.observer.Cliente
```

Cada capítulo del sitio presenta un comando inicial relacionado con su contenido.

## Organización del repositorio

```text
.
├── docs/                       # Complemento digital de la primera edición
├── src/main/java/com/corozco/  # Principios, prácticas y patrones en Java
├── .devcontainer/              # Entorno reproducible para Codespaces
├── .github/workflows/          # Publicación automática en GitHub Pages
├── mkdocs.yml                  # Navegación y configuración editorial
└── pom.xml                     # Proyecto Maven con Java 11
```

<details>
<summary><strong>Alcance y fidelidad respecto de la obra</strong></summary>

Los capítulos digitales conservan los títulos, la numeración y la secuencia conceptual de la primera edición. El código permite experimentar con los conceptos, pero la decisión de aplicar un patrón depende siempre del problema, sus fuerzas y las consecuencias esperadas.

</details>

<details>
<summary><strong>Serie Notas a mano para ingenieros</strong></summary>

1. [Notas a mano sobre fundamentos en lógica y programación estructurada](https://a.co/d/aobD6ct)
2. **Notas a mano sobre análisis orientado a objetos y patrones de diseño**
3. [Notas a mano sobre análisis de complejidad computacional](https://a.co/d/02EZLscG)

</details>

## Autores

| Autor | Perfiles académicos |
| --- | --- |
| **Carlos Eduardo Orozco Garcés** | [LinkedIn](https://www.linkedin.com/in/corozco9408) · [ORCID](https://orcid.org/0000-0003-3279-4784) · [ResearchGate](https://www.researchgate.net/profile/Carlos-Orozco-41) |
| **César Jesús Pardo Calvache** | [ResearchGate](https://www.researchgate.net/profile/Cesar-Pardo-Calvache) |
| **Eydy del Carmen Suárez Brieva** | Coautora de la primera edición |

## Licencia

El material educativo y la documentación se distribuyen bajo [Creative Commons Attribution-NonCommercial 4.0 International](LICENSE.MD). Se permite compartirlos y adaptarlos con atribución, siempre que no se utilicen con fines comerciales.

<div align="center">

© 2025 Carlos Eduardo Orozco Garcés, César Jesús Pardo Calvache y Eydy del Carmen Suárez Brieva

</div>
