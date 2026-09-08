#!/usr/bin/env python3
"""Publica en MkDocs el contenido técnico mantenido en los README del código."""

from __future__ import annotations

import os
import re
import shutil
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
        "Simular un universo único durante el ciclo de vida de la aplicación.",
        "Las dos solicitudes controladas devuelven la misma referencia; el ejemplo también hace visible por qué reflexión puede romper una implementación ingenua.",
    ),
    "prototype": (
        "Clonar la oveja Dolly a partir del estado de una oveja prototipo sin acoplar el cliente a su construcción.",
        "El clon conserva inicialmente los datos del prototipo y después puede cambiar sin modificar el objeto original.",
    ),
    "builder": (
        "Construir universos con combinaciones distintas de materia, energía y galaxias sin recurrir a constructores telescópicos.",
        "El cliente obtiene configuraciones legibles y el proceso de construcción mantiene juntas las validaciones del producto.",
    ),
    "factory": (
        "Permitir que un servicio de seguridad incorpore algoritmos PS256, PS512, RS256 y RS512 sin modificar al consumidor cada vez que aparece una variante.",
        "Cada creador concreto entrega un algoritmo a través del mismo contrato; RS512 se incorpora con un creador nuevo, sin condicionales en el cliente.",
    ),
    "abstract_factory": (
        "Crear en History of Empires unidades terrestres y marítimas compatibles con cada era histórica.",
        "Al cambiar la fábrica, el cliente recibe una familia medieval o industrial completa y evita mezclar unidades de épocas distintas.",
    ),
    "adapter": (
        "Importar trabajadores de una fuente externa a un sistema de nómina que solo conoce el modelo Empleado.",
        "El adaptador traduce nombres, documento y teléfono al contrato esperado sin alterar ni el sistema existente ni el tipo externo.",
    ),
    "bridge": (
        "Evitar una jerarquía explosiva al combinar sistemas operativos con arquitecturas de 32 y 64 bits.",
        "La abstracción del sistema operativo y la implementación de arquitectura pueden variar de forma independiente.",
    ),
    "composite": (
        "Representar archivos y directorios como un árbol y recorrer ambos mediante una operación uniforme.",
        "El cliente imprime hojas y composiciones desde la misma abstracción, mientras cada directorio delega el recorrido a sus hijos.",
    ),
    "decorator": (
        "Combinar coberturas de seguro —accidente, incapacidad y defunción— sin crear una subclase para cada combinación.",
        "Los decoradores agregan porcentajes al seguro base y pueden componerse dinámicamente conservando el mismo contrato.",
    ),
    "facade": (
        "Encapsular los pasos repetibles de integración y stage de un proceso de entrega continua.",
        "Una operación de fachada coordina validación, construcción y pruebas en el orden correcto y entrega un estado único al operador.",
    ),
    "flyweight": (
        "Reducir objetos repetidos al almacenar teléfonos con configuraciones de hardware compartidas.",
        "La fábrica reutiliza exactamente la misma instancia de Hardware cuando RAM, disco y costo coinciden; el identificador permanece en el objeto ligero.",
    ),
    "proxy": (
        "Controlar el acceso de usuarios y administradores a recursos de un portal web.",
        "El proxy comprueba permisos antes de delegar en el servicio remoto y bloquea las rutas no autorizadas.",
    ),
    "cadena_responsabilidad": (
        "Procesar una solicitud de crédito por el conducto regular definido según su monto.",
        "Cada evaluador resuelve el intervalo que le corresponde o delega al siguiente eslabón sin que el solicitante conozca la cadena.",
    ),
    "command": (
        "Traducir una consulta en lenguaje natural y ejecutarla de forma transparente sobre distintos motores SQL.",
        "El invocador trabaja con comandos uniformes y cada comando encapsula la sintaxis y el receptor de su motor.",
    ),
    "iterator": (
        "Recorrer arreglos y estructuras de personas sin exponer su representación interna.",
        "Cada colección produce su iterador y el cliente consume una secuencia mediante las mismas operaciones de avance y consulta.",
    ),
    "mediator": (
        "Reutilizar un mecanismo de comunicación tanto en una sala de chat como en una torre de control.",
        "Los colegas notifican al mediador; este distribuye los mensajes sin crear dependencias directas entre cada par de participantes.",
    ),
    "memento": (
        "Guardar el progreso de un jugador y restaurar el último punto de control después de su muerte.",
        "El cuidador conserva instantáneas opacas y el originador restaura vida, experiencia y estado sin exponer su representación interna.",
    ),
    "observer": (
        "Notificar a los compradores suscritos cuando una librería recibe títulos nuevos.",
        "La librería publica el cambio a sus observadores activos; altas y bajas no modifican la lógica de inventario.",
    ),
    "state": (
        "Gestionar una ventanilla abierta, suspendida o cerrada con reglas de atención diferentes.",
        "La ventanilla delega la decisión al objeto que representa su estado actual y cambia de comportamiento sin condicionales centrales.",
    ),
    "strategy": (
        "Seleccionar en tiempo de ejecución entre algoritmos de ordenamiento por burbuja, inserción, mezcla y radix.",
        "El contexto ejecuta todas las variantes mediante un contrato común y produce arreglos ordenados sin conocer sus pasos internos.",
    ),
    "template": (
        "Conectar diferentes bases de datos con una secuencia fija de controlador, autenticación, autorización y conexión.",
        "La plantilla conserva el orden del algoritmo y permite redefinir únicamente los pasos variables de cada motor.",
    ),
    "visitor": (
        "Agregar cálculos de intereses y millas a distintas tarjetas de crédito sin llenar las tarjetas de operaciones ajenas.",
        "Cada tarjeta acepta al visitante apropiado y el cálculo varía por tipo mediante doble despacho.",
    ),
}
PATTERN_NUMBERS = {
    "singleton": "5.3.1", "prototype": "5.3.2", "builder": "5.3.3",
    "factory": "5.3.4", "abstract_factory": "5.3.5",
    "adapter": "6.3.1", "bridge": "6.3.2", "composite": "6.3.3",
    "decorator": "6.3.4", "facade": "6.3.5", "flyweight": "6.3.6",
    "proxy": "6.3.7", "cadena_responsabilidad": "7.3.1",
    "command": "7.3.2", "iterator": "7.3.3", "mediator": "7.3.4",
    "memento": "7.3.5", "observer": "7.3.6", "state": "7.3.7",
    "strategy": "7.3.8", "template": "7.3.9", "visitor": "7.3.10",
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
    preamble = re.sub(
        r"(</h1>)",
        rf"\1\n\n<span class=\"chapter-kicker\">Sección {PATTERN_NUMBERS[pattern]} de la primera edición</span>",
        preamble,
        count=1,
    )
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
[:octicons-codespaces-16: Abrir este ejemplo en Codespaces](https://codespaces.new/Notas-a-Mano-serie-de-libros/2_notas-a-mano-sobre-analisis-orientado-objetos-patrones-diseno?quickstart=1){{ .md-button .md-button--primary .codespaces-button target="_blank" rel="noopener noreferrer" }}
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


def publish_page(source: Path, destination: Path) -> None:
    content = source.read_text(encoding="utf-8")
    content = pattern_page_content(source, content)

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
        if resolved in PAGES:
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
    content = content.replace("(Orozco, 2024)", "(Orozco et al., primera edición)")
    content = content.replace("(Orozco, 2025)", "(Orozco et al., primera edición)")

    try:
        guidance_key = source.relative_to(JAVA).as_posix()
    except ValueError:
        guidance_key = ""
    if guidance_key in APPLICATION_GUIDANCE:
        problem, scenario, advantage, precaution = APPLICATION_GUIDANCE[guidance_key]
        content += (
            "\n\n---\n\n"
            "## Aplicación, ventajas y límites\n\n"
            "| Elemento de análisis | Desarrollo |\n"
            "| --- | --- |\n"
            f"| **Problema que aborda** | {problem} |\n"
            f"| **Escenario de aplicación** | {scenario} |\n"
            f"| **Ventaja principal** | {advantage} |\n"
            f"| **Desventaja o precaución** | {precaution} |\n"
        )

    examples = RELATED_EXAMPLES.get(source.resolve(), [])
    if examples:
        content += "\n\n### Casos desarrollados y diagramas UML\n\n"
        for index, example in enumerate(examples, start=1):
            label = example.parent.name.replace("_", " ").capitalize()
            target = PAGES[example]
            content += f"{index}. [{label}]({relative_doc_link(destination, target)})\n"

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
