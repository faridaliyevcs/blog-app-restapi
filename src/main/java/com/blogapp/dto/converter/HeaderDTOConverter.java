package com.blogapp.dto.converter;

import com.blogapp.dto.HeaderDTO;
import com.blogapp.entity.Header;
import com.blogapp.repository.HeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class HeaderDTOConverter {

    @Autowired
    private HeaderRepository headerRepository;

    @Autowired
    private EntryDTOConverter entryDTOConverter;

    public Header getHeaderFromHeaderDTO(HeaderDTO from) {
        return new Header(from.getId(), from.getName(), entryDTOConverter.getListOfEntryFromListOfEntryDTO(from.getEntries()));
    }
    public HeaderDTO getHeaderDTOFromHeader(Header from) {
        return new HeaderDTO(from.getId(), from.getName(), entryDTOConverter.getListOfEntryDTOFromListOfEntry(from.getEntries()));
    }

    public List<HeaderDTO> getListOfHeaderDTOFromListOfHeader(List<Header> from) {
        return from.stream().map(header->getHeaderDTOFromHeader(header)).collect(Collectors.toList());
    }

}
