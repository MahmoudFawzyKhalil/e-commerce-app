package gov.iti.jets.repository;

import jakarta.persistence.EntityManager;

import java.util.List;

public abstract class AbstractRepository<T> {
    protected Class<T> clazz;

    protected void setClazz(Class<T> clazz) {
        this.clazz = clazz;
    }

    private final EntityManager entityManager;

    protected AbstractRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public T findOne(long id) {
        return entityManager.find(clazz, id);
    }

    public List<T> findAll() {
        return entityManager.createQuery("from " + clazz.getName(), clazz)
                .getResultList();
    }

    public void create(T entity) {
        entityManager.persist(entity);
    }

    public T update(T entity) {
        return entityManager.merge(entity);
    }

    public void delete(T entity) {
        entityManager.remove(entity);
    }

    public void deleteById(long entityId) {
        T entity = findOne(entityId);
        delete(entity);
    }
}
