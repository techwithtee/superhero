package com.wileyedge.superhero.controller;

import com.wileyedge.superhero.model.Organisation;
import com.wileyedge.superhero.service.OrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/organisations")
public class OrgController {

    private final OrgService orgService;

    @Autowired
    public OrgController(OrgService orgService) {
        this.orgService = orgService;
    }

    @PostMapping
    public Organisation createOrganisation(@RequestBody Organisation organisation) {
        return orgService.createOrganisation(organisation);
    }

    @GetMapping("/{id}")
    public Organisation getOrganisationById(@PathVariable int id) {
        return orgService.getOrganisationById(id);
    }

    @GetMapping
    public List<Organisation> getAllOrganisations() {
        return orgService.getAllOrganisations();
    }

    @PutMapping("/{id}")
    public void updateOrganisation(@PathVariable int id, @RequestBody Organisation organisation) {
        orgService.updateOrganisation(organisation);
    }

    @DeleteMapping("/{id}")
    public void deleteOrganisation(@PathVariable int id) {
        orgService.deleteOrganisation(id);
    }
}
