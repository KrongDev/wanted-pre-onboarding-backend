package org.example.office.aggregate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.office.command.CreateOffice;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Office {
    //
    private String id;
    private String name;
    private String nation;
    private String region;

    public Office (CreateOffice command) {
        //
        BeanUtils.copyProperties(command, this);
    }
}
