<h1 style="text-align:center;">
  <strong> Ejemplo práctico: Gestión de dispositivos IoT (ISP)</strong>
</h1>

<div class="lab-action" markdown>
[:fontawesome-brands-github: ABRIR EN CODESPACES](https://codespaces.new/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno?quickstart=1){ .md-button .md-button--primary .codespaces-button target="_blank" rel="noopener noreferrer" }
<span class="lab-action__note">Requiere una cuenta de GitHub. Consulta la <a href="../../../../codespaces/">guía de preparación</a> y ejecuta las pruebas o el comando indicado en el ejemplo.</span>
</div>

<hr/>

<h2><strong> Descripción del problema</strong></h2>

<p style="text-align:justify;">
Se solicita crear un sistema que permita gestionar diferentes <b>dispositivos IoT</b> dentro de una red inteligente,
como <b>cámaras de seguridad</b> y <b>sensores de temperatura</b>.
Cada dispositivo posee <b>capacidades específicas</b> (por ejemplo, capturar imágenes o registrar valores ambientales),
y el sistema debe ofrecer una interfaz común para su administración general (encendido, apagado, reinicio, monitoreo, etc.).
</p>

<p style="text-align:justify;">
En la primera implementación, se diseñó una única interfaz <code>Dispositivo</code> que incluía métodos para todas las operaciones posibles
(sensado, grabación, captura de video, transmisión, etc.).
Este enfoque obligaba a clases como <code>SensorTemperatura</code> a implementar métodos que no aplicaban a su naturaleza,
como <code>iniciarGrabacion()</code> o <code>detenerTransmision()</code>.
Esta violación del <b>Principio de Segregación de Interfaces (ISP)</b> hacía el código menos mantenible,
incrementando el acoplamiento y reduciendo la cohesión.
</p>

<p style="text-align:justify;">
El objetivo fue refactorizar el diseño dividiendo la interfaz monolítica en varias <b>interfaces más pequeñas y específicas</b>,
de modo que cada tipo de dispositivo solo implemente las capacidades que realmente necesita.
</p>

<hr/>

<h2><strong> Estructura del ejemplo y accesos directos</strong></h2>

<table style="width:100%; border-collapse:collapse;">
  <thead>
    <tr style="background:#f5f5f5;">
      <th style="border:1px solid #ddd; padding:8px; text-align:center;"> Sin aplicar ISP</th>
      <th style="border:1px solid #ddd; padding:8px; text-align:center;"> Aplicando ISP</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td style="border:1px solid #ddd; padding:8px;">
        <p style="text-align:justify;">
          En esta versión, la interfaz <code>Dispositivo</code> define métodos genéricos para cualquier tipo de dispositivo IoT,
          incluyendo funcionalidades de captura, transmisión y sensado.
          Esto obliga a las clases <code>CamaraSeguridad</code> y <code>SensorTemperatura</code>
          a implementar operaciones que no tienen sentido en su contexto, violando el principio ISP.
        </p>
        <ul style="margin:0 0 4px 18px;">
          <li>▶️ <a href="#codigo-sin-aplicar-principio-dispositivo-dispositivo-java"><b>Dispositivo.java</b></a></li>
          <li>▶️ <a href="#codigo-sin-aplicar-principio-dispositivo-camaraseguridad-java"><b>CamaraSeguridad.java</b></a></li>
          <li>▶️ <a href="#codigo-sin-aplicar-principio-dispositivo-sensortemperatura-java"><b>SensorTemperatura.java</b></a></li>
          <li>▶️ <a href="#codigo-sin-aplicar-principio-cliente-java"><b>Cliente.java</b></a></li>
        </ul>
      </td>
      <td style="border:1px solid #ddd; padding:8px;">
        <p style="text-align:justify;">
          En la versión refactorizada, el diseño se divide en <b>interfaces más específicas</b>:
          <code>Camara</code>, <code>Sensor</code> y <code>Dispositivo</code>.
          Cada interfaz define únicamente los métodos relacionados con su propósito funcional,
          permitiendo que las clases concretas implementen solo las operaciones que realmente utilizan.
          Así, <code>SensorTemperatura</code> implementa <code>Sensor</code> y <code>Dispositivo</code>,
          mientras que <code>CamaraSeguridad</code> implementa <code>Camara</code> y <code>Dispositivo</code>.
        </p>
        <ul style="margin:0 0 4px 18px;">
          <li>▶️ <a href="#codigo-aplicando-principio-dispositivo-dispositivo-java"><b>Dispositivo.java</b></a></li>
          <li>▶️ <a href="#codigo-aplicando-principio-dispositivo-camara-java"><b>Camara.java</b></a></li>
          <li>▶️ <a href="#codigo-aplicando-principio-dispositivo-sensor-java"><b>Sensor.java</b></a></li>
          <li>▶️ <a href="#codigo-aplicando-principio-dispositivo-dispositivo-concreto-camaraseguridad-java"><b>CamaraSeguridad.java</b></a></li>
          <li>▶️ <a href="#codigo-aplicando-principio-dispositivo-dispositivo-concreto-sensortemperatura-java"><b>SensorTemperatura.java</b></a></li>
          <li>▶️ <a href="#codigo-aplicando-principio-cliente-java"><b>Cliente.java</b></a></li>
        </ul>
      </td>
    </tr>
  </tbody>
</table>

<hr/>

<h2 style="text-align:justify;"><strong> Modelo UML sin aplicar Segregación de Interfaces</strong></h2>

<p style="text-align:justify;">
En el diseño inicial, una sola interfaz <code>Dispositivo</code> agrupaba todas las operaciones posibles,
desde la captura de video hasta el registro de datos.
Este enfoque “monolítico” generaba dependencias innecesarias y clases obligadas a implementar métodos vacíos o sin sentido,
comprometiendo la mantenibilidad del sistema.
</p>

<p style="text-align:center;">
  <img src="../../../../assets/images/contenido/capitulos/capitulo3/solid/segregacion_interfaces/isp_ejemplo2_mal.png"
       width="85%" height="auto" alt="Modelo UML sin aplicar ISP"/>
</p>
<p style="text-align:center;"><b>Figura 1.</b> Diseño incorrecto: una interfaz única fuerza dependencias innecesarias en clases específicas.</p>

<hr/>

## Solución en código

El ejemplo deja visible el punto de entrada `main`; las clases que colaboran con él se explican en las secciones anteriores.

=== "Incorrecto"

    ```java
    package capitulo3.solid.segregacion_interfaces.ejemplo2_gestion_iot.sin_aplicar_principio;
    
    import capitulo3.solid.segregacion_interfaces.ejemplo2_gestion_iot.sin_aplicar_principio.dispositivo.CamaraSeguridad;
    import capitulo3.solid.segregacion_interfaces.ejemplo2_gestion_iot.sin_aplicar_principio.dispositivo.Dispositivo;
    import capitulo3.solid.segregacion_interfaces.ejemplo2_gestion_iot.sin_aplicar_principio.dispositivo.SensorTemperatura;
    
    public class Cliente {
    
        public static void main(String[] args) {
            Dispositivo sensorTemperatura = new SensorTemperatura();
            sensorTemperatura.encender();
            sensorTemperatura.leerTemperatura();
    
            Dispositivo camaraSeguridad = new CamaraSeguridad();
            camaraSeguridad.encender();
            camaraSeguridad.ajustarBrillo(90);
            camaraSeguridad.leerTemperatura();
        }
    }
    ```

=== "Correcto"

    ```java
    package capitulo3.solid.segregacion_interfaces.ejemplo2_gestion_iot.aplicando_principio;
    
    import capitulo3.solid.segregacion_interfaces.ejemplo2_gestion_iot.aplicando_principio.dispositivo.Camara;
    import capitulo3.solid.segregacion_interfaces.ejemplo2_gestion_iot.aplicando_principio.dispositivo.Sensor;
    import capitulo3.solid.segregacion_interfaces.ejemplo2_gestion_iot.aplicando_principio.dispositivo.dispositivo_concreto.CamaraSeguridad;
    import capitulo3.solid.segregacion_interfaces.ejemplo2_gestion_iot.aplicando_principio.dispositivo.dispositivo_concreto.SensorTemperatura;
    
    public class Cliente {
    
        public static void main(String[] args) {
            Sensor sensorTemperatura = new SensorTemperatura();
            sensorTemperatura.encender();
            sensorTemperatura.realizarLectura();
            sensorTemperatura.apagar();
    
            Camara camaraSeguridad = new CamaraSeguridad();
            camaraSeguridad.encender();
            camaraSeguridad.tomarFoto();
            camaraSeguridad.ajustarBrillo(90);
            camaraSeguridad.apagar();
        }
    }
    ```
