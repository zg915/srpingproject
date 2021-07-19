package com.primeton.springproject.service;


import com.primeton.springproject.entity.Organization;
import com.primeton.springproject.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;

    public List<Organization> findAll() {
        List<Organization> organizationList = organizationRepository.findAll();
        return organizationList;
    }
}
