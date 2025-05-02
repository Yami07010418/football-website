package com.ch.personmis.service;

import com.ch.personmis.entity.Quit;

import java.util.Map;

public interface QuitService {
    String addQuit(Quit quit);
    Map<String, Object> getQuit(Quit quit);
    Map<String, Object> selectQuitsByCon(Quit quit);
}
