package PicPaySimplificado.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Request {

    private Double value;
    private Integer payer;
    private Integer payee;

}
