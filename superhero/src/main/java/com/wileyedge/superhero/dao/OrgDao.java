package com.wileyedge.superhero.dao;

import java.util.List;

import com.wileyedge.superhero.model.HeroOrg;
import com.wileyedge.superhero.model.Organisation;
public interface OrgDao {
    Organisation createOrganisation(Organisation organisation);
    Organisation getOrganisationById(int id);
    List<Organisation> getAllOrganisations();
    Organisation updateOrganisation(Organisation organisation);
    void deleteOrganisation(int id);
    List<HeroOrg> getMembersOfOrganisation(int orgId);


}
