<h1 style="text-align:center;"><strong>🧩 Principio DRY (Don’t Repeat Yourself)</strong></h1>

<h4 style="text-align:center;"><em>“Cada pieza de conocimiento debe tener una representación única, clara y autoritativa dentro de un sistema.”</em></h4>

<p style="text-align: justify;">
El <b>principio DRY</b> —acrónimo de <i>“Don’t Repeat Yourself”</i>, traducido como <b>“No te repitas”</b>— establece que <b>ninguna forma de conocimiento debería duplicarse dentro de un sistema</b>.  
Este principio fue introducido formalmente en 1999 en el libro <i>The Pragmatic Programmer</i> (<a href="#ref">Hunt &amp; Thomas, 1999</a>) y se ha convertido en una de las bases más importantes del desarrollo de software moderno.
</p>

<p style="text-align: justify;">
En sus primeras interpretaciones, el principio DRY se asociaba exclusivamente con la <b>eliminación de código duplicado</b>.  
No obstante, sus autores aclararon posteriormente que su alcance es mucho más amplio: <b>DRY aplica a cualquier tipo de conocimiento representado dentro de un sistema</b> —ya sea código, documentación, reglas de negocio, datos, o procesos operativos—.  
Su objetivo final es mantener una <b>única fuente de verdad</b> (Single Source of Truth), asegurando la consistencia, la coherencia y la trazabilidad del conocimiento.
</p>

---

## 🧭 Propósito del principio

<p style="text-align: justify;">
El principio DRY busca garantizar que cada pieza de información relevante en el sistema exista en un solo lugar.  
De esta forma, cuando se necesite modificar, actualizar o eliminar dicha información, los cambios se realicen <b>una sola vez</b>, evitando inconsistencias o comportamientos inesperados.  
En esencia, DRY fomenta un <b>diseño limpio, coherente y fácil de mantener</b>.
</p>

<div align="center">
  <figure>
    <img src="../../../../../../resources/images/principios/dry/dry_general.png" alt="Principio DRY - representación conceptual" style="max-width:75%;">
    <figcaption><b>Figura 1.</b> Representación conceptual del principio DRY: una única fuente de conocimiento, múltiples referencias.</figcaption>
  </figure>
</div>

---

## 🧩 Consideraciones para su aplicación

<p style="text-align: justify;">
Aplicar el principio <b>DRY</b> puede resultar complejo para quienes inician en el diseño de software, ya que no toda duplicación es necesariamente negativa.  
A continuación, se presentan algunos lineamientos que permiten identificar cuándo una solución puede beneficiarse de este principio:
</p>

<table>
  <thead>
    <tr>
      <th style="text-align:center;">🔍 Criterio</th>
      <th style="text-align:justify;">📖 Descripción</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td style="text-align:center;"><b>Identificación de duplicación</b></td>
      <td style="text-align:justify;">Debe existir una duplicación clara de lógica, datos o estructuras dentro del sistema. Esta duplicación puede encontrarse en cualquier artefacto: código fuente, documentación, pruebas, configuración o datos de negocio.</td>
    </tr>
    <tr>
      <td style="text-align:center;"><b>Contexto común</b></td>
      <td style="text-align:justify;">Los elementos duplicados deben responder al mismo propósito o contexto funcional. Si dos estructuras similares resuelven problemas conceptualmente distintos, no deben unificarse, ya que sus requisitos pueden divergir.</td>
    </tr>
    <tr>
      <td style="text-align:center;"><b>Posibilidad de abstracción</b></td>
      <td style="text-align:justify;">Debe ser posible abstraer la funcionalidad repetida en una entidad común —por ejemplo, una función, clase, módulo o documento compartido— sin afectar la semántica original.</td>
    </tr>
    <tr>
      <td style="text-align:center;"><b>Mantenibilidad mejorada</b></td>
      <td style="text-align:justify;">La aplicación del principio debe mejorar la legibilidad y la extensibilidad del sistema, facilitando futuras modificaciones o adaptaciones.</td>
    </tr>
    <tr>
      <td style="text-align:center;"><b>Beneficio sobre el costo</b></td>
      <td style="text-align:justify;">Aplicar DRY debe aportar un beneficio tangible que justifique los costos de refactorización. Si el esfuerzo requerido supera el valor obtenido, se recomienda mantener la duplicación controlada.</td>
    </tr>
  </tbody>
</table>

---

## 💡 Beneficios del principio DRY

| 🧱 Beneficio | 📘 Descripción |
|--------------|----------------|
| **Consistencia** | <p style="text-align: justify;">Una única fuente de verdad garantiza coherencia entre las distintas capas del sistema.</p> |
| **Mantenibilidad** | <p style="text-align: justify;">Los cambios se realizan en un único punto, reduciendo errores y simplificando el mantenimiento.</p> |
| **Eficiencia** | <p style="text-align: justify;">Evita duplicar esfuerzos en codificación, documentación o pruebas.</p> |
| **Escalabilidad** | <p style="text-align: justify;">Favorece arquitecturas modulares donde los componentes pueden evolucionar sin afectar a otros.</p> |
| **Trazabilidad** | <p style="text-align: justify;">Facilita la comprensión de la lógica del sistema al mantener las reglas de negocio centralizadas.</p> |

---

## 🚫 Cuándo **no** aplicar DRY

<p style="text-align: justify;">
El principio DRY no debe aplicarse de manera dogmática.  
Existen situaciones en las que la duplicación puede ser aceptable o incluso deseable:
</p>

- Cuando los contextos funcionales son distintos aunque el código parezca similar.
- En prototipos o pruebas exploratorias, donde la abstracción prematura puede obstaculizar la iteración.
- En código auto-contenido donde la independencia entre módulos es prioritaria sobre la reutilización.

<p style="text-align: justify;">
La clave es equilibrar la <b>claridad</b> con la <b>reutilización</b>: eliminar duplicaciones innecesarias sin comprometer la comprensión del sistema.
</p>

---

## 🧠 Conceptos relacionados

### 🔹 Abstracción
<p style="text-align: justify;">
Proceso mediante el cual se encapsula una idea o comportamiento común en una entidad genérica (función, clase o módulo), evitando repeticiones en el código.
</p>

### 🔹 Reutilización
<p style="text-align: justify;">
Capacidad de emplear componentes existentes en distintos contextos, reduciendo la redundancia y mejorando la eficiencia del desarrollo.
</p>

### 🔹 Cohesión y acoplamiento
<p style="text-align: justify;">
El principio DRY promueve alta cohesión —cada módulo cumple un propósito único— y bajo acoplamiento —los módulos dependen lo mínimo entre sí—.
</p>

---

## 📎 Referencia

<p style="text-align: justify;" id="ref">
Hunt, A., &amp; Thomas, D. (1999). <i>The Pragmatic Programmer: From Journeyman to Master</i>.  
Addison-Wesley Professional. ISBN 978-0-2016-1622-4.
</p>