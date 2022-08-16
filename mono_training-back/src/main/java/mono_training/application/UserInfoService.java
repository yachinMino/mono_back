package mono_training.application;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mono_training.domain.person.UserInfoRepository;
import mono_training.domain.userInfo.UserInfoEntity;

@Service
public class UserInfoService {
    @Autowired
    private UserInfoRepository userInfoRepository;

    public List<UserInfoEntity> getAll() {
        return (List<UserInfoEntity>) userInfoRepository.findAll();
    }

    public List<UserInfoEntity> findByIdAndNameLike(Integer id, String name) {
        return userInfoRepository.findByIdAndNameLike(id, name);
    }

    public List<UserInfoEntity> getByNameLike(String name) {
        return userInfoRepository.findByNameLike("%" + name + "%");
    }

    public List<UserInfoEntity> findById(Integer id) {
        List<UserInfoEntity> retList = new ArrayList<>();
        UserInfoEntity tmp = userInfoRepository.findById(id).orElse(null);
        if (tmp != null) {
            retList.add(tmp);
        }
        return retList;
    }

    public UserInfoEntity create(UserInfoEntity insertEntity) {
        return userInfoRepository.save(insertEntity);
    }

    public UserInfoEntity update(UserInfoEntity updateEntity) {
        UserInfoEntity userInfo = findById(updateEntity.getId()).get(0);
        // updateするフィールドをセットする
        userInfo.setName(updateEntity.getName());
        return userInfoRepository.save(userInfo);
    }

    public void delete(UserInfoEntity deleteEntity) {
        userInfoRepository.delete(deleteEntity);
    }
}
