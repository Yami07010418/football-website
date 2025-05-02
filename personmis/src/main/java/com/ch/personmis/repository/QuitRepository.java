package com.ch.personmis.repository;

import com.ch.personmis.entity.Quit;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuitRepository {
    int addQuit(Quit quit);
    int deletestaff(Quit quit);
    List<Quit> selectQuitStaff(Quit quit);
    List<Quit> selectQuitsByCon(Quit quit);
}
