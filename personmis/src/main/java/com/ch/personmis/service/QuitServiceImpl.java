package com.ch.personmis.service;

import com.ch.personmis.entity.Quit;
import com.ch.personmis.repository.QuitRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QuitServiceImpl implements  QuitService {
    @Resource
    private QuitRepository quitRepository;
    @Override
    public String addQuit(Quit quit) {
        if( quitRepository.addQuit(quit) > 0 )
//                && quitRepository.deletestaff(quit)>0)
            return "ok";
        return "no";
    }

    @Override
    public Map<String, Object> getQuit(Quit quit) {
        Map<String, Object> map = new HashMap<String, Object>();
        quit.setAct("byPage");
        List<Quit> quits = quitRepository.selectQuitStaff(quit);
        map.put("quits", quits);
        quit.setAct("byNoPage");
        map.put("total", quitRepository.selectQuitStaff(quit).size());
        return map;
    }

    @Override
    public Map<String, Object> selectQuitsByCon(Quit quit) {
        Map<String, Object> map = new HashMap<String, Object>();
        quit.setAct("byPage");
        List<Quit> quits = quitRepository.selectQuitsByCon(quit);
        map.put("quits", quits);
        quit.setAct("byNoPage");
        map.put("total", quitRepository.selectQuitsByCon(quit).size());
        return map;
    }
}
