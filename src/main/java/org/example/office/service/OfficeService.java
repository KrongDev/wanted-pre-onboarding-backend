package org.example.office.service;

import lombok.RequiredArgsConstructor;
import org.example.office.aggregate.Office;
import org.example.office.command.CreateOffice;
import org.example.office.store.OfficeStore;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OfficeService {
    //
    private final OfficeStore officeStore;

    public String create(CreateOffice command) {
        //
        String newId = UUID.randomUUID().toString();
        command.setId(newId);

        Office office = new Office(command);

        this.officeStore.create(office);
        return office.getId();
    }

    public Office loadOffice(String officeId) {
        //
        return this.officeStore.loadOffice(officeId);
    }
}
