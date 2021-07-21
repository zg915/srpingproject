package com.primeton.springproject.controller;


import com.primeton.springproject.entity.Organization;
import com.primeton.springproject.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/organization")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @GetMapping(value = "/findAll")
    public List<Organization> findAll() {
        return organizationService.findAll();
    }

    @GetMapping(value = "/findById")
    public Object findById(@RequestParam int id) {
        return organizationService.findById(id);
    }

    @PostMapping(value = "/create")
    public Object create(Organization organization){
        return organizationService.create(organization);
    }

    @PutMapping(value = "/update")
    public Object update(Organization organization){
        return organizationService.update(organization);
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteById(@RequestParam int id){
        return organizationService.deleteById(id);
    }
}
