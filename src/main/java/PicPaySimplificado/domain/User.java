package PicPaySimplificado.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "users")
public class User {

    @Id
    private Integer id;
    private String tipo;
    private String nome_completo;
    private String cpf;
    private String email;
    private String senha;
    private Double saldo;

}
