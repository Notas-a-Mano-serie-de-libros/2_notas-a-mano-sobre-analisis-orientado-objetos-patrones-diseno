<h1 style="text-align:center;">
  <strong> Ejemplo: Capa de Control de Acceso a Datos</strong>
</h1>

<div class="lab-action" markdown>
[:fontawesome-brands-github: ABRIR EN CODESPACES](https://codespaces.new/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno?quickstart=1){ .md-button .md-button--primary .codespaces-button target="_blank" rel="noopener noreferrer" }
<span class="lab-action__note">Requiere una cuenta de GitHub. Consulta la <a href="../../../../codespaces/">guía de preparación</a> y ejecuta las pruebas o el comando indicado en el ejemplo.</span>
</div>

<hr/>

<h2><strong> Descripción del problema</strong></h2>

<p style="text-align:justify;">
Se solicita implementar un módulo genérico que permita
<b>almacenar, editar y eliminar entidades</b> de cualquier tipo dentro de una base de datos.
Por convención, todas las entidades del sistema deben poseer un identificador único para su gestión unificada.
</p>

<p style="text-align:justify;">
Para evitar el acoplamiento directo entre las clases del dominio y la lógica de persistencia,
se introduce la clase genérica <code>EntidadDAO&lt;T&gt;</code> como <b>mecanismo de indirección</b> (principio GRASP).
De este modo, las clases de negocio no interactúan con la fuente de datos: delegan en un intermediario especializado
que encapsula las operaciones de acceso.
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
El siguiente diagrama muestra cómo <code>EntidadDAO&lt;T&gt;</code> funciona como capa de <b>indirección</b> entre las entidades
del dominio y las operaciones de persistencia. El cliente invoca métodos genéricos (guardar, editar, eliminar)
sin preocuparse por detalles de implementación ni por diferencias entre entidades.
</p>

<p style="text-align:center;">
  <img src="../../../../assets/images/contenido/capitulos/capitulo3/grasp/indireccion_ejemplo.png"
       width="75%" height="auto"
       alt="Diagrama UML que muestra el principio de Indirección aplicado a una capa DAO genérica"/>
</p>
<p style="text-align:center; font-size:14px; color:#555;">
  <b>Figura 1.</b> Aplicación del principio <i>Indirección</i> mediante la clase genérica <code>EntidadDAO&lt;T&gt;</code>.
</p>

<hr/>

## Solución en código

El ejemplo deja visible el punto de entrada `main`; las clases que colaboran con él se explican en las secciones anteriores.

=== "Java"

    ```java
    package capitulo3.grasp.indireccion.ejemplo;
    
    import capitulo3.grasp.indireccion.ejemplo.entidad.Persona;
    import capitulo3.grasp.indireccion.ejemplo.entidad.Producto;
    
    public class Cliente {
    
        public static void main(String[] args) {
            Persona luisa = new Persona("Luisa", "2345", "1062");
            Producto producto = new Producto("Producto", "p1");
    
            EntidadDAO<Persona> daoPersona = new EntidadDAO<>();
            EntidadDAO<Producto> daoProducto = new EntidadDAO<>();
    
            daoPersona.guardar(luisa);
            daoPersona.editar(luisa.getId());
            daoProducto.guardar(producto);
            daoProducto.eliminar(producto.getId());
        }
    }
    ```
