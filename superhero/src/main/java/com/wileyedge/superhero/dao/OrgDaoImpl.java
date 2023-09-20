package com.wileyedge.superhero.dao;

import com.wileyedge.superhero.model.HeroOrg;
import com.wileyedge.superhero.model.Organisation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrgDaoImpl implements OrgDao {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Organisation> rowMapper;

    @Autowired
    public OrgDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapper = (rs, rowNum) -> {
            Organisation organisation = new Organisation();
            organisation.setOrgId(rs.getInt("org_id"));
            organisation.setOrgName(rs.getString("org_name"));
            organisation.setOrgDesc(rs.getString("org_desc"));
            organisation.setOrgContact(rs.getString("org_contact"));
            // You can map other fields here if needed
            return organisation;
        };
    }

    @Override
    public Organisation createOrganisation(Organisation organisation) {
        String query = "INSERT INTO organisation (org_name, org_desc, org_contact) VALUES (?, ?, ?)";
        jdbcTemplate.update(
                query,
                organisation.getOrgName(),
                organisation.getOrgDesc(),
                organisation.getOrgContact()
        );
        return organisation;
    }

    @Override
    public Organisation getOrganisationById(int id) {
        String query = "SELECT * FROM organisation WHERE org_id=?";
        return jdbcTemplate.queryForObject(query, rowMapper, id);
    }

    @Override
    public List<Organisation> getAllOrganisations() {
        String query = "SELECT * FROM organisation";
        return jdbcTemplate.query(query, rowMapper);
    }


    @Override
    public Organisation updateOrganisation(Organisation organisation) {
        String query = "UPDATE organisation SET org_name=?, org_desc=?, org_contact=? WHERE org_id=?";
        jdbcTemplate.update(
                query,
                organisation.getOrgName(),
                organisation.getOrgDesc(),
                organisation.getOrgContact(),
                organisation.getOrgId()
        );
        return organisation;
    }

    @Override
    public void deleteOrganisation(int id) {
        String query = "DELETE FROM organisation WHERE org_id=?";
        jdbcTemplate.update(query, id);
    }

    @Override
    public List<HeroOrg> getMembersOfOrganisation(int orgId) {
        String query = "SELECT hero.hero_id, hero.hero_name, org.org_id, org.org_name " +
                "FROM hero " +
                "JOIN hero_organisation ho ON hero.hero_id = ho.hero_id " +
                "JOIN organisation org ON ho.org_id = org.org_id " +
                "WHERE org.org_id = ?";

        return jdbcTemplate.query(query, new Object[]{orgId}, (resultSet, i) -> {
            HeroOrg heroOrg = new HeroOrg();
            heroOrg.setHeroId(resultSet.getInt("hero_id"));
            heroOrg.setHeroName(resultSet.getString("hero_name"));
            heroOrg.setOrgId(resultSet.getInt("org_id"));
            heroOrg.setOrgName(resultSet.getString("org_name"));
            return heroOrg;
        });
    }



}
