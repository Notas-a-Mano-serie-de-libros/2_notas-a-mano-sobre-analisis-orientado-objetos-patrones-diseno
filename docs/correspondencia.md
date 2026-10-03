# Correspondencia entre el libro y el código

Esta guía conecta el recorrido conceptual de la primera edición con las implementaciones Java del repositorio. Los ejemplos no sustituyen la explicación del libro: permiten observar cada principio o patrón en una situación concreta.

| Capítulo | Tema | Implementación principal |
| --- | --- | --- |
| 1 | Introducción | Lectura conceptual |
| 2 | [Introducción al diseño orientado a objetos](capitulos/capitulo-2/programacion-orientada-a-objetos.md) | Pilares, diagramas UML y ejemplos en Java, Python y C++ |
| 3 | GRASP y SOLID | Próximamente · [`grasp`](https://github.com/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/tree/main/src/main/java/capitulo3/grasp) · [`solid`](https://github.com/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/tree/main/src/main/java/capitulo3/solid) |
| 4 | DRY, KISS, YAGNI y Ley de Demeter | Próximamente · [`capitulo4`](https://github.com/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/tree/main/src/main/java/capitulo4) |
| 5 | Patrones creacionales | Próximamente · [`capitulos/capitulo5`](https://github.com/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/tree/main/src/main/java/capitulo5) |
| 6 | Patrones estructurales | Próximamente · [`capitulos/capitulo6`](https://github.com/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/tree/main/src/main/java/capitulo6) |
| 7 | Patrones de comportamiento | Próximamente · [`capitulos/capitulo7`](https://github.com/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/tree/main/src/main/java/capitulo7) |
| 8 | Reflexiones finales | Síntesis y criterios de selección |

## Organización del código

```text
src/main/java/
├── capitulo3/
│   ├── grasp/
│   └── solid/
├── capitulo4/
│   ├── dry/
│   ├── kiss/
│   ├── yagni/
│   └── demeter/
├── capitulo5/          # Patrones creacionales
├── capitulo6/          # Patrones estructurales
└── capitulo7/          # Patrones de comportamiento
```

Cada directorio contiene su propio índice y los ejemplos correspondientes. Para una lectura progresiva, conviene empezar por los principios y buenas prácticas antes de comparar las tres familias de patrones.
