<h1 style="text-align:center;">
  <strong>🧩 O: Open/Closed Principle (OCP)</strong>
</h1>

<hr/>

<h3 style="text-align:center;">
  <em>"Las entidades de software deben estar abiertas para la extensión, pero cerradas para la modificación"</em>
</h3>

<hr/>

<h2><strong>📘 Descripción general</strong></h2>

<p style="text-align:justify;">
El <b>Principio Abierto/Cerrado (OCP)</b> establece que una entidad de software —como una clase, módulo o función— debe ser <b>abierta para la extensión</b> pero <b>cerrada para la modificación</b>.  
Esto significa que el sistema debe poder incorporar nuevas funcionalidades <u>sin alterar el código existente</u>, evitando romper el comportamiento ya probado y desplegado en producción.
</p>

<p style="text-align:justify;">
El objetivo del OCP es garantizar la <b>estabilidad</b> y la <b>evolutividad</b> del software: los cambios se introducen mediante nuevas clases o implementaciones, no reescribiendo las que ya funcionan.  
Este principio se apoya en <b>abstracciones</b> y <b>polimorfismo</b>, pilares de la extensibilidad en POO.
</p>

<hr/>

<h2><strong>🔍 Significado de “abierto” y “cerrado”</strong></h2>

<ul style="text-align:justify; list-style-type: disc;">
  <li><b>Abierto:</b> permite agregar nuevo comportamiento sin modificar el código original (mediante <b>herencia</b>, <b>composición</b> e <b>interfaces</b>).</li>
  <li><b>Cerrado:</b> su código fuente no debe alterarse una vez estabilizado en producción; se protege su integridad para no introducir fallas regresivas.</li>
</ul>

<p style="text-align:justify;">
En síntesis: el sistema debe crecer por <b>extensión</b>, no por <b>modificación</b>.
</p>

<hr/>

<h2><strong>🧠 Analogía: la máquina expendedora</strong></h2>

<p style="text-align:justify;">
<b>Manuel</b> administra una tienda con una <b>máquina de gancho</b> activada por monedas. Para atraer más clientes, pide a <b>Juan</b> que agregue nuevos juguetes.  
Agregar juguetes <b>cumple el OCP</b>: extiende funcionalidades sin tocar el mecanismo original.
</p>

<p style="text-align:center;">
  <img src="../../../../../../../resources/images/principios/solid/abierto_cerrado/ocp_analogia_caso1.png" width="85%" height="auto" alt="Caso 1: agregar juguetes sin modificar la máquina"/>
</p>

<p style="text-align:justify;">
Más tarde, Manuel quiere <u>modificar</u> la misma máquina para vender golosinas. Esto <b>viola el OCP</b>: cambia la estructura interna de un sistema que ya funciona y arriesga su estabilidad.
</p>

<p style="text-align:center;">
  <img src="../../../../../../../resources/images/principios/solid/abierto_cerrado/ocp_analogia_caso2.png" width="85%" height="auto" alt="Caso 2: modificar una máquina estable"/>
</p>

<p style="text-align:justify;">
La alternativa correcta es instalar una <b>nueva máquina de golosinas</b> junto a la de juguetes: <b>extiende</b> el negocio sin modificar el sistema existente.
</p>

<p style="text-align:center;">
  <img src="../../../../../../../resources/images/principios/solid/abierto_cerrado/ocp_analogia_caso3.png" width="85%" height="auto" alt="Caso 3: extender sin modificar el original"/>
</p>

<hr/>

<h2><strong>📂 Accesos directos a los ejemplos</strong></h2>

<table style="width:100%; border-collapse:collapse;">
  <thead>
    <tr style="background:#f5f5f5;">
      <th style="border:1px solid #ddd; padding:8px; text-align:center;">Ejemplo</th>
      <th style="border:1px solid #ddd; padding:8px; text-align:center;">Descripción (alineada con el código)</th>
      <th style="border:1px solid #ddd; padding:8px; text-align:center;">Acceso</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td style="border:1px solid #ddd; padding:8px; text-align:center;"><b>Ejemplo 1</b><br/>Figuras geométricas</td>
      <td style="border:1px solid #ddd; padding:8px; text-align:justify;">
        El cliente trabaja con la <b>abstracción</b> de una figura y el sistema permite <b>agregar nuevas figuras</b> (p. ej., Triángulo, Rectángulo)  
        implementando el mismo contrato, sin modificar el código que las usa. Aplica OCP mediante polimorfismo.
      </td>
      <td style="border:1px solid #ddd; padding:8px; text-align:center;">
        📁 <a href="./ejemplo1_figuras_geometricas/README.md" target="_blank"><b>Ir al ejemplo</b></a>
      </td>
    </tr>
    <tr>
      <td style="border:1px solid #ddd; padding:8px; text-align:center;"><b>Ejemplo 2</b><br/>Solicitud administrativa</td>
      <td style="border:1px solid #ddd; padding:8px; text-align:justify;">
        Flujo para procesar <b>solicitudes</b> administrativas basado en una <b>interfaz</b>/clase base común.  
        Nuevos tipos de solicitud se incorporan creando nuevas implementaciones—sin tocar el motor existente—cumpliendo el OCP.
      </td>
      <td style="border:1px solid #ddd; padding:8px; text-align:center;">
        📁 <a href="./ejemplo2_solicitud_administrativa/README.md" target="_blank"><b>Ir al ejemplo</b></a>
      </td>
    </tr>
  </tbody>
</table>

<hr/>

<h2><strong>💬 Reflexión</strong></h2>

<p style="text-align:justify;">
El OCP se vuelve crítico conforme crece la base de código y se acumula <b>deuda técnica</b>.  
Aplicarlo exige diseñar con <b>interfaces estables</b> y aislar variaciones con patrones como <b>Strategy</b>, <b>Template Method</b>, <b>Factory</b> o <b>Decorator</b>.
</p>

<hr/>

<h2><strong>💡 Conclusión</strong></h2>

<p style="text-align:justify;">
El <b>Principio Abierto/Cerrado</b> promueve software estable y adaptable: el comportamiento se <b>extiende</b> sin comprometer lo ya validado.  
Respetarlo implica invertir en <b>abstracciones claras</b> y <b>módulos desacoplados</b>, reduciendo costes de mantenimiento y riesgos de regresión.
</p>

<hr/>

<h2><strong>📚 Referencias</strong></h2>

<ul style="text-align:justify;">
  <li>Martin, R. C. (2003). <i>Agile Software Development: Principles, Patterns, and Practices.</i> Prentice Hall.</li>
  <li>Martin, R. C. (2009). <i>Clean Architecture: A Craftsman’s Guide to Software Structure and Design.</i> Prentice Hall.</li>
  <li>Larman, C. (2005). <i>Applying UML and Patterns: An Introduction to Object-Oriented Analysis and Design.</i> Prentice Hall.</li>
</ul>