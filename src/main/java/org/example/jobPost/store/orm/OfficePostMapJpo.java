package org.example.jobPost.store.orm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.jobPost.aggregate.OfficePostMap;
import org.example.util.JsonUtil;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_office_post_map")
public class OfficePostMapJpo {
    //
    @Id
    private String officeId;
    @Column(columnDefinition = "LONGTEXT")
    private String jopPostIdsJson;

    public OfficePostMapJpo(OfficePostMap officePostMap) {
        //
        this.officeId = officePostMap.getOfficeId();
        this.jopPostIdsJson = JsonUtil.toJson(officePostMap.getJobPostIds());
    }

    public OfficePostMap toDomain() {
        //
        return new OfficePostMap(
                this.officeId,
                JsonUtil.fromJsonList(this.jopPostIdsJson, String.class)
        );
    }
}
