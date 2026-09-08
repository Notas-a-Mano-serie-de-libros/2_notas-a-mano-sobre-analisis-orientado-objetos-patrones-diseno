# Encapsulamiento

Encapsular significa mantener juntas la información y las operaciones que protegen su consistencia, ocultando decisiones internas detrás de una interfaz estable. Declarar atributos privados es una herramienta, no el objetivo completo: un objeto también debe impedir estados inválidos y evitar que sus clientes dependan de detalles que pueden cambiar.

**Accesos directos a los ejemplos**

| Elemento | Acceso |
| --- | --- |
| Privado (`-`) | [Explicación y figura](#visibilidad-privada) |
| Protegido (`#`) | [Explicación y figura](#visibilidad-protegida) |
| Paquete (`~`) | [Explicación y figura](#visibilidad-de-paquete) |
| Público (`+`) | [Explicación y figura](#visibilidad-publica) |
| Comparación en Java | [Código genérico](#codigo-visibilidad) |

<a id="visibilidad-privada"></a>
### 2.3.1 Visibilidad privada

Un miembro `private` solo puede utilizarse directamente desde la clase que lo declara. Las subclases y los colaboradores deben interactuar mediante operaciones públicas o protegidas, lo que permite validar cambios y conservar invariantes. En UML se identifica con el signo `-`.

<figure class="uml-figure uml-figure--wide">
  <img src="../../../assets/images/contenido/capitulos/capitulo2/encapsulamiento/private.png" alt="Acceso permitido y denegado para un atributo privado">
  <figcaption><strong>Figura 2.5.</strong> Solo la clase que declara el atributo privado tiene acceso directo; los demás objetos utilizan su interfaz pública.</figcaption>
</figure>

<a id="visibilidad-protegida"></a>
### 2.3.2 Visibilidad protegida

Un miembro `protected` es accesible desde las clases del mismo paquete y desde subclases, incluso cuando estas pertenecen a otro paquete. No constituye una interfaz pública general: las clases externas que no heredan del tipo no pueden acceder directamente. En UML se representa con `#`.

<figure class="uml-figure uml-figure--wide">
  <img src="../../../assets/images/contenido/capitulos/capitulo2/encapsulamiento/protected.png" alt="Acceso permitido y denegado para un atributo protegido">
  <figcaption><strong>Figura 2.6.</strong> El acceso protegido alcanza al paquete y a la jerarquía de herencia.</figcaption>
</figure>

<a id="visibilidad-de-paquete"></a>
### 2.3.3 Visibilidad de paquete

Cuando una declaración Java no incluye modificador, utiliza acceso de paquete o *package-private*. Cualquier clase del mismo paquete puede acceder al miembro, exista o no herencia; desde otro paquete no es visible. UML utiliza el símbolo `~`.

<figure class="uml-figure uml-figure--wide">
  <img src="../../../assets/images/contenido/capitulos/capitulo2/encapsulamiento/default.png" alt="Acceso permitido y denegado para un atributo con visibilidad de paquete">
  <figcaption><strong>Figura 2.7.</strong> La frontera de acceso coincide con la frontera del paquete.</figcaption>
</figure>

<a id="visibilidad-publica"></a>
### 2.3.4 Visibilidad pública

Un miembro `public` forma parte del contrato disponible para cualquier cliente que pueda referenciar la clase. Debe reservarse para operaciones estables y necesarias, pues ampliar la interfaz pública también amplía los compromisos de compatibilidad. UML lo representa con `+`.

<figure class="uml-figure uml-figure--wide">
  <img src="../../../assets/images/contenido/capitulos/capitulo2/encapsulamiento/public.png" alt="Acceso permitido para un atributo público">
  <figcaption><strong>Figura 2.8.</strong> Todas las clases pueden acceder al miembro público.</figcaption>
</figure>

<a id="codigo-visibilidad"></a>
??? example "Código genérico · modificadores de acceso"

    ```java
    class Cuenta {
        private double saldo;       // Solo Cuenta.
        protected String titular;   // Paquete y subclases.
        String moneda;              // Solo el mismo paquete.
        public void depositar(double valor) {
            if (valor <= 0) throw new IllegalArgumentException();
            saldo += valor;
        }
    }

    class CuentaPremium extends Cuenta {
        void mostrarTitular() {
            System.out.println(titular); // Acceso protegido válido.
        }
    }
    ```

Una interfaz pública pequeña reduce el acoplamiento y facilita cambiar la representación interna. Sin embargo, ocultar indiscriminadamente también puede producir objetos difíciles de usar. La visibilidad correcta es la mínima que permite la colaboración prevista.

