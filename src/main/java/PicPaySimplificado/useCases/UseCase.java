package PicPaySimplificado.useCases;

import PicPaySimplificado.adapters.UserAdapter;
import PicPaySimplificado.exception.FailedAuthorizator;
import PicPaySimplificado.exception.FailedSave;
import PicPaySimplificado.exception.IsNotUniqueException;
import PicPaySimplificado.interfaces.AuthorizatorClient;
import PicPaySimplificado.domain.Authorizator;
import PicPaySimplificado.domain.Request;
import PicPaySimplificado.domain.User;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UseCase {
    private final UserAdapter adapter;
    private final AuthorizatorClient authorizator;

    public void verificarUnique(String cpf, String email){
        if ( adapter.fetchByCPF(cpf) == null || adapter.fetchByEmail(email) == null){
            throw new IsNotUniqueException("Email ou CPF já existente!");
        }
    }

    public void authorizator(){
        Authorizator authorizator1 = authorizator.getAuthorizator();
        if (authorizator1.getStatus().equals("fail")) {
            throw new FailedAuthorizator("Authorization has failed!");
        }
    }

    public void notificator(){
        Authorizator notificator1 = authorizator.postNotify();
        if (notificator1.getStatus().equals("fail")){
            throw new FailedAuthorizator("Notification has failed!");
        }
    }

    public void save(User user){
        if (adapter.save(user) == null){
            throw new FailedSave("Falha ao salvar os dados da transação!");
        }
    }

    public boolean update(int id, User user){
        return adapter.updateById(id, user) != null;
    }

    public String transfer(Request request){

        User payer = adapter.fetchById(request.getPayer());
        User payee = adapter.fetchById(request.getPayee());

        verificarUnique(payer.getCpf(), payee.getEmail());
        verificarUnique(payee.getCpf(), payer.getEmail());

        if (payer == null || payee == null) {
            return "Usuário não encontrado!";
        }

        if (payer.getTipo().equals("lojista")) {
            return "Lojista não pode efetuar pagamento!";
        }

        if (payer.getSaldo() <= request.getValue()) {
            return "Saldo insuficiente!";
        }

        payer.setSaldo(payer.getSaldo() - request.getValue());
        payee.setSaldo(payee.getSaldo() + request.getValue());

        authorizator();

        save(payer);
        save(payee);

        return "Pagamento efetuado com sucesso!";

    }
}
