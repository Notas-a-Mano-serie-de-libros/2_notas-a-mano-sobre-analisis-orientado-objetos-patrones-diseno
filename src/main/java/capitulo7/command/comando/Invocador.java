package capitulo7.command.comando;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class Invocador {

    private List<IComandoDB> comandos;

}
