<nav class="chapter-nav" aria-label="Navegación superior entre capítulos"><a href="../../">← Inicio</a><a class="chapter-nav__index" href="../">Recorrido</a><a class="chapter-nav__next" href="../capitulo-2/">Capítulo 2 →</a></nav>

# Capítulo 1 · Introducción

<span class="chapter-kicker">De la programación al diseño</span>

El capítulo sitúa los patrones dentro de la evolución de la programación orientada a objetos. Las clases permiten representar conceptos; el diseño determina cómo distribuyen responsabilidades, colaboran y responden cuando cambian los requisitos.

## 1.1 El problema del diseño

Un programa puede producir el resultado esperado y, aun así, resultar difícil de modificar. El problema de diseño aparece cuando una nueva regla obliga a tocar muchas clases, una decisión concreta se repite en varios lugares o ningún objeto tiene una responsabilidad clara.

Diseñar consiste en decidir:

- qué conceptos forman parte del modelo;
- qué información y comportamiento pertenece a cada objeto;
- qué dependencias deben permanecer estables;
- qué elementos pueden variar;
- y qué costo introduce cada nivel de abstracción.

## 1.2 Sobre los patrones de diseño

Un patrón nombra una solución recurrente dentro de un contexto. Incluye el problema, las fuerzas que condicionan la decisión, los participantes y las consecuencias. Por eso no debe reducirse a copiar una estructura de clases.

| Elemento del patrón | Pregunta que responde |
| --- | --- |
| Nombre | ¿Cómo podemos comunicar la solución de forma precisa? |
| Contexto | ¿En qué situación aparece el problema? |
| Problema | ¿Qué tensión o dificultad recurrente debe resolverse? |
| Fuerzas | ¿Qué restricciones y objetivos compiten entre sí? |
| Estructura UML | ¿Qué participantes colaboran y qué relaciones mantienen? |
| Consecuencias | ¿Qué flexibilidad se obtiene y qué complejidad se acepta? |
| Escenarios | ¿Cuándo aporta valor y cuándo sería excesivo? |

## 1.3 Del diseño a los patrones

Saber escribir clases no garantiza un diseño mantenible. El salto consiste en decidir qué objeto conoce cada dato, quién inicia una operación, qué dependencia puede variar y qué interfaz debe permanecer estable.

Los patrones consolidan experiencia, pero no reemplazan el análisis. Antes de elegir Factory, Observer o Decorator debe formularse el problema sin usar el nombre del patrón. Esto permite verificar si la intención del patrón coincide realmente con la necesidad.

## 1.4 Principios, prácticas y patrones

Los principios ofrecen criterios para evaluar alternativas; las buenas prácticas ayudan a controlar duplicación, complejidad accidental y conocimiento innecesario entre objetos.

| Tipo de herramienta | Función | Ejemplo |
| --- | --- | --- |
| Concepto orientado a objetos | Proporciona el lenguaje del modelo y sus relaciones. | Encapsulamiento, composición, polimorfismo. |
| Principio | Orienta una decisión y permite evaluar sus consecuencias. | Experto en información, responsabilidad única, inversión de dependencias. |
| Buena práctica | Advierte sobre una fuente habitual de complejidad. | DRY, KISS, YAGNI, Ley de Demeter. |
| Patrón de diseño | Describe una solución recurrente con participantes y colaboración conocidos. | Builder, Adapter, Observer. |

## 1.5 El papel de UML

UML permite representar las decisiones relevantes antes de perderse en detalles de implementación. En esta obra se utiliza principalmente el diagrama de clases para mostrar contratos, dependencias, composición, herencia y participantes de un patrón.

Un diagrama debe leerse junto con el enunciado del problema. La misma forma estructural puede responder a intenciones distintas: Adapter, Decorator y Proxy envuelven objetos, pero traducen, amplían y controlan respectivamente.

## 1.6 Recorrido recomendado

1. Lee el enunciado y reconoce qué parte del sistema cambia.
2. Examina el diagrama inicial y localiza acoplamiento, responsabilidades o condicionales.
3. Estudia la intención del principio o patrón.
4. Compara el diagrama propuesto con el anterior.
5. Ejecuta el ejemplo Java y sigue la colaboración entre objetos.
6. Evalúa ventajas, desventajas y escenarios antes de reutilizar la solución.

!!! note "Idea central"
    El catálogo de patrones tiene sentido después de comprender responsabilidades, cohesión, acoplamiento y encapsulamiento.

---

<nav class="chapter-nav chapter-nav--bottom" aria-label="Navegación inferior entre capítulos"><a href="../../">← Inicio</a><a class="chapter-nav__index" href="../">Recorrido</a><a class="chapter-nav__next" href="../capitulo-2/">Capítulo 2 →</a></nav>
