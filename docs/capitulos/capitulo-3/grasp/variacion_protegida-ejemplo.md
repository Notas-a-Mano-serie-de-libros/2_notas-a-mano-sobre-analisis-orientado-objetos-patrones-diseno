<h1 style="text-align:center;">
  <strong> Ejemplo: Pasarela de pago</strong>
</h1>

<div class="lab-action" markdown>
[:fontawesome-brands-github: ABRIR EN CODESPACES](https://codespaces.new/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno?quickstart=1){ .md-button .md-button--primary .codespaces-button target="_blank" rel="noopener noreferrer" }
<span class="lab-action__note">Requiere una cuenta de GitHub. Consulta la <a href="../../../../codespaces/">guía de preparación</a> y ejecuta las pruebas o el comando indicado en el ejemplo.</span>
</div>

<hr/>

<h2><strong> Descripción del problema</strong></h2>

<p style="text-align:justify;">
Se solicita diseñar un sistema que permita realizar pagos
utilizando distintos métodos, entre ellos: <b>tarjeta de crédito</b>, <b>PayPal</b> y
<b>pago seguro en línea (PSE)</b>.
Además, el cliente ha indicado que en el futuro podrían agregarse nuevos medios de pago,
por lo que la solución debe ser fácilmente extensible sin requerir modificaciones en la lógica existente.
</p>

<p style="text-align:justify;">
Para resolver este escenario, el diseño propuesto encapsula los diferentes métodos de pago
tras una <b>abstracción común</b> denominada <code>MetodoPago</code>.
Cada tipo de pago concreto —<code>PagoTarjeta</code>, <code>PagoPayPal</code> y <code>PagoPSE</code>—
hereda de esta clase abstracta e implementa su propia versión del método
<code>realizarPago(monto: double)</code>, de acuerdo con su lógica específica.
</p>

<hr/>

<h2><strong> Estructura del ejemplo y accesos directos</strong></h2>

<table style="width:100%; border-collapse:collapse;">
  <thead>
    <tr style="background:#f5f5f5;">
      <th style="border:1px solid #ddd; padding:8px; text-align:center;">Cliente / Ejecución</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td style="border:1px solid #ddd; padding:8px;">
        ▶️ <a href="#codigo-cliente-java"><b>Cliente.java</b></a>
      </td>
    </tr>
  </tbody>
</table>

<hr/>

<h2><strong> Modelo UML</strong></h2>

<p style="text-align:justify;">
En el siguiente modelo UML se muestra la estructura de la pasarela de pagos.
El cliente interactúa exclusivamente con la abstracción <code>MetodoPago</code>,
sin depender directamente de las implementaciones concretas.
De esta manera, se protege al sistema de variaciones futuras y se promueve un diseño flexible
basado en interfaces estables.
</p>

<p style="text-align:center;">
  <img src="../../../../assets/images/contenido/capitulos/capitulo3/grasp/variacion_protegida_ejemplo.png"
       width="80%" height="auto"
       alt="Diagrama UML del principio de Variaciones Protegidas aplicado a una pasarela de pago"/>
</p>

<p style="text-align:center; font-size:14px; color:#555;">
  <b>Figura 1.</b> Aplicación del principio <i>Variaciones Protegidas</i> mediante una jerarquía de métodos de pago.
</p>

<hr/>

## Solución en código

El ejemplo deja visible el punto de entrada `main`; las clases que colaboran con él se explican en las secciones anteriores.

=== "Java"

    ```java
    package capitulo3.grasp.variacion_protegida.ejemplo;
    
    import capitulo3.grasp.variacion_protegida.ejemplo.metodo_pago.MetodoPago;
    import capitulo3.grasp.variacion_protegida.ejemplo.metodo_pago.PagoPSE;
    import capitulo3.grasp.variacion_protegida.ejemplo.metodo_pago.PagoPayPal;
    import capitulo3.grasp.variacion_protegida.ejemplo.metodo_pago.PagoTarjetaCredito;
    
    public class Cliente {
    
        public static void main(String[] args) {
            MetodoPago tarjeta = new PagoTarjetaCredito();
            MetodoPago paypal = new PagoPayPal();
            MetodoPago pse = new PagoPSE();
    
            tarjeta.realizarPago(1000);
            paypal.realizarPago(2000);
            pse.realizarPago(3000);
        }
    }
    ```
