package capitulo4.yagni.ejemplo.sin_aplicar_principio.exporte;

import capitulo4.yagni.ejemplo.sin_aplicar_principio.Nota;

public class ExportePDF implements ServicioExporte {
    @Override
    public void exportarNota(Nota nota) {
        System.out.println("Exportando nota a PDF: " + nota.getContenido());
    }
}