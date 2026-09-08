# Notas a mano sobre análisis orientado a objetos y patrones de diseño

## Complemento digital de la obra

Este repositorio reúne las implementaciones Java de la primera edición del libro de **Carlos Eduardo Orozco Garcés**, **César Jesús Pardo Calvache** y **Eydy del Carmen Suárez Brieva**. El libro desarrolla la teoría; [Pages](https://notas-a-mano-serie-de-libros.github.io/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/) concentra las explicaciones, organiza el contenido por capítulos y conecta cada concepto con sus ejemplos ejecutables.

<p align="center">
  <a href="https://github.com/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/actions/workflows/pages.yml"><img src="https://github.com/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/actions/workflows/pages.yml/badge.svg" alt="Estado de GitHub Pages"></a>
  <img src="https://img.shields.io/badge/Java-11%2B-ED8B00?logo=openjdk&amp;logoColor=white" alt="Java 11 o superior">
  <img src="https://img.shields.io/badge/Maven-Wrapper-C71A36?logo=apachemaven&amp;logoColor=white" alt="Maven Wrapper">
  <img src="https://img.shields.io/badge/Edición-Primera-1f4e79" alt="Primera edición">
  <a href="LICENSE.MD"><img src="https://img.shields.io/badge/Licencia-CC%20BY--NC%204.0-EF9421?logo=creativecommons&amp;logoColor=white" alt="Licencia Creative Commons BY-NC 4.0"></a>
</p>

<p align="center">
  <a href="https://notas-a-mano-serie-de-libros.github.io/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/">
    <img src="https://raw.githubusercontent.com/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/main/assets/qr/pages-inicio.png" width="168" alt="Código QR del complemento digital de la obra">
  </a>
  <br>
  <strong><a href="https://notas-a-mano-serie-de-libros.github.io/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/">Consultar el complemento digital</a></strong>
</p>

## Guía de instalación

Necesita **JDK 11 o posterior** y Git. El proyecto incluye Maven Wrapper, por lo que no necesita instalar Maven por separado.

```bash
git clone https://github.com/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno.git
cd 2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno
./mvnw clean test
```

En Windows PowerShell:

```powershell
git clone https://github.com/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno.git
cd 2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno
.\mvnw.cmd clean test
```

También puede abrir el repositorio mediante los botones de **GitHub Codespaces** disponibles en Pages. El entorno prepara Java y Maven automáticamente; consulte la [guía de ejecución en Codespaces](https://notas-a-mano-serie-de-libros.github.io/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/codespaces/) antes de utilizarlo por primera vez.

## Guía de ejecución de ejemplos

Sitúese en la raíz del proyecto y ejecute la clase principal del ejemplo que quiera estudiar:

```bash
./mvnw -q exec:java \
  -Dexec.mainClass=capitulo5.singleton.Cliente
```

Cada sección de [Pages](https://notas-a-mano-serie-de-libros.github.io/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/capitulos/) presenta el comando correspondiente al ejemplo explicado. Para comprobar conjuntamente todas las implementaciones, ejecute:

```bash
./mvnw -q test
```

En Windows reemplace `./mvnw` por `.\mvnw.cmd`.
