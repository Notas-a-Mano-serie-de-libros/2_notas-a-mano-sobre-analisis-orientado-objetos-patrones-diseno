<h1 style="text-align:center;">
  <strong>🧩 L: Liskov Substitution Principle (LSP)</strong>
</h1>

<hr/>

<h3 style="text-align:center;">
  <em>"Los subtipos de una clase deben ser sustituibles por su superclase."</em>
</h3>

<hr/>

<h2><strong>📘 Descripción general</strong></h2>

<p style="text-align:justify;">
El <b>Principio de Sustitución de Liskov (LSP)</b> fue formulado por <b>Barbara Liskov</b> en 1987 durante su conferencia magistral <i>“Data Abstraction and Hierarchy”</i>.  
El principio establece que, dentro de una jerarquía de clases, <b>las subclases deben poder sustituir a su superclase sin alterar el comportamiento correcto del programa</b>.
</p>

<p style="text-align:justify;">
En otras palabras, si una clase <code>B</code> hereda de una clase <code>A</code>, cualquier instancia de <code>A</code> en el sistema debería poder ser reemplazada por una instancia de <code>B</code> sin afectar el resultado ni romper la funcionalidad.  
Cuando esto no ocurre, la jerarquía presenta un <b>defecto de diseño</b> o una <b>herencia inapropiada</b>.
</p>

<hr/>

<h2><strong>🧠 Analogía: la cafetería familiar</strong></h2>

<p style="text-align:justify;">
Imagina que <b>Julián</b> es el dueño de una cafetería y sabe preparar todas las bebidas del menú: cafés, batidos, infusiones y nevados.  
Él representa la <b>superclase</b> de una jerarquía, ya que domina todas las operaciones.
</p>

<p style="text-align:center;">
  <img src="../../../../../../../resources/images/principios/solid/liskov/lsp_analogia_caso1.png"
       width="85%" height="auto"
       alt="Caso 1: Julián, el barista original, conoce todas las recetas"/>
</p>

<p style="text-align:justify;">
Julián tiene dos hijos: <b>Andrés</b> e <b>Isabel</b>, quienes a veces ayudan en la cafetería.  
<b>Andrés</b> disfruta trabajar con su padre y ha aprendido a preparar todas las bebidas del menú, por lo que puede reemplazarlo sin problema.  
Esto significa que <b>Andrés cumple con el principio de sustitución de Liskov</b>: puede sustituir a su padre sin afectar el funcionamiento del negocio.
</p>

<p style="text-align:center;">
  <img src="../../../../../../../resources/images/principios/solid/liskov/lsp_analogia_caso2.png"
       width="85%" height="auto"
       alt="Caso 2: Andrés puede reemplazar a su padre sin alterar el funcionamiento"/>
</p>

<p style="text-align:justify;">
Por otro lado, <b>Isabel</b> no participa con frecuencia en la cafetería y no domina la preparación de bebidas complejas.  
Cuando intenta reemplazar a su padre, no puede cumplir con todas las tareas, afectando la calidad del servicio.  
Esto demuestra que <b>Isabel no cumple el principio de sustitución</b>, ya que no puede asumir completamente las responsabilidades de la superclase.
</p>

<p style="text-align:center;">
  <img src="../../../../../../../resources/images/principios/solid/liskov/lsp_analogia_caso3.png"
       width="85%" height="auto"
       alt="Caso 3: Isabel no puede reemplazar completamente a su padre"/>
</p>

<p style="text-align:justify;">
De manera análoga, en la ingeniería de software, una subclase que no puede reemplazar a su superclase indica una <b>abstracción mal definida</b> o un <b>uso inadecuado de la herencia</b>.  
El diseño correcto debe asegurar que toda subclase preserve el contrato, las precondiciones y la semántica de la clase base.
</p>

<hr/>

<h2><strong>🔍 Aplicación práctica</strong></h2>

<p style="text-align:justify;">
El principio LSP tiene implicaciones profundas en el diseño orientado a objetos, ya que promueve <b>jerarquías coherentes y seguras</b>.  
Para cumplirlo, las subclases deben:
</p>

<ul style="text-align:justify; list-style-type: disc;">
  <li><b>Respetar las precondiciones</b> definidas por la superclase (no exigir más de lo que esta ya requería).</li>
  <li><b>No alterar las postcondiciones</b> (mantener los mismos resultados esperados).</li>
  <li><b>Conservar las invariantes</b> de la superclase (garantías que siempre deben cumplirse).</li>
  <li><b>No lanzar excepciones adicionales</b> que la superclase no preveía.</li>
</ul>

<p style="text-align:justify;">
Un incumplimiento clásico de este principio ocurre cuando una subclase modifica el comportamiento esperado de la superclase, alterando la lógica de uso por parte del cliente.  
Por ejemplo, si una clase <code>Cuadrado</code> hereda de <code>Rectángulo</code> y redefine los métodos de asignación de ancho y alto para que siempre sean iguales, deja de comportarse como un rectángulo real, violando el LSP.
</p>

<hr/>

<h2><strong>📂 Accesos directos a los ejemplos</strong></h2>

<table style="width:100%; border-collapse:collapse;">
  <thead>
    <tr style="background:#f5f5f5;">
      <th style="border:1px solid #ddd; padding:8px; text-align:center;">Ejemplo</th>
      <th style="border:1px solid #ddd; padding:8px; text-align:center;">Descripción</th>
      <th style="border:1px solid #ddd; padding:8px; text-align:center;">Acceso</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td style="border:1px solid #ddd; padding:8px; text-align:center;">
        <b>Ejemplo 1</b><br/>Figuras geométricas
      </td>
      <td style="border:1px solid #ddd; padding:8px; text-align:justify;">
        Presenta la clásica relación entre <code>Rectángulo</code> y <code>Cuadrado</code>, donde la herencia mal aplicada genera una violación del principio de sustitución.  
        Al intentar tratar un <code>Cuadrado</code> como un <code>Rectángulo</code>, el sistema produce resultados inconsistentes en operaciones como el cálculo del área.
      </td>
      <td style="border:1px solid #ddd; padding:8px; text-align:center;">
        📁 <a href="./ejemplo1_figuras_geometrica/README.md" target="_blank"><b>Ir al ejemplo</b></a>
      </td>
    </tr>
    <tr>
      <td style="border:1px solid #ddd; padding:8px; text-align:center;">
        <b>Ejemplo 2</b><br/>Estación de servicio
      </td>
      <td style="border:1px solid #ddd; padding:8px; text-align:justify;">
        Expone una jerarquía correcta donde las subclases (<code>VehiculoGasolina</code>, <code>VehiculoElectrico</code>)  
        pueden reemplazar sin problema a la superclase <code>Vehiculo</code>.  
        Cada tipo de vehículo cumple el contrato general sin alterar el comportamiento esperado, demostrando una aplicación adecuada del LSP.
      </td>
      <td style="border:1px solid #ddd; padding:8px; text-align:center;">
        📁 <a href="./ejemplo2_estacion_servicio/README.md" target="_blank"><b>Ir al ejemplo</b></a>
      </td>
    </tr>
  </tbody>
</table>

<hr/>

<h2><strong>💡 Conclusión</strong></h2>

<p style="text-align:justify;">
El <b>Principio de Sustitución de Liskov</b> asegura que las jerarquías de clases mantengan relaciones coherentes y predecibles.  
Cumplirlo garantiza que las subclases puedan ampliar el comportamiento de la superclase sin romper su contrato ni alterar su semántica original.  
Aplicar este principio refuerza la integridad del modelo de herencia y mejora la estabilidad del sistema.
</p>

<p style="text-align:justify;">
En conjunto con el <b>Principio Abierto/Cerrado</b> y la <b>Inversión de Dependencias</b>, el LSP se convierte en un pilar fundamental para construir arquitecturas orientadas a objetos extensibles, seguras y fácilmente mantenibles.
</p>

<hr/>

<h2><strong>📚 Referencias</strong></h2>

<ul style="text-align:justify;">
  <li>Liskov, B. (1987). <i>Data Abstraction and Hierarchy.</i> ACM SIGPLAN Notices.</li>
  <li>Martin, R. C. (2003). <i>Agile Software Development: Principles, Patterns, and Practices.</i> Prentice Hall.</li>
  <li>Martin, R. C. (2009). <i>Clean Code: A Handbook of Agile Software Craftsmanship.</i> Prentice Hall.</li>
  <li>Larman, C. (2005). <i>Applying UML and Patterns: An Introduction to Object-Oriented Analysis and Design.</i> Prentice Hall.</li>
</ul>