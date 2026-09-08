# Capítulo 5 · Patrones creacionales

<span class="chapter-kicker">Construir sin acoplar</span>

Los patrones creacionales separan la decisión de qué construir, cómo configurarlo y quién controla su ciclo de vida.

| Patrón | Problema que aborda | Implementación |
| --- | --- | :---: |
| Singleton · Instancia única | Controlar el acceso a una única instancia. | [Java](https://github.com/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/tree/main/src/main/java/com/corozco/libro/patrones/creacional/singleton) |
| Prototype · Prototipo | Crear a partir de un ejemplar configurado. | [Java](https://github.com/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/tree/main/src/main/java/com/corozco/libro/patrones/creacional/prototype) |
| Builder · Constructor | Construir paso a paso objetos complejos. | [Java](https://github.com/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/tree/main/src/main/java/com/corozco/libro/patrones/creacional/builder) |
| Factory · Fábrica | Delegar la selección de una implementación concreta. | [Java](https://github.com/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/tree/main/src/main/java/com/corozco/libro/patrones/creacional/factory) |
| Abstract Factory · Fábrica abstracta | Crear familias compatibles de objetos. | [Java](https://github.com/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/tree/main/src/main/java/com/corozco/libro/patrones/creacional/abstract_factory) |

## Criterio de selección

1. Confirma que el problema se encuentra en la creación.
2. Identifica qué decisión debe permanecer oculta al cliente.
3. Evalúa configuración, identidad y ciclo de vida.
4. Elige la alternativa más sencilla que proteja el punto de variación.

!!! warning "Uso responsable de Singleton"
    La unicidad introduce estado compartido y puede dificultar las pruebas. Debe responder a una restricción real, no a la conveniencia de disponer de una variable global.
