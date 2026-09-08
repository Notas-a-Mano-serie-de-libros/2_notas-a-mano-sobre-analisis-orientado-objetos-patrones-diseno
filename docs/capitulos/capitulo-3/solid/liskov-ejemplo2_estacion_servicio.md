<h1 style="text-align:center;">
  <strong> Ejemplo práctico: Estación de servicio (LSP)</strong>
</h1>

<div class="lab-action" markdown>
[:fontawesome-brands-github: ABRIR EN CODESPACES](https://codespaces.new/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno?quickstart=1){ .md-button .md-button--primary .codespaces-button target="_blank" rel="noopener noreferrer" }
<span class="lab-action__note">Requiere una cuenta de GitHub. Consulta la <a href="../../../../codespaces/">guía de preparación</a> y ejecuta las pruebas o el comando indicado en el ejemplo.</span>
</div>

<hr/>

<h2><strong> Descripción del problema</strong></h2>

<p style="text-align:justify;">
Se solicita implementar una solución que facilite el <b>abastecimiento de combustible</b> o <b>suministro eléctrico</b>
a los diferentes tipos de vehículos que atiende una estación de servicio.
La estación debe poder manejar vehículos de <b>combustión</b> (funcionan con gasolina), <b>eléctricos</b> e <b>híbridos</b>.
</p>

<p style="text-align:justify;">
En el diseño inicial, la clase base <code>Vehiculo</code> fue implementada con un método <code>recargarCombustible()</code>.
Las subclases <code>VehiculoCombustion</code> y <code>VehiculoHibrido</code> sobrescriben el método correctamente;
sin embargo, <code>VehiculoElectrico</code> no requiere combustible, por lo que su implementación termina siendo vacía o lanzando una excepción.
Esto genera una <b>violación del Principio de Sustitución de Liskov (LSP)</b>.
</p>

<p style="text-align:justify;">
El reto consiste en rediseñar la jerarquía de clases de forma que <b>todas las subclases puedan reemplazar a la clase base sin alterar el comportamiento esperado</b>.
Para lograrlo, se debe crear una abstracción que respete los distintos tipos de abastecimiento sin romper el contrato establecido por la clase base.
</p>

<hr/>

<h2><strong> Estructura del ejemplo y accesos directos</strong></h2>

<table style="width:100%; border-collapse:collapse;">
  <thead>
    <tr style="background:#f5f5f5;">
      <th style="border:1px solid #ddd; padding:8px; text-align:center;"> Sin aplicar LSP</th>
      <th style="border:1px solid #ddd; padding:8px; text-align:center;"> Aplicando LSP</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td style="border:1px solid #ddd; padding:8px;">
        <p style="text-align:justify;">
          En la versión inicial, la clase <code>Vehiculo</code> define el método <code>recargarCombustible()</code>,
          lo que obliga a las subclases eléctricas a implementar comportamientos que no aplican a su naturaleza.
          Esta jerarquía es inconsistente y rompe el principio de sustitución: un <code>VehiculoElectrico</code> no puede sustituir
          a un <code>VehiculoCombustion</code> sin alterar el funcionamiento de la estación.
        </p>
        <ul style="margin:0 0 4px 18px;">
          <li>▶️ <a href="#codigo-sin-aplicar-principio-vehiculo-vehiculo-java"><b>Vehiculo.java</b></a></li>
          <li>▶️ <a href="#codigo-sin-aplicar-principio-vehiculo-vehiculocombustion-java"><b>VehiculoCombustion.java</b></a></li>
          <li>▶️ <a href="#codigo-sin-aplicar-principio-vehiculo-vehiculoelectrico-java"><b>VehiculoElectrico.java</b></a></li>
          <li>▶️ <a href="#codigo-sin-aplicar-principio-vehiculo-vehiculohibrido-java"><b>VehiculoHibrido.java</b></a></li>
          <li>▶️ <a href="#codigo-sin-aplicar-principio-estacionservicio-java"><b>EstacionServicio.java</b></a></li>
          <li>▶️ <a href="#codigo-sin-aplicar-principio-cliente-java"><b>Cliente.java</b></a></li>
        </ul>
      </td>
      <td style="border:1px solid #ddd; padding:8px;">
        <p style="text-align:justify;">
          En la versión mejorada, se redefine la jerarquía introduciendo una abstracción más genérica (<code>Vehiculo</code>)
          con el método <code>abastecer()</code>, que cada subclase implementa de acuerdo con su tipo de energía.
          Así, la estación puede procesar cualquier vehículo sin conocer su tipo ni violar el contrato del padre.
        </p>
        <ul style="margin:0 0 4px 18px;">
          <li>▶️ <a href="#codigo-aplicando-principio-vehiculo-vehiculo-java"><b>Vehiculo.java</b></a></li>
          <li>▶️ <a href="#codigo-aplicando-principio-vehiculo-vehiculocombustion-java"><b>VehiculoCombustion.java</b></a></li>
          <li>▶️ <a href="#codigo-aplicando-principio-vehiculo-vehiculoelectrico-java"><b>VehiculoElectrico.java</b></a></li>
          <li>▶️ <a href="#codigo-aplicando-principio-vehiculo-vehiculohibrido-java"><b>VehiculoHibrido.java</b></a></li>
          <li>▶️ <a href="#codigo-aplicando-principio-estacionservicio-java"><b>EstacionServicio.java</b></a></li>
          <li>▶️ <a href="#codigo-aplicando-principio-cliente-java"><b>Cliente.java</b></a></li>
        </ul>
      </td>
    </tr>
  </tbody>
</table>

<hr/>

<h2 style="text-align:justify;"><strong> Modelo UML sin aplicar Sustitución de Liskov</strong></h2>

<p style="text-align:justify;">
En el diseño original, la jerarquía de clases obliga a todos los vehículos a compartir el método <code>recargarCombustible()</code>.
Este enfoque no respeta las diferencias entre los tipos de vehículos y genera comportamientos no deseados:
los vehículos eléctricos no usan combustible y los híbridos combinan diferentes métodos de recarga.
Esto rompe el principio de sustitución, ya que <b>no todas las subclases pueden comportarse como la superclase</b>.
</p>

<p style="text-align:center;">
  <img src="../../../../assets/images/contenido/capitulos/capitulo3/solid/liskov/lsp_ejemplo2_mal.png"
       width="75%" height="auto" alt="Modelo UML sin aplicar LSP"/>
</p>
<p style="text-align:center;"><b>Figura 1.</b> Diseño incorrecto: la jerarquía impone métodos inaplicables a algunas subclases.</p>

<hr/>

## Solución en código

El ejemplo deja visible el punto de entrada `main`; las clases que colaboran con él se explican en las secciones anteriores.

=== "Incorrecto"

    ```java
    package capitulo3.solid.liskov.ejemplo2_estacion_servicio.sin_aplicar_principio;
    
    import capitulo3.solid.liskov.ejemplo2_estacion_servicio.sin_aplicar_principio.vehiculo.Vehiculo;
    import capitulo3.solid.liskov.ejemplo2_estacion_servicio.sin_aplicar_principio.vehiculo.VehiculoCombustion;
    import capitulo3.solid.liskov.ejemplo2_estacion_servicio.sin_aplicar_principio.vehiculo.VehiculoElectrico;
    import capitulo3.solid.liskov.ejemplo2_estacion_servicio.sin_aplicar_principio.vehiculo.VehiculoHibrido;
    
    public class Cliente {
    
        public static void main(String[] args) throws Exception {
            EstacionServicio estacion = new EstacionServicio();
            Vehiculo combustion = new VehiculoCombustion();
            Vehiculo electrico = new VehiculoElectrico();
            Vehiculo hibrido = new VehiculoHibrido();
    
            estacion.reabastecer(combustion, 100, 0);
            estacion.reabastecer(electrico, 0, 70);
            estacion.reabastecer(hibrido, 80, 50);
    
            // Usuario intenta recargar un auto que funciona con gasolina
            combustion.recargarBateria(100);
        }
    }
    ```

=== "Correcto"

    ```java
    package capitulo3.solid.liskov.ejemplo2_estacion_servicio.aplicando_principio;
    
    import capitulo3.solid.liskov.ejemplo2_estacion_servicio.aplicando_principio.vehiculo.Vehiculo;
    import capitulo3.solid.liskov.ejemplo2_estacion_servicio.aplicando_principio.vehiculo.VehiculoCombustion;
    import capitulo3.solid.liskov.ejemplo2_estacion_servicio.aplicando_principio.vehiculo.VehiculoElectrico;
    import capitulo3.solid.liskov.ejemplo2_estacion_servicio.aplicando_principio.vehiculo.VehiculoHibrido;
    
    public class Cliente {
    
        public static void main(String[] args) {
            EstacionServicio estacion = new EstacionServicio();
    
            Vehiculo combustion = new VehiculoCombustion();
            Solicitud recargaCombustible = new Solicitud();
            recargaCombustible.setPorcentajeGasolina(100);
            estacion.reabastecer(combustion, recargaCombustible);
    
            Vehiculo electrico = new VehiculoElectrico();
            Solicitud recargaBateria = new Solicitud();
            recargaBateria.setPorcentajeRecarga(70);
            estacion.reabastecer(electrico, recargaBateria);
    
            Vehiculo hibrido = new VehiculoHibrido();
            Solicitud recargaHibrido = new Solicitud();
            recargaHibrido.setPorcentajeGasolina(80);
            recargaHibrido.setPorcentajeRecarga(50);
            estacion.reabastecer(hibrido, recargaHibrido);
    
            System.out.println("Sistema termina ejecución sin excepciones");
        }
    }
    ```
