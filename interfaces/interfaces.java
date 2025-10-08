package interfaces;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface Repositoryy<T, ID> {
    T save(T endidy);
    List<T> saveAll(Collection<T> entities);
    Optional<T> findById(ID id);
    void deleteById(ID id);
    void deleteAll(T entity);
    long count();
    boolean existsById(ID id);

}