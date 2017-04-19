package de.falkharnisch.web.karip.services;

import de.falkharnisch.web.karip.database.Federation;
import de.falkharnisch.web.karip.database.User;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by A410581 on 17.04.2017.
 */
@ApplicationScoped
public class RefereeService {

    @PersistenceContext
    private EntityManager em;

    public List<User> getRefereesByFederation(@NotNull Federation federation) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        query.where(criteriaBuilder.equal(root.get("federation"), federation));
        return em.createQuery(query).getResultList();
    }
}