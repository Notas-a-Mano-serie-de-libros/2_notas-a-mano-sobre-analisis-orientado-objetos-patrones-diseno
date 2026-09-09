<nav class="chapter-nav" aria-label="Navegación superior entre capítulos"><a href="../capitulo-5/">← Capítulo 5</a><a class="chapter-nav__index" href="../">Recorrido</a><a class="chapter-nav__next" href="../capitulo-7/">Capítulo 7 →</a></nav>

# Capítulo 6 · Patrones estructurales

<span class="chapter-kicker">Páginas 209–248</span>

## Recorrido del capítulo

Los patrones estructurales organizan la composición de clases y objetos para adaptar contratos, separar dimensiones de cambio, formar árboles, añadir responsabilidades, simplificar subsistemas, compartir estado o controlar accesos.

<nav class="chapter-outline chapter-outline--pages chapter-outline--patterns" aria-label="Secciones del capítulo">
<strong>Secciones del capítulo</strong>
<ol class="chapter-section-list">
<li><a href="adapter/"><span>6.3.1 Adapter</span><small>Leer sección →</small></a></li>
<li><a href="bridge/"><span>6.3.2 Bridge</span><small>Leer sección →</small></a></li>
<li><a href="composite/"><span>6.3.3 Composite</span><small>Leer sección →</small></a></li>
<li><a href="decorator/"><span>6.3.4 Decorator</span><small>Leer sección →</small></a></li>
<li><a href="facade/"><span>6.3.5 Facade</span><small>Leer sección →</small></a></li>
<li><a href="flyweight/"><span>6.3.6 Flyweight</span><small>Leer sección →</small></a></li>
<li><a href="proxy/"><span>6.3.7 Proxy</span><small>Leer sección →</small></a></li>
</ol>
</nav>

---

## 6.4 Tabla comparativa de decisión

| Familia de decisión | Patrones | Pregunta clave para decidir |
| --- | --- | --- |
| Compatibilidad | **Adapter** | ¿Debe traducirse una interfaz existente a otra que el cliente ya comprende? |
| Dimensiones independientes | **Bridge** | ¿Abstracción e implementación forman dos ejes de cambio que deben combinarse sin multiplicar subclases? |
| Estructuras parte–todo | **Composite** | ¿Hojas y grupos deben tratarse uniformemente dentro de un árbol? |
| Responsabilidades dinámicas | **Decorator** | ¿Debe añadirse comportamiento a una instancia, incluso combinándolo en tiempo de ejecución? |
| Acceso simplificado | **Facade** | ¿El cliente necesita una entrada pequeña y coordinada a un subsistema complejo? |
| Estado compartido | **Flyweight** | ¿Muchas instancias repiten estado intrínseco inmutable que puede compartirse? |
| Acceso controlado | **Proxy** | ¿Debe controlarse, retrasarse, protegerse o registrarse el acceso al objeto real? |
| Comparar envoltorios | **Adapter vs. Decorator vs. Proxy** | ¿Se traduce el contrato, se amplía la responsabilidad o se conserva el contrato para controlar el acceso? |

### Mapa de relaciones entre patrones estructurales

<figure class="pattern-relationship-map">
  <object data="../../assets/diagrams/patrones-estructurales.svg" type="image/svg+xml" aria-label="Mapa navegable de relaciones entre Adapter, Bridge, Composite, Decorator, Facade, Flyweight y Proxy">
    <img src="../../assets/diagrams/patrones-estructurales.svg" alt="Mapa de relaciones entre Adapter, Bridge, Composite, Decorator, Facade, Flyweight y Proxy">
  </object>
  <figcaption>El mapa distingue las variantes de envoltura y muestra cómo pueden colaborar dentro de estructuras mayores.</figcaption>
</figure>

---

<nav class="chapter-nav chapter-nav--bottom" aria-label="Navegación inferior entre capítulos"><a href="../capitulo-5/">← Capítulo 5</a><a class="chapter-nav__index" href="../">Recorrido</a><a class="chapter-nav__next" href="../capitulo-7/">Capítulo 7 →</a></nav>
