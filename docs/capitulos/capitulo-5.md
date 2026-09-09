<nav class="chapter-nav" aria-label="Navegación superior entre capítulos"><a href="../capitulo-4/">← Capítulo 4</a><a class="chapter-nav__index" href="../">Recorrido</a><a class="chapter-nav__next" href="../capitulo-6/">Capítulo 6 →</a></nav>

# Capítulo 5 · Patrones creacionales

<span class="chapter-kicker">Páginas 171–208</span>

## Recorrido del capítulo

Los patrones creacionales aíslan decisiones de instanciación y construcción: controlan identidad, clonación, construcción progresiva, selección del producto y compatibilidad entre familias sin acoplar el cliente a clases concretas.

<nav class="chapter-outline chapter-outline--pages chapter-outline--patterns" aria-label="Secciones del capítulo">
<strong>Secciones del capítulo</strong>
<ol class="chapter-section-list">
<li><a href="singleton/"><span>5.3.1 Singleton</span><small>Leer sección →</small></a></li>
<li><a href="prototype/"><span>5.3.2 Prototype</span><small>Leer sección →</small></a></li>
<li><a href="builder/"><span>5.3.3 Builder</span><small>Leer sección →</small></a></li>
<li><a href="factory/"><span>5.3.4 Factory Method</span><small>Leer sección →</small></a></li>
<li><a href="abstract_factory/"><span>5.3.5 Abstract Factory</span><small>Leer sección →</small></a></li>
</ol>
</nav>

---

## 5.4 Tabla comparativa de decisión

| Familia de decisión | Patrones | Pregunta clave para decidir |
| --- | --- | --- |
| Controlar identidad | **Singleton** | ¿El dominio exige una única instancia o solo se busca un acceso global cómodo? |
| Reutilizar un estado inicial | **Prototype** | ¿Conviene copiar un objeto ya configurado y está definida la profundidad de la copia? |
| Construir por etapas | **Builder** | ¿La creación tiene pasos, opciones o combinaciones que un constructor no expresa con claridad? |
| Elegir un producto | **Factory Method** | ¿Un creador especializado debe decidir qué producto concreto entregar? |
| Elegir una familia compatible | **Abstract Factory** | ¿Deben cambiar juntos varios tipos de productos relacionados sin permitir combinaciones incompatibles? |
| Comparar mecanismos de creación | **Factory Method vs. Abstract Factory vs. Builder** | ¿Varía un producto, una familia completa o el proceso paso a paso con el que se construye? |

### Mapa de relaciones entre patrones creacionales

<figure class="pattern-relationship-map">
  <object data="../../assets/diagrams/patrones-creacionales.svg" type="image/svg+xml" aria-label="Mapa navegable de relaciones entre Singleton, Prototype, Builder, Factory Method y Abstract Factory">
    <img src="../../assets/diagrams/patrones-creacionales.svg" alt="Mapa de relaciones entre Singleton, Prototype, Builder, Factory Method y Abstract Factory">
  </object>
  <figcaption>Las flechas expresan colaboración o alternativas de implementación; cada patrón conserva una intención diferente.</figcaption>
</figure>

---

<nav class="chapter-nav chapter-nav--bottom" aria-label="Navegación inferior entre capítulos"><a href="../capitulo-4/">← Capítulo 4</a><a class="chapter-nav__index" href="../">Recorrido</a><a class="chapter-nav__next" href="../capitulo-6/">Capítulo 6 →</a></nav>
