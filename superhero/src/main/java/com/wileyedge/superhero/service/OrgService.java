package com.wileyedge.superhero.service;

import com.wileyedge.superhero.model.HeroOrg;
import com.wileyedge.superhero.model.Organisation;
import java.util.List;

public interface OrgService {
    Organisation createOrganisation(Organisation organisation);
    Organisation getOrganisationById(int id);
    List<Organisation> getAllOrganisations();
    void updateOrganisation(Organisation organisation);
    void deleteOrganisation(int id);

    List<HeroOrg> getMembersOfOrganisation(int orgId);

}
