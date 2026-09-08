# Capítulo 6 · Patrones estructurales

<span class="chapter-kicker">Componer y adaptar</span>

| Patrón | Intención principal | Implementación |
| --- | --- | :---: |
| Adapter · Adaptador | Compatibilizar interfaces distintas. | [Java](https://github.com/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/tree/main/src/main/java/com/corozco/libro/patrones/estructural/adapter) |
| Bridge · Puente | Separar abstracción e implementación. | [Java](https://github.com/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/tree/main/src/main/java/com/corozco/libro/patrones/estructural/bridge) |
| Composite · Compuesto | Tratar elementos y grupos de forma uniforme. | [Java](https://github.com/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/tree/main/src/main/java/com/corozco/libro/patrones/estructural/composite) |
| Decorator · Decorador | Añadir responsabilidades mediante envolturas. | [Java](https://github.com/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/tree/main/src/main/java/com/corozco/libro/patrones/estructural/decorator) |
| Facade · Fachada | Simplificar la entrada a un subsistema. | [Java](https://github.com/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/tree/main/src/main/java/com/corozco/libro/patrones/estructural/facade) |
| Flyweight · Peso ligero | Compartir estado para reducir recursos. | [Java](https://github.com/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/tree/main/src/main/java/com/corozco/libro/patrones/estructural/flyweight) |
| Proxy · Intermediario | Controlar el acceso a otro objeto. | [Java](https://github.com/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/tree/main/src/main/java/com/corozco/libro/patrones/estructural/proxy) |

## Cómo distinguirlos

- **Adapter** cambia la interfaz que ve el cliente.
- **Decorator** conserva la interfaz y añade comportamiento.
- **Facade** ofrece una entrada simplificada a varias piezas.
- **Proxy** representa al objeto real y controla su acceso.
- **Composite** unifica el tratamiento de hojas y agrupaciones.
- **Bridge** separa dos dimensiones que deben variar independientemente.
- **Flyweight** comparte el estado común entre muchos objetos.
