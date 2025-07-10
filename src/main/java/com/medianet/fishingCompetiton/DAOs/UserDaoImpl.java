package com.medianet.fishingCompetiton.DAOs;

import com.medianet.fishingCompetiton.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User findById(int id){
        return entityManager.find(User.class,id);
    }
    @Override
    public List<User> findAll(){
        return entityManager.createQuery("FROM User",User.class).getResultList();
    };
    @Override
    @Transactional
    public void save(User user){
        entityManager.persist(user);
    };
    @Override
    public void delete(int id){
        User user=findById(id);
        if(user!=null){
            entityManager.remove(user);
        }
    };
    @Override
    public User update(User user){
        entityManager.merge(user);
        return user;
    };

    @Override
    public Optional<User> findByPhoneNumber(String phoneNumber) {
        try {
            String jpql = "SELECT u FROM User u WHERE u.phoneNumber = :phone";
            User user = entityManager.createQuery(jpql, User.class)
                    .setParameter("phone", phoneNumber)
                    .getSingleResult();
            return Optional.of(user);
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

}
