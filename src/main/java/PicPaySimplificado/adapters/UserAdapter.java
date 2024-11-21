package PicPaySimplificado.adapters;

import PicPaySimplificado.Repository.UserRepository;
import PicPaySimplificado.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserAdapter {

    private final UserRepository userRepository;

    public User fetchByCPF(String cpf){
        return userRepository.findByCpf(cpf);
    }

    public User fetchByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public User fetchById(int id){
        return userRepository.findById(id);
    }

    public User updateById(int id, User user){
        return userRepository.updateUserById(id, user);
    }

    public User save(User body){
        return userRepository.save(body);
    }

}
