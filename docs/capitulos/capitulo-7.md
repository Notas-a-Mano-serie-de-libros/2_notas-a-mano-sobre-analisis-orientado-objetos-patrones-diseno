<nav class="chapter-nav" aria-label="Navegación superior entre capítulos"><a href="../capitulo-6/">← Capítulo 6</a><a class="chapter-nav__index" href="../">Recorrido</a><a class="chapter-nav__next" href="../capitulo-8/">Capítulo 8 →</a></nav>

# Capítulo 7 · Patrones de comportamiento

<span class="chapter-kicker">Páginas 249–314</span>

## Recorrido del capítulo

Los patrones de comportamiento distribuyen algoritmos, responsabilidades y comunicaciones: encadenan decisiones, encapsulan solicitudes, recorren colecciones, coordinan colegas, conservan estados, publican cambios y sustituyen comportamientos.

<nav class="chapter-outline chapter-outline--pages chapter-outline--patterns" aria-label="Secciones del capítulo">
<strong>Secciones del capítulo</strong>
<ol class="chapter-section-list">
<li><a href="cadena_responsabilidad/"><span>7.3.1 Chain of Responsibility</span><small>Leer sección →</small></a></li>
<li><a href="command/"><span>7.3.2 Command</span><small>Leer sección →</small></a></li>
<li><a href="iterator/"><span>7.3.3 Iterator</span><small>Leer sección →</small></a></li>
<li><a href="mediator/"><span>7.3.4 Mediator</span><small>Leer sección →</small></a></li>
<li><a href="memento/"><span>7.3.5 Memento</span><small>Leer sección →</small></a></li>
<li><a href="observer/"><span>7.3.6 Observer</span><small>Leer sección →</small></a></li>
<li><a href="state/"><span>7.3.7 State</span><small>Leer sección →</small></a></li>
<li><a href="strategy/"><span>7.3.8 Strategy</span><small>Leer sección →</small></a></li>
<li><a href="template/"><span>7.3.9 Template Method</span><small>Leer sección →</small></a></li>
<li><a href="visitor/"><span>7.3.10 Visitor</span><small>Leer sección →</small></a></li>
</ol>
</nav>

---

## 7.4 Tabla comparativa de decisión

| Familia de decisión | Patrones | Pregunta clave para decidir |
| --- | --- | --- |
| Procesar por etapas | **Chain of Responsibility** | ¿Varios manejadores deben tener la oportunidad de procesar o delegar una solicitud? |
| Representar una petición | **Command** | ¿La operación debe almacenarse, encolarse, registrarse, deshacerse o enviarse a otro receptor? |
| Recorrer una colección | **Iterator** | ¿Se necesita recorrer elementos sin exponer la representación interna? |
| Coordinar colaboradores | **Mediator** | ¿Muchas dependencias entre colegas pueden concentrarse en un coordinador explícito? |
| Restaurar estado | **Memento** | ¿Debe recuperarse una instantánea sin romper el encapsulamiento del originador? |
| Publicar cambios | **Observer** | ¿Varios interesados deben reaccionar cuando cambia un sujeto sin que este conozca sus clases? |
| Variar según estado | **State** | ¿El comportamiento cambia con el estado interno y los condicionales ya dominan el contexto? |
| Intercambiar algoritmo | **Strategy** | ¿Debe sustituirse una política completa manteniendo estable al cliente? |
| Conservar un esqueleto | **Template Method** | ¿El orden general del algoritmo es fijo y solo algunos pasos pueden redefinirse? |
| Agregar operaciones | **Visitor** | ¿La estructura es estable, pero aparecen operaciones nuevas sobre todos sus tipos? |
| Comparar variaciones | **State vs. Strategy vs. Template Method** | ¿La variante depende del estado, se elige como una política intercambiable o está limitada a pasos dentro de un algoritmo fijo? |

### Mapa de relaciones entre patrones de comportamiento

<figure class="pattern-relationship-map">
  <object data="../../assets/diagrams/patrones-comportamiento.svg" type="image/svg+xml" aria-label="Mapa navegable de relaciones entre los diez patrones de comportamiento desarrollados en el capítulo">
    <img src="../../assets/diagrams/patrones-comportamiento.svg" alt="Mapa de relaciones entre los diez patrones de comportamiento desarrollados en el capítulo">
  </object>
  <figcaption>Las relaciones muestran composición, apoyo entre responsabilidades y diferencias de intención entre estructuras similares.</figcaption>
</figure>

---

<nav class="chapter-nav chapter-nav--bottom" aria-label="Navegación inferior entre capítulos"><a href="../capitulo-6/">← Capítulo 6</a><a class="chapter-nav__index" href="../">Recorrido</a><a class="chapter-nav__next" href="../capitulo-8/">Capítulo 8 →</a></nav>
