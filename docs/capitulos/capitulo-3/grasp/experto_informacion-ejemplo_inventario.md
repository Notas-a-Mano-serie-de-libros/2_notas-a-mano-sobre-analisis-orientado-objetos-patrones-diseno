<h1 style="text-align:center;">
  <strong> Ejemplo: Registro de Inventario</strong>
</h1>

<div class="lab-action" markdown>
[:fontawesome-brands-github: ABRIR EN CODESPACES](https://codespaces.new/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno?quickstart=1){ .md-button .md-button--primary .codespaces-button target="_blank" rel="noopener noreferrer" }
<span class="lab-action__note">Requiere una cuenta de GitHub. Consulta la <a href="../../../../codespaces/">guía de preparación</a> y ejecuta las pruebas o el comando indicado en el ejemplo.</span>
</div>

<hr/>

<h2><strong> Descripción del problema</strong></h2>

<p style="text-align:justify;">
Se solicita diseñar un sistema que gestione el <b>inventario de productos</b> de una tienda.
La aplicación debe permitir calcular tanto el <b>costo unitario</b> de cada producto como el <b>costo total</b> del inventario,
y posibilitar la incorporación de nuevos lotes de productos conforme ingresen al almacén.
Cada registro en el inventario debe reflejar la cantidad, el precio y el valor acumulado de los productos disponibles.
</p>

<p style="text-align:justify;">
Para abordar este problema se aplica el principio <b>Experto en Información</b> del conjunto de patrones <b>GRASP</b>.
Según este principio, las responsabilidades deben asignarse a la clase que posee la información necesaria para ejecutarlas.
En este contexto, la clase <code>Inventario</code> es la más adecuada para calcular el valor total y administrar los productos,
pues contiene los registros y datos que permiten realizar estas operaciones de forma consistente y autónoma.
</p>

<hr/>

<h2><strong> Estructura del ejemplo y accesos directos</strong></h2>

<table style="width:100%; border-collapse:collapse;">
  <thead>
    <tr style="background:#f5f5f5;">
      <th style="border:1px solid #ddd; padding:8px; text-align:center;">Cliente</th>
      <th style="border:1px solid #ddd; padding:8px; text-align:center;">Clases principales</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td style="border:1px solid #ddd; padding:8px;">
        ▶️ <a href="#codigo-cliente-java"><b>Cliente.java</b></a>
      </td>
      <td style="border:1px solid #ddd; padding:8px;">
        ▶️ <a href="#codigo-inventario-java"><b>Inventario.java</b></a><br/>
        ▶️ <a href="#codigo-detalleproducto-java"><b>DetalleProducto.java</b></a><br/>
        ▶️ <a href="#codigo-producto-java"><b>Producto.java</b></a>
      </td>
    </tr>
  </tbody>
</table>

<hr/>

<h2><strong> Modelo UML</strong></h2>

<p style="text-align:justify;">
El diagrama UML ilustra la relación entre las clases <code>Inventario</code>, <code>DetalleProducto</code> y <code>Producto</code>.
La clase <code>Inventario</code> actúa como experta en información: conoce los registros de los productos almacenados y dispone de los datos
necesarios para calcular el costo total de los artículos disponibles.
Cada <code>DetalleProducto</code> mantiene una relación de composición con <code>Producto</code>, ya que representa una instancia particular
que almacena su cantidad y el costo total correspondiente.
</p>

<p style="text-align:center;">
  <img src="../../../../assets/images/contenido/capitulos/capitulo3/grasp/experto_informacion_ejemplo.png"
       width="70%" height="auto"
       alt="Diagrama UML que representa la aplicación del principio Experto en Información en el registro de inventario"/>
</p>

<p style="text-align:center; font-size:14px; color:#555;">
  <b>Figura 1.</b> Aplicación del principio <i>Experto en Información</i> en la gestión del inventario de productos.
</p>

<hr/>

## Solución en código

El ejemplo deja visible el punto de entrada `main`; las clases que colaboran con él se explican en las secciones anteriores.

=== "Java"

    ```java
    package capitulo3.grasp.experto_informacion.ejemplo_inventario;
    
    public class Cliente {
    
        public static void main(String[] args) {
            Inventario inventario = new Inventario();
            inventario.agregarProducto("Producto 1", 1000.0, 3);
            inventario.agregarProducto("Producto 2", 2000.0, 5);
    
            inventario.getInfo();
        }
    }
    ```
