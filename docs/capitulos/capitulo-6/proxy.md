<h1 style="text-align:center;"><strong> Proxy (Intermediario)</strong></h1>

<h4 style="text-align:center;"><em>“Proporciona un sustituto o representante de otro objeto para controlar su
acceso.”</em></h4>


## Definición

<p style="text-align:justify;">
El patrón <b>Proxy</b> tiene como objetivo controlar el acceso a un objeto,
proveyendo una capa intermediaria entre el cliente y el recurso real.
El proxy actúa como un sustituto, pudiendo añadir comportamientos adicionales como validación, registro, carga diferida o comunicación remota antes de delegar la operación al objeto original.
</p>

<hr/>

## Motivación

<p style="text-align:justify;">
El patrón <b>Proxy</b> se utiliza cuando se desea ejercer control sobre el acceso a objetos costosos o sensibles.
Puede retrasar la creación de objetos complejos hasta que sean necesarios (proxy virtual), controlar el acceso (proxy de protección), representar un objeto remoto (proxy remoto) o añadir funcionalidades adicionales sin modificar el código original (referencia inteligente).
</p>

<hr/>

## Modelo UML

<p style="text-align:justify;">
La interfaz <b>IObjetivo</b> define las operaciones del objeto real.
El <b>Proxy</b> implementa la misma interfaz y mantiene una referencia al <b>ObjetoReal</b>, interceptando las llamadas y ejecutando operaciones adicionales antes o después de delegar la tarea.
De esta manera, el cliente interactúa siempre con el proxy sin conocer si está accediendo al objeto real o no.
</p>

<p style="text-align:center;">
  <img src="../../../assets/images/contenido/capitulos/capitulo6/proxy.png" alt="Diagrama UML del patrón Proxy" width="70%" height="auto"/>
</p>

<p style="text-align:center;"><b>Figura 1.</b> Diagrama UML del patrón <i>Proxy</i>.</p>

<hr/>

## Implementación genérica de la estructura

Las clases e interfaces conservan los nombres de los participantes del modelo UML anterior. Así puede seguirse cada relación del diagrama directamente en el código. Java se muestra por defecto; las otras pestañas expresan la misma colaboración sin cambiar su intención.

=== "Java"

    ```java
    interface IObjetivo {
        void solicitud();
    }
    
    final class ObjetoReal implements IObjetivo {
        public void solicitud() { System.out.println("Objeto real"); }
    }
    
    final class Proxy implements IObjetivo {
        private ObjetoReal objetoReal;
        public void solicitud() {
            if (objetoReal == null) objetoReal = new ObjetoReal();
            objetoReal.solicitud();
        }
    }
    ```

=== "Python"

    ```python
    class IObjetivo:
        def solicitud(self): raise NotImplementedError
    class ObjetoReal(IObjetivo):
        def solicitud(self): return "real"
    class Proxy(IObjetivo):
        def __init__(self): self.real = None
        def solicitud(self):
            if self.real is None: self.real = ObjetoReal()
            return self.real.solicitud()
    ```

=== "C#"

    ```csharp
    interface IObjetivo { void Solicitud(); }
    
    class ObjetoReal : IObjetivo { public void Solicitud() { } }
    
    class Proxy : IObjetivo {
        private ObjetoReal? real;
        public void Solicitud() { real ??= new ObjetoReal(); real.Solicitud(); }
    }
    ```

=== "Pseudocódigo"

    ```text
    INTERFAZ IObjetivo: solicitud()
    CLASE ObjetoReal IMPLEMENTA IObjetivo
    CLASE Proxy IMPLEMENTA IObjetivo
        real ← NULO
        solicitud(): validar; crear real si falta; delegar real.solicitud()
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
      <td style="text-align:center;"><b>IObjetivo</b></td>
      <td style="text-align:justify;">Define la interfaz común entre el objeto real y el proxy.</td>
    </tr>
    <tr>
      <td style="text-align:center;"><b>ObjetoReal</b></td>
      <td style="text-align:justify;">Clase que implementa la lógica o funcionalidad principal del sistema.</td>
    </tr>
    <tr>
      <td style="text-align:center;"><b>Proxy</b></td>
      <td style="text-align:justify;">Intermediario que controla el acceso al objeto real, pudiendo realizar tareas adicionales como validación, logging o caching.</td>
    </tr>
    <tr>
      <td style="text-align:center;"><b>Cliente</b></td>
      <td style="text-align:justify;">Solicita servicios a través de la interfaz común sin distinguir si el objeto es real o un proxy.</td>
    </tr>
  </tbody>
</table>

<hr/>

## Enunciado del problema

Se solicita controlar el acceso a los recursos de un portal web que cuenta con dos roles: (i) los usuarios tienen permisos básicos para navegar en el portal y (ii) los administradores pueden acceder a los recursos del sistema. Se requiere un mecanismo que permita controlar el acceso de los usuarios a los recursos de la aplicación.

## Solución en código

El ejemplo deja visible el punto de entrada `main`; las clases que colaboran con él se explican en las secciones anteriores.

=== "Java"

    ```java
    package capitulo6.proxy;
    
    import capitulo6.proxy.dominio.IServidor;
    import capitulo6.proxy.dominio.implementacion.Proxy;
    import capitulo6.proxy.usuario.Admin;
    import capitulo6.proxy.usuario.UsuarioBasico;
    import capitulo6.proxy.usuario.UsuarioSistema;
    
    public class Cliente {
        public static void main(String[] args) {
            final UsuarioSistema admin = new Admin("admin", "admin");
            final UsuarioSistema corozco = new UsuarioBasico("corozco", "111",
                    "Carlos Orozco");
    
            final IServidor proxyServer = new Proxy("host_remoto", "8081");
            proxyServer.acceder(corozco, "login");
            proxyServer.acceder(corozco, "admin");
            proxyServer.acceder(admin, "admin");
            proxyServer.acceder(admin, "server");
        }
    }
    ```
