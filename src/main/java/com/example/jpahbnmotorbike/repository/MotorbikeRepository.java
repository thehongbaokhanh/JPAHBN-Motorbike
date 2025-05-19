package com.example.jpahbnmotorbike.repository;

import com.example.jpahbnmotorbike.model.Motorbike;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class MotorbikeRepository implements IMotorbikeRepository {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Motorbike> findAll() {
        TypedQuery<Motorbike> query = entityManager.createQuery("select m from Motorbike m", Motorbike.class);
        return query.getResultList();
    }

    @Override
    public Motorbike findById(long id) {
        TypedQuery<Motorbike> query = entityManager.createQuery("select m from Motorbike m where m.id = :id", Motorbike.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public List<Motorbike> findByName(String name) {
        TypedQuery<Motorbike> query = entityManager.createQuery("select m from Motorbike m where lower(m.name) like lower(concat('%', :name, '%')) ", Motorbike.class);
        query.setParameter("name", name);
        return query.getResultList();
    }

    @Override
    public List<Motorbike> findByBestSelling() {
        TypedQuery<Motorbike> query = entityManager.createQuery("select m from Motorbike m order by m.soldNumber desc", Motorbike.class);
        return query.getResultList();
    }

    @Override
    public void save(Motorbike motorbike) {
        if (motorbike.getId() != 0) {
            entityManager.merge(motorbike);
        }else {
            entityManager.persist(motorbike);
        }
    }

    @Override
    public void delete(long id) {
        Motorbike motorbike = findById(id);
        entityManager.remove(motorbike);
    }
}
