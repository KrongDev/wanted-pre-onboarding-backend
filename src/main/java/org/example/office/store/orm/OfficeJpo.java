package org.example.office.store.orm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.office.aggregate.Office;
import org.springframework.beans.BeanUtils;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_office")
public class OfficeJpo {
    @Id
    private String id;
    private String name;
    private String nation;
    private String region;

    public OfficeJpo(Office office) {
        //
        BeanUtils.copyProperties(office, this);
    }

    public Office toDomain() {
        //
        Office office = new Office();
        BeanUtils.copyProperties(this, office);
        return office;
    }
}
