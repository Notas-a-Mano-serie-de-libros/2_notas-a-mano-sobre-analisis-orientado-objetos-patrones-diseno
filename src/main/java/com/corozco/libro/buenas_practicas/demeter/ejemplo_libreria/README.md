<h1 style="text-align:center;">
  <strong>📚 Ejemplo práctico: Sistema de Librería</strong>
</h1>

<hr/>

<h2><strong>🧩 Descripción del problema</strong></h2>

<p style="text-align:justify;">
Se solicita a <em>nuestro desarrollador</em> diseñar un sistema que permita <b>consultar los ejemplares disponibles en una librería</b>.  
El sistema debe mostrar al usuario la información esencial de cada libro —título, número de páginas, género literario e información del autor—, además de permitir la <b>consulta directa del autor asociado a un libro específico</b>.
</p>

<p style="text-align:justify;">
En un primer intento, el diseño original viola la <b>Ley de Demeter</b>, ya que el objeto principal accede de manera directa a las dependencias internas de otros objetos, generando un alto acoplamiento y una baja cohesión entre los componentes del sistema.
</p>

<hr/>

<h2><strong>📂 Estructura del ejemplo</strong></h2>

<table style="width:100%; border-collapse:collapse; text-align:center;">
  <thead>
    <tr style="background-color:#f0f0f0;">
      <th style="width:50%; border:1px solid #ccc; padding:6px;">Versión sin aplicar el principio</th>
      <th style="width:50%; border:1px solid #ccc; padding:6px;">Versión aplicando el principio</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td style="border:1px solid #ccc; padding:6px;">
        <p style="text-align:justify;">
          En esta versión inicial, el <b>Cliente</b> accede directamente a las dependencias internas de los objetos.  
          Esto viola la <b>Ley de Demeter</b>, creando una cadena de dependencias difíciles de mantener.
        </p>
        <p style="text-align:center;">
          ▶️ <a href="./sin_aplicar_principio/Cliente.java" target="_blank"><b>Ver Cliente (sin aplicar principio)</b></a>
        </p>
      </td>
      <td style="border:1px solid #ccc; padding:6px;">
        <p style="text-align:justify;">
          En la versión corregida, el <b>Cliente</b> se comunica únicamente con sus colaboradores directos.  
          Se evita el acceso encadenado y se mejora la <b>cohesión</b> y <b>mantenibilidad</b> del sistema.
        </p>
        <p style="text-align:center;">
          ▶️ <a href="./aplicando_principio/Cliente.java" target="_blank"><b>Ver Cliente (aplicando principio)</b></a>
        </p>
      </td>
    </tr>
  </tbody>
</table>

<hr/>

<h2 style="text-align:justify;"><strong>❌ Modelo UML sin aplicar la Ley de Demeter</strong></h2>

<p style="text-align:justify;">
En este modelo inicial, la clase principal consulta de forma encadenada los métodos de otras clases (por ejemplo, <code>libro.getAutor().getNombre()</code>), lo que rompe el principio de bajo acoplamiento.  
El resultado es un diseño rígido, difícil de mantener y propenso a errores ante cualquier cambio en las clases intermedias.
</p>

<p style="text-align:center;">
  <img src="../../../../../../../resources/images/principios/demeter/ley_demeter_ejemplo_mal.png" 
       width="70%" height="auto" alt="Diagrama UML violando la Ley de Demeter"/>
</p>
<p style="text-align:center;"><b>Figura 1.</b> Diseño inicial que viola la Ley de Demeter.</p>

<hr/>

<h2 style="text-align:justify;"><strong>✅ Modelo UML aplicando la Ley de Demeter</strong></h2>

<p style="text-align:justify;">
En la versión corregida, el diseño se ajusta a la <b>Ley de Demeter</b>, también conocida como el principio del <em>"no hables con extraños"</em>.  
Cada clase se comunica únicamente con sus colaboradores directos (amigos), evitando el encadenamiento de llamadas.  
El resultado es un sistema más limpio, modular y fácil de mantener.
</p>

<p style="text-align:center;">
  <img src="../../../../../../../resources/images/principios/demeter/ley_demeter_ejemplo_bien.png" 
       width="70%" height="auto" alt="Diagrama UML aplicando la Ley de Demeter"/>
</p>
<p style="text-align:center;"><b>Figura 2.</b> Diseño final aplicando correctamente la Ley de Demeter.</p>

<hr/>

<h2><strong>💡 Conclusión</strong></h2>

<p style="text-align:justify;">
Aplicar la <b>Ley de Demeter</b> favorece la <b>cohesión interna</b> y <b>reduce el acoplamiento</b> entre clases.  
De esta forma, cada componente conoce únicamente a los objetos con los que interactúa directamente, logrando un diseño más robusto, reutilizable y adaptable a futuros cambios.
</p>