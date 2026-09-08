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

### Diagrama de decisión y conexiones

<div class="pattern-decision-map" role="img" aria-label="Árbol para seleccionar un patrón creacional según la decisión de creación que cambia">
  <div class="decision-start">¿Qué cambia durante la creación?</div>
  <div class="decision-branches">
    <a class="decision-node" href="singleton/"><span>Cantidad de instancias</span><strong>Singleton</strong></a>
    <a class="decision-node" href="prototype/"><span>Estado inicial que se copia</span><strong>Prototype</strong></a>
    <a class="decision-node" href="builder/"><span>Secuencia de construcción</span><strong>Builder</strong></a>
    <a class="decision-node" href="factory/"><span>Tipo concreto de un producto</span><strong>Factory Method</strong></a>
    <a class="decision-node" href="abstract_factory/"><span>Familia completa de productos</span><strong>Abstract Factory</strong></a>
  </div>
  <p class="decision-connection-note"><strong>Conexión:</strong> Abstract Factory puede usar Factory Method para crear cada producto y Builder puede recibir productos de una fábrica cuando también debe controlar su ensamblaje.</p>
</div>

---

<nav class="chapter-nav chapter-nav--bottom" aria-label="Navegación inferior entre capítulos"><a href="../capitulo-4/">← Capítulo 4</a><a class="chapter-nav__index" href="../">Recorrido</a><a class="chapter-nav__next" href="../capitulo-6/">Capítulo 6 →</a></nav>
