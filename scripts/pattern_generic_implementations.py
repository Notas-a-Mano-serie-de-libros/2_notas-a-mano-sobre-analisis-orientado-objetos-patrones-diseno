"""Implementaciones Java que materializan literalmente los participantes UML."""

GENERIC_IMPLEMENTATIONS = {
    "singleton": r'''final class Singleton {
    private static Singleton instancia;

    private Singleton() { }

    public static synchronized Singleton obtenerInstancia() {
        if (instancia == null) instancia = new Singleton();
        return instancia;
    }
}''',
    "prototype": r'''interface IPrototipo {
    IPrototipo clonar();
}


final class PrototipoConcreto implements IPrototipo {
    private final String estado;

    PrototipoConcreto(String estado) { this.estado = estado; }

    @Override
    public IPrototipo clonar() {
        return new PrototipoConcreto(estado);
    }
}''',
    "builder": r'''final class Producto {
    private String parteA;
    private String parteB;

    void setParteA(String parteA) { this.parteA = parteA; }
    void setParteB(String parteB) { this.parteB = parteB; }
}

interface IBuilder {
    void construirParteA();
    void construirParteB();
    Producto obtenerProducto();
}

final class BuilderConcreto implements IBuilder {
    private final Producto producto = new Producto();

    public void construirParteA() { producto.setParteA("A"); }
    public void construirParteB() { producto.setParteB("B"); }
    public Producto obtenerProducto() { return producto; }
}

final class Director {
    Producto construir(IBuilder builder) {
        builder.construirParteA();
        builder.construirParteB();
        return builder.obtenerProducto();
    }
}''',
    "factory": r'''interface IProducto {
    void operacion();
}

final class ProductoConcreto implements IProducto {
    public void operacion() { System.out.println("Producto concreto"); }
}

interface IProductoCreador {
    IProducto crearProducto();
}

final class ProductoCreador implements IProductoCreador {
    public IProducto crearProducto() {
        return new ProductoConcreto();
    }
}''',
    "abstract_factory": r'''interface IProductoAbstractoA { void operacionA(); }
interface IProductoAbstractoB { void operacionB(); }

final class ProductoConcretoA1 implements IProductoAbstractoA {
    public void operacionA() { System.out.println("Producto A de la familia 1"); }
}
final class ProductoConcretoB1 implements IProductoAbstractoB {
    public void operacionB() { System.out.println("Producto B de la familia 1"); }
}
final class ProductoConcretoA2 implements IProductoAbstractoA {
    public void operacionA() { System.out.println("Producto A de la familia 2"); }
}
final class ProductoConcretoB2 implements IProductoAbstractoB {
    public void operacionB() { System.out.println("Producto B de la familia 2"); }
}

interface IFabricaAbstracta {
    IProductoAbstractoA crearProductoA();
    IProductoAbstractoB crearProductoB();
}

final class FabricaConcreta1 implements IFabricaAbstracta {
    public IProductoAbstractoA crearProductoA() { return new ProductoConcretoA1(); }
    public IProductoAbstractoB crearProductoB() { return new ProductoConcretoB1(); }
}

final class FabricaConcreta2 implements IFabricaAbstracta {
    public IProductoAbstractoA crearProductoA() { return new ProductoConcretoA2(); }
    public IProductoAbstractoB crearProductoB() { return new ProductoConcretoB2(); }
}''',
    "bridge": r'''interface Implementacion {
    void operacionImplementada();
}

final class ImplementacionConcretaA implements Implementacion {
    public void operacionImplementada() { System.out.println("Implementación A"); }
}

final class ImplementacionConcretaB implements Implementacion {
    public void operacionImplementada() { System.out.println("Implementación B"); }
}

abstract class Abstraccion {
    protected final Implementacion implementacion;

    protected Abstraccion(Implementacion implementacion) {
        this.implementacion = implementacion;
    }

    abstract void operacion();
}

final class AbstraccionRefinada extends Abstraccion {
    AbstraccionRefinada(Implementacion implementacion) { super(implementacion); }
    void operacion() { implementacion.operacionImplementada(); }
}''',
    "flyweight": r'''interface Flyweight {
    String obtenerEstadoIntrinseco();
}

final class Compartido implements Flyweight {
    private final String estadoIntrinseco;
    Compartido(String estadoIntrinseco) { this.estadoIntrinseco = estadoIntrinseco; }
    public String obtenerEstadoIntrinseco() { return estadoIntrinseco; }
}

final class NoCompartido {
    private final String estadoExtrinseco;
    NoCompartido(String estadoExtrinseco) { this.estadoExtrinseco = estadoExtrinseco; }
}

final class ObjetoLigero {
    private final Compartido compartido;
    private final NoCompartido noCompartido;

    ObjetoLigero(Compartido compartido, NoCompartido noCompartido) {
        this.compartido = compartido;
        this.noCompartido = noCompartido;
    }
}

final class Fabrica {
    private final java.util.Map<String, Compartido> compartidos = new java.util.HashMap<>();

    ObjetoLigero crear(String estadoIntrinseco, String estadoExtrinseco) {
        Compartido compartido = compartidos.computeIfAbsent(
                estadoIntrinseco, Compartido::new);
        return new ObjetoLigero(compartido, new NoCompartido(estadoExtrinseco));
    }
}''',
    "iterator": r'''interface Iterador<T> {
    boolean tieneSiguiente();
    T siguiente();
}

interface Iterable<T> {
    Iterador<T> crearIterador();
}

final class IterableConcreto<T> implements Iterable<T> {
    private final java.util.List<T> elementos;
    IterableConcreto(java.util.List<T> elementos) { this.elementos = elementos; }
    public Iterador<T> crearIterador() { return new IteradorConcreto<>(elementos); }
}

final class IteradorConcreto<T> implements Iterador<T> {
    private final java.util.List<T> elementos;
    private int posicion;
    IteradorConcreto(java.util.List<T> elementos) { this.elementos = elementos; }
    public boolean tieneSiguiente() { return posicion < elementos.size(); }
    public T siguiente() {
        if (!tieneSiguiente()) throw new java.util.NoSuchElementException();
        return elementos.get(posicion++);
    }
}''',
    "template": r'''abstract class Plantilla {
    public final void algoritmo() {
        pasoFijo();
        pasoVariable();
        gancho();
    }

    private void pasoFijo() { System.out.println("Paso común"); }
    protected abstract void pasoVariable();
    protected void gancho() { }
}

final class ImplementacionA extends Plantilla {
    protected void pasoVariable() { System.out.println("Variante A"); }
}

final class ImplementacionB extends Plantilla {
    protected void pasoVariable() { System.out.println("Variante B"); }
}''',
    "visitor": r'''interface IAbstraccion {
    void aceptar(IVisitante visitante);
}

final class ImplementacionA implements IAbstraccion {
    public void aceptar(IVisitante visitante) { visitante.visitar(this); }
}

final class ImplementacionB implements IAbstraccion {
    public void aceptar(IVisitante visitante) { visitante.visitar(this); }
}

interface IVisitante {
    void visitar(ImplementacionA elemento);
    void visitar(ImplementacionB elemento);
}

final class VisitanteConcreto implements IVisitante {
    public void visitar(ImplementacionA elemento) { System.out.println("Visita A"); }
    public void visitar(ImplementacionB elemento) { System.out.println("Visita B"); }
}''',
    "adapter": r'''interface IObjetivo {
    void operacionEsperada();
}

final class ProductoIncompatible {
    void operacionExistente() { System.out.println("Operación existente"); }
}

final class Adaptador implements IObjetivo {
    private final ProductoIncompatible adaptado;
    Adaptador(ProductoIncompatible adaptado) { this.adaptado = adaptado; }
    public void operacionEsperada() { adaptado.operacionExistente(); }
}''',
    "composite": r'''interface Componente {
    void operacion();
}

final class Hoja implements Componente {
    public void operacion() { System.out.println("Hoja"); }
}

final class Compuesto implements Componente {
    private final java.util.List<Componente> hijos = new java.util.ArrayList<>();
    void agregar(Componente componente) { hijos.add(componente); }
    void eliminar(Componente componente) { hijos.remove(componente); }
    public void operacion() { hijos.forEach(Componente::operacion); }
}''',
    "decorator": r'''interface IComponente {
    void operacion();
}

final class ComponenteConcreto implements IComponente {
    public void operacion() { System.out.println("Componente"); }
}

abstract class Decorador implements IComponente {
    protected final IComponente componente;
    protected Decorador(IComponente componente) { this.componente = componente; }
    public void operacion() { componente.operacion(); }
}

final class DecoradorConcreto extends Decorador {
    DecoradorConcreto(IComponente componente) { super(componente); }
    public void operacion() {
        super.operacion();
        System.out.println("Responsabilidad adicional");
    }
}''',
    "facade": r'''final class SubsistemaA {
    void operacionA() { System.out.println("Subsistema A"); }
}
final class SubsistemaB {
    void operacionB() { System.out.println("Subsistema B"); }
}

interface IFachada { void operacion(); }

final class FachadaImpl implements IFachada {
    private final SubsistemaA a = new SubsistemaA();
    private final SubsistemaB b = new SubsistemaB();
    public void operacion() {
        a.operacionA();
        b.operacionB();
    }
}''',
    "proxy": r'''interface IObjetivo {
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
}''',
    "cadena_responsabilidad": r'''abstract class Manejador {
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
}''',
    "command": r'''interface IComando { void ejecutar(); }

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
}''',
    "mediator": r'''interface IMediador {
    void notificar(Colega emisor, String evento);
}

abstract class Colega {
    protected final IMediador mediador;
    protected Colega(IMediador mediador) { this.mediador = mediador; }
}

final class ColegaConcreto extends Colega {
    ColegaConcreto(IMediador mediador) { super(mediador); }
    void enviar(String evento) { mediador.notificar(this, evento); }
    void recibir(String evento) { System.out.println(evento); }
}

final class MediadorConcreto implements IMediador {
    private ColegaConcreto colega;
    void registrar(ColegaConcreto colega) { this.colega = colega; }
    public void notificar(Colega emisor, String evento) {
        if (colega != emisor) colega.recibir(evento);
    }
}''',
    "memento": r'''final class Memento {
    private final String estado;
    Memento(String estado) { this.estado = estado; }
    String obtenerEstado() { return estado; }
}

final class Originador {
    private String estado;
    void cambiarEstado(String estado) { this.estado = estado; }
    Memento guardar() { return new Memento(estado); }
    void restaurar(Memento memento) { estado = memento.obtenerEstado(); }
}

final class Cuidador {
    private final java.util.Deque<Memento> historial = new java.util.ArrayDeque<>();
    void guardar(Memento memento) { historial.push(memento); }
    Memento recuperar() { return historial.pop(); }
}''',
    "observer": r'''interface IObservador { void actualizar(String evento); }
interface IObservable {
    void suscribir(IObservador observador);
    void desuscribir(IObservador observador);
    void notificar(String evento);
}

final class ObservableConcreto implements IObservable {
    private final java.util.List<IObservador> observadores = new java.util.ArrayList<>();
    public void suscribir(IObservador o) { observadores.add(o); }
    public void desuscribir(IObservador o) { observadores.remove(o); }
    public void notificar(String evento) { observadores.forEach(o -> o.actualizar(evento)); }
}

final class ObservadorConcreto implements IObservador {
    public void actualizar(String evento) { System.out.println(evento); }
}''',
    "state": r'''interface IEstado { void manejar(Contexto contexto); }

final class EstadoConcretoA implements IEstado {
    public void manejar(Contexto contexto) { contexto.cambiarEstado(new EstadoConcretoB()); }
}
final class EstadoConcretoB implements IEstado {
    public void manejar(Contexto contexto) { contexto.cambiarEstado(new EstadoConcretoA()); }
}

final class Contexto {
    private IEstado estado;
    Contexto(IEstado estado) { this.estado = estado; }
    void cambiarEstado(IEstado estado) { this.estado = estado; }
    void solicitud() { estado.manejar(this); }
}''',
    "strategy": r'''interface IEstrategia { void algoritmo(); }

final class EstrategiaConcretaA implements IEstrategia {
    public void algoritmo() { System.out.println("Estrategia A"); }
}
final class EstrategiaConcretaB implements IEstrategia {
    public void algoritmo() { System.out.println("Estrategia B"); }
}

final class Contexto {
    private IEstrategia estrategia;
    Contexto(IEstrategia estrategia) { this.estrategia = estrategia; }
    void cambiarEstrategia(IEstrategia estrategia) { this.estrategia = estrategia; }
    void ejecutar() { estrategia.algoritmo(); }
}''',
}
PYTHON_IMPLEMENTATIONS = {
    "singleton": '''class Singleton:\n    _instancia = None\n\n    def __new__(cls):\n        if cls._instancia is None:\n            cls._instancia = super().__new__(cls)\n        return cls._instancia''',
    "prototype": '''from copy import deepcopy\n\nclass IPrototipo:\n    def clonar(self): raise NotImplementedError\n\nclass PrototipoConcreto(IPrototipo):\n    def __init__(self, estado): self.estado = estado\n    def clonar(self): return deepcopy(self)''',
    "builder": '''class Producto:\n    def __init__(self): self.partes = []\n\nclass IBuilder:\n    def construir_parte_a(self): raise NotImplementedError\n    def construir_parte_b(self): raise NotImplementedError\n    def obtener_producto(self): raise NotImplementedError\n\nclass BuilderConcreto(IBuilder):\n    def __init__(self): self.producto = Producto()\n    def construir_parte_a(self): self.producto.partes.append("A")\n    def construir_parte_b(self): self.producto.partes.append("B")\n    def obtener_producto(self): return self.producto\n\nclass Director:\n    def construir(self, builder):\n        builder.construir_parte_a(); builder.construir_parte_b()\n        return builder.obtener_producto()''',
    "factory": '''class IProducto:\n    def operacion(self): raise NotImplementedError\n\nclass ProductoConcreto(IProducto):\n    def operacion(self): return "producto"\n\nclass IProductoCreador:\n    def crear_producto(self): raise NotImplementedError\n\nclass ProductoCreador(IProductoCreador):\n    def crear_producto(self): return ProductoConcreto()''',
    "abstract_factory": '''class IProductoAbstractoA: pass\nclass IProductoAbstractoB: pass\n+class ProductoConcretoA1(IProductoAbstractoA): pass\n+class ProductoConcretoB1(IProductoAbstractoB): pass\n+class ProductoConcretoA2(IProductoAbstractoA): pass\n+class ProductoConcretoB2(IProductoAbstractoB): pass\n+\nclass IFabricaAbstracta:\n    def crear_producto_a(self): raise NotImplementedError\n    def crear_producto_b(self): raise NotImplementedError\n\nclass FabricaConcreta1(IFabricaAbstracta):\n    def crear_producto_a(self): return ProductoConcretoA1()\n    def crear_producto_b(self): return ProductoConcretoB1()\n\nclass FabricaConcreta2(IFabricaAbstracta):\n    def crear_producto_a(self): return ProductoConcretoA2()\n    def crear_producto_b(self): return ProductoConcretoB2()'''.replace("\n+", "\n"),
    "adapter": '''class IObjetivo:\n    def operacion_esperada(self): raise NotImplementedError\n\nclass ProductoIncompatible:\n    def operacion_existente(self): return "existente"\n\nclass Adaptador(IObjetivo):\n    def __init__(self, adaptado): self.adaptado = adaptado\n    def operacion_esperada(self): return self.adaptado.operacion_existente()''',
    "bridge": '''class Implementacion:\n    def operacion_implementada(self): raise NotImplementedError\n\nclass ImplementacionConcreta(Implementacion):\n    def operacion_implementada(self): return "implementada"\n\nclass Abstraccion:\n    def __init__(self, implementacion): self.implementacion = implementacion\n\nclass AbstraccionRefinada(Abstraccion):\n    def operacion(self): return self.implementacion.operacion_implementada()''',
    "composite": '''class Componente:\n    def operacion(self): raise NotImplementedError\n\nclass Hoja(Componente):\n    def operacion(self): return "hoja"\n\nclass Compuesto(Componente):\n    def __init__(self): self.hijos = []\n    def agregar(self, componente): self.hijos.append(componente)\n    def operacion(self): return [hijo.operacion() for hijo in self.hijos]''',
    "decorator": '''class IComponente:\n    def operacion(self): raise NotImplementedError\n\nclass ComponenteConcreto(IComponente):\n    def operacion(self): return "componente"\n\nclass Decorador(IComponente):\n    def __init__(self, componente): self.componente = componente\n    def operacion(self): return self.componente.operacion()\n\nclass DecoradorConcreto(Decorador):\n    def operacion(self): return super().operacion() + " + adicional"''',
    "facade": '''class SubsistemaA:\n    def operacion_a(self): return "A"\nclass SubsistemaB:\n    def operacion_b(self): return "B"\n\nclass IFachada:\n    def operacion(self): raise NotImplementedError\n\nclass FachadaImpl(IFachada):\n    def __init__(self): self.a, self.b = SubsistemaA(), SubsistemaB()\n    def operacion(self): return self.a.operacion_a() + self.b.operacion_b()''',
    "flyweight": '''class Flyweight: pass\nclass Compartido(Flyweight):\n    def __init__(self, intrinseco): self.intrinseco = intrinseco\nclass NoCompartido:\n    def __init__(self, extrinseco): self.extrinseco = extrinseco\nclass ObjetoLigero:\n    def __init__(self, compartido, no_compartido):\n        self.compartido, self.no_compartido = compartido, no_compartido\nclass Fabrica:\n    def __init__(self): self.compartidos = {}\n    def crear(self, intrinseco, extrinseco):\n        compartido = self.compartidos.setdefault(intrinseco, Compartido(intrinseco))\n        return ObjetoLigero(compartido, NoCompartido(extrinseco))''',
    "proxy": '''class IObjetivo:\n    def solicitud(self): raise NotImplementedError\nclass ObjetoReal(IObjetivo):\n    def solicitud(self): return "real"\nclass Proxy(IObjetivo):\n    def __init__(self): self.real = None\n    def solicitud(self):\n        if self.real is None: self.real = ObjetoReal()\n        return self.real.solicitud()''',
    "cadena_responsabilidad": '''class Manejador:\n    def __init__(self): self.siguiente = None\n    def enlazar(self, siguiente): self.siguiente = siguiente; return siguiente\n    def manejar(self, solicitud):\n        return self.siguiente.manejar(solicitud) if self.siguiente else None\nclass ManejadorConcreto(Manejador):\n    def manejar(self, solicitud):\n        return "atendida" if solicitud == "admitida" else super().manejar(solicitud)''',
    "command": '''class IComando:\n    def ejecutar(self): raise NotImplementedError\nclass Receptor:\n    def accion(self): return "acción"\nclass ComandoConcreto(IComando):\n    def __init__(self, receptor): self.receptor = receptor\n    def ejecutar(self): return self.receptor.accion()\nclass Invocador:\n    def __init__(self, comando): self.comando = comando\n    def invocar(self): return self.comando.ejecutar()''',
    "iterator": '''class Iterador:\n    def __next__(self): raise NotImplementedError\nclass Iterable:\n    def __iter__(self): raise NotImplementedError\nclass IteradorConcreto(Iterador):\n    def __init__(self, elementos): self.elementos, self.posicion = elementos, 0\n    def __iter__(self): return self\n    def __next__(self):\n        if self.posicion >= len(self.elementos): raise StopIteration\n        valor = self.elementos[self.posicion]; self.posicion += 1; return valor\nclass IterableConcreto(Iterable):\n    def __init__(self, elementos): self.elementos = elementos\n    def __iter__(self): return IteradorConcreto(self.elementos)''',
    "mediator": '''class IMediador:\n    def notificar(self, emisor, evento): raise NotImplementedError\nclass Colega:\n    def __init__(self, mediador): self.mediador = mediador\nclass ColegaConcreto(Colega):\n    def enviar(self, evento): self.mediador.notificar(self, evento)\n    def recibir(self, evento): self.ultimo = evento\nclass MediadorConcreto(IMediador):\n    def __init__(self): self.colegas = []\n    def notificar(self, emisor, evento):\n        for colega in self.colegas:\n            if colega is not emisor: colega.recibir(evento)''',
    "memento": '''class Memento:\n    def __init__(self, estado): self._estado = estado\nclass Originador:\n    def __init__(self): self.estado = None\n    def guardar(self): return Memento(self.estado)\n    def restaurar(self, memento): self.estado = memento._estado\nclass Cuidador:\n    def __init__(self): self.historial = []\n    def guardar(self, memento): self.historial.append(memento)\n    def recuperar(self): return self.historial.pop()''',
    "observer": '''class IObservador:\n    def actualizar(self, evento): raise NotImplementedError\nclass IObservable:\n    def suscribir(self, observador): raise NotImplementedError\n    def notificar(self, evento): raise NotImplementedError\nclass ObservableConcreto(IObservable):\n    def __init__(self): self.observadores = []\n    def suscribir(self, observador): self.observadores.append(observador)\n    def notificar(self, evento):\n        for observador in self.observadores: observador.actualizar(evento)\nclass ObservadorConcreto(IObservador):\n    def actualizar(self, evento): self.ultimo = evento''',
    "state": '''class IEstado:\n    def manejar(self, contexto): raise NotImplementedError\nclass EstadoConcretoA(IEstado):\n    def manejar(self, contexto): contexto.estado = EstadoConcretoB()\nclass EstadoConcretoB(IEstado):\n    def manejar(self, contexto): contexto.estado = EstadoConcretoA()\nclass Contexto:\n    def __init__(self, estado): self.estado = estado\n    def solicitud(self): self.estado.manejar(self)''',
    "strategy": '''class IEstrategia:\n    def algoritmo(self, datos): raise NotImplementedError\nclass EstrategiaConcretaA(IEstrategia):\n    def algoritmo(self, datos): return sorted(datos)\nclass EstrategiaConcretaB(IEstrategia):\n    def algoritmo(self, datos): return list(reversed(datos))\nclass Contexto:\n    def __init__(self, estrategia): self.estrategia = estrategia\n    def ejecutar(self, datos): return self.estrategia.algoritmo(datos)''',
    "template": '''class Plantilla:\n    def algoritmo(self):\n        self.paso_fijo(); self.paso_variable(); self.gancho()\n    def paso_fijo(self): pass\n    def paso_variable(self): raise NotImplementedError\n    def gancho(self): pass\nclass ImplementacionA(Plantilla):\n    def paso_variable(self): return "A"\nclass ImplementacionB(Plantilla):\n    def paso_variable(self): return "B"''',
    "visitor": '''class IAbstraccion:\n    def aceptar(self, visitante): raise NotImplementedError\nclass ImplementacionA(IAbstraccion):\n    def aceptar(self, visitante): return visitante.visitar_a(self)\nclass ImplementacionB(IAbstraccion):\n    def aceptar(self, visitante): return visitante.visitar_b(self)\nclass IVisitante:\n    def visitar_a(self, elemento): raise NotImplementedError\n    def visitar_b(self, elemento): raise NotImplementedError\nclass VisitanteConcreto(IVisitante):\n    def visitar_a(self, elemento): return "visita A"\n    def visitar_b(self, elemento): return "visita B"''',
}

CSHARP_IMPLEMENTATIONS = {
    "singleton": '''sealed class Singleton {\n    private static readonly Singleton instancia = new Singleton();\n    private Singleton() { }\n    public static Singleton ObtenerInstancia() => instancia;\n}''',
    "prototype": '''interface IPrototipo { IPrototipo Clonar(); }\nclass PrototipoConcreto : IPrototipo {\n    public string Estado { get; }\n    public PrototipoConcreto(string estado) => Estado = estado;\n    public IPrototipo Clonar() => new PrototipoConcreto(Estado);\n}''',
    "builder": '''class Producto { public System.Collections.Generic.List<string> Partes { get; } = new(); }\ninterface IBuilder { void ConstruirParteA(); void ConstruirParteB(); Producto ObtenerProducto(); }\nclass BuilderConcreto : IBuilder {\n    private readonly Producto producto = new();\n    public void ConstruirParteA() => producto.Partes.Add("A");\n    public void ConstruirParteB() => producto.Partes.Add("B");\n    public Producto ObtenerProducto() => producto;\n}\nclass Director {\n    public Producto Construir(IBuilder b) { b.ConstruirParteA(); b.ConstruirParteB(); return b.ObtenerProducto(); }\n}''',
    "factory": '''interface IProducto { void Operacion(); }\nclass ProductoConcreto : IProducto { public void Operacion() { } }\ninterface IProductoCreador { IProducto CrearProducto(); }\nclass ProductoCreador : IProductoCreador {\n    public IProducto CrearProducto() => new ProductoConcreto();\n}''',
    "abstract_factory": '''interface IProductoAbstractoA { }\ninterface IProductoAbstractoB { }\nclass ProductoConcretoA1 : IProductoAbstractoA { }\nclass ProductoConcretoB1 : IProductoAbstractoB { }\nclass ProductoConcretoA2 : IProductoAbstractoA { }\nclass ProductoConcretoB2 : IProductoAbstractoB { }\ninterface IFabricaAbstracta { IProductoAbstractoA CrearA(); IProductoAbstractoB CrearB(); }\nclass FabricaConcreta1 : IFabricaAbstracta {\n    public IProductoAbstractoA CrearA() => new ProductoConcretoA1();\n    public IProductoAbstractoB CrearB() => new ProductoConcretoB1();\n}\nclass FabricaConcreta2 : IFabricaAbstracta {\n    public IProductoAbstractoA CrearA() => new ProductoConcretoA2();\n    public IProductoAbstractoB CrearB() => new ProductoConcretoB2();\n}''',
    "adapter": '''interface IObjetivo { string OperacionEsperada(); }\nclass ProductoIncompatible { public string OperacionExistente() => "existente"; }\nclass Adaptador : IObjetivo {\n    private readonly ProductoIncompatible adaptado;\n    public Adaptador(ProductoIncompatible adaptado) => this.adaptado = adaptado;\n    public string OperacionEsperada() => adaptado.OperacionExistente();\n}''',
    "bridge": '''interface Implementacion { void OperacionImplementada(); }\nclass ImplementacionConcreta : Implementacion { public void OperacionImplementada() { } }\nabstract class Abstraccion {\n    protected Implementacion implementacion;\n    protected Abstraccion(Implementacion i) => implementacion = i;\n}\nclass AbstraccionRefinada : Abstraccion {\n    public AbstraccionRefinada(Implementacion i) : base(i) { }\n    public void Operacion() => implementacion.OperacionImplementada();\n}''',
    "composite": '''interface Componente { void Operacion(); }\nclass Hoja : Componente { public void Operacion() { } }\nclass Compuesto : Componente {\n    private readonly System.Collections.Generic.List<Componente> hijos = new();\n    public void Agregar(Componente c) => hijos.Add(c);\n    public void Operacion() { foreach (var hijo in hijos) hijo.Operacion(); }\n}''',
    "decorator": '''interface IComponente { void Operacion(); }\nclass ComponenteConcreto : IComponente { public void Operacion() { } }\nabstract class Decorador : IComponente {\n    protected readonly IComponente componente;\n    protected Decorador(IComponente c) => componente = c;\n    public virtual void Operacion() => componente.Operacion();\n}\nclass DecoradorConcreto : Decorador {\n    public DecoradorConcreto(IComponente c) : base(c) { }\n    public override void Operacion() { base.Operacion(); /* responsabilidad adicional */ }\n}''',
    "facade": '''class SubsistemaA { public void OperacionA() { } }\nclass SubsistemaB { public void OperacionB() { } }\ninterface IFachada { void Operacion(); }\nclass FachadaImpl : IFachada {\n    private readonly SubsistemaA a = new(); private readonly SubsistemaB b = new();\n    public void Operacion() { a.OperacionA(); b.OperacionB(); }\n}''',
    "flyweight": '''interface Flyweight { string ObtenerEstadoIntrinseco(); }\nclass Compartido : Flyweight {\n    private readonly string intrinseco; public Compartido(string e) => intrinseco = e;\n    public string ObtenerEstadoIntrinseco() => intrinseco;\n}\nrecord NoCompartido(string Extrinseco);\nrecord ObjetoLigero(Compartido Compartido, NoCompartido NoCompartido);\nclass Fabrica {\n    private readonly System.Collections.Generic.Dictionary<string, Compartido> compartidos = new();\n    public ObjetoLigero Crear(string i, string e) {\n        if (!compartidos.ContainsKey(i)) compartidos[i] = new Compartido(i);\n        return new ObjetoLigero(compartidos[i], new NoCompartido(e));\n    }\n}''',
    "proxy": '''interface IObjetivo { void Solicitud(); }\nclass ObjetoReal : IObjetivo { public void Solicitud() { } }\nclass Proxy : IObjetivo {\n    private ObjetoReal? real;\n    public void Solicitud() { real ??= new ObjetoReal(); real.Solicitud(); }\n}''',
    "cadena_responsabilidad": '''abstract class Manejador {\n    private Manejador? siguiente;\n    public Manejador Enlazar(Manejador s) { siguiente = s; return s; }\n    public virtual void Manejar(string solicitud) => siguiente?.Manejar(solicitud);\n}\nclass ManejadorConcreto : Manejador {\n    public override void Manejar(string s) { if (s != "admitida") base.Manejar(s); }\n}''',
    "command": '''interface IComando { void Ejecutar(); }\nclass Receptor { public void Accion() { } }\nclass ComandoConcreto : IComando {\n    private readonly Receptor receptor; public ComandoConcreto(Receptor r) => receptor = r;\n    public void Ejecutar() => receptor.Accion();\n}\nclass Invocador { public IComando Comando { get; set; } public void Invocar() => Comando.Ejecutar(); }''',
    "iterator": '''interface Iterador<T> { bool TieneSiguiente(); T Siguiente(); }\ninterface Iterable<T> { Iterador<T> CrearIterador(); }\nclass IteradorConcreto<T> : Iterador<T> {\n    private readonly System.Collections.Generic.IList<T> datos; private int posicion;\n    public IteradorConcreto(System.Collections.Generic.IList<T> d) => datos = d;\n    public bool TieneSiguiente() => posicion < datos.Count;\n    public T Siguiente() => datos[posicion++];\n}\nclass IterableConcreto<T> : Iterable<T> {\n    private readonly System.Collections.Generic.IList<T> datos;\n    public IterableConcreto(System.Collections.Generic.IList<T> d) => datos = d;\n    public Iterador<T> CrearIterador() => new IteradorConcreto<T>(datos);\n}''',
    "mediator": '''interface IMediador { void Notificar(Colega emisor, string evento); }\nabstract class Colega { protected IMediador mediador; protected Colega(IMediador m) => mediador = m; }\nclass ColegaConcreto : Colega { public ColegaConcreto(IMediador m) : base(m) { } public void Enviar(string e) => mediador.Notificar(this,e); }\nclass MediadorConcreto : IMediador { public void Notificar(Colega emisor, string evento) { /* coordina colegas */ } }''',
    "memento": '''record Memento(string Estado);\nclass Originador {\n    public string Estado { get; set; }\n    public Memento Guardar() => new(Estado);\n    public void Restaurar(Memento m) => Estado = m.Estado;\n}\nclass Cuidador { public Stack<Memento> Historial { get; } = new(); }''',
    "observer": '''interface IObservador { void Actualizar(string evento); }\ninterface IObservable { void Suscribir(IObservador o); void Notificar(string evento); }\nclass ObservableConcreto : IObservable {\n    private readonly System.Collections.Generic.List<IObservador> observadores = new();\n    public void Suscribir(IObservador o) => observadores.Add(o);\n    public void Notificar(string e) { foreach (var o in observadores) o.Actualizar(e); }\n}\nclass ObservadorConcreto : IObservador { public void Actualizar(string evento) { } }''',
    "state": '''interface IEstado { void Manejar(Contexto contexto); }\nclass EstadoConcretoA : IEstado { public void Manejar(Contexto c) => c.Estado = new EstadoConcretoB(); }\nclass EstadoConcretoB : IEstado { public void Manejar(Contexto c) => c.Estado = new EstadoConcretoA(); }\nclass Contexto { public IEstado Estado { get; set; } public void Solicitud() => Estado.Manejar(this); }''',
    "strategy": '''interface IEstrategia { int[] Algoritmo(int[] datos); }\nclass EstrategiaConcretaA : IEstrategia { public int[] Algoritmo(int[] d) { var r=(int[])d.Clone(); System.Array.Sort(r); return r; } }\nclass EstrategiaConcretaB : IEstrategia { public int[] Algoritmo(int[] d) { var r=(int[])d.Clone(); System.Array.Reverse(r); return r; } }\nclass Contexto {\n    public IEstrategia Estrategia { get; set; }\n    public int[] Ejecutar(int[] datos) => Estrategia.Algoritmo(datos);\n}''',
    "template": '''abstract class Plantilla {\n    public void Algoritmo() { PasoFijo(); PasoVariable(); Gancho(); }\n    private void PasoFijo() { }\n    protected abstract void PasoVariable();\n    protected virtual void Gancho() { }\n}\nclass ImplementacionA : Plantilla { protected override void PasoVariable() { } }\nclass ImplementacionB : Plantilla { protected override void PasoVariable() { } }''',
    "visitor": '''interface IAbstraccion { void Aceptar(IVisitante visitante); }\nclass ImplementacionA : IAbstraccion { public void Aceptar(IVisitante v) => v.Visitar(this); }\nclass ImplementacionB : IAbstraccion { public void Aceptar(IVisitante v) => v.Visitar(this); }\ninterface IVisitante { void Visitar(ImplementacionA e); void Visitar(ImplementacionB e); }\nclass VisitanteConcreto : IVisitante { public void Visitar(ImplementacionA e) { } public void Visitar(ImplementacionB e) { } }''',
}

PSEUDOCODE_IMPLEMENTATIONS = {
    "singleton": '''CLASE Singleton\n    instancia ← NULO\n    MÉTODO obtenerInstancia()\n        SI instancia ES NULO ENTONCES instancia ← NUEVO Singleton\n        RETORNAR instancia''',
    "prototype": '''INTERFAZ IPrototipo: clonar()\nCLASE PrototipoConcreto IMPLEMENTA IPrototipo\n    estado\n    MÉTODO clonar()\n        RETORNAR NUEVO PrototipoConcreto(copia de estado)''',
    "builder": '''INTERFAZ IBuilder: construirParteA(), obtenerProducto()\nCLASE BuilderConcreto IMPLEMENTA IBuilder\n    producto ← NUEVO Producto\n    construirParteA(): configurar producto.parteA\n    obtenerProducto(): RETORNAR producto\nCLASE Director\n    construir(builder): ejecutar pasos y RETORNAR builder.obtenerProducto()''',
    "factory": '''INTERFAZ IProducto: operacion()\nCLASE ProductoConcreto IMPLEMENTA IProducto\nINTERFAZ IProductoCreador: crearProducto()\nCLASE ProductoCreador IMPLEMENTA IProductoCreador\n    crearProducto(): RETORNAR NUEVO ProductoConcreto''',
    "abstract_factory": '''INTERFACES IProductoAbstractoA, IProductoAbstractoB\nINTERFAZ IFabricaAbstracta: crearProductoA(), crearProductoB()\nCLASE FabricaConcreta1 IMPLEMENTA IFabricaAbstracta\n    crearProductoA(): RETORNAR ProductoConcretoA1\n    crearProductoB(): RETORNAR ProductoConcretoB1\nCLIENTE usa solo IFabricaAbstracta y productos abstractos''',
    "adapter": '''INTERFAZ IObjetivo: operacionEsperada()\nCLASE ProductoIncompatible: operacionExistente()\nCLASE Adaptador IMPLEMENTA IObjetivo\n    adaptado ← ProductoIncompatible\n    operacionEsperada(): RETORNAR adaptado.operacionExistente()''',
    "bridge": '''INTERFAZ Implementacion: operacionImplementada()\nCLASE ImplementacionConcreta IMPLEMENTA Implementacion\nCLASE Abstraccion: contiene Implementacion\nCLASE AbstraccionRefinada EXTIENDE Abstraccion\n    operacion(): delegar en implementacion.operacionImplementada()''',
    "composite": '''INTERFAZ Componente: operacion()\nCLASE Hoja IMPLEMENTA Componente\nCLASE Compuesto IMPLEMENTA Componente\n    hijos ← lista de Componente\n    operacion(): PARA CADA hijo HACER hijo.operacion()''',
    "decorator": '''INTERFAZ IComponente: operacion()\nCLASE ComponenteConcreto IMPLEMENTA IComponente\nCLASE Decorador IMPLEMENTA IComponente: contiene IComponente\nCLASE DecoradorConcreto EXTIENDE Decorador\n    operacion(): componente.operacion(); agregarResponsabilidad()''',
    "facade": '''CLASES SubsistemaA, SubsistemaB\nINTERFAZ IFachada: operacion()\nCLASE FachadaImpl IMPLEMENTA IFachada\n    contiene SubsistemaA y SubsistemaB\n    operacion(): coordinar operacionA() y operacionB()''',
    "flyweight": '''CLASE Compartido: estadoIntrinseco inmutable\nCLASE ObjetoLigero: Compartido + estadoExtrinseco\nCLASE Fabrica: mapa de objetos Compartido\n    crear(intrinseco, extrinseco)\n        compartido ← buscar o crear por intrinseco\n        RETORNAR ObjetoLigero(compartido, extrinseco)''',
    "proxy": '''INTERFAZ IObjetivo: solicitud()\nCLASE ObjetoReal IMPLEMENTA IObjetivo\nCLASE Proxy IMPLEMENTA IObjetivo\n    real ← NULO\n    solicitud(): validar; crear real si falta; delegar real.solicitud()''',
    "cadena_responsabilidad": '''CLASE Manejador: siguiente Manejador\n    manejar(solicitud): delegar al siguiente si existe\nCLASE ManejadorConcreto EXTIENDE Manejador\n    manejar(solicitud)\n        SI puedeAtender ENTONCES procesar\n        SI NO delegar mediante la superclase''',
    "command": '''INTERFAZ IComando: ejecutar()\nCLASE Receptor: accion()\nCLASE ComandoConcreto: contiene Receptor\n    ejecutar(): receptor.accion()\nCLASE Invocador: contiene IComando\n    invocar(): comando.ejecutar()''',
    "iterator": '''INTERFAZ Iterador: tieneSiguiente(), siguiente()\nINTERFAZ Iterable: crearIterador()\nCLASE IterableConcreto: contiene elementos\nCLASE IteradorConcreto: elementos + posición\n    siguiente(): validar límite; retornar elemento; avanzar posición''',
    "mediator": '''INTERFAZ IMediador: notificar(emisor, evento)\nCLASE Colega: contiene IMediador\nCLASE ColegaConcreto: enviar mediante mediador\nCLASE MediadorConcreto\n    notificar(emisor, evento): coordinar destinatarios sin acoplar colegas''',
    "memento": '''CLASE Memento: estado inmutable\nCLASE Originador\n    guardar(): RETORNAR Memento(estado)\n    restaurar(memento): estado ← memento.estado\nCLASE Cuidador: pila de Memento''',
    "observer": '''INTERFAZ IObservador: actualizar(evento)\nINTERFAZ IObservable: suscribir(), desuscribir(), notificar()\nCLASE ObservableConcreto: lista de IObservador\n    notificar(evento): PARA CADA observador HACER actualizar(evento)\nCLASE ObservadorConcreto IMPLEMENTA IObservador''',
    "state": '''INTERFAZ IEstado: manejar(contexto)\nCLASES EstadoConcretoA y EstadoConcretoB IMPLEMENTAN IEstado\nCLASE Contexto: contiene IEstado actual\n    solicitud(): estado.manejar(esteContexto)\n    cambiarEstado(nuevo): estado ← nuevo''',
    "strategy": '''INTERFAZ IEstrategia: algoritmo(datos)\nCLASES EstrategiaConcretaA y B IMPLEMENTAN IEstrategia\nCLASE Contexto: contiene IEstrategia\n    cambiarEstrategia(nueva): estrategia ← nueva\n    ejecutar(datos): RETORNAR estrategia.algoritmo(datos)''',
    "template": '''CLASE ABSTRACTA Plantilla\n    algoritmo FINAL(): pasoFijo(); pasoVariable(); gancho()\n    pasoFijo(): implementación común\n    pasoVariable(): ABSTRACTO\nCLASE ImplementacionA EXTIENDE Plantilla: redefine pasoVariable()''',
    "visitor": '''INTERFAZ IAbstraccion: aceptar(IVisitante)\nCLASE ImplementacionA: aceptar(v) → v.visitar(esteA)\nCLASE ImplementacionB: aceptar(v) → v.visitar(esteB)\nINTERFAZ IVisitante: visitar(A), visitar(B)\nCLASE VisitanteConcreto IMPLEMENTA ambas operaciones''',
}
