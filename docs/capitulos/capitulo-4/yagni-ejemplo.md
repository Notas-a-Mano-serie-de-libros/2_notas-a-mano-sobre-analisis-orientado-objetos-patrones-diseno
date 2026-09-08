<h1 style="text-align:center;">
  <strong> Ejemplo: Sistema de gestión de notas (YAGNI)</strong>
</h1>

<div class="lab-action" markdown>
[:fontawesome-brands-github: ABRIR EN CODESPACES](https://codespaces.new/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno?quickstart=1){ .md-button .md-button--primary .codespaces-button target="_blank" rel="noopener noreferrer" }
<span class="lab-action__note">Requiere una cuenta de GitHub. Consulta la <a href="../../../codespaces/">guía de preparación</a> y ejecuta las pruebas o el comando indicado en el ejemplo.</span>
</div>

<hr/>

<h2><strong> Descripción del problema</strong></h2>

<p style="text-align:justify;">
Se solicita implementar un módulo que permita realizar operaciones básicas sobre las notas: <b>crear</b>, <b>editar</b> y <b>eliminar</b>.
Sin embargo, durante el desarrollo, el programador decidió anticiparse a posibles requerimientos futuros, añadiendo funcionalidades que <b>no fueron solicitadas</b> como exportar las notas a PDF o imagen, y enviar notificaciones por correo.
</p>

<p style="text-align:justify;">
Esta situación sirve para ilustrar el principio <b>YAGNI</b> (<i>You Aren’t Gonna Need It</i>), que establece que <b>no se deben implementar características hasta que sean realmente necesarias</b>.
Agregar funcionalidad innecesaria aumenta la complejidad del sistema, el acoplamiento entre módulos y el esfuerzo de mantenimiento, sin aportar valor real al producto.
</p>

<hr/>

<h2><strong> Estructura del ejemplo y accesos directos</strong></h2>

<table style="width:100%; border-collapse:collapse;">
  <thead>
    <tr style="background:#f5f5f5;">
      <th style="border:1px solid #ddd; padding:8px; text-align:center;"> Sin aplicar YAGNI</th>
      <th style="border:1px solid #ddd; padding:8px; text-align:center;"> Aplicando YAGNI</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td style="border:1px solid #ddd; padding:8px;">
        <p style="text-align:justify;">
          Se implementaron módulos adicionales de exportación y mensajería sin que el cliente los solicitara, generando un código más extenso y difícil de mantener.
        </p>
        <ul style="margin:0 0 4px 18px;">
          <li>▶️ <a href="#codigo-sin-aplicar-principio-nota-java"><b>Nota</b></a></li>
          <li>▶️ <a href="#codigo-sin-aplicar-principio-notasmanager-java"><b>NotasManager</b></a></li>
          <li>▶️ <a href="#codigo-sin-aplicar-principio-exporte-servicioexporte-java"><b>ServicioExporte</b></a></li>
          <li>▶️ <a href="#codigo-sin-aplicar-principio-exporte-exportepdf-java"><b>ExportePDF</b></a></li>
          <li>▶️ <a href="#codigo-sin-aplicar-principio-exporte-exporteimagen-java"><b>ExporteImagen</b></a></li>
          <li>▶️ <a href="#codigo-sin-aplicar-principio-mensajeria-serviciomensajeria-java"><b>ServicioMensajeria</b></a></li>
          <li>▶️ <a href="#codigo-sin-aplicar-principio-mensajeria-mensajeriaemail-java"><b>MensajeriaEmail</b></a></li>
        </ul>
      </td>
      <td style="border:1px solid #ddd; padding:8px;">
        <p style="text-align:justify;">
          Se implementan exclusivamente las operaciones necesarias para gestionar las notas, eliminando dependencias innecesarias y manteniendo un diseño simple y funcional.
        </p>
        <ul style="margin:0 0 4px 18px;">
          <li>▶️ <a href="#codigo-aplicando-principio-nota-java"><b>Nota</b></a></li>
          <li>▶️ <a href="#codigo-aplicando-principio-notasmanager-java"><b>NotasManager</b></a></li>
        </ul>
      </td>
    </tr>
  </tbody>
</table>

<hr/>

<h2 style="text-align:justify;"><strong> Modelo UML sin aplicar YAGNI</strong></h2>

<p style="text-align:justify;">
En esta versión, el desarrollador añadió módulos para exportar las notas a distintos formatos y enviarlas por correo electrónico.
Aunque estas características podrían ser útiles en el futuro, actualmente no son necesarias.
El resultado es un sistema más complejo, con dependencias adicionales y un mantenimiento más costoso.
</p>

<p style="text-align:center;">
  <img src="../../../assets/images/contenido/capitulos/capitulo4/yagni/yagni_ejemplo_mal.png"
       width="70%" height="auto" alt="Modelo UML sin aplicar YAGNI"/>
</p>

<p style="text-align:center; font-size:14px; color:#555;">
  <b>Figura 1.</b> Modelo sin aplicar el principio YAGNI: funcionalidades innecesarias aumentan la complejidad del sistema.
</p>

<hr/>

## Solución en código

El ejemplo deja visible el punto de entrada `main`; las clases que colaboran con él se explican en las secciones anteriores.

=== "Incorrecto"

    ```text
    Este ejemplo presenta clases de apoyo; no incluye un método `main` ejecutable.
    ```
=== "Correcto"

    ```text
    Este ejemplo presenta clases de apoyo; no incluye un método `main` ejecutable.
    ```
