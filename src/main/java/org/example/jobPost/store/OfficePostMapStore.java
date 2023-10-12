package org.example.jobPost.store;

import lombok.RequiredArgsConstructor;
import org.example.jobPost.aggregate.OfficePostMap;
import org.example.jobPost.store.orm.OfficePostMapJpo;
import org.example.jobPost.store.orm.OfficePostRepository;
import org.springframework.stereotype.Repository;

import java.util.NoSuchElementException;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class OfficePostMapStore {
    //
    private final OfficePostRepository officePostRepository;

    public void create(OfficePostMap officePostMap) {
        //
        this.officePostRepository.save(new OfficePostMapJpo(officePostMap));
    }

    public OfficePostMap loadOfficePostMap(String officeId) {
        Optional<OfficePostMapJpo> jpo = this.officePostRepository.findById(officeId);
        if(jpo.isEmpty()) throw new NoSuchElementException();
        return jpo.get().toDomain();
    }

    public void update(OfficePostMap officePostMap) {
        //
        this.officePostRepository.save(new OfficePostMapJpo(officePostMap));
    }
}
