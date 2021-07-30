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
        return organizationRepository.findAll();
    }

    public Object findById(int id){
        if (organizationRepository.existsById(id)) {
            return organizationRepository.getById(id);
        }
        return "id does not exist";
    }

    public Object create(Organization organization){
        if (organizationRepository.existsById(organization.getId())){
            return "id already exists";
        }
        organizationRepository.save(organization);
        return organization;
    }

    public Object update(Organization organization){
        if (organizationRepository.existsById(organization.getId())){
            Organization neworganization = organizationRepository.getById(organization.getId());
            JpaUtil.copyNotNullProperties(organization, neworganization);
            return organizationRepository.save(neworganization);
        }
        return "id does not exist";
    }

    public String deleteById(int id){
        if(organizationRepository.existsById(id)){
            organizationRepository.deleteById(id);
            return "success";
        }
        return "id does not exist";
    }

}
