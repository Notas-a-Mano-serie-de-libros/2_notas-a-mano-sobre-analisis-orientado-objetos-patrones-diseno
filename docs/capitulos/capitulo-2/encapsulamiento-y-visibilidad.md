# Encapsulamiento

<span class="chapter-kicker">Capítulo 2 · Pilares de la programación orientada a objetos</span>

El encapsulamiento define los mecanismos que determinan quién puede ver e interactuar con los atributos y operaciones de una clase. Su propósito es proteger el estado interno y ofrecer una interfaz estable que controle la forma en que otros objetos consultan o modifican ese estado.

Declarar atributos privados es una herramienta, no el objetivo completo. Una clase bien encapsulada también valida sus cambios, conserva sus invariantes y evita que los clientes dependan de detalles internos que podrían cambiar.

<figure class="uml-figure uml-figure--wide">
  <img src="../../../assets/images/contenido/capitulos/capitulo2/encapsulamiento/encapsulamiento_1.svg" alt="Interacción de un cliente con la interfaz pública y el estado interno de una clase">
  <figcaption><strong>Figura 2.2.</strong> El cliente interactúa con el objeto mediante su interfaz pública, mientras el estado interno permanece protegido.</figcaption>
</figure>

<figure class="uml-figure uml-figure--wide">
  <img src="../../../assets/images/contenido/capitulos/capitulo2/encapsulamiento/encapsulamiento_2.svg" alt="Resumen de los modificadores de acceso aplicados a una clase Persona">
  <figcaption><strong>Figura 2.3.</strong> Los modificadores establecen fronteras distintas para atributos y operaciones.</figcaption>
</figure>

**Accesos directos a los ejemplos**

| Modificador | Símbolo UML | Acceso |
| --- | :---: | --- |
| Público | `+` | [Explicación, figura y código](#visibilidad-publica) |
| Protegido | `#` | [Explicación, figura y código](#visibilidad-protegida) |
| Privado | `-` | [Explicación, figura y código](#visibilidad-privada) |
| Por defecto o paquete | `~` | [Explicación, figura y código](#visibilidad-de-paquete) |

<a id="visibilidad-publica"></a>
## 2.3.1 Modificador público (`public`)

Un miembro `public` forma parte del contrato disponible para cualquier cliente que pueda referenciar la clase. Debe reservarse para operaciones estables y necesarias, pues ampliar la interfaz pública también amplía los compromisos de compatibilidad.

<figure class="uml-figure uml-figure--wide">
  <img src="../../../assets/images/contenido/capitulos/capitulo2/encapsulamiento/public.svg" alt="Acceso permitido para un atributo público">
  <figcaption><strong>Figura 2.5.</strong> Todas las clases pueden acceder directamente al miembro público.</figcaption>
</figure>

<details class="readonly-code-panel" open markdown="1">
<summary>Código Java · modificador public</summary>

```java
package dominio;

public class ClaseA {
    public String atributo = "visible para todo el sistema";
}

class ClaseB extends ClaseA {
    void leer() { System.out.println(atributo); } // Correcto.
}

class ClaseC {
    void leer(ClaseA a) { System.out.println(a.atributo); } // Correcto.
}
```

</details>

**Discusión.** La visibilidad pública es adecuada cuando el acceso directo no amenaza la integridad del objeto, por ejemplo, en constantes inmutables. Para el estado mutable suele ser preferible exponer operaciones que expresen intención y puedan validar el cambio.

<a id="visibilidad-protegida"></a>
## 2.3.2 Modificador protegido (`protected`)

En Java, un miembro `protected` es accesible desde las clases del mismo paquete y desde subclases ubicadas en otros paquetes. No constituye una interfaz pública general: una clase externa que no hereda del tipo no puede acceder directamente. En UML se representa con `#`.

<figure class="uml-figure uml-figure--wide">
  <img src="../../../assets/images/contenido/capitulos/capitulo2/encapsulamiento/protected.svg" alt="Acceso permitido y denegado para un atributo protegido">
  <figcaption><strong>Figura 2.6.</strong> El acceso protegido alcanza al paquete y a la jerarquía de herencia.</figcaption>
</figure>

<details class="readonly-code-panel" open markdown="1">
<summary>Código Java · modificador protected</summary>

```java
// archivo dominio/ClaseA.java
package dominio;
public class ClaseA {
    protected String atributo = "visible para paquete y subclases";
}

// archivo dominio/ClaseC.java
package dominio;
class ClaseC {
    void leer(ClaseA a) { System.out.println(a.atributo); } // Correcto: mismo paquete.
}

// archivo externo/ClaseB.java
package externo;
class ClaseB extends dominio.ClaseA {
    void leer() { System.out.println(atributo); } // Correcto: subclase.
}

// archivo externo/ClaseD.java
package externo;
class ClaseD {
    // a.atributo no compila: no pertenece al paquete ni hereda de ClaseA.
}
```

</details>

**Discusión.** El modificador protegido resulta útil cuando la clase fue diseñada para ser extendida y sus subclases necesitan colaborar con parte del estado interno. Debe emplearse con prudencia porque cada miembro protegido pasa a formar parte del contrato de herencia.

<a id="visibilidad-privada"></a>
## 2.3.3 Modificador privado (`private`)

Un miembro `private` solo puede utilizarse directamente desde la clase que lo declara. Las subclases y los colaboradores deben interactuar mediante operaciones públicas o protegidas, lo que permite validar los cambios y conservar las invariantes. En UML se identifica con `-`.

<figure class="uml-figure uml-figure--wide">
  <img src="../../../assets/images/contenido/capitulos/capitulo2/encapsulamiento/private.svg" alt="Acceso permitido y denegado para un atributo privado">
  <figcaption><strong>Figura 2.7.</strong> Solo `ClaseA` accede directamente al atributo privado; las demás clases utilizan su interfaz.</figcaption>
</figure>

<details class="readonly-code-panel" open markdown="1">
<summary>Código Java · modificador private</summary>

```java
public class ClaseA {
    private int atributo;

    public int getAtributo() {
        return atributo;
    }

    public void setAtributo(int nuevoValor) {
        if (nuevoValor < 0) {
            throw new IllegalArgumentException("El valor no puede ser negativo");
        }
        atributo = nuevoValor;
    }
}

class ClaseB extends ClaseA {
    void actualizar() {
        setAtributo(10);          // Correcto: usa la interfaz pública.
        // atributo = 10;         // No compila: atributo es privado.
    }
}
```

</details>

**Discusión.** La privacidad evita que un cliente deje el objeto en un estado inválido. La validación reside junto al dato que protege, por lo que cualquier cambio atraviesa una única regla de consistencia.

<a id="visibilidad-de-paquete"></a>
## 2.3.4 Modificador por defecto o de paquete

Cuando una declaración Java no incluye modificador, utiliza acceso de paquete o *package-private*. Cualquier clase del mismo paquete puede acceder al miembro, exista o no herencia; desde otro paquete no es visible. UML suele representarlo con `~`.

<figure class="uml-figure uml-figure--wide">
  <img src="../../../assets/images/contenido/capitulos/capitulo2/encapsulamiento/default.svg" alt="Acceso permitido y denegado para un atributo con visibilidad de paquete">
  <figcaption><strong>Figura 2.8.</strong> La frontera de acceso coincide con la frontera del paquete.</figcaption>
</figure>

<details class="readonly-code-panel" open markdown="1">
<summary>Código Java · acceso por defecto</summary>

```java
// archivo dominio/ClaseA.java
package dominio;
public class ClaseA {
    String atributo = "visible dentro de dominio"; // Sin modificador.
}

// archivo dominio/ClaseC.java
package dominio;
class ClaseC {
    void leer(ClaseA a) { System.out.println(a.atributo); } // Correcto.
}

// archivo externo/ClaseB.java
package externo;
class ClaseB extends dominio.ClaseA {
    // atributo no es visible, aunque ClaseB sea una subclase.
}
```

</details>

**Discusión.** El acceso de paquete permite que un conjunto de clases relacionadas colabore sin exponer su implementación al resto del sistema. Su semántica depende del lenguaje: en Java la ausencia de modificador significa paquete, mientras que otros lenguajes adoptan valores predeterminados distintos.

!!! note "Idea central"
    La visibilidad correcta es la mínima que permite la colaboración prevista. Reducir la superficie pública disminuye el acoplamiento, pero ocultar indiscriminadamente puede producir objetos difíciles de utilizar.
