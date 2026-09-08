package capitulo7.mediator.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class General {

    private String id;

    public General(String id) {
        this.id = id;
    }
}
