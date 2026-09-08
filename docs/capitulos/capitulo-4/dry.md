<h1 style="text-align:center;"><strong> DRY (Don’t Repeat Yourself)</strong></h1>

<div class="lab-action" markdown>
[:fontawesome-brands-github: ABRIR EN CODESPACES](https://codespaces.new/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno?quickstart=1){ .md-button .md-button--primary .codespaces-button target="_blank" rel="noopener noreferrer" }
<span class="lab-action__note">Requiere una cuenta de GitHub. Consulta la <a href="../../../codespaces/">guía de preparación</a> y ejecuta las pruebas o el comando indicado en el ejemplo.</span>
</div>

<h4 style="text-align:center;"><em>“Cada pieza de conocimiento debe tener una representación única, clara y autoritativa dentro de un sistema.”</em></h4>

<p style="text-align: justify;">
El <b>principio DRY</b> —acrónimo de <i>“Don’t Repeat Yourself”</i>, traducido como <b>“No te repitas”</b>— establece que <b>ninguna forma de conocimiento debería duplicarse dentro de un sistema</b>.
Este principio fue introducido formalmente en 1999 en el libro <i>The Pragmatic Programmer</i> (<a href="#ref">Hunt &amp; Thomas, 1999</a>) y se ha convertido en una de las bases más importantes del desarrollo de software moderno.
</p>

<p style="text-align: justify;">
En sus primeras interpretaciones, el principio DRY se asociaba exclusivamente con la <b>eliminación de código duplicado</b>.
No obstante, sus autores aclararon posteriormente que su alcance es mucho más amplio: <b>DRY aplica a cualquier tipo de conocimiento representado dentro de un sistema</b> —ya sea código, documentación, reglas de negocio, datos, o procesos operativos—.
Su objetivo final es mantener una <b>única fuente de verdad</b> (Single Source of Truth), asegurando la consistencia, la coherencia y la trazabilidad del conocimiento.
</p>

---

##  Propósito del principio

<p style="text-align: justify;">
El principio DRY busca garantizar que cada pieza de información relevante en el sistema exista en un solo lugar.
De esta forma, cuando se necesite modificar, actualizar o eliminar dicha información, los cambios se realicen <b>una sola vez</b>, evitando inconsistencias o comportamientos inesperados.
En esencia, DRY fomenta un <b>diseño limpio, coherente y fácil de mantener</b>.
</p>

##  Consideraciones para su aplicación

<p style="text-align: justify;">
Aplicar el principio <b>DRY</b> puede resultar complejo para quienes inician en el diseño de software, ya que no toda duplicación es necesariamente negativa.
A continuación, se presentan algunos lineamientos que permiten identificar cuándo una solución puede beneficiarse de este principio:
</p>

<table>
  <thead>
    <tr>
      <th style="text-align:center;"> Criterio</th>
      <th style="text-align:justify;"> Descripción</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td style="text-align:center;"><b>Identificación de duplicación</b></td>
      <td style="text-align:justify;">Debe existir una duplicación clara de lógica, datos o estructuras dentro del sistema. Esta duplicación puede encontrarse en cualquier artefacto: código fuente, documentación, pruebas, configuración o datos de negocio.</td>
    </tr>
    <tr>
      <td style="text-align:center;"><b>Contexto común</b></td>
      <td style="text-align:justify;">Los elementos duplicados deben responder al mismo propósito o contexto funcional. Si dos estructuras similares resuelven problemas conceptualmente distintos, no deben unificarse, ya que sus requisitos pueden divergir.</td>
    </tr>
    <tr>
      <td style="text-align:center;"><b>Posibilidad de abstracción</b></td>
      <td style="text-align:justify;">Debe ser posible abstraer la funcionalidad repetida en una entidad común —por ejemplo, una función, clase, módulo o documento compartido— sin afectar la semántica original.</td>
    </tr>
    <tr>
      <td style="text-align:center;"><b>Mantenibilidad mejorada</b></td>
      <td style="text-align:justify;">La aplicación del principio debe mejorar la legibilidad y la extensibilidad del sistema, facilitando futuras modificaciones o adaptaciones.</td>
    </tr>
    <tr>
      <td style="text-align:center;"><b>Beneficio sobre el costo</b></td>
      <td style="text-align:justify;">Aplicar DRY debe aportar un beneficio tangible que justifique los costos de refactorización. Si el esfuerzo requerido supera el valor obtenido, se recomienda mantener la duplicación controlada.</td>
    </tr>
  </tbody>
</table>

---

##  Beneficios del principio DRY

|  Beneficio |  Descripción |
|--------------|----------------|
| **Consistencia** | <p style="text-align: justify;">Una única fuente de verdad garantiza coherencia entre las distintas capas del sistema.</p> |
| **Mantenibilidad** | <p style="text-align: justify;">Los cambios se realizan en un único punto, reduciendo errores y simplificando el mantenimiento.</p> |
| **Eficiencia** | <p style="text-align: justify;">Evita duplicar esfuerzos en codificación, documentación o pruebas.</p> |
| **Escalabilidad** | <p style="text-align: justify;">Favorece arquitecturas modulares donde los componentes pueden evolucionar sin afectar a otros.</p> |
| **Trazabilidad** | <p style="text-align: justify;">Facilita la comprensión de la lógica del sistema al mantener las reglas de negocio centralizadas.</p> |

---

##  Cuándo **no** aplicar DRY

<p style="text-align: justify;">
El principio DRY no debe aplicarse de manera dogmática.
Existen situaciones en las que la duplicación puede ser aceptable o incluso deseable:
</p>

- Cuando los contextos funcionales son distintos aunque el código parezca similar.
- En prototipos o pruebas exploratorias, donde la abstracción prematura puede obstaculizar la iteración.
- En código auto-contenido donde la independencia entre módulos es prioritaria sobre la reutilización.

<p style="text-align: justify;">
La clave es equilibrar la <b>claridad</b> con la <b>reutilización</b>: eliminar duplicaciones innecesarias sin comprometer la comprensión del sistema.
</p>

---

##  Conceptos relacionados

###  Abstracción
<p style="text-align: justify;">
Proceso mediante el cual se encapsula una idea o comportamiento común en una entidad genérica (función, clase o módulo), evitando repeticiones en el código.
</p>

###  Reutilización
<p style="text-align: justify;">
Capacidad de emplear componentes existentes en distintos contextos, reduciendo la redundancia y mejorando la eficiencia del desarrollo.
</p>

###  Cohesión y acoplamiento
<p style="text-align: justify;">
El principio DRY promueve alta cohesión —cada módulo cumple un propósito único— y bajo acoplamiento —los módulos dependen lo mínimo entre sí—.
</p>

---

## Ejemplos

<ul class="chapter-section-list">
<li><a href="#ejemplo-dry-1"><strong>Duplicación de código</strong></a><small>Tres operaciones repiten el cálculo del promedio y la versión refactorizada concentra el conocimiento.</small></li>
<li><a href="#ejemplo-dry-2"><strong>Duplicación en la documentación</strong></a><small>La comparación muestra cómo los comentarios repetidos se desactualizan.</small></li>
<li><a href="#ejemplo-dry-3"><strong>Duplicación del modelo</strong></a><small>Estudiante y Profesor comparten datos que pueden representarse una sola vez.</small></li>
<li><a href="#ejemplo-dry-4"><strong>Coincidencia frente a regla de negocio</strong></a><small>Una semejanza accidental no siempre representa una misma regla.</small></li>
<li><a href="#ejemplo-dry-5"><strong>Duplicación de procesos</strong></a><small>El cálculo combinatorio permite identificar una única fuente para factorial.</small></li>
</ul>

## Ejemplos desarrollados

<a id="ejemplo-dry-1"></a>
### 1. Duplicación de código

Tres operaciones repiten el cálculo del promedio; la versión refactorizada concentra el conocimiento en una sola operación reutilizable.

??? example "dry_codigo/Utilidad.java"

    ```java
    package capitulo4.dry.dry_codigo;
    
    public class Utilidad {
    
        public double getPromedioCalificaciones(double nota1, double nota2) {
            return (nota1 + nota2) / 2;
        }
    
        public double getPromedioVentas(double venta1, double venta2, double venta3) {
            return (venta1 + venta2 + venta3) / 3;
        }
    
        public double getPromedioEdades(double edad1, double edad2, double edad3, double edad4) {
            return (edad1 + edad2 + edad3 + edad4) / 4;
        }
    }
    ```

??? example "dry_codigo/UtilidadRefactorizada.java"

    ```java
    package capitulo4.dry.dry_codigo;
    
    import java.util.Arrays;
    
    public class UtilidadRefactorizada {
        public static double getPromedio(double... args) {
            return Arrays.stream(args).average().getAsDouble();
        }
    }
    ```

<a id="ejemplo-dry-2"></a>
### 2. Duplicación en la documentación

La comparación muestra cómo comentarios que repiten literalmente el código se desactualizan y añaden ruido sin explicar decisiones.

??? example "dry_documentacion/Calculadora.java"

    ```java
    package capitulo4.dry.dry_documentacion;
    
    /**
     * Esta clase se llama Calculadora.
     * Sirve para realizar operaciones matemáticas básicas.
     * + Se espera agregar nuevas operaciones en el futuro.
     */
    public class Calculadora {
    
        /**
         * Este método suma dos números.
         *
         * @param a El primer número a sumar.
         * @param b El segundo número a sumar.
         * @return La suma de los dos números.
         */
        public int sumarDosNumeros(int a, int b) {
            return a + b; // Suma los dos números y devuelve el resultado
        }
    }
    ```

??? example "dry_documentacion/CalculadoraDRY.java"

    ```java
    package capitulo4.dry.dry_documentacion;
    
    // Utilidad que permite realizar operaciones aritméticas simples
    public class CalculadoraDRY {
        public int sumar(int a, int b) {
            return a + b;
        }
    }
    ```

<a id="ejemplo-dry-3"></a>
### 3. Duplicación del modelo

Estudiante y Profesor repiten los datos de una persona; la refactorización introduce una representación común para ese conocimiento compartido.

??? example "dry_logica/entidades/Estudiante.java"

    ```java
    package capitulo4.dry.dry_logica.entidades;
    
    public class Estudiante {
        private String documento;
        private String nombre;
        private String correoElectronico;
        private double promedio;
        private int semestre;
    }
    ```

??? example "dry_logica/entidades/Profesor.java"

    ```java
    package capitulo4.dry.dry_logica.entidades;
    
    public class Profesor {
        private String documento;
        private String nombre;
        private String correoElectronico;
        private String departamento;
        private String tipoContrato;
        private int horasAsignadas;
    }
    ```

??? example "dry_logica/entidades_refactor/Persona.java"

    ```java
    package capitulo4.dry.dry_logica.entidades_refactor;
    
    public class Persona {
        private String documento;
        private String nombre;
        private String correoElectronico;
    }
    ```

??? example "dry_logica/entidades_refactor/Estudiante.java"

    ```java
    package capitulo4.dry.dry_logica.entidades_refactor;
    
    public class Estudiante extends Persona {
        private double promedio;
        private int semestre;
    }
    ```

??? example "dry_logica/entidades_refactor/Profesor.java"

    ```java
    package capitulo4.dry.dry_logica.entidades_refactor;
    
    public class Profesor extends Persona {
        private String departamento;
        private String tipoContrato;
        private int horasAsignadas;
    }
    ```

<a id="ejemplo-dry-4"></a>
### 4. Coincidencia frente a regla de negocio

El mismo valor límite no implica necesariamente una única regla: abstraer semejanzas accidentales puede acoplar decisiones que deben evolucionar por separado.

??? example "dry_negocio/Utilidad.java"

    ```java
    package capitulo4.dry.dry_negocio;
    
    public class Utilidad {
    
        public boolean esMayorDeEdad(int edad) {
            return edad > 18;
        }
    
        public boolean validarCantidadProductos(int cantidad) {
            return cantidad > 18;
        }
    }
    ```

<a id="ejemplo-dry-5"></a>
### 5. Duplicación de procesos

El cálculo combinatorio vuelve a implementar factorial; el caso permite identificar cuándo una operación común debe tener una sola fuente autorizada.

??? example "dry_proceso/Utilidad.java"

    ```java
    package capitulo4.dry.dry_proceso;
    
    public class Utilidad {
        public static int factorial(int n) {
            if (n < 0) {
                throw new IllegalArgumentException("n no puede ser negativo");
            }
            if (n == 0 || n == 1) {
                return 1;
            } else {
                return n * factorial(n - 1);
            }
        }
    }
    ```

??? example "dry_proceso/UtilidadCombinatoria.java"

    ```java
    package capitulo4.dry.dry_proceso;
    
    public class UtilidadCombinatoria {
        public static int coeficienteBinomial(int n, int k) {
            if (k < 0 || k > n) {
                throw new IllegalArgumentException("k debe estar entre 0 y n");
            }
            return factorial(n) / (factorial(k) * factorial(n - k));
        }
    
        public static int factorial(int n) {
            if (n < 0) {
                throw new IllegalArgumentException("n no puede ser negativo");
            }
    
            int resultado = 1;
            for (int i = 2; i <= n; i++) {
                resultado *= i;
            }
            return resultado;
        }
    }
    ```

<hr/>

## Aplicación, ventajas y límites

| Elemento de análisis | Desarrollo |
| --- | --- |
| **Problema que aborda** | El mismo conocimiento está representado en varios lugares que pueden divergir. |
| **Escenario de aplicación** | Reglas de validación, fórmulas, configuraciones o documentación repetida. |
| **Ventaja principal** | Una fuente autorizada mantiene consistencia y reduce cambios duplicados. |
| **Desventaja o precaución** | La semejanza accidental no justifica una abstracción común. |


<hr/>

## Bibliografía
<p style="text-align: justify;" id="ref">
Hunt, A., &amp; Thomas, D. (1999). <i>The Pragmatic Programmer: From Journeyman to Master</i>.
Addison-Wesley Professional. ISBN 978-0-2016-1622-4.
</p>


---

[:material-code-tags: Consultar el README y el código fuente](https://github.com/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/blob/main/src/main/java/capitulo4/dry/README.md){ .md-button target="_blank" rel="noopener noreferrer" }
