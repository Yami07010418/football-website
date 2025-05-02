package com.ch.personmis.service;

import com.ch.personmis.entity.Transfer;

import java.util.Map;

public interface TransferService {
    public Transfer getBeforePost(int id);
    public  String addTransfer(Transfer transfer);
    public Map<String, Object> getTransfer(Transfer transfer);
    public  Map<String, Object> selectTransfersByCon(Transfer transfer);
}
