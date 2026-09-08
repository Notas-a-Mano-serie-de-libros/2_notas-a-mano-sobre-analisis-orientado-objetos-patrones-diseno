<h1 style="text-align:center;">
  <strong> Chain of Responsibility</strong><br>
  <strong>(Cadena de Responsabilidad)</strong>
</h1>

<h4 style="text-align:center;"><em>“Permite que una solicitud recorra una cadena de manejadores hasta que uno de ellos
la procese.”</em></h4>


## Definición

<p style="text-align:justify;">
El <b>patrón Chain of Responsibility</b> pertenece al grupo de <b>patrones de comportamiento</b> y tiene como propósito <b>desacoplar el emisor de una solicitud del receptor</b>.
Cada manejador (handler) en la cadena decide si procesa la petición o la reenvía al siguiente manejador.
De este modo, el flujo de responsabilidad se distribuye de forma flexible y extensible, favoreciendo la cohesión y reduciendo el acoplamiento.
</p>

<hr/>

## Motivación
<p style="text-align:justify;">
En muchos sistemas, una petición puede requerir pasar por varias etapas o verificaciones antes de ser procesada.
Por ejemplo, una solicitud de pago puede necesitar validaciones de autenticación, saldo, límites y auditoría antes de aprobarse.
En lugar de escribir una secuencia rígida de condiciones, el patrón <b>Chain of Responsibility</b> permite que cada paso sea manejado por un objeto independiente, organizado en una <b>cadena dinámica</b> de responsabilidades.
</p>

<p style="text-align:justify;">
Este patrón sigue el principio de <i>“no acoplar directamente el emisor con el receptor”</i>.
Cada manejador se enfoca en una sola tarea, y la estructura de la cadena puede modificarse sin alterar la lógica de los demás componentes.
</p>

<hr/>

## Modelo UML

<p style="text-align:justify;">
La clase <b>Manejador</b> define una interfaz común para procesar solicitudes y mantener una referencia al siguiente manejador en la cadena.
Cada <b>ManejadorConcreto</b> decide si puede manejar la petición o, en caso contrario, la reenvía al siguiente.
</p>

<p style="text-align:center;">
  <img src="../../../assets/images/contenido/capitulos/capitulo7/chain_of_responsability.png" alt="Diagrama UML del patrón Chain of Responsibility" width="70%" height="auto">
</p>
<p style="text-align:center;"><b>Figura 1.</b> Diagrama UML del patrón <i>Chain of Responsibility</i>.</p>

<hr/>

## Implementación genérica de la estructura

Las clases e interfaces conservan los nombres de los participantes del modelo UML anterior. Así puede seguirse cada relación del diagrama directamente en el código. Java se muestra por defecto; las otras pestañas expresan la misma colaboración sin cambiar su intención.

=== "Java"

    ```java
    abstract class Manejador {
        private Manejador siguiente;
        Manejador enlazar(Manejador siguiente) { this.siguiente = siguiente; return siguiente; }
        public void manejar(String solicitud) {
            if (siguiente != null) siguiente.manejar(solicitud);
        }
    }
    
    final class ManejadorConcreto extends Manejador {
        public void manejar(String solicitud) {
            if ("admitida".equals(solicitud)) System.out.println("Solicitud atendida");
            else super.manejar(solicitud);
        }
    }
    ```

=== "Python"

    ```python
    class Manejador:
        def __init__(self): self.siguiente = None
        def enlazar(self, siguiente): self.siguiente = siguiente; return siguiente
        def manejar(self, solicitud):
            return self.siguiente.manejar(solicitud) if self.siguiente else None
    class ManejadorConcreto(Manejador):
        def manejar(self, solicitud):
            return "atendida" if solicitud == "admitida" else super().manejar(solicitud)
    ```

=== "C#"

    ```csharp
    abstract class Manejador {
        private Manejador? siguiente;
        public Manejador Enlazar(Manejador s) { siguiente = s; return s; }
        public virtual void Manejar(string solicitud) => siguiente?.Manejar(solicitud);
    }
    
    class ManejadorConcreto : Manejador {
        public override void Manejar(string s) { if (s != "admitida") base.Manejar(s); }
    }
    ```

=== "Pseudocódigo"

    ```text
    CLASE Manejador: siguiente Manejador
        manejar(solicitud): delegar al siguiente si existe
    CLASE ManejadorConcreto EXTIENDE Manejador
        manejar(solicitud)
            SI puedeAtender ENTONCES procesar
            SI NO delegar mediante la superclase
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
      <td style="text-align:center;"><b>Manejador</b></td>
      <td style="text-align:justify;">Define la interfaz para manejar una solicitud y establece una referencia al siguiente manejador de la cadena.</td>
    </tr>
    <tr>
      <td style="text-align:center;"><b>ManejadorConcreto</b></td>
      <td style="text-align:justify;">Implementa la lógica para procesar una solicitud específica o reenviarla al siguiente manejador si no puede manejarla.</td>
    </tr>
    <tr>
      <td style="text-align:center;"><b>Cliente</b></td>
      <td style="text-align:justify;">Crea la cadena de manejadores y envía las solicitudes iniciales.</td>
    </tr>
  </tbody>
</table>

<hr/>

## Enunciado del problema

Una entidad bancaria solicita implementar un módulo que permita controlar el conducto regular que debe seguir una solicitud de crédito realizada por un cliente del banco. De acuerdo con el requerimiento, una solicitud de crédito se evalúa en cuatro etapas:

- Si el monto solicitado es menor o igual a cien mil pesos, la solicitud es evaluada por el asesor que tiene asignado el cliente.
- Si el monto es mayor a cien mil pesos y menor o igual a cinco millones de pesos, la solicitud se debe enviar al departamento de evaluación de riesgo.
- Si el monto es mayor a cinco millones de pesos y menor o igual a diez millones de pesos, la solicitud debe pasar por un proceso de evaluación de antecedentes judiciales.
- Si el monto supera los diez millones de pesos, la solicitud debe ser evaluada por el director del departamento de créditos.

## Solución en código

El ejemplo deja visible el punto de entrada `main`; las clases que colaboran con él se explican en las secciones anteriores.

=== "Java"

    ```java
    package capitulo7.cadena_responsabilidad;
    
    import capitulo7.cadena_responsabilidad.cadena.SolicitudCredito;
    import capitulo7.cadena_responsabilidad.manejadores.Asesor;
    import capitulo7.cadena_responsabilidad.manejadores.EvaluadorDirectivo;
    import capitulo7.cadena_responsabilidad.manejadores.EvaluadorJudicial;
    import capitulo7.cadena_responsabilidad.manejadores.EvaluadorRiesgo;
    
    public class Cliente {
        public static void main(String[] args) {
    
            // Inicializa los objetos de la cadena de responsabilidad
            final SolicitudCredito asesor = new Asesor();
            final SolicitudCredito evaluadorRiesgo = new EvaluadorRiesgo();
            final SolicitudCredito evaluadorJudicial = new EvaluadorJudicial();
            final SolicitudCredito evaluadorDirectivo = new EvaluadorDirectivo();
    
            // Crea la cadena de responsabilidad
            asesor.setSiguiente(evaluadorRiesgo);
            evaluadorRiesgo.setSiguiente(evaluadorJudicial);
            evaluadorJudicial.setSiguiente(evaluadorDirectivo);
    
            System.out.print("Solicitud por 100000: ");
            asesor.solicitar(100000);
            System.out.print("Solicitud por 7000000: ");
            asesor.solicitar(7000000);
            System.out.print("Solicitud por 12000000: ");
            asesor.solicitar(12000000);
            System.out.print("Solicitud por 20000000: ");
            asesor.solicitar(20000000);
        }
    }
    ```
