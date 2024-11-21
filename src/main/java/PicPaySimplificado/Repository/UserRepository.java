package PicPaySimplificado.Repository;

import PicPaySimplificado.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, Integer> {

    User findByEmail(String email);
    User findByCpf(String cpf);

    User findById(int id); // Usar int para o campo _id

    @Query("{ '_id': ?0 }")
    User updateUserById(int id, User user);

}
