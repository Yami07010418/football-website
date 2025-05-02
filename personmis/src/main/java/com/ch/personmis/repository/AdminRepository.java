package com.ch.personmis.repository;
import com.ch.personmis.entity.UserEntity;
import org.springframework.stereotype.Repository;
@Repository
public interface AdminRepository {
    UserEntity login(UserEntity userEntity);
//注册和是否注册过
//    public List<BUserEntity> isUse(BUserEntity bUser);
//    public int register(BUserEntity bUser);
}
