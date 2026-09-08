<h1 style="text-align:center;"> <strong>Patrones de Comportamiento</strong></h1>

----

<h2><strong>Definición</strong><br></h2>
<p style="text-align:justify;"> 
    Hasta ahora, los patrones presentados en el libro se han enfocado en cumplir dos objetivos: (i) facilitar la creación de objetos y (ii) agregar nuevas funcionalidades a las estructuras existentes de forma efectiva. Sin embargo, cuando un proyecto es suficientemente maduro, el siguiente paso se centra en asegurar que el grado de acoplamiento entre los componentes del sistema sea mínimo. En este sentido, los patrones de comportamiento proponen soluciones comunes a problemas relacionados con el aumento del acoplamiento cuando se asignan responsabilidades a un objeto, o cuando varios objetos se comunican entre si.

</p>

----

<h2><strong>Importancia</strong><br></h2>
<p style="text-align:justify;"> 
    Considerando el principio abierto/cerrado, es natural esperar que cuando un sistema comienza a crecer, está sujeto a que surjan dependencias entre sus componentes en todos los niveles de abstracción. Como resultado, los equipos de desarrollo enfrentan grandes desafíos relacionados con identificar e implementar las acciones necesarias para asegurar que el estado del sistema es consistente con el paso del tiempo. No obstante, escalar un sistema trae problemas relacionados con: (i) determinar la forma en la cual se extienden nuevas funcionalidades, (ii) dotar al sistema con estructuras que permitan una comunicación efectiva entre objetos, (iii) asegurar que todos los objetos tienen un nivel alto de cohesión (cuentan con responsabilidades claramente definidas), (iv) mantener un nivel bajo de acoplamiento entre sus componentes (se evita la creación de dependencias), entre otros.
</p>

<p style="text-align:justify;"> 
    En particular, el bajo acoplamiento es el principio que busca lograr un grado de dependencia mínimo entre los objetos que interactúan en un sistema, permitiendo potenciar aspectos relacionados con la flexibilidad, la reutilización y el flujo adecuado de la información que se pasa entre objetos. De acuerdo con lo anterior, los patrones de comportamiento presentan la solución a problemas comunes que buscan reducir el acoplamiento al máximo.
</p>


----

<h2><strong>Listado de patrones</strong><br></h2>

<h3>- [Chain of Responsability (Cadena de Responsabilidad)](cadena_responsabilidad/README.md)</h3>
<h3>- [Command (Comando)](command/README.md)</h3>
<h3>- [Iterator (Iterador)](iterator/README.md)</h3>
<h3>- [Mediator (Mediador)](mediator/README.md)</h3>
<h3>- [Memento (Memoria)](memento/README.mdd)</h3>
<h3>- [Observer (Observador)](observer/README.md)</h3>
<h3>- [State (Estado)](state/README.md)</h3>
<h3>- [Strategy (Estrategia)](strategy/README.md)</h3>
<h3>- [Template Method (Método Plantilla)](template/README.md)</h3>
<h3>- [Visitor (Visitante)](visitor/README.md)</h3>

----