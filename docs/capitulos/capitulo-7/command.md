<h1 style="text-align:center;">
  <strong> Command (Comando)</strong>
</h1>

<h4 style="text-align:center;"><em>“Encapsula una solicitud como un objeto, permitiendo parametrizar clientes con diferentes solicitudes, encolar operaciones y soportar deshacer/rehacer.”</em></h4>


## Definición

<p style="text-align:justify;">
El <b>patrón Command</b> tiene como objetivo <b>encapsular una acción o solicitud dentro de un objeto comando</b>.
Esto permite <b>desacoplar el emisor</b> de una solicitud (<i>invocador</i>) del objeto que realmente la ejecuta (<i>receptor</i>), brindando flexibilidad, extensibilidad y control sobre las operaciones que se ejecutan.
</p>

<hr/>

## Motivación

<p style="text-align:justify;">
Para entender el patrón, puede imaginarse una universidad que define distintos procedimientos administrativos: homologación de materias, cancelación de cursos, exención de requisitos, etc.
El estudiante solo emite la solicitud (comando), sin preocuparse por quién la procesará o cómo se llevará a cabo.
Cada solicitud sigue un protocolo específico gestionado por los departamentos correspondientes, pero el estudiante solo necesita ejecutar el comando: <i>“Cancelar curso X”</i>.
De este modo, la universidad puede modificar los procesos internos sin que el estudiante lo perciba.
</p>

<p style="text-align:justify;">
El patrón <b>Command</b> sigue exactamente esta filosofía: un <b>invocador</b> ejecuta una solicitud, pero la lógica de la operación (qué se hace y quién lo hace) está oculta dentro del comando y su <b>receptor</b>.
Además, los comandos pueden <b>almacenarse, deshacerse o ejecutarse secuencialmente</b>, permitiendo mayor control y extensibilidad.
</p>

<hr/>

## Modelo UML

<p style="text-align:justify;">
El modelo propuesto por el GoF define un <b>Invocador</b> que mantiene una colección de comandos que puede ejecutar, un <b>Cliente</b> que configura los comandos y un <b>Receptor</b> que realiza las operaciones reales.
En este libro se adopta una versión extendida que diferencia entre el <b>ClienteReceptor</b> (quien asocia el comando con el receptor) y el <b>ClienteInvocador</b> (quien ejecuta los comandos).
</p>

<p style="text-align:center;">
  <img src="../../../assets/images/contenido/capitulos/capitulo7/command_original.png" alt="Diagrama UML original del patrón Command" width="70%" height="auto"/>
</p>

<p style="text-align:justify;">
En la versión ajustada, el <b>ClienteReceptor</b> define qué receptor corresponde a cada comando, el <b>Invocador</b> contiene los comandos disponibles, y el <b>ClienteInvocador</b> los ejecuta bajo demanda.
Esta separación conceptual mejora la comprensión y reduce el acoplamiento entre las partes.
</p>

<p style="text-align:center;">
  <img src="../../../assets/images/contenido/capitulos/capitulo7/command.png" alt="Diagrama UML ajustado del patrón Command" width="70%" height="auto"/>
</p>
<p style="text-align:center;"><b>Figura 1.</b> Diagrama UML del patrón <i>Command</i> con ajuste conceptual.</p>

<hr/>

## Implementación genérica de la estructura

Las clases e interfaces conservan los nombres de los participantes del modelo UML anterior. Así puede seguirse cada relación del diagrama directamente en el código. Java se muestra por defecto; las otras pestañas expresan la misma colaboración sin cambiar su intención.

=== "Java"

    ```java
    interface IComando { void ejecutar(); }
    
    final class Receptor {
        void accion() { System.out.println("Acción del receptor"); }
    }
    
    final class ComandoConcreto implements IComando {
        private final Receptor receptor;
        ComandoConcreto(Receptor receptor) { this.receptor = receptor; }
        public void ejecutar() { receptor.accion(); }
    }
    
    final class Invocador {
        private IComando comando;
        void setComando(IComando comando) { this.comando = comando; }
        void invocar() { comando.ejecutar(); }
    }
    ```

=== "Python"

    ```python
    class IComando:
        def ejecutar(self): raise NotImplementedError
    class Receptor:
        def accion(self): return "acción"
    class ComandoConcreto(IComando):
        def __init__(self, receptor): self.receptor = receptor
        def ejecutar(self): return self.receptor.accion()
    class Invocador:
        def __init__(self, comando): self.comando = comando
        def invocar(self): return self.comando.ejecutar()
    ```

=== "C#"

    ```csharp
    interface IComando { void Ejecutar(); }
    
    class Receptor { public void Accion() { } }
    
    class ComandoConcreto : IComando {
        private readonly Receptor receptor; public ComandoConcreto(Receptor r) => receptor = r;
        public void Ejecutar() => receptor.Accion();
    }
    
    class Invocador { public IComando Comando { get; set; } public void Invocar() => Comando.Ejecutar(); }
    ```

=== "Pseudocódigo"

    ```text
    INTERFAZ IComando: ejecutar()
    CLASE Receptor: accion()
    CLASE ComandoConcreto: contiene Receptor
        ejecutar(): receptor.accion()
    CLASE Invocador: contiene IComando
        invocar(): comando.ejecutar()
    ```

## Participantes

<table>
  <thead>
    <tr>
      <th style="text-align:center;">Elemento</th>
      <th style="text-align:justify;">Descripción</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td style="text-align:center;"><b>Invocador</b></td>
      <td style="text-align:justify;">Contiene una colección de comandos disponibles y ofrece una interfaz para su ejecución.</td>
    </tr>
    <tr>
      <td style="text-align:center;"><b>IComando</b></td>
      <td style="text-align:justify;">Interfaz que define la operación <code>ejecutar()</code> que todos los comandos concretos deben implementar.</td>
    </tr>
    <tr>
      <td style="text-align:center;"><b>ComandoConcreto</b></td>
      <td style="text-align:justify;">Implementa la acción específica a ejecutar e invoca las operaciones correspondientes en el receptor.</td>
    </tr>
    <tr>
      <td style="text-align:center;"><b>Receptor</b></td>
      <td style="text-align:justify;">Realiza las acciones concretas asociadas al comando. Es el componente que conoce la lógica de negocio.</td>
    </tr>
    <tr>
      <td style="text-align:center;"><b>ClienteReceptor</b></td>
      <td style="text-align:justify;">Configura las asociaciones entre los comandos y sus receptores.</td>
    </tr>
    <tr>
      <td style="text-align:center;"><b>ClienteInvocador</b></td>
      <td style="text-align:justify;">Ejecuta comandos definidos en el invocador, sin conocer su implementación interna.</td>
    </tr>
  </tbody>
</table>

<hr/>

## Enunciado del problema

Se solicita implementar, junto con varios colegas, un sistema capaz de transformar frases en lenguaje natural en consultas SQL. Sin embargo, el modo de ejecución de las consultas debe ser transparente para cualquier usuario que quiera consumir la operación.

## Solución en código

El ejemplo deja visible el punto de entrada `main`; las clases que colaboran con él se explican en las secciones anteriores.

=== "Java"

    ```java
    package capitulo7.command;
    
    import capitulo7.command.comando.Invocador;
    import capitulo7.command.receptor.ClienteReceptor;
    
    public class Cliente {
        public static void main(String[] args) {
            final Invocador invocador = ClienteReceptor.getComandos();
            final String sql = "Selecciona los primeros diez nombres de la tabla Usuario ordenados por id de forma ascendente";
    
            System.out.println("Consulta en lenguaje natural");
            System.out.println("\t" + sql);
            invocador.getComandos().forEach(comando -> comando.ejecutar(sql));
        }
    }
    ```
