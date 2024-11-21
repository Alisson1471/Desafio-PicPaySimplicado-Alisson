package PicPaySimplificado.interfaces;

import PicPaySimplificado.domain.Authorizator;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "Authorizator", url = "https://util.devi.tools/api")
public interface AuthorizatorClient {

    @GetMapping("/v2/authorize")    
    Authorizator getAuthorizator();

    @PostMapping("/v1/notify")
    Authorizator postNotify();
}
