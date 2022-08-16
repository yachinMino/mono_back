package mono_training.domain.person;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mono_training.domain.userInfo.UserInfoEntity;

@Repository
public interface UserInfoRepository extends CrudRepository<UserInfoEntity, Integer> {

    List<UserInfoEntity> findAll();

    Optional<UserInfoEntity> findById(Integer id);

    List<UserInfoEntity> findByNameLike(String name);

    List<UserInfoEntity> findByIdAndNameLike(Integer id, String name);

}
