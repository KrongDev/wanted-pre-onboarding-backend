package org.example.office.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateOffice {
    //
    transient private String id;
    private String name;
    private String nation;
    private String region;
}
