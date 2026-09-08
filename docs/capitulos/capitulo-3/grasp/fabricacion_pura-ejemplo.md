<h1 style="text-align:center;">
  <strong> Ejemplo: Logs Personalizados</strong>
</h1>

<div class="lab-action" markdown>
[:fontawesome-brands-github: ABRIR EN CODESPACES](https://codespaces.new/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno?quickstart=1){ .md-button .md-button--primary .codespaces-button target="_blank" rel="noopener noreferrer" }
<span class="lab-action__note">Requiere una cuenta de GitHub. Consulta la <a href="../../../../codespaces/">guía de preparación</a> y ejecuta las pruebas o el comando indicado en el ejemplo.</span>
</div>

<hr/>

<h2><strong> Descripción del problema</strong></h2>

<p style="text-align:justify;">
Se solicita implementar una utilidad que permita generar <b>logs personalizados</b> para los distintos servicios del sistema.
El objetivo es crear una librería independiente que proporcione una interfaz común para registrar mensajes informativos, de depuración y errores críticos,
e integrarse fácilmente en cualquier servicio sin modificar su lógica principal.
</p>

<p style="text-align:justify;">
Para ello se aplica el patrón <b>Fabricación Pura</b> (<i>Pure Fabrication</i>): se introduce una clase auxiliar —<code>Logger</code>— que <b>no pertenece al dominio</b>,
pero encapsula y centraliza las operaciones de registro, manteniendo la cohesión del código de negocio y reduciendo el acoplamiento con detalles técnicos.
</p>

<hr/>

<h2><strong> Estructura del ejemplo y accesos directos</strong></h2>

<table style="width:100%; border-collapse:collapse;">
  <thead>
    <tr style="background:#f5f5f5;">
      <th style="border:1px solid #ddd; padding:8px; text-align:center;">Clases principales</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td style="border:1px solid #ddd; padding:8px;">
        ▶️ <a href="#codigo-servicio-java"><b>Servicio.java</b></a><br/>
        ▶️ <a href="#codigo-logger-java"><b>Logger.java</b></a>
      </td>
    </tr>
  </tbody>
</table>

<hr/>

<h2><strong> Modelo UML</strong></h2>

<p style="text-align:justify;">
La clase <code>Logger</code> se introduce como <b>fabricación pura</b> para ofrecer una API uniforme (<code>info()</code>, <code>debug()</code>, <code>error()</code>)
y permitir que <code>Servicio</code> delegue la responsabilidad de registrar eventos sin contaminar su lógica de negocio.
</p>

<p style="text-align:center;">
  <img src="../../../../assets/images/contenido/capitulos/capitulo3/grasp/fabricacion_pura_ejemplo.png"
       width="70%" height="auto"
       alt="Diagrama UML del principio de Fabricación Pura aplicado a un servicio de logs personalizados"/>
</p>

<p style="text-align:center; font-size:14px; color:#555;">
  <b>Figura 1.</b> Aplicación del principio <i>Fabricación Pura</i> mediante una clase <code>Logger</code> que encapsula la lógica de registro.
</p>

<hr/>

## Solución en código

El ejemplo deja visible el punto de entrada `main`; las clases que colaboran con él se explican en las secciones anteriores.

=== "Java"

    ```text
    Este ejemplo presenta clases de apoyo; no incluye un método `main` ejecutable.
    ```
