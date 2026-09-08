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

### Diagrama de decisión y conexiones

<div class="pattern-decision-map" role="img" aria-label="Árbol para seleccionar un patrón de comportamiento según la colaboración que cambia">
  <div class="decision-start">¿Qué aspecto de la colaboración debe variar?</div>
  <div class="decision-branches">
    <a class="decision-node" href="cadena_responsabilidad/"><span>Quién atiende una solicitud</span><strong>Chain of Responsibility</strong></a>
    <a class="decision-node" href="command/"><span>Cómo se representa la solicitud</span><strong>Command</strong></a>
    <a class="decision-node" href="iterator/"><span>Cómo se recorre</span><strong>Iterator</strong></a>
    <a class="decision-node" href="mediator/"><span>Quién coordina</span><strong>Mediator</strong></a>
    <a class="decision-node" href="memento/"><span>Qué estado se restaura</span><strong>Memento</strong></a>
    <a class="decision-node" href="observer/"><span>Quién recibe el cambio</span><strong>Observer</strong></a>
    <a class="decision-node" href="state/"><span>Conducta por estado interno</span><strong>State</strong></a>
    <a class="decision-node" href="strategy/"><span>Algoritmo intercambiable</span><strong>Strategy</strong></a>
    <a class="decision-node" href="template/"><span>Pasos de un esqueleto fijo</span><strong>Template Method</strong></a>
    <a class="decision-node" href="visitor/"><span>Operación sobre tipos estables</span><strong>Visitor</strong></a>
  </div>
  <p class="decision-connection-note"><strong>Conexión:</strong> Command puede recorrer una Chain of Responsibility y notificar resultados mediante Observer. State puede delegar variantes en Strategy; Template Method fija el flujo mientras Strategy reemplaza el algoritmo completo. Iterator permite que Visitor recorra una estructura sin conocer su almacenamiento.</p>
</div>

---

<nav class="chapter-nav chapter-nav--bottom" aria-label="Navegación inferior entre capítulos"><a href="../capitulo-6/">← Capítulo 6</a><a class="chapter-nav__index" href="../">Recorrido</a><a class="chapter-nav__next" href="../capitulo-8/">Capítulo 8 →</a></nav>
