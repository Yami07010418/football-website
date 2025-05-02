package com.ch.personmis.service;

import com.ch.personmis.entity.Post;
import com.ch.personmis.entity.Transfer;
import com.ch.personmis.repository.TransferRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TransferServiceImpl implements  TransferService{
    @Resource
    private TransferRepository transferRepository;
    @Override
    public Transfer getBeforePost(int id) {
        return transferRepository.getBeforePost(id);
    }

    @Override
    public String addTransfer(Transfer transfer) {
        if (transferRepository.addTransferStaff(transfer) > 0
                &&transferRepository.updateStaff(transfer) > 0)
            return "ok";
        return "no";
    }

    @Override
    public Map<String, Object> getTransfer(Transfer transfer) {//熏染界面
        Map<String, Object> map = new HashMap<String, Object>();
        transfer.setAct("byPage");
        List<Transfer> transfers = transferRepository.selectTransfer(transfer);
        map.put("transfers", transfers);
        transfer.setAct("byNoPage");
        map.put("total", transferRepository.selectTransfer(transfer).size());
        return map;
    }

    @Override
    public Map<String, Object> selectTransfersByCon(Transfer transfer) {
        Map<String, Object> map = new HashMap<String, Object>();
        transfer.setAct("byPage");
        List<Transfer> transfers = transferRepository.selectTransfersByCon(transfer);
        map.put("transfers", transfers);
        transfer.setAct("byNoPage");
        map.put("total", transferRepository.selectTransfersByCon(transfer).size());
        return map;
    }
}
