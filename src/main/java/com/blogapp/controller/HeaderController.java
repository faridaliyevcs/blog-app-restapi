package com.blogapp.controller;

import com.blogapp.dto.EntryDTO;
import com.blogapp.dto.HeaderDTO;
import com.blogapp.dto.converter.EntryDTOConverter;
import com.blogapp.dto.converter.HeaderDTOConverter;
import com.blogapp.entity.Header;
import com.blogapp.service.impl.EntryServiceImpl;
import com.blogapp.service.impl.HeaderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/headers")
public class HeaderController {

    @Autowired
    private EntryDTOConverter entryDTOConverter;

    @Autowired
    private HeaderDTOConverter headerDTOConverter;

    @Autowired
    private HeaderServiceImpl headerService;

    @Autowired
    private EntryServiceImpl entryService;

    @PostMapping("/header")
    public ResponseEntity<HeaderDTO> createHeader(@RequestBody HeaderDTO headerDTO){
        headerService.updateHeader(headerDTOConverter.getHeaderFromHeaderDTO(headerDTO));
        return ResponseEntity.ok(headerDTO);
    }

    @GetMapping
    public ResponseEntity<List<HeaderDTO>> getAllHeaders() {
        return ResponseEntity.ok(headerDTOConverter.getListOfHeaderDTOFromListOfHeader(headerService.getAllHeader()));

    }

    @GetMapping("/{id}")
    public ResponseEntity<HeaderDTO> getHeader(@PathVariable(name = "id") Integer id) {
            return ResponseEntity.ok(headerDTOConverter.getHeaderDTOFromHeader(headerService.getHeaderById(id)));
    }

    @PostMapping("/{id}/entry")
    public ResponseEntity<EntryDTO> createEntry(@RequestBody EntryDTO entryDTO,
                                                @PathVariable(name = "id") Integer id) {
        entryDTO.setHeader(headerDTOConverter.getHeaderDTOFromHeader(headerService.getHeaderById(id)));
        entryService.updateEntry(entryDTOConverter.getEntryFromEntryDTO(entryDTO));
        return ResponseEntity.ok(entryDTO);
    }

    @GetMapping("/most")
    public ResponseEntity<List<HeaderDTO>> getAllHeaderWithTopTenEntry() {
        List<HeaderDTO> result = new ArrayList<>();
        for(Header header: headerService.getAllHeader()) {
            int check = 0;
            for(int i = 0; i<headerService.getAllHeader().size(); i++) {
                if(header.getEntries().size()>headerService.getAllHeader().get(i).getEntries().size()) {
                    check ++;
                }
            }
            if(check >= headerService.getAllHeader().size() - 10) {
                result.add(headerDTOConverter.getHeaderDTOFromHeader(header));
            }
        }
        return ResponseEntity.ok(result);
    }



}
