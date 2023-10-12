package org.example.jobPost.service;

import lombok.RequiredArgsConstructor;
import org.example.jobPost.aggregate.OfficePostMap;
import org.example.jobPost.store.OfficePostMapStore;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class OfficePostMapService {
    //
    private final OfficePostMapStore officePostMapStore;

    public void addJobPost(String officeId, String jobPostId) {
        //
        try {
            OfficePostMap officePostMap = this.officePostMapStore.loadOfficePostMap(officeId);
            officePostMap.add(jobPostId);
            this.officePostMapStore.update(officePostMap);
        }catch (NoSuchElementException e) {
            OfficePostMap officePostMap = new OfficePostMap(officeId);
            officePostMap.add(jobPostId);
            this.officePostMapStore.create(officePostMap);
        }
    }

    public void removeJobPost(String officeId, String jobPostId) {
        //
        OfficePostMap officePostMap = this.officePostMapStore.loadOfficePostMap(officeId);
        officePostMap.remove(jobPostId);
        this.officePostMapStore.update(officePostMap);
    }

    public OfficePostMap loadOfficePostMap(String officeId) {
        //
        return this.officePostMapStore.loadOfficePostMap(officeId);
    }
}
