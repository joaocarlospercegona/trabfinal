package DAO;

import java.util.List;

public interface BaseDAO<T> {

    void create(T vo);

    void edit(T vo);

    void destroy(T obj);

    void destroy(String id);

    List<T> findEntities();

    List<T> findEntities(int maxResults, int firstResult);

    List<T> findEntities(boolean all, int maxResults, int firstResult);

    T find(Integer id);

    int getCount();

    void setConnection(java.sql.Connection con);

}

