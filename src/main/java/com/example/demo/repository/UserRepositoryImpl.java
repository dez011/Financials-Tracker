package com.example.demo.repository;

import com.example.demo.entity.BankAccount;
import com.example.demo.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public void saveNewCode(BankAccount bankAccount) {
        em.persist(bankAccount);
    }

    @Override
    public User saveNewUser(User user) {
        em.persist(user);
        return user;
    }

    @Override
    public List<BankAccount> findAll() {
//        .parallelStream().collect(Collectors.toList())
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<BankAccount> criteriaQuery = criteriaBuilder.createQuery(BankAccount.class);
        Root<BankAccount> root = criteriaQuery.from(BankAccount.class);
        criteriaQuery.select(root);
        TypedQuery<BankAccount> typedQuery = em.createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }

    @Override
    public List<User> findAllUsers() {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
        return query.getResultList();
    }

    @Override
    public User findUserById(Long id) {
        return em.find(User.class, id);
    }
}

