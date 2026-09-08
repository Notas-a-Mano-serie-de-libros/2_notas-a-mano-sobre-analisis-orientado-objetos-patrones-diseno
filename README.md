<div align="center">

# Notas a mano sobre análisis orientado a objetos y patrones de diseño

**Primera edición · 2025**

Carlos Eduardo Orozco Garcés · César Jesús Pardo Calvache · Eydy del Carmen Suárez Brieva

[![Java 11](https://img.shields.io/badge/Java-11-1b365d.svg)](pom.xml)
[![GitHub Pages](https://github.com/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/actions/workflows/pages.yml/badge.svg)](https://github.com/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/actions/workflows/pages.yml)
[![Licencia CC BY--NC 4.0](https://img.shields.io/badge/Licencia-CC_BY--NC_4.0-b66a3c.svg)](LICENSE.MD)

[Complemento digital](https://notas-a-mano-serie-de-libros.github.io/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/) · [Explorar los ejemplos](src/main/java/com/corozco/libro/README.md)

</div>

Este repositorio reúne el complemento digital y las implementaciones Java que acompañan la primera edición de la obra. El recorrido combina fundamentos de orientación a objetos, criterios de asignación de responsabilidades, buenas prácticas y los patrones clásicos de diseño.

## Contenido

| Bloque de la obra | Recursos del repositorio |
| --- | --- |
| Principios de diseño | [GRASP](src/main/java/com/corozco/libro/buenas_practicas/grasp/README.md) y [SOLID](src/main/java/com/corozco/libro/buenas_practicas/solid/README.md) |
| Buenas prácticas | [DRY, KISS, YAGNI y Ley de Demeter](src/main/java/com/corozco/libro/buenas_practicas/README.md) |
| Patrones creacionales | [Singleton, Prototype, Builder, Factory y Abstract Factory](src/main/java/com/corozco/libro/patrones/creacional/README.md) |
| Patrones estructurales | [Adapter, Bridge, Composite, Decorator, Facade, Flyweight y Proxy](src/main/java/com/corozco/libro/patrones/estructural/README.md) |
| Patrones de comportamiento | [Diez patrones de interacción y responsabilidad](src/main/java/com/corozco/libro/patrones/comportamiento/README.md) |

La [correspondencia libro-código](docs/correspondencia.md) permite localizar cada conjunto de ejemplos siguiendo el orden de los capítulos.

## Compilar los ejemplos

Requiere JDK 11 o posterior. El proyecto incluye Maven Wrapper, por lo que no hace falta instalar Maven globalmente.

```bash
./mvnw clean test
```

En Windows:

```powershell
.\mvnw.cmd clean test
```

Los ejemplos están organizados por paquete y pueden ejecutarse también desde IntelliJ IDEA, Eclipse o Visual Studio Code.

## Ejecutar el complemento digital

```bash
python -m venv .venv
.venv/bin/pip install -r requirements-docs.txt
.venv/bin/mkdocs serve
```

El sitio se publica mediante GitHub Actions en GitHub Pages cuando se actualiza la rama `main`.

## Estructura

```text
.
├── docs/                       # Complemento digital de la primera edición
├── src/main/java/com/corozco/  # Principios, prácticas y patrones en Java
├── .github/workflows/pages.yml # Publicación en GitHub Pages
├── mkdocs.yml                  # Navegación y configuración editorial
└── pom.xml                     # Proyecto Maven con Java 11
```

## Licencia

El material educativo y la documentación se distribuyen bajo [CC BY-NC 4.0](LICENSE.MD). Consulta el archivo de licencia para conocer las condiciones de uso y atribución.
