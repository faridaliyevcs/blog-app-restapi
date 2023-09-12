package com.blogapp.service.impl;

import com.blogapp.entity.Header;
import com.blogapp.repository.HeaderRepository;
import com.blogapp.service.inter.HeaderServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HeaderServiceImpl implements HeaderServiceInter {

    @Autowired
    private HeaderRepository headerRepository;

    @Override
    public List<Header> getTopTenHeaders() {
        List<Header> result = new ArrayList<>();
        for(Header header : headerRepository.findAll()) {
            int check = 0;
            for(int i = 0; i<headerRepository.findAll().size(); i++) {
                if(header.getEntries().size()>headerRepository.findAll().get(i).getEntries().size()) {
                    check ++;
                }
            }
            if(check >= headerRepository.findAll().size() - 10) {
                result.add(header);
            }
        }
        return result;
    }

    @Override
    public List<Header> getAllHeader() {
        return headerRepository.findAll();
    }

    @Override
    public Header getHeaderById(int id) {
        return headerRepository.getById(id);
    }

    @Override
    public void deleteHeaderById(int id) {
        headerRepository.deleteById(id);
    }

    @Override
    public void updateHeader(Header header) {
        headerRepository.save(header);
    }

}
