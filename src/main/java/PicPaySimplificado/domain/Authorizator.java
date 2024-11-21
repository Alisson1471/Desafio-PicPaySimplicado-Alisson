package PicPaySimplificado.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Authorizator {
    private String status;
    private Autorizar data;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    public static class Autorizar {
        @JsonProperty("authorization")
        private boolean authorization;
    }
}
