# Capítulo 7 · Patrones de comportamiento

<span class="chapter-kicker">Coordinar colaboraciones</span>

| Patrón | Intención principal | Implementación |
| --- | --- | :---: |
| Chain of Responsibility · Cadena de responsabilidad | Pasar una solicitud por posibles receptores. | [Java](https://github.com/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/tree/main/src/main/java/com/corozco/libro/patrones/comportamiento/cadena_responsabilidad) |
| Command · Comando | Representar una petición como objeto. | [Java](https://github.com/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/tree/main/src/main/java/com/corozco/libro/patrones/comportamiento/command) |
| Iterator · Iterador | Recorrer una colección sin exponer su representación. | [Java](https://github.com/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/tree/main/src/main/java/com/corozco/libro/patrones/comportamiento/iterator) |
| Mediator · Mediador | Centralizar la coordinación entre objetos. | [Java](https://github.com/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/tree/main/src/main/java/com/corozco/libro/patrones/comportamiento/mediator) |
| Memento · Memoria | Capturar y restaurar estado. | [Java](https://github.com/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/tree/main/src/main/java/com/corozco/libro/patrones/comportamiento/memento) |
| Observer · Observador | Notificar cambios a dependientes. | [Java](https://github.com/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/tree/main/src/main/java/com/corozco/libro/patrones/comportamiento/observer) |
| State · Estado | Variar comportamiento según el estado interno. | [Java](https://github.com/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/tree/main/src/main/java/com/corozco/libro/patrones/comportamiento/state) |
| Strategy · Estrategia | Intercambiar algoritmos tras un contrato. | [Java](https://github.com/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/tree/main/src/main/java/com/corozco/libro/patrones/comportamiento/strategy) |
| Template Method · Plantilla | Fijar un proceso y variar algunos pasos. | [Java](https://github.com/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/tree/main/src/main/java/com/corozco/libro/patrones/comportamiento/template) |
| Visitor · Visitante | Añadir operaciones a una estructura estable. | [Java](https://github.com/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/tree/main/src/main/java/com/corozco/libro/patrones/comportamiento/visitor) |

## Preguntas para elegir

- Si varía un algoritmo, compara **Strategy** y **Template Method**.
- Si el comportamiento cambia con etapas internas, revisa **State**.
- Si una acción debe almacenarse o ponerse en cola, revisa **Command**.
- Si varios interesados reaccionan al mismo evento, revisa **Observer**.
- Si muchas relaciones son difíciles de seguir, revisa **Mediator**.

!!! note "La intención forma parte del patrón"
    Dos estructuras parecidas pueden resolver problemas distintos. Contexto, fuerzas y consecuencias importan tanto como el diagrama.
