package com.primeton.springproject.service;


import com.primeton.springproject.entity.Organization;
import com.primeton.springproject.repository.OrganizationRepository;
import com.primeton.springproject.util.JpaUtil;
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

    public Organization findById(int id){
        Organization organization = organizationRepository.getById(id);
        return organization;
    }

    public Organization create(Organization organization){
        organizationRepository.save(organization);
        return organization;
    }

    public Organization update(Organization organization){
        if (organization != null && organization.getId() != null){
            Organization neworganization = organizationRepository.getById(organization.getId());
            JpaUtil.copyNotNullProperties(organization, neworganization);
            return organizationRepository.save(neworganization);
        }
        return null;
    }

    public String deleteById(int id){
        organizationRepository.deleteById(id);
        return "Success";
    }

}
