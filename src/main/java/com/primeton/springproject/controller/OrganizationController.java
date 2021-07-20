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

}
