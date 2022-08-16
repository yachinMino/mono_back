package mono_training.interfaces;

import mono_training.application.UserInfoService;
import mono_training.domain.userInfo.UserInfoEntity;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping
    public List<UserInfoEntity> getAll() {
        List<UserInfoEntity> allList = userInfoService.getAll();
        allList.sort(Comparator.comparing(UserInfoEntity::getId));
        return allList;
    }

    @GetMapping("/findById/{id}")
    public List<UserInfoEntity> get(@PathVariable Integer id) {
        return userInfoService.findById(id);
    }

    @GetMapping("/findByName/{name}")
    public List<UserInfoEntity> getByNameLike(@PathVariable String name) {
        return userInfoService.getByNameLike(name);
    }

    @GetMapping("/{id}/{name}")
    public List<UserInfoEntity> getIdAndName(@PathVariable Integer id, @PathVariable String name) {
        return userInfoService.findByIdAndNameLike(id, "%" + name + "%");
    }

    @PostMapping
    public UserInfoEntity create(@RequestBody UserInfoEntity insertEntity) {
        return userInfoService.create(insertEntity);
    }

    @PutMapping
    public UserInfoEntity update(@RequestBody UserInfoEntity updateEntity) {
        return userInfoService.update(updateEntity);
    }

    @DeleteMapping
    public void delete(@RequestBody UserInfoEntity deleteEntity) {
        userInfoService.delete(deleteEntity);
    }
}