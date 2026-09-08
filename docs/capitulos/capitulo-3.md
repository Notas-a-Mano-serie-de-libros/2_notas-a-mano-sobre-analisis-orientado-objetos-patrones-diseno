# Capítulo 3 · Principios de diseño

<span class="chapter-kicker">GRASP y SOLID</span>

GRASP orienta la asignación de responsabilidades. SOLID ayuda a conservar módulos enfocados, sustituibles y dependientes de contratos estables.

## Principios GRASP

| Principio | Pregunta de diseño |
| --- | --- |
| Creator · Creador | ¿Quién posee la información o la relación necesaria para crear el objeto? |
| Information Expert · Experto en información | ¿Quién conoce los datos necesarios para cumplir la responsabilidad? |
| High Cohesion · Alta cohesión | ¿Las responsabilidades del elemento permanecen enfocadas? |
| Low Coupling · Bajo acoplamiento | ¿Cuántas decisiones externas necesita conocer? |
| Controller · Controlador | ¿Quién recibe y coordina un evento del sistema? |
| Polymorphism · Polimorfismo | ¿La variación puede expresarse mediante un contrato común? |
| Pure Fabrication · Fabricación pura | ¿Hace falta un servicio que no representa una entidad del dominio? |
| Indirection · Indirección | ¿Un intermediario puede separar dos elementos? |
| Protected Variations · Variaciones protegidas | ¿Qué punto de cambio necesita una frontera estable? |

[Ver ejemplos GRASP](https://github.com/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/tree/main/src/main/java/com/corozco/libro/buenas_practicas/grasp){ .md-button .md-button--primary }

## Principios SOLID

| Principio | Idea central |
| --- | --- |
| SRP · Responsabilidad única | Un módulo debe tener una razón principal para cambiar. |
| OCP · Abierto/cerrado | Extender comportamiento sin modificar continuamente el núcleo estable. |
| LSP · Sustitución de Liskov | Un subtipo debe conservar las expectativas del contrato base. |
| ISP · Segregación de interfaces | Los clientes dependen de contratos pequeños y específicos. |
| DIP · Inversión de dependencias | Políticas y detalles dependen de abstracciones. |

[Ver ejemplos SOLID](https://github.com/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/tree/main/src/main/java/com/corozco/libro/buenas_practicas/solid){ .md-button .md-button--primary }

!!! warning "No son una lista de comprobación mecánica"
    Los principios pueden entrar en tensión. El objetivo es un diseño proporcionado al problema, no maximizar cada regla de forma aislada.
