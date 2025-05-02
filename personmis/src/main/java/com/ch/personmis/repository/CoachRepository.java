package com.ch.personmis.repository;
import com.ch.personmis.entity.BUserEntity;
import com.ch.personmis.entity.CoachEntity;
import com.ch.personmis.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoachRepository {
    public List<CoachEntity> login(CoachEntity bUser);
//    CoachEntity login(CoachEntity buser);
    public int register(CoachEntity bUser);
    public List<BUserEntity> isUse(CoachEntity bUser);
//注册和是否注册过
//    public List<BUserEntity> isUse(BUserEntity bUser);
//    public int register(BUserEntity bUser);
}
