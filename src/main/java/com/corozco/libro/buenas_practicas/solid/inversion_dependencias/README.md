<h1 style="text-align:center;">
  <strong>🧩 D: Dependency Inversion Principle (DIP)</strong>
</h1>

<hr/>

<h3 style="text-align:center;">
  <em>"Las abstracciones no deben depender de los detalles; los detalles deben depender de las abstracciones."</em>
</h3>

<hr/>

<h2><strong>📘 Descripción general</strong></h2>

<p style="text-align:justify;">
El <b>Principio de Inversión de Dependencias (DIP)</b> establece que los módulos de alto nivel no deben depender de módulos de bajo nivel,  
sino que ambos deben depender de <b>abstracciones</b>.  
De la misma forma, las <b>abstracciones</b> no deben depender de los <b>detalles concretos</b>; en su lugar, los detalles deben depender de las abstracciones.
</p>

<p style="text-align:justify;">
El propósito de este principio es <b>reducir el acoplamiento</b> entre las partes del sistema.  
Esto se logra mediante el uso de <b>interfaces</b> o <b>clases abstractas</b> que definen los contratos de comunicación entre módulos,  
de modo que las implementaciones concretas puedan cambiar sin afectar la estructura principal.  
Aplicar el DIP permite construir arquitecturas <b>flexibles, escalables y fácilmente testeables</b>.
</p>

<hr/>

<h2><strong>🧠 Analogía: la orquesta sinfónica</strong></h2>

<p style="text-align:justify;">
Imagina que <b>Camilo</b> es el director de una orquesta sinfónica que ofrece conciertos en varios teatros de la ciudad.  
Antes de cada presentación, <b>Camilo</b> da instrucciones específicas a cada músico para coordinar la interpretación de la obra.  
Este enfoque funcionaba mientras la orquesta era pequeña, pero cuando el grupo creció, <b>Camilo</b> empezó a pasar demasiado tiempo adaptando sus indicaciones a cada músico,  
lo que aumentó la complejidad y redujo la eficiencia.
</p>

<p style="text-align:center;">
  <img src="../../../../../../../resources/images/principios/solid/inversion_dependencias/dip_analogia_caso1.png"
       width="85%" height="auto"
       alt="Caso 1: dependencia directa entre el director y los músicos"/>
</p>

<p style="text-align:justify;">
Para resolver el problema, <b>Camilo</b> nombró a su asistente <b>Javier</b> como responsable de adaptar las partituras a cada instrumento.  
De esta forma, el director solo debía entregar una partitura general, mientras que <b>Javier</b> se encargaba de crear las versiones específicas según el tipo de músico.
</p>

<p style="text-align:center;">
  <img src="../../../../../../../resources/images/principios/solid/inversion_dependencias/dip_analogia_caso2.png"
       width="85%" height="auto"
       alt="Caso 2: el asistente actúa como capa intermedia (abstracción)"/>
</p>

<p style="text-align:justify;">
Gracias a esta reorganización, <b>Camilo</b> dejó de depender directamente de los músicos individuales y ahora solo se comunica con <b>Javier</b>.  
El asistente actúa como una <b>abstracción intermedia</b> entre el director (módulo de alto nivel) y los músicos (módulos de bajo nivel).  
Así, si se incorpora un nuevo instrumentista, basta con entregarle la partitura adaptada, sin afectar la dinámica del resto de la orquesta.
</p>

<p style="text-align:center;">
  <img src="../../../../../../../resources/images/principios/solid/inversion_dependencias/dip_analogia_caso3.png"
       width="85%" height="auto"
       alt="Caso 3: la abstracción reduce el acoplamiento entre el director y los músicos"/>
</p>

<p style="text-align:justify;">
En el contexto del software, <b>Camilo</b> representa un módulo de alto nivel (la lógica del negocio),  
<b>los músicos</b> representan las implementaciones concretas (detalles),  
y <b>Javier</b> simboliza la capa de abstracción (interfaz o contrato).  
Gracias a la inversión de dependencias, el sistema se vuelve <b>modular, reutilizable y resistente al cambio</b>.
</p>

<hr/>

<h2><strong>🔍 Aplicación práctica</strong></h2>

<p style="text-align:justify;">
En programación, el DIP implica que las clases deben depender de <b>interfaces</b> o <b>abstracciones</b>, no de implementaciones específicas.  
Por ejemplo, un sistema de almacenamiento no debería depender directamente de una clase concreta como <code>DiscoLocal</code> o <code>NubeAWS</code>,  
sino de una interfaz genérica <code>Repositorio</code> que defina las operaciones comunes.  
Así, es posible cambiar el tipo de almacenamiento sin modificar la lógica de negocio.
</p>

<p style="text-align:justify;">
Este principio se relaciona directamente con los conceptos de <b>Inversión de Control (IoC)</b> y <b>Inyección de Dependencias (DI)</b>,  
que permiten automatizar la creación y vinculación de objetos, asegurando que las dependencias se administren dinámicamente en tiempo de ejecución.  
Esto facilita la extensión del sistema y simplifica las pruebas unitarias.
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
        Muestra cómo separar la lógica de cálculo geométrico de las implementaciones concretas.  
        Inicialmente, las figuras dependen directamente de clases de dibujo o exportación, pero al aplicar DIP,
        la dependencia se invierte para que las figuras dependan de una interfaz abstracta, permitiendo intercambiar la forma de renderizado o almacenamiento sin afectar el código central.
      </td>
      <td style="border:1px solid #ddd; padding:8px; text-align:center;">
        📁 <a href="./ejemplo1_figuras_geometricas/README.md" target="_blank"><b>Ir al ejemplo</b></a>
      </td>
    </tr>
    <tr>
      <td style="border:1px solid #ddd; padding:8px; text-align:center;">
        <b>Ejemplo 2</b><br/>Servicio de almacenamiento
      </td>
      <td style="border:1px solid #ddd; padding:8px; text-align:justify;">
        Demuestra la inversión de dependencias en un servicio de persistencia de archivos.  
        Un módulo de alto nivel (por ejemplo, un gestor de documentos) depende de una interfaz <code>Repositorio</code>,
        mientras que las implementaciones concretas (<code>AlmacenamientoLocal</code>, <code>AlmacenamientoNube</code>) se conectan dinámicamente a través de inyección de dependencias.  
        Esto permite cambiar el backend de almacenamiento sin modificar la lógica principal.
      </td>
      <td style="border:1px solid #ddd; padding:8px; text-align:center;">
        📁 <a href="./ejemplo2_servicio_almacenamiento/README.md" target="_blank"><b>Ir al ejemplo</b></a>
      </td>
    </tr>
  </tbody>
</table>

<hr/>

<h2><strong>💡 Conclusión</strong></h2>

<p style="text-align:justify;">
El <b>Principio de Inversión de Dependencias</b> es fundamental para desacoplar los componentes de un sistema y aumentar su capacidad de extensión.  
Cuando los módulos de alto nivel dependen de abstracciones y no de detalles concretos, el sistema se vuelve más estable,  
más fácil de mantener y mejor preparado para el cambio.
</p>

<p style="text-align:justify;">
Aplicar DIP fomenta arquitecturas limpias y sostenibles, donde las dependencias fluyen hacia las abstracciones.  
Combinado con el uso de contenedores de inyección de dependencias y principios como el <b>OCP</b> y el <b>ISP</b>,  
este principio consolida la base de una arquitectura verdaderamente desacoplada y escalable.
</p>

<hr/>

<h2><strong>📚 Referencias</strong></h2>

<ul style="text-align:justify;">
  <li>Martin, R. C. (2003). <i>Agile Software Development: Principles, Patterns, and Practices.</i> Prentice Hall.</li>
  <li>Martin, R. C. (2017). <i>Clean Architecture: A Craftsman’s Guide to Software Structure and Design.</i> Prentice Hall.</li>
  <li>Larman, C. (2005). <i>Applying UML and Patterns: An Introduction to Object-Oriented Analysis and Design.</i> Prentice Hall.</li>
</ul>