# Correspondencia entre el libro y el código

Esta guía conecta el recorrido conceptual de la primera edición con las implementaciones Java del repositorio. Los ejemplos no sustituyen la explicación del libro: permiten observar cada principio o patrón en una situación concreta.

| Capítulo | Tema | Implementación principal |
| --- | --- | --- |
| 1 | Introducción | Lectura conceptual |
| 2 | Diseño orientado a objetos | Ejemplos distribuidos en los paquetes del proyecto |
| 3 | GRASP y SOLID | [`buenas_practicas/grasp`](https://github.com/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/tree/main/src/main/java/com/corozco/libro/buenas_practicas/grasp) y [`buenas_practicas/solid`](https://github.com/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/tree/main/src/main/java/com/corozco/libro/buenas_practicas/solid) |
| 4 | DRY, KISS, YAGNI y Ley de Demeter | [`buenas_practicas`](https://github.com/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/tree/main/src/main/java/com/corozco/libro/buenas_practicas) |
| 5 | Patrones creacionales | [`patrones/creacional`](https://github.com/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/tree/main/src/main/java/com/corozco/libro/patrones/creacional) |
| 6 | Patrones estructurales | [`patrones/estructural`](https://github.com/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/tree/main/src/main/java/com/corozco/libro/patrones/estructural) |
| 7 | Patrones de comportamiento | [`patrones/comportamiento`](https://github.com/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/tree/main/src/main/java/com/corozco/libro/patrones/comportamiento) |
| 8 | Reflexiones finales | Síntesis y criterios de selección |

## Organización del código

```text
src/main/java/com/corozco/libro/
├── buenas_practicas/
│   ├── grasp/
│   ├── solid/
│   ├── dry/
│   ├── kiss/
│   ├── yagni/
│   └── demeter/
└── patrones/
    ├── creacional/
    ├── estructural/
    └── comportamiento/
```

Cada directorio contiene su propio índice y los ejemplos correspondientes. Para una lectura progresiva, conviene empezar por los principios y buenas prácticas antes de comparar las tres familias de patrones.

