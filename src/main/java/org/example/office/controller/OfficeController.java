package org.example.office.controller;

import lombok.RequiredArgsConstructor;
import org.example.office.command.CreateOffice;
import org.example.office.service.OfficeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/office")
@RequiredArgsConstructor
public class OfficeController {
    //
    private final OfficeService officeService;

    @PostMapping()
    public String create(@RequestBody CreateOffice command) {
        //
        return this.officeService.create(command);
    }
}
