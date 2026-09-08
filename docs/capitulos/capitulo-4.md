# Capítulo 4 · Buenas prácticas de diseño

<span class="chapter-kicker">Simplicidad y límites</span>

| Práctica | Pregunta útil | Ejemplo Java |
| --- | --- | --- |
| DRY | ¿Este conocimiento está definido en más de un lugar? | [Abrir](https://github.com/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/tree/main/src/main/java/com/corozco/libro/buenas_practicas/dry) |
| KISS | ¿Existe una solución más directa que conserve el propósito? | [Abrir](https://github.com/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/tree/main/src/main/java/com/corozco/libro/buenas_practicas/kiss) |
| YAGNI | ¿La necesidad es real y actual? | [Abrir](https://github.com/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/tree/main/src/main/java/com/corozco/libro/buenas_practicas/yagni) |
| Ley de Demeter | ¿El objeto habla solo con colaboradores cercanos? | [Abrir](https://github.com/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/tree/main/src/main/java/com/corozco/libro/buenas_practicas/demeter) |

## DRY

*Don't Repeat Yourself* se refiere a una única representación autorizada de cada conocimiento. La primera edición lo aplica a código, información, documentación, negocio y proceso de desarrollo.

## KISS

*Keep It Simple* favorece soluciones que puedan explicarse y mantenerse sin estructuras innecesarias. Simple no significa incompleto: cada elemento debe justificar su existencia.

## YAGNI

*You Aren't Gonna Need It* invita a posponer capacidades especulativas. Implementar cuando existe evidencia reduce supuestos y costo de mantenimiento.

## Ley de Demeter

El principio del mínimo conocimiento limita cuánto sabe un objeto sobre la estructura interna de otros y evita cadenas de navegación frágiles.
