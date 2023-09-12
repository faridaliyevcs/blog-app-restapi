package com.blogapp.dto.converter;

import com.blogapp.dto.EntryDTO;
import com.blogapp.entity.Entry;
import com.blogapp.repository.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class EntryDTOConverter {

    @Autowired
    private EntryRepository entryRepository;

    @Autowired
    private HeaderDTOConverter headerDTOConverter;

    @Autowired
    private UserDTOConverter userDTOConverter;

    public Entry getEntryFromEntryDTO(EntryDTO from) {

        return new Entry(from.getId(),
                from.getContent(),
                headerDTOConverter.getHeaderFromHeaderDTO(from.getHeader()),
                userDTOConverter.getUserFromDTO(from.getUser()),
                null,
                from.getDate());
    }

    public EntryDTO getEntryDTOFromEntry(Entry from) {
        return new EntryDTO(from.getId(),
                userDTOConverter.getUserDTOFromEntity(from.getUser()),
                null,
                headerDTOConverter.getHeaderDTOFromHeader(from.getHeader()),
                from.getContent(),
                from.getDate());
    }

    public List<Entry> getListOfEntryFromListOfEntryDTO(List<EntryDTO> from) {
        return from.stream().map(entry->getEntryFromEntryDTO(entry)).collect(Collectors.toList());
    }

    public List<EntryDTO> getListOfEntryDTOFromListOfEntry(List<Entry> from) {
        return from.stream().map(entry->getEntryDTOFromEntry(entry)).collect(Collectors.toList());
    }


}
