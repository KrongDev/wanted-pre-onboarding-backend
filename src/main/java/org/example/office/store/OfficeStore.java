package org.example.office.store;

import lombok.RequiredArgsConstructor;
import org.example.office.aggregate.Office;
import org.example.office.store.orm.OfficeJpo;
import org.example.office.store.orm.OfficeRepository;
import org.springframework.stereotype.Repository;

import java.util.NoSuchElementException;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class OfficeStore {
    //
    private final OfficeRepository officeRepository;

    public void create(Office office) {
        //
        this.officeRepository.save(new OfficeJpo(office));
    }

    public Office loadOffice(String officeId) {
        //
        Optional<OfficeJpo> jpo = this.officeRepository.findById(officeId);
        if(jpo.isEmpty()) throw new NoSuchElementException();
        return jpo.get().toDomain();
    }
}
