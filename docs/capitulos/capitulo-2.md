# Capítulo 2 · Introducción al diseño orientado a objetos

<span class="chapter-kicker">Conceptos y relaciones</span>

El capítulo establece el lenguaje compartido para analizar los diseños que aparecen después.

| Concepto | Función en el diseño | Precaución |
| --- | --- | --- |
| Clase | Define estructura y comportamiento común. | Debe expresar una responsabilidad reconocible. |
| Objeto | Aporta identidad, estado y comportamiento. | Conviene proteger su estado interno. |
| Abstracción | Conserva los rasgos relevantes para un propósito. | Depende del contexto del problema. |
| Encapsulamiento | Oculta decisiones detrás de una interfaz. | No se limita a declarar atributos privados. |
| Herencia | Expresa especialización entre tipos. | Requiere sustitución válida, no solo reutilización. |
| Polimorfismo | Permite variar comportamiento tras un contrato. | Las implementaciones deben preservar las expectativas. |

## Relaciones entre clases

Asociación, dependencia, agregación, composición, generalización y realización comunican dirección del conocimiento, propiedad y ciclo de vida. Un diagrama útil explica decisiones; no se limita a acumular clases.

## Del modelo al código

Los ejemplos Java del repositorio muestran cómo las relaciones se manifiestan mediante interfaces, campos, parámetros, composición y jerarquías. Estas herramientas se reutilizan en los principios y patrones de los capítulos siguientes.

[Explorar el código fuente](https://github.com/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/tree/main/src/main/java/com/corozco/libro){ .md-button }
