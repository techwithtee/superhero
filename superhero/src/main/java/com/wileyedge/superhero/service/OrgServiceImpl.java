package com.wileyedge.superhero.service;

import com.wileyedge.superhero.dao.OrgDao;
import com.wileyedge.superhero.model.Organisation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrgServiceImpl implements OrgService {

    private final OrgDao orgDao;

    @Autowired
    public OrgServiceImpl(OrgDao orgDao) {
        this.orgDao = orgDao;
    }

    @Override
    public Organisation createOrganisation(Organisation organisation) {
        return orgDao.createOrganisation(organisation);
    }

    @Override
    public Organisation getOrganisationById(int id) {
        return orgDao.getOrganisationById(id);
    }

    @Override
    public List<Organisation> getAllOrganisations() {
        return orgDao.getAllOrganisations();
    }

    @Override
    public void updateOrganisation(Organisation organisation) {
        orgDao.updateOrganisation(organisation);
    }

    @Override
    public void deleteOrganisation(int id) {
        orgDao.deleteOrganisation(id);
    }
}
