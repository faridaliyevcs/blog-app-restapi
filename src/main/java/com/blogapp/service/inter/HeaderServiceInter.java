package com.blogapp.service.inter;

import com.blogapp.entity.Header;

import java.util.List;

public interface HeaderServiceInter {

    List<Header> getTopTenHeaders();

    List<Header> getAllHeader();

    Header getHeaderById(int id);

    void deleteHeaderById(int id);

    void updateHeader(Header header);


}
