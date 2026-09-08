<h1 style="text-align:center;">
  <strong> Ejemplo práctico: Manipulación de facturas (SRP)</strong>
</h1>

<div class="lab-action" markdown>
[:fontawesome-brands-github: ABRIR EN CODESPACES](https://codespaces.new/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno?quickstart=1){ .md-button .md-button--primary .codespaces-button target="_blank" rel="noopener noreferrer" }
<span class="lab-action__note">Requiere una cuenta de GitHub. Consulta la <a href="../../../../codespaces/">guía de preparación</a> y ejecuta las pruebas o el comando indicado en el ejemplo.</span>
</div>

<hr/>

<h2><strong> Descripción del problema</strong></h2>

<p style="text-align:justify;">
Se solicita crear un sistema que permita <b>exportar e imprimir facturas</b>.
Cada factura contiene información sobre el cliente, los productos adquiridos, los precios unitarios, los impuestos y el total a pagar.
El sistema debe permitir generar reportes en distintos formatos: <b>PDF</b>, <b>texto plano</b> y <b>Excel (XLS)</b>.
</p>

<p style="text-align:justify;">
En la versión inicial, toda la lógica —desde la creación de la factura hasta la generación del reporte y la impresión—
fue implementada dentro de una sola clase <code>Factura</code>.
Si bien el código funcionaba correctamente, este diseño mezclaba múltiples responsabilidades: cálculo, exportación, y presentación.
Cualquier cambio en un formato de salida obligaba a modificar la misma clase, incrementando el riesgo de errores y
rompiendo el <b>Principio de Responsabilidad Única (SRP)</b>.
</p>

<p style="text-align:justify;">
El objetivo es <b>separar las responsabilidades</b> de generación, exportación e impresión en componentes independientes,
de manera que cada uno cumpla una función clara y pueda evolucionar sin afectar al resto del sistema.
</p>

<hr/>

<h2><strong> Estructura del ejemplo y accesos directos</strong></h2>

<table style="width:100%; border-collapse:collapse;">
  <thead>
    <tr style="background:#f5f5f5;">
      <th style="border:1px solid #ddd; padding:8px; text-align:center;"> Sin aplicar SRP</th>
      <th style="border:1px solid #ddd; padding:8px; text-align:center;"> Aplicando SRP</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td style="border:1px solid #ddd; padding:8px;">
        <p style="text-align:justify;">
          En la versión inicial, la clase <code>Factura</code> asume varias responsabilidades:
          calcular totales, formatear los datos y generar los archivos de salida en distintos formatos.
          Si se necesita agregar un nuevo formato de exportación (por ejemplo, JSON o XML),
          se debe modificar directamente esta clase, aumentando el acoplamiento y la posibilidad de errores.
        </p>
        <ul style="margin:0 0 4px 18px;">
          <li>▶️ <a href="#codigo-sin-aplicar-principio-factura-java"><b>Factura.java</b></a></li>
          <li>▶️ <a href="#codigo-sin-aplicar-principio-cliente-java"><b>Cliente.java</b></a></li>
        </ul>
      </td>
      <td style="border:1px solid #ddd; padding:8px;">
        <p style="text-align:justify;">
          En la versión refactorizada, la clase <code>Factura</code> se limita únicamente a representar los datos de la factura.
          Las tareas de exportación se delegan a una jerarquía de clases dentro del paquete <code>reporte</code>,
          y la impresión se encapsula en la clase <code>Impresora</code>.
          De este modo, cada componente tiene una única razón para cambiar, cumpliendo con el principio SRP.
        </p>
        <ul style="margin:0 0 4px 18px;">
          <li>▶️ <a href="#codigo-aplicando-principio-reporte-reporte-java"><b>Reporte.java</b></a></li>
          <li>▶️ <a href="#codigo-aplicando-principio-reporte-reportepdf-java"><b>ReportePDF.java</b></a></li>
          <li>▶️ <a href="#codigo-aplicando-principio-reporte-reportetextoplano-java"><b>ReporteTextoPlano.java</b></a></li>
          <li>▶️ <a href="#codigo-aplicando-principio-reporte-reportexls-java"><b>ReporteXLS.java</b></a></li>
          <li>▶️ <a href="#codigo-aplicando-principio-factura-java"><b>Factura.java</b></a></li>
          <li>▶️ <a href="#codigo-aplicando-principio-impresora-java"><b>Impresora.java</b></a></li>
          <li>▶️ <a href="#codigo-aplicando-principio-cliente-java"><b>Cliente.java</b></a></li>
        </ul>
      </td>
    </tr>
  </tbody>
</table>

<hr/>

<h2 style="text-align:justify;"><strong> Modelo UML sin aplicar Responsabilidad Única</strong></h2>

<p style="text-align:justify;">
En el diseño original, la clase <code>Factura</code> combina lógica de negocio y de presentación.
Se encarga tanto del cálculo de los totales como de la exportación e impresión del reporte.
Esto genera una dependencia innecesaria entre la estructura interna de la factura y el formato de salida,
lo que dificulta la evolución del sistema.
</p>

<p style="text-align:center;">
  <img src="../../../../assets/images/contenido/capitulos/capitulo3/solid/responsabilidad_unica/srp_ejemplo2_mal.png"
       width="85%" height="auto" alt="Modelo UML sin aplicar SRP"/>
</p>
<p style="text-align:center;"><b>Figura 1.</b> Diseño incorrecto: múltiples responsabilidades concentradas en una sola clase.</p>

<hr/>

## Solución en código

El ejemplo deja visible el punto de entrada `main`; las clases que colaboran con él se explican en las secciones anteriores.

=== "Incorrecto"

    ```java
    package capitulo3.solid.responsabilidad_unica.ejemplo2_manipulacion_facturas.sin_aplicar_principio;
    
    public class Cliente {
    
        public static void main(String[] args) {
            Factura factura = new Factura("Hola mundo");
            factura.imprimir();
            factura.exportarPDF();
            factura.exportarTextoPlano();
            factura.exportarXLS();
        }
    }
    ```

=== "Correcto"

    ```java
    package capitulo3.solid.responsabilidad_unica.ejemplo2_manipulacion_facturas.aplicando_principio;
    
    import capitulo3.solid.responsabilidad_unica.ejemplo2_manipulacion_facturas.aplicando_principio.reporte.Reporte;
    import capitulo3.solid.responsabilidad_unica.ejemplo2_manipulacion_facturas.aplicando_principio.reporte.ReportePDF;
    import capitulo3.solid.responsabilidad_unica.ejemplo2_manipulacion_facturas.aplicando_principio.reporte.ReporteTextoPlano;
    import capitulo3.solid.responsabilidad_unica.ejemplo2_manipulacion_facturas.aplicando_principio.reporte.ReporteXLS;
    
    public class Cliente {
        public static void main(String[] args) {
            Factura factura = new Factura("Hola mundo");
            Impresora impresora = new Impresora();
    
            impresora.imprimir(factura);
    
            Reporte reportePDF = new ReportePDF();
            Reporte reporteTextoPlano = new ReporteTextoPlano();
            Reporte reporteXLS = new ReporteXLS();
    
            reportePDF.exportar(factura);
            reporteTextoPlano.exportar(factura);
            reporteXLS.exportar(factura);
        }
    }
    ```
