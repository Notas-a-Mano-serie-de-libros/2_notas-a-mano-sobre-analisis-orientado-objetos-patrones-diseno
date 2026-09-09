#!/usr/bin/env python3
"""Publica en MkDocs el contenido técnico mantenido en los README del código."""

from __future__ import annotations

import os
import re
import shutil
from html import unescape
from pathlib import Path

from pattern_generic_implementations import (
    CSHARP_IMPLEMENTATIONS,
    GENERIC_IMPLEMENTATIONS,
    PSEUDOCODE_IMPLEMENTATIONS,
    PYTHON_IMPLEMENTATIONS,
)


ROOT = Path(__file__).resolve().parents[1]
JAVA = ROOT / "src/main/java/com/corozco/libro"
RESOURCES = ROOT / "src/main/resources/images"
DOC_IMAGES = ROOT / "docs/assets/images/contenido"
GITHUB_BLOB = (
    "https://github.com/Notas-a-Mano-serie-de-libros/"
    "2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno/blob/main/"
)

PAGES: dict[Path, Path] = {}
RELATED_EXAMPLES: dict[Path, list[Path]] = {}


def register(source: Path, destination: Path) -> None:
    PAGES[source.resolve()] = destination.resolve()


# Capítulo 3 · GRASP
grasp_root = JAVA / "buenas_practicas/grasp"
register(grasp_root / "README.md", ROOT / "docs/capitulos/capitulo-3/grasp.md")
grasp_items = {
    "acoplamiento": ["ejemplo"],
    "cohesion": ["ejemplo"],
    "controlador": ["ejemplo_reserva_habitacion"],
    "creador": [
        "ejemplo_agregacion",
        "ejemplo_asociacion_dependencia",
        "ejemplo_composicion",
        "ejemplo_inicializacion",
    ],
    "experto_informacion": ["ejemplo_inventario"],
    "fabricacion_pura": ["ejemplo"],
    "indireccion": ["ejemplo"],
    "polimorfismo": ["ejemplo"],
    "variacion_protegida": ["ejemplo"],
}
for principle, examples in grasp_items.items():
    principle_source = grasp_root / principle / "README.md"
    register(
        principle_source,
        ROOT / f"docs/capitulos/capitulo-3/grasp/{principle}.md",
    )
    RELATED_EXAMPLES[principle_source.resolve()] = []
    for example in examples:
        example_source = grasp_root / principle / example / "README.md"
        register(
            example_source,
            ROOT / f"docs/capitulos/capitulo-3/grasp/{principle}-{example}.md",
        )
        RELATED_EXAMPLES[principle_source.resolve()].append(example_source.resolve())

# Capítulo 3 · SOLID
solid_root = JAVA / "buenas_practicas/solid"
register(solid_root / "README.md", ROOT / "docs/capitulos/capitulo-3/solid.md")
solid_items = {
    "responsabilidad_unica": [
        "ejemplo1_figuras_geometricas",
        "ejemplo2_manipulacion_facturas",
    ],
    "abierto_cerrado": [
        "ejemplo1_figuras_geometricas",
        "ejemplo2_solicitud_administrativa",
    ],
    "liskov": ["ejemplo1_figuras_geometrica", "ejemplo2_estacion_servicio"],
    "segregacion_interfaces": [
        "ejemplo1_figuras_geometricas",
        "ejemplo2_gestion_iot",
    ],
    "inversion_dependencias": [
        "ejemplo1_figuras_geometricas",
        "ejemplo2_servicio_almacenamiento",
    ],
}
for principle, examples in solid_items.items():
    principle_source = solid_root / principle / "README.md"
    register(
        principle_source,
        ROOT / f"docs/capitulos/capitulo-3/solid/{principle}.md",
    )
    RELATED_EXAMPLES[principle_source.resolve()] = []
    for example in examples:
        example_source = solid_root / principle / example / "README.md"
        register(
            example_source,
            ROOT / f"docs/capitulos/capitulo-3/solid/{principle}-{example}.md",
        )
        RELATED_EXAMPLES[principle_source.resolve()].append(example_source.resolve())

# Capítulo 4 · Buenas prácticas
practices_root = JAVA / "buenas_practicas"
for practice in ("dry", "kiss", "yagni", "demeter"):
    register(
        practices_root / practice / "README.md",
        ROOT / f"docs/capitulos/capitulo-4/{practice}.md",
    )
register(
    practices_root / "yagni/ejemplo/README.md",
    ROOT / "docs/capitulos/capitulo-4/yagni-ejemplo.md",
)
register(
    practices_root / "demeter/ejemplo_libreria/README.md",
    ROOT / "docs/capitulos/capitulo-4/demeter-ejemplo-libreria.md",
)
RELATED_EXAMPLES[(practices_root / "yagni/README.md").resolve()] = [
    (practices_root / "yagni/ejemplo/README.md").resolve()
]
RELATED_EXAMPLES[(practices_root / "demeter/README.md").resolve()] = [
    (practices_root / "demeter/ejemplo_libreria/README.md").resolve()
]

# Capítulos 5–7 · Patrones GoF
pattern_groups = {
    "capitulo-5": ("creacional", ["singleton", "prototype", "builder", "factory", "abstract_factory"]),
    "capitulo-6": ("estructural", ["adapter", "bridge", "composite", "decorator", "facade", "flyweight", "proxy"]),
    "capitulo-7": (
        "comportamiento",
        [
            "cadena_responsabilidad",
            "command",
            "iterator",
            "mediator",
            "memento",
            "observer",
            "state",
            "strategy",
            "template",
            "visitor",
        ],
    ),
}
PATTERN_CASES = {
    "singleton": (
        "De acuerdo con algunas teorías cosmológicas, nuestro Universo es el único que existe. Se solicita analizar cuál podría ser la lógica necesaria para «simular» la creación de nuestro Universo utilizando teoría de diseño orientado a objetos.",
        "Las dos solicitudes controladas devuelven la misma referencia; el ejemplo también hace visible por qué reflexión puede romper una implementación ingenua.",
    ),
    "prototype": (
        "El 5 de julio de 1996, un grupo de científicos del Instituto Roslin en la ciudad de Edimburgo clonó el primer mamífero con éxito. Para lograrlo, se basaron en las células de una oveja y tomaron su base genética para obtener una oveja idéntica llamada Dolly. Se solicita crear un programa que permita simular el proceso de clonación de la oveja.",
        "El clon conserva inicialmente los datos del prototipo y después puede cambiar sin modificar el objeto original.",
    ),
    "builder": (
        "En el campo de la física, la teoría de cuerdas propone la existencia de múltiples Universos, cada uno con sus propias leyes fundamentales. Se solicita implementar una solución que simule la creación de Universos. Para simplificar el problema, se asume que un Universo se caracteriza por un identificador, un código único, su masa, su porcentaje de materia bariónica —materia conocida—, su porcentaje de materia oscura, su porcentaje de energía oscura —en astronomía se le dice oscuro a todo aquello que no tenemos la más remota idea de qué es— y el conjunto de galaxias que tenga asociado.",
        "El cliente obtiene configuraciones legibles y el proceso de construcción mantiene juntas las validaciones del producto.",
    ),
    "factory": (
        "Una empresa de seguridad provee servicios enfocados en crear algoritmos de cifrado. Actualmente, la empresa cifra su información utilizando los algoritmos PS256, PS512 y RS256. Sin embargo, un nuevo cliente considera que los algoritmos que provee la empresa son obsoletos y solicitó incluir un servicio que cifre y descifre información utilizando el algoritmo RS512. En este sentido, se solicita definir una estructura genérica que permita a un cliente solicitar diferentes algoritmos de cifrado de manera dinámica.",
        "Cada creador concreto entrega un algoritmo a través del mismo contrato; RS512 se incorpora con un creador nuevo, sin condicionales en el cliente.",
    ),
    "abstract_factory": (
        "Se solicita crear un juego de estrategia llamado «History of Empires», un simulador que permita controlar a una cultura entre varias disponibles, ver su evolución con el paso del tiempo y luchar con otras civilizaciones. El objetivo del juego es avanzar progresivamente a través de diferentes eras —piedra, bronce, medieval, industrial y contemporánea—. Por diseño, cada era cuenta con un conjunto de unidades asociadas con su contexto histórico.",
        "Al cambiar la fábrica, el cliente recibe una familia medieval o industrial completa y evita mezclar unidades de épocas distintas.",
    ),
    "adapter": (
        "Una empresa cuenta con un sistema para cargar la nómina de sus empleados. Por decisiones de negocio, el sistema necesita importar empleados que provienen de una fuente de datos externa. En este sentido, se solicita establecer un mecanismo que permita cargar la información al sistema.",
        "El adaptador traduce nombres, documento y teléfono al contrato esperado sin alterar ni el sistema existente ni el tipo externo.",
    ),
    "bridge": (
        "Se solicita identificar y corregir posibles indicios de deuda técnica en el proyecto de una empresa que gestiona la información de diferentes sistemas operativos. Al ingresar al proyecto se observa que la solución tiene la estructura presentada en el modelo original del caso.",
        "La abstracción del sistema operativo y la implementación de arquitectura pueden variar de forma independiente.",
    ),
    "composite": (
        "Se solicita explicar el patrón Composite de forma intuitiva. Una de las estructuras más sencillas que se puede representar como un árbol es una ruta de directorios.",
        "El cliente imprime hojas y composiciones desde la misma abstracción, mientras cada directorio delega el recorrido a sus hijos.",
    ),
    "decorator": (
        """Se solicita implementar algunas mejoras en un sistema de seguros. Concretamente, se debe modificar el pago de seguros de vida a los usuarios considerando los siguientes escenarios:

- **Seguro por accidente:** se paga un monto igual al costo del seguro básico contratado por el usuario, más un 10 % adicional.
- **Seguro por incapacidad:** se paga un monto igual al costo del seguro básico contratado por el usuario, más un 50 % adicional.
- **Seguro por defunción:** se paga un monto igual al costo del seguro básico contratado por el usuario, más un 70 % adicional.

Los seguros por accidente se consideran vitalicios. Sin embargo, la empresa indicó de manera explícita que no se debe modificar el modelo existente.""",
        "Los decoradores agregan porcentajes al seguro base y pueden componerse dinámicamente conservando el mismo contrato.",
    ),
    "facade": (
        "Una empresa está pasando por un proceso de migración en el que busca adoptar prácticas de implementación y despliegue continuo. Sin embargo, el proceso de despliegue requiere que un operador ejecute manualmente cada uno de los pasos de validación durante las etapas de integración y pruebas (*stage*), los cuales siempre son iguales y se ejecutan en el mismo orden desde diferentes ambientes. Con el propósito de avanzar con la migración, se solicita implementar un servicio que encapsule todas las acciones que se deben disparar para desplegar nuevos cambios en el proyecto.",
        "Una operación de fachada coordina validación, construcción y pruebas en el orden correcto y entrega un estado único al operador.",
    ),
    "flyweight": (
        "Una empresa de telefonía cuenta con un sistema que almacena la información básica de diferentes modelos de teléfonos inteligentes —identificador, RAM, disco y costo— y ofrece descuentos a sus clientes en varias épocas del año. Cuando el sistema comenzó a crecer, el equipo de desarrollo notó que el rendimiento de la aplicación se vio perjudicado. Se solicita identificar posibles brechas de rendimiento y proponer acciones de mejora en caso de ser necesario.",
        "La fábrica reutiliza exactamente la misma instancia de Hardware cuando RAM, disco y costo coinciden; el identificador permanece en el objeto ligero.",
    ),
    "proxy": (
        "Se solicita controlar el acceso a los recursos de un portal web que cuenta con dos roles: (i) los usuarios tienen permisos básicos para navegar en el portal y (ii) los administradores pueden acceder a los recursos del sistema. Se requiere un mecanismo que permita controlar el acceso de los usuarios a los recursos de la aplicación.",
        "El proxy comprueba permisos antes de delegar en el servicio remoto y bloquea las rutas no autorizadas.",
    ),
    "cadena_responsabilidad": (
        """Una entidad bancaria solicita implementar un módulo que permita controlar el conducto regular que debe seguir una solicitud de crédito realizada por un cliente del banco. De acuerdo con el requerimiento, una solicitud de crédito se evalúa en cuatro etapas:

- Si el monto solicitado es menor o igual a cien mil pesos, la solicitud es evaluada por el asesor que tiene asignado el cliente.
- Si el monto es mayor a cien mil pesos y menor o igual a cinco millones de pesos, la solicitud se debe enviar al departamento de evaluación de riesgo.
- Si el monto es mayor a cinco millones de pesos y menor o igual a diez millones de pesos, la solicitud debe pasar por un proceso de evaluación de antecedentes judiciales.
- Si el monto supera los diez millones de pesos, la solicitud debe ser evaluada por el director del departamento de créditos.""",
        "Cada evaluador resuelve el intervalo que le corresponde o delega al siguiente eslabón sin que el solicitante conozca la cadena.",
    ),
    "command": (
        "Se solicita implementar, junto con varios colegas, un sistema capaz de transformar frases en lenguaje natural en consultas SQL. Sin embargo, el modo de ejecución de las consultas debe ser transparente para cualquier usuario que quiera consumir la operación.",
        "El invocador trabaja con comandos uniformes y cada comando encapsula la sintaxis y el receptor de su motor.",
    ),
    "iterator": (
        "Se solicita explicar a un grupo de estudiantes la estructura interna del patrón Iterator de forma sencilla. En esta situación no hay problemas elaborados; el ejemplo se centra en explicar la estructura del patrón.",
        "Cada colección produce su iterador y el cliente consume una secuencia mediante las mismas operaciones de avance y consulta.",
    ),
    "mediator": (
        "Se solicita implementar un sistema de comunicación genérico que pueda utilizarse en diferentes dominios de negocio; por ejemplo, una sala de chat que permita a dos usuarios comunicarse entre ellos o una torre de control que permita notificar el estado de diferentes vuelos.",
        "Los colegas notifican al mediador; este distribuye los mensajes sin crear dependencias directas entre cada par de participantes.",
    ),
    "memento": (
        "Se solicita implementar, como parte de un equipo que desarrolla un juego de mundo abierto, la lógica para guardar el progreso del jugador y restaurar el último estado disponible cuando muera. En este punto del proyecto, el sistema ya incluye la clase `Jugador`.",
        "El cuidador conserva instantáneas opacas y el originador restaura vida, experiencia y estado sin exponer su representación interna.",
    ),
    "observer": (
        "Se solicita implementar un sistema de venta de libros a través de un portal web. El sistema debe contar con una función que permita a los usuarios recibir notificaciones cuando lleguen nuevos libros a la tienda.",
        "La librería publica el cambio a sus observadores activos; altas y bajas no modifican la lógica de inventario.",
    ),
    "state": (
        """Una empresa solicita implementar una aplicación que permita gestionar las solicitudes realizadas por diferentes usuarios en una ventanilla virtual. El sistema debe cumplir las siguientes condiciones:

- La ventanilla puede estar **abierta**: cualquier usuario puede ser atendido.
- La ventanilla puede estar **suspendida**: solo atiende usuarios mayores de 60 años.
- La ventanilla puede estar **cerrada**: no se atiende a ningún usuario.""",
        "La ventanilla delega la decisión al objeto que representa su estado actual y cambia de comportamiento sin condicionales centrales.",
    ),
    "strategy": (
        "Se solicita explicar a un grupo de estudiantes en qué consiste el patrón Strategy dentro de un curso de Ingeniería de Software.",
        "El contexto ejecuta todas las variantes mediante un contrato común y produce arreglos ordenados sin conocer sus pasos internos.",
    ),
    "template": (
        "Una empresa necesita implementar la lógica que facilite el acceso a diferentes bases de datos. Por diseño, la conexión a cualquier base de datos realiza los siguientes pasos en el mismo orden: (i) establecer el controlador de la base de datos, (ii) realizar el proceso de autenticación, (iii) realizar la autorización y, finalmente, (iv) conectar la instancia de la base de datos. Se solicita definir un modelo que facilite la creación de conexiones a cualquier base de datos utilizando controladores genéricos. Sin embargo, el sistema también debe permitir la creación de instancias con controladores personalizados. Inicialmente, la empresa necesita crear conexiones para Oracle, MySQL, PostgreSQL y una base de datos propietaria llamada CustomSQL. Además, el sistema debe permitir crear conexiones para la base de datos no relacional DynamoDB.",
        "La plantilla conserva el orden del algoritmo y permite redefinir únicamente los pasos variables de cada motor.",
    ),
    "visitor": (
        """Una empresa que trabaja en el sector financiero está desarrollando una aplicación para gestionar diversas operaciones con tarjetas de crédito. Sin embargo, debido a decisiones de desarrollo deficientes, el proyecto ha llegado a un punto en el que realizar cambios resulta muy complicado.

Se solicita crear una funcionalidad que permita calcular los intereses y las millas aplicadas a una tarjeta de crédito después de hacer una compra, de acuerdo con las siguientes condiciones:

- La **Tarjeta Básica** no acumula intereses ni millas.
- La **Tarjeta Gold** acumula un interés igual al 1 % del valor de cada compra y no acumula millas.
- La **Tarjeta Platino** acumula un interés igual al 1,5 % del valor de cada compra y acumula 10 millas por cada compra.
- La **Tarjeta Black** acumula un interés igual al 2,1 % del valor de cada compra y acumula 100 millas por cada compra.

Antes de comenzar el análisis de la solución, se establece la directriz de evitar al máximo los cambios sobre el código existente y procurar que el impacto sobre cualquier estructura que deba modificarse sea mínimo.""",
        "Cada tarjeta acepta al visitante apropiado y el cálculo varía por tipo mediante doble despacho.",
    ),
}
for chapter, (family, patterns) in pattern_groups.items():
    for pattern in patterns:
        register(
            JAVA / "patrones" / family / pattern / "README.md",
            ROOT / f"docs/capitulos/{chapter}/{pattern}.md",
        )


def pattern_page_content(source: Path, content: str) -> str:
    """Ordena cada patrón como el libro y añade el caso ejecutable real."""
    pattern = source.parent.name
    if pattern not in PATTERN_CASES:
        return content

    headings = list(re.finditer(r"<h2[^>]*>.*?</h2>", content, flags=re.DOTALL))
    if not headings:
        return content

    preamble = content[: headings[0].start()]
    # El contexto de los capítulos 5–7 ya deja claro que cada entrada es un
    # patrón. Conservamos el nombre y su traducción sin repetir "Patrón" en el
    # título principal de cada página.
    preamble = re.sub(r"Patr[oó]n\s+", "", preamble, count=1, flags=re.IGNORECASE)
    preamble = re.sub(
        r"(</h4>\s*)",
        r"\1\n## Definición\n\n",
        preamble,
        count=1,
    )
    blocks: list[tuple[str, str]] = []
    for index, heading in enumerate(headings):
        end = headings[index + 1].start() if index + 1 < len(headings) else len(content)
        block = content[heading.start() : end]
        label = re.sub(r"<[^>]+>", "", heading.group(0)).lower()
        blocks.append((label, block))

    def take(fragment: str, replacement: str | None = None) -> str:
        for index, (label, block) in enumerate(blocks):
            if fragment in label:
                blocks.pop(index)
                if replacement:
                    block = re.sub(
                        r"<h2[^>]*>.*?</h2>",
                        f"## {replacement}",
                        block,
                        count=1,
                        flags=re.DOTALL,
                    )
                return block.strip()
        return ""

    motivation = take("motivación", "Motivación")
    structure = take("estructura", "Modelo UML")
    implementation = take("implementación", "Implementación genérica de la estructura")
    if pattern in GENERIC_IMPLEMENTATIONS:
        languages = (
            ("Java", "java", GENERIC_IMPLEMENTATIONS[pattern]),
            ("Python", "python", PYTHON_IMPLEMENTATIONS[pattern]),
            ("C#", "csharp", CSHARP_IMPLEMENTATIONS[pattern]),
            ("Pseudocódigo", "text", PSEUDOCODE_IMPLEMENTATIONS[pattern]),
        )
        tabs = []
        for label, language, code in languages:
            indented = "\n".join(
                f"    {line}" for line in f"```{language}\n{code}\n```".splitlines()
            )
            tabs.append(f'=== "{label}"\n\n{indented}')
        implementation = (
            "## Implementación genérica de la estructura\n\n"
            "Las clases e interfaces conservan los nombres de los participantes del "
            "modelo UML anterior. Así puede seguirse cada relación del diagrama "
            "directamente en el código. Java se muestra por defecto; las otras "
            "pestañas expresan la misma colaboración sin cambiar su intención.\n\n"
            + "\n\n".join(tabs)
        )
    participants = take("participantes", "Participantes")
    problem, result = PATTERN_CASES[pattern]

    java_files = sorted(source.parent.rglob("*.java"))
    code_sections = []
    for java_file in java_files:
        relative_name = java_file.relative_to(source.parent).as_posix()
        code = java_file.read_text(encoding="utf-8").rstrip()
        code_sections.append(
            f'??? example "{relative_name}"\n\n'
            + "\n".join(f"    {line}" for line in ("```java\n" + code + "\n```").splitlines())
        )

    package = re.search(
        r"^package\s+([^;]+);",
        (source.parent / "Cliente.java").read_text(encoding="utf-8"),
        flags=re.MULTILINE,
    ).group(1)
    command = f"./mvnw -q exec:java -Dexec.mainClass={package}.Cliente"
    source_url = GITHUB_BLOB + source.parent.relative_to(ROOT).as_posix() + "/"
    code_content = "\n\n".join(code_sections)
    case_study = f"""
## Enunciado del problema

{problem}

## Solución implementada en la obra

La solución concreta conserva los participantes del modelo UML, pero los lleva al
dominio del caso de estudio. Los archivos siguientes son el código real del
proyecto —no una segunda versión simplificada del algoritmo—:

{code_content}

## Resultado y discusión

{result}

La ejecución puede reproducirse con:

```bash
{command}
```

<div class="lab-action" markdown>
[:fontawesome-brands-github: ABRIR EN CODESPACES](https://codespaces.new/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno?quickstart=1){{ .md-button .md-button--primary .codespaces-button target="_blank" rel="noopener noreferrer" }}
<span class="lab-action__note">Requiere una cuenta de GitHub. Consulta la <a href="../../../codespaces/">guía de preparación</a> y ejecuta <code>{command}</code>.</span>
</div>

[:material-source-repository: Ver la carpeta del caso en GitHub]({source_url}){{ .md-button target="_blank" rel="noopener noreferrer" }}
""".strip()

    ordered = [preamble.strip(), motivation, structure, implementation, participants, case_study]
    ordered.extend(block.strip() for _, block in blocks)
    return "\n\n".join(part for part in ordered if part)


APPLICATION_GUIDANCE = {
    "buenas_practicas/grasp/acoplamiento/README.md": (
        "Un cambio en un colaborador obliga a modificar muchos consumidores.",
        "Integración con servicios de notificación, persistencia o proveedores sustituibles.",
        "Los cambios quedan aislados detrás de contratos pequeños.",
        "Demasiadas capas de indirección dificultan seguir el flujo.",
    ),
    "buenas_practicas/grasp/cohesion/README.md": (
        "Una clase reúne operaciones que cambian por motivos distintos.",
        "Separación de utilidades de archivos, base de datos, HTTP, registro y conversión.",
        "Cada componente conserva un propósito reconocible y puede probarse de forma aislada.",
        "Dividir sin criterio produce clases diminutas y lógica fragmentada.",
    ),
    "buenas_practicas/grasp/controlador/README.md": (
        "La interfaz de usuario o las entidades reciben directamente eventos del sistema.",
        "Coordinación de un caso de uso como reservar una habitación.",
        "Se separan entrada, coordinación y reglas del dominio.",
        "Un único controlador para todo el sistema puede convertirse en un objeto omnipotente.",
    ),
    "buenas_practicas/grasp/creador/README.md": (
        "La construcción de objetos está dispersa o asignada a un elemento sin relación natural.",
        "Objetos unidos por composición, agregación, inicialización o información de registro.",
        "La creación queda cerca de la información y del ciclo de vida que necesita.",
        "Cuando la construcción es compleja o muy variable puede convenir una fábrica especializada.",
    ),
    "buenas_practicas/grasp/experto_informacion/README.md": (
        "Una operación se asigna lejos de los datos necesarios para realizarla.",
        "Cálculos de inventario, totales, disponibilidad o reglas sobre el propio estado.",
        "Mejora encapsulamiento y cohesión al mantener juntos conocimiento y comportamiento.",
        "Las responsabilidades técnicas que no pertenecen al dominio pueden sobrecargar la entidad.",
    ),
    "buenas_practicas/grasp/fabricacion_pura/README.md": (
        "Una responsabilidad necesaria no encaja de forma natural en ninguna entidad del dominio.",
        "Persistencia, registro, conversión, mensajería o integración técnica.",
        "Protege la cohesión del modelo y facilita reutilizar servicios técnicos.",
        "El exceso de servicios artificiales puede producir un modelo de dominio sin comportamiento.",
    ),
    "buenas_practicas/grasp/indireccion/README.md": (
        "Dos componentes dependen directamente y cualquier cambio se propaga entre ellos.",
        "Adaptación de proveedores, repositorios, pasarelas o mecanismos de comunicación.",
        "El intermediario reduce el conocimiento mutuo y concentra la traducción.",
        "La indirección sin una variación real agrega saltos y dificulta el diagnóstico.",
    ),
    "buenas_practicas/grasp/polimorfismo/README.md": (
        "Condicionales repetidos seleccionan comportamiento según el tipo de objeto.",
        "Variantes de cálculo, pago, exportación, notificación o procesamiento.",
        "El cliente usa un contrato común y nuevas variantes pueden agregarse con menor impacto.",
        "Un contrato demasiado general puede ocultar diferencias que los clientes sí necesitan conocer.",
    ),
    "buenas_practicas/grasp/variacion_protegida/README.md": (
        "Un elemento inestable expone sus cambios al resto del sistema.",
        "APIs externas, formatos, motores de cálculo o políticas que evolucionan.",
        "Una frontera estable concentra el impacto de la variación.",
        "Predecir cambios inexistentes genera abstracciones especulativas.",
    ),
    "buenas_practicas/solid/responsabilidad_unica/README.md": (
        "Una clase cambia por decisiones de negocio, presentación, almacenamiento o reporte a la vez.",
        "Separación del cálculo de una factura respecto de su impresión o exportación.",
        "Los módulos quedan enfocados y sus pruebas requieren menos contexto.",
        "Separar cada operación en una clase distinta fragmenta el modelo sin mejorar su cohesión.",
    ),
    "buenas_practicas/solid/abierto_cerrado/README.md": (
        "Cada nueva variante obliga a modificar condicionales dentro de código estable.",
        "Nuevas figuras, solicitudes, reglas de cálculo o proveedores.",
        "Las extensiones se incorporan mediante contratos sin reabrir continuamente el núcleo.",
        "La abstracción debe responder a una variación observada, no a posibilidades imaginarias.",
    ),
    "buenas_practicas/solid/liskov/README.md": (
        "Un subtipo rechaza operaciones, cambia resultados o rompe invariantes del tipo base.",
        "Jerarquías de figuras, vehículos, medios de pago o dispositivos.",
        "Los clientes pueden trabajar con el contrato sin comprobar tipos concretos.",
        "Una jerarquía demasiado amplia oculta capacidades diferentes y produce sustituciones falsas.",
    ),
    "buenas_practicas/solid/segregacion_interfaces/README.md": (
        "Una interfaz obliga a implementar métodos que algunos clientes no necesitan.",
        "Dispositivos IoT o figuras con capacidades dimensionales distintas.",
        "Cada cliente depende únicamente de las operaciones que utiliza.",
        "Demasiadas interfaces mínimas pueden dispersar un contrato conceptualmente indivisible.",
    ),
    "buenas_practicas/solid/inversion_dependencias/README.md": (
        "La política de alto nivel crea o conoce directamente detalles tecnológicos.",
        "Almacenamiento en archivo, base de datos o nube y mecanismos de salida intercambiables.",
        "Las políticas pueden probarse y evolucionar independientemente de los detalles.",
        "Introducir abstracciones sin alternativas reales aumenta el diseño sin reducir riesgo.",
    ),
    "buenas_practicas/dry/README.md": (
        "El mismo conocimiento está representado en varios lugares que pueden divergir.",
        "Reglas de validación, fórmulas, configuraciones o documentación repetida.",
        "Una fuente autorizada mantiene consistencia y reduce cambios duplicados.",
        "La semejanza accidental no justifica una abstracción común.",
    ),
    "buenas_practicas/kiss/README.md": (
        "La solución contiene más mecanismos y estados de los necesarios para su propósito.",
        "Flujos directos que no requieren un framework, jerarquía o configuración generalizada.",
        "Reduce carga cognitiva, errores y costo de mantenimiento.",
        "Simplificar no debe eliminar requisitos, validaciones o claridad del dominio.",
    ),
    "buenas_practicas/yagni/README.md": (
        "Se construyen capacidades para necesidades futuras que todavía no han sido confirmadas.",
        "Exportadores, integraciones o canales añadidos sin un caso de uso vigente.",
        "Reduce código, pruebas, supuestos y mantenimiento innecesarios.",
        "No justifica ignorar requisitos de seguridad, calidad o evolución ya conocidos.",
    ),
    "buenas_practicas/demeter/README.md": (
        "Un objeto navega por cadenas de colaboradores y conoce su estructura interna.",
        "Modelos con agregados, capas o árboles de objetos.",
        "Los cambios internos quedan encapsulados tras operaciones significativas.",
        "Delegar mecánicamente cada acceso puede inflar interfaces sin reducir conocimiento real.",
    ),
}


def relative_doc_link(destination: Path, target: Path) -> str:
    return Path(os.path.relpath(target, destination.parent)).as_posix()


def relative_page_url(destination: Path, target: Path) -> str:
    """Calcula una URL relativa entre las carpetas publicadas por MkDocs."""
    source_route = destination.parent if destination.name == "index.md" else destination.with_suffix("")
    target_route = target.parent if target.name == "index.md" else target.with_suffix("")
    relative = Path(os.path.relpath(target_route, source_route)).as_posix()
    return f"{relative}/"


def relative_asset_url(destination: Path, target: Path) -> str:
    source_route = destination.parent if destination.name == "index.md" else destination.with_suffix("")
    return Path(os.path.relpath(target, source_route)).as_posix()


EXAMPLE_SOURCES = {
    example
    for related_examples in RELATED_EXAMPLES.values()
    for example in related_examples
}


def java_code_anchor(example_source: Path, java_file: Path) -> str:
    relative_name = java_file.relative_to(example_source.parent).as_posix().lower()
    slug = re.sub(r"[^a-z0-9]+", "-", relative_name).strip("-")
    return f"codigo-{slug}"


def example_code_section(source: Path) -> str:
    """Publica cada archivo Java del caso en una celda desplegable."""
    variants = {
        "sin_aplicar_principio": (0, "Versión inicial · sin aplicar el principio"),
        "aplicando_principio": (1, "Versión refactorizada · aplicando el principio"),
        "ejemplo_alto_acoplamiento": (0, "Versión con alto acoplamiento"),
        "ejemplo_bajo_acoplamiento": (1, "Versión con bajo acoplamiento"),
        "ejemplo_baja_cohesion": (0, "Versión con baja cohesión"),
        "ejemplo_alta_cohesion": (1, "Versión con alta cohesión"),
    }

    def sort_key(java_file: Path) -> tuple[int, str]:
        relative = java_file.relative_to(source.parent)
        variant = variants.get(relative.parts[0]) if relative.parts else None
        return (variant[0] if variant else 0, relative.as_posix())

    java_files = sorted(source.parent.rglob("*.java"), key=sort_key)
    if not java_files:
        return ""

    blocks = [
        "## Solución en código",
        "",
        "Cada archivo forma parte de la solución representada en los diagramas UML. "
        "Seleccione su nombre para desplegar el código sin salir del ejemplo.",
    ]
    current_variant: str | None = None
    for java_file in java_files:
        relative = java_file.relative_to(source.parent)
        variant_name = relative.parts[0] if relative.parts else ""
        variant = variants.get(variant_name)
        variant_key = variant_name if variant else ""
        if variant_key != current_variant:
            if variant:
                blocks.extend(("", f"### {variant[1]}"))
            current_variant = variant_key

        relative_name = relative.as_posix()
        anchor = java_code_anchor(source, java_file)
        code = java_file.read_text(encoding="utf-8").rstrip()
        indented = "\n".join(
            f"    {line}" for line in ("```java\n" + code + "\n```").splitlines()
        )
        blocks.extend(
            (
                "",
                f'<a id="{anchor}"></a>',
                f'??? example "{relative_name}"',
                "",
                indented,
            )
        )
    return "\n".join(blocks)


def insert_before_conclusion(content: str, section: str) -> str:
    if not section:
        return content
    heading_pattern = re.compile(
        r"^(?:##(?!#)[^\n]*|<h2\b[^>]*>.*?</h2>)\s*$",
        flags=re.MULTILINE | re.DOTALL | re.IGNORECASE,
    )
    for heading in heading_pattern.finditer(content):
        label = re.sub(r"<[^>]+>|#+", "", heading.group(0)).lower()
        if any(
            closing in label
            for closing in ("conclusión", "conclusion", "bibliografía", "bibliografia")
        ):
            return content[: heading.start()] + section + "\n\n<hr/>\n\n" + content[heading.start() :]
    return content.rstrip() + "\n\n---\n\n" + section


def readable_fragment(fragment: str) -> str:
    """Convierte un fragmento HTML editorial en texto útil para tablas."""
    fragment = re.sub(r"<br\s*/?>", " ", fragment, flags=re.IGNORECASE)
    fragment = re.sub(r"<[^>]+>", " ", fragment)
    fragment = re.sub(r"\[([^]]+)]\([^)]+\)", r"\1", fragment)
    return re.sub(r"\s+", " ", unescape(fragment)).strip()


def neutralize_problem_voice(content: str) -> str:
    """Formula los casos como solicitudes, sin la figura del narrador."""
    content = re.sub(
        r"(?:Se (?:ha )?solicit(?:ó|ado)|Se pidió|Se solicita) a <em>nuestro desarrollador</em>\s+",
        "Se solicita ",
        content,
        flags=re.IGNORECASE,
    )
    content = re.sub(
        r"Un cliente contrató a <em>nuestro desarrollador</em> para\s+",
        "Se solicita ",
        content,
        flags=re.IGNORECASE,
    )
    content = re.sub(
        r"La empresa donde trabaja <em>nuestro desarrollador</em>\s+",
        "La empresa ",
        content,
        flags=re.IGNORECASE,
    )
    return re.sub(
        r"Basado en esta idea, <em>nuestro desarrollador</em> decidió\s+",
        "Con base en esta idea, se solicita ",
        content,
        flags=re.IGNORECASE,
    )


def clean_principle_titles(content: str) -> str:
    """Quita etiquetas redundantes de los títulos de principios y prácticas."""
    title_match = re.search(r"<h1\b[^>]*>(.*?)</h1>", content, flags=re.DOTALL | re.IGNORECASE)
    if title_match:
        title = title_match.group(1)
        title = re.sub(r"Principio(?:s)?(?:\s+de)?\s+", "", title, count=1, flags=re.IGNORECASE)
        title = re.sub(r"GRASP:\s*", "", title, count=1, flags=re.IGNORECASE)
        title = re.sub(r"Buena[s]?\s+práctica[s]?\s*:?\s*", "", title, count=1, flags=re.IGNORECASE)
        content = content[: title_match.start(1)] + title + content[title_match.end(1) :]
    return re.sub(
        r"(Modelo UML\s+(?:sin\s+aplicar|aplicando)\s+)(?:el|la)\s+Principio(?:\s+de)?\s+",
        r"\1",
        content,
        flags=re.IGNORECASE,
    )


def codespaces_action(destination: Path) -> str:
    guide_url = relative_page_url(destination, ROOT / "docs/codespaces.md")
    return (
        '<div class="lab-action" markdown>\n'
        '[:fontawesome-brands-github: ABRIR EN CODESPACES]('
        'https://codespaces.new/Notas-a-Mano-serie-de-libros/'
        '2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno?quickstart=1)'
        '{ .md-button .md-button--primary .codespaces-button target="_blank" '
        'rel="noopener noreferrer" }\n'
        f'<span class="lab-action__note">Requiere una cuenta de GitHub. Consulta la '
        f'<a href="{guide_url}">guía de preparación</a> y ejecuta las pruebas '
        'o el comando indicado en el ejemplo.</span>\n'
        '</div>'
    )


def add_codespaces_action(content: str, destination: Path) -> str:
    """Coloca el acceso a Codespaces junto al título de cada página con código."""
    match = re.search(r"</h1>", content, flags=re.IGNORECASE)
    if not match or "codespaces.new" in content:
        return content
    return content[: match.end()] + "\n\n" + codespaces_action(destination) + content[match.end() :]


def insert_after_last_uml(content: str, section: str) -> str:
    """Inserta el código inmediatamente después del último bloque UML."""
    if not section:
        return content
    heading_pattern = re.compile(
        r"^(?:##(?!#)[^\n]*|<h2\b[^>]*>.*?</h2>)\s*$",
        flags=re.MULTILINE | re.DOTALL | re.IGNORECASE,
    )
    headings = list(heading_pattern.finditer(content))
    uml_headings = [
        heading
        for heading in headings
        if "uml" in re.sub(r"<[^>]+>|#+", "", heading.group(0)).lower()
    ]
    if uml_headings:
        target = uml_headings[-1]
        next_heading = next((heading for heading in headings if heading.start() > target.start()), None)
        insertion = next_heading.start() if next_heading else len(content)
        return content[:insertion].rstrip() + "\n\n" + section + "\n\n" + content[insertion:].lstrip()
    return insert_before_conclusion(content, section)


def example_title_and_summary(example: Path) -> tuple[str, str]:
    content = neutralize_problem_voice(example.read_text(encoding="utf-8"))
    title_match = re.search(r"<h1\b[^>]*>(.*?)</h1>", content, flags=re.DOTALL | re.IGNORECASE)
    title = readable_fragment(title_match.group(1)) if title_match else example.parent.name
    title = re.sub(r"^[^\wÁÉÍÓÚáéíóúÑñ]*Ejemplo(?:\s+práctico)?\s*:\s*", "", title, flags=re.IGNORECASE)

    first_section = re.search(r"<h2\b[^>]*>.*?</h2>(.*?)(?=<h2\b|\Z)", content, flags=re.DOTALL | re.IGNORECASE)
    search_area = first_section.group(1) if first_section else content
    paragraph = re.search(r"<p\b[^>]*>(.*?)</p>", search_area, flags=re.DOTALL | re.IGNORECASE)
    summary = readable_fragment(paragraph.group(1)) if paragraph else "Caso desarrollado con modelo UML y código Java."
    return title, summary


def related_examples_section(destination: Path, examples: list[Path]) -> str:
    """Crea el acceso, la explicación y la vista UML de los casos relacionados."""
    records: list[tuple[str, str, str, list[str]]] = []
    for example in examples:
        title, summary = example_title_and_summary(example)
        target = PAGES[example]
        # Se genera un vínculo entre documentos Markdown para que MkDocs lo
        # valide y lo convierta a la URL limpia correspondiente.
        url = relative_doc_link(destination, target)
        raw = example.read_text(encoding="utf-8")
        images: list[str] = []
        for image_path in re.findall(r'src="([^"]+)"', raw, flags=re.IGNORECASE):
            resolved = (example.parent / image_path).resolve()
            try:
                relative = resolved.relative_to(RESOURCES.resolve())
            except ValueError:
                continue
            images.append(relative_asset_url(destination, DOC_IMAGES / relative))
        records.append((title, summary, url, images))

    lines = [
        "## Accesos directos a los ejemplos",
        "",
        "| Ejemplo | Qué permite analizar | Acceso |",
        "| --- | --- | --- |",
    ]
    for title, summary, url, _ in records:
        lines.append(
            f"| **{title.replace('|', '&#124;')}** | {summary.replace('|', '&#124;')} | "
            f"[Ver diagramas y desplegar el código]({url}) |"
        )

    lines.extend(("", "## Ejemplos y diagramas UML"))
    for index, (title, summary, url, images) in enumerate(records, start=1):
        lines.extend(("", f"### {index}. {title}", "", summary))
        for image_index, image_url in enumerate(images, start=1):
            suffix = f", vista {image_index}" if len(images) > 1 else ""
            lines.extend(
                (
                    "",
                    '<figure class="uml-figure uml-figure--wide">',
                    f'  <img src="{image_url}" alt="Diagrama UML de {title}">',
                    f"  <figcaption><strong>Modelo UML.</strong> {title}{suffix}.</figcaption>",
                    "</figure>",
                )
            )
        lines.extend(("", f"[Estudiar el caso y desplegar su código Java]({url}){{ .md-button }}"))
    return "\n".join(lines)


PRACTICE_CODE_CASES = {
    "dry": (
        (
            "Duplicación de código",
            "Tres operaciones repiten el cálculo del promedio; la versión refactorizada concentra el conocimiento en una sola operación reutilizable.",
            ("dry_codigo/Utilidad.java", "dry_codigo/UtilidadRefactorizada.java"),
        ),
        (
            "Duplicación en la documentación",
            "La comparación muestra cómo comentarios que repiten literalmente el código se desactualizan y añaden ruido sin explicar decisiones.",
            ("dry_documentacion/Calculadora.java", "dry_documentacion/CalculadoraDRY.java"),
        ),
        (
            "Duplicación del modelo",
            "Estudiante y Profesor repiten los datos de una persona; la refactorización introduce una representación común para ese conocimiento compartido.",
            (
                "dry_logica/entidades/Estudiante.java",
                "dry_logica/entidades/Profesor.java",
                "dry_logica/entidades_refactor/Persona.java",
                "dry_logica/entidades_refactor/Estudiante.java",
                "dry_logica/entidades_refactor/Profesor.java",
            ),
        ),
        (
            "Coincidencia frente a regla de negocio",
            "El mismo valor límite no implica necesariamente una única regla: abstraer semejanzas accidentales puede acoplar decisiones que deben evolucionar por separado.",
            ("dry_negocio/Utilidad.java",),
        ),
        (
            "Duplicación de procesos",
            "El cálculo combinatorio vuelve a implementar factorial; el caso permite identificar cuándo una operación común debe tener una sola fuente autorizada.",
            ("dry_proceso/Utilidad.java", "dry_proceso/UtilidadCombinatoria.java"),
        ),
    ),
    "kiss": (
        (
            "Calculadora innecesariamente compleja frente a solución simple",
            "Ambas versiones satisfacen las mismas operaciones, pero la segunda utiliza directamente las abstracciones del lenguaje y reduce ramas, ciclos y posibilidades de error.",
            ("CalculadoraCompleja.java", "CalculadoraSimple.java"),
        ),
    ),
}


def practice_code_section(source: Path) -> str:
    cases = PRACTICE_CODE_CASES.get(source.parent.name)
    if not cases:
        return ""

    lines = [
        "## Accesos directos a los ejemplos",
        "",
        "| Ejemplo | Propósito | Acceso |",
        "| --- | --- | --- |",
    ]
    for index, (title, description, _) in enumerate(cases, start=1):
        anchor = f"ejemplo-{source.parent.name}-{index}"
        lines.append(f"| **{title}** | {description} | [Ver código](#{anchor}) |")

    lines.extend(("", "## Ejemplos desarrollados"))
    for index, (title, description, files) in enumerate(cases, start=1):
        anchor = f"ejemplo-{source.parent.name}-{index}"
        lines.extend(("", f'<a id="{anchor}"></a>', f"### {index}. {title}", "", description))
        for relative_name in files:
            java_file = source.parent / relative_name
            code = java_file.read_text(encoding="utf-8").rstrip()
            indented = "\n".join(
                f"    {line}" for line in ("```java\n" + code + "\n```").splitlines()
            )
            lines.extend(("", f'??? example "{relative_name}"', "", indented))
    return "\n".join(lines)


def clean_reference_sections(content: str) -> str:
    """Elimina autorreferencias y conserva las fuentes reales como bibliografía."""
    heading_pattern = re.compile(
        r"^((?:##(?!#)[^\n]*)|(?:<h2\b[^>]*>.*?</h2>))\s*$",
        flags=re.MULTILINE | re.DOTALL | re.IGNORECASE,
    )
    headings = list(heading_pattern.finditer(content))
    if not headings:
        return content

    result: list[str] = []
    cursor = 0
    for index, heading in enumerate(headings):
        end = headings[index + 1].start() if index + 1 < len(headings) else len(content)
        label = re.sub(r"<[^>]+>|#+", "", heading.group(1)).lower()
        prefix = content[cursor : heading.start()]
        body = content[heading.end() : end]

        if "referencia" not in label:
            result.extend((prefix, content[heading.start() : end]))
            cursor = end
            continue

        body = re.sub(
            r"<p\b[^>]*>.*?Notas\s+a\s+mano\s+sobre.*?</p>",
            "",
            body,
            flags=re.DOTALL | re.IGNORECASE,
        )
        meaningful = re.sub(r"(?:<hr\s*/?>|---|\s)+", "", body, flags=re.IGNORECASE)
        if meaningful:
            result.extend((prefix, "## Bibliografía", body))
        else:
            prefix = re.sub(
                r"\n\s*(?:<hr\s*/?>|---)\s*\n\s*$",
                "\n",
                prefix,
                flags=re.IGNORECASE,
            )
            result.append(prefix.rstrip())
        cursor = end

    result.append(content[cursor:])
    cleaned = "".join(result)
    # Algunos README antiguos ubican la autorreferencia debajo de "Notas" en
    # lugar de una sección propia. También se elimina en esa variante.
    cleaned = re.sub(
        r"<p\b[^>]*>\s*Este material.*?Notas\s+a\s+mano\s+sobre.*?</p>",
        "",
        cleaned,
        flags=re.DOTALL | re.IGNORECASE,
    )
    return re.sub(
        r"\n\s*<hr\s*/?>\s*\n\s*---",
        "\n\n---",
        cleaned,
        flags=re.IGNORECASE,
    )


def publish_page(source: Path, destination: Path) -> None:
    content = neutralize_problem_voice(source.read_text(encoding="utf-8"))
    if "buenas_practicas" in source.parts:
        content = clean_principle_titles(content)
    content = pattern_page_content(source, content)
    content = clean_reference_sections(content)
    is_example_page = source.resolve() in EXAMPLE_SOURCES

    # El README histórico de DRY menciona una figura que no forma parte del
    # repositorio. No se publica una referencia rota ni se inventa un recurso.
    content = re.sub(
        r'<div align="center">\s*<figure>\s*<img[^>]+dry_general\.png[^>]*>.*?</figure>\s*</div>',
        "",
        content,
        flags=re.DOTALL,
    )

    def image_link(match: re.Match[str]) -> str:
        raw = match.group(1)
        if raw.startswith(("http://", "https://", "data:")):
            return match.group(0)
        resolved = (source.parent / raw).resolve()
        try:
            image_relative = resolved.relative_to(RESOURCES.resolve())
        except ValueError:
            return match.group(0)
        target = DOC_IMAGES / image_relative
        return f'src="{relative_asset_url(destination, target)}"'

    def html_link(match: re.Match[str]) -> str:
        raw = match.group(1)
        if raw.startswith(("http://", "https://", "mailto:", "#")):
            return match.group(0)
        path_text, separator, fragment = raw.partition("#")
        resolved = (source.parent / path_text).resolve()
        if is_example_page and resolved.is_file() and resolved.suffix == ".java":
            link = f"#{java_code_anchor(source, resolved)}"
        elif resolved in PAGES:
            link = relative_page_url(destination, PAGES[resolved])
        elif resolved.exists():
            link = GITHUB_BLOB + resolved.relative_to(ROOT).as_posix()
        else:
            return match.group(0)
        if separator:
            link += f"#{fragment}"
        return f'href="{link}"'

    content = re.sub(r'src="([^"]+)"', image_link, content)
    content = re.sub(r'href="([^"]+)"', html_link, content)
    if is_example_page:
        content = re.sub(
            r'(<a\s+href="#codigo-[^"]+")\s+target="_blank"',
            r"\1",
            content,
        )
    content = content.replace("(Orozco, 2024)", "(Orozco et al., primera edición)")
    content = content.replace("(Orozco, 2025)", "(Orozco et al., primera edición)")

    if is_example_page:
        content = insert_after_last_uml(content, example_code_section(source))
    else:
        content = insert_before_conclusion(content, practice_code_section(source))

    if "buenas_practicas" in source.parts:
        content = add_codespaces_action(content, destination)

    examples = RELATED_EXAMPLES.get(source.resolve(), [])
    is_solid_page = "solid" in source.parts
    if examples and not is_solid_page:
        content = insert_before_conclusion(
            content,
            related_examples_section(destination, examples),
        )

    try:
        guidance_key = source.relative_to(JAVA).as_posix()
    except ValueError:
        guidance_key = ""
    if guidance_key in APPLICATION_GUIDANCE:
        problem, scenario, advantage, precaution = APPLICATION_GUIDANCE[guidance_key]
        guidance = (
            "## Aplicación, ventajas y límites\n\n"
            "| Elemento de análisis | Desarrollo |\n"
            "| --- | --- |\n"
            f"| **Problema que aborda** | {problem} |\n"
            f"| **Escenario de aplicación** | {scenario} |\n"
            f"| **Ventaja principal** | {advantage} |\n"
            f"| **Desventaja o precaución** | {precaution} |\n"
        )
        content = insert_before_conclusion(content, guidance)

    if not is_example_page:
        source_url = GITHUB_BLOB + source.relative_to(ROOT).as_posix()
        content += (
            "\n\n---\n\n"
            f"[:material-code-tags: Consultar el README y el código fuente]({source_url})"
            '{ .md-button target="_blank" rel="noopener noreferrer" }\n'
        )
    destination.parent.mkdir(parents=True, exist_ok=True)
    if not destination.exists() or destination.read_text(encoding="utf-8") != content:
        destination.write_text(content, encoding="utf-8")


def main() -> None:
    for source_image in RESOURCES.rglob("*"):
        if not source_image.is_file():
            continue
        target_image = DOC_IMAGES / source_image.relative_to(RESOURCES)
        target_image.parent.mkdir(parents=True, exist_ok=True)
        source_stat = source_image.stat()
        if target_image.exists():
            target_stat = target_image.stat()
            if (
                source_stat.st_size == target_stat.st_size
                and source_stat.st_mtime_ns == target_stat.st_mtime_ns
            ):
                continue
        shutil.copy2(source_image, target_image)
    for source, destination in PAGES.items():
        publish_page(source, destination)
    print(f"Publicadas {len(PAGES)} subsecciones y los diagramas asociados.")


def on_pre_build(config, **kwargs) -> None:
    """Hook de MkDocs: actualiza el contenido antes de recopilar los archivos."""
    main()


if __name__ == "__main__":
    main()
