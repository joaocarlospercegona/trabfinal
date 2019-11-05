/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;

/**
 * Métodos Padrões dos DAOs
 *
 * @author Dieval Guizelini
 *
 */
public interface BaseDAO<T> {
    /**
     * insere um objeto T no banco de dados e obtém o id
     * desse registro.
     *
     * @param vo
     */
    void create(T vo);

    /**
     * Permite atualizar um objeto T
     *
     * @param vo a ser atualizado
     *
     * @throws Exception - id não informado ou inexistente
     */
    void edit(T vo);

    /**
     * Permite excluir um objeto T do banco de dados.
     *
     * @param obj - contendo o id a ser excluido.
     * @throws Exception - id não informado ou inexistente
     */
    void destroy(T obj);

    /**
     * Permite excluir um objeto T do banco de dados.
     *
     * @param id - do T a ser excluido.
     * @throws Exception - id não informado ou inexistente
     */
    void destroy(String id);

    /**
     * Obtém uma coleção de T.
     *
     * @return lista dos T
     */
    List<T> findEntities();

    /**
     * Obtém uma coleção de tamanho definido. Altamente dependente do BD.
     * <p>Mysql utiliza limit, Oracle top etc</p>
     *
     * @param maxResults - se !all, então retorna no máximo maxResults elementos.
     * @param firstResult - se !all, então retorna no máximo maxResults elementos,
     *     começando em firstResult.
     * @return lista dos T
     */
    List<T> findEntities(int maxResults, int firstResult);

    /**
     * Obtém uma coleção de tamanho definido. Altamente dependente do BD.
     * <p>Mysql utiliza limit, Oracle top etc</p>
     *
     * @param all - ignora os outros dois parametros e retorna a lista toda
     * @param maxResults - se !all, então retorna no máximo maxResults elementos.
     * @param firstResult - se !all, então retorna no máximo maxResults elementos,
     *     começando em firstResult.
     * @return lista dos T
     */
    List<T> findEntities(boolean all, int maxResults, int firstResult);

    /**
     * Permite resgatar do banco de dados um objeto específico.
     *
     * @param id do objeto desejado.
     *
     * @return GenbankVO do registro id informado ou NULL.
     */
    T find(Integer id);

    /**
     * Quantidade de objetos (registrods) contidos na tabela correspondente a T
     *
     * @return (int) número de objetos
     */
    int getCount();

    /**
     * Define uma conexão particular
     *
     * @param con - instância de java.sql.Connection
     */
    void setConnection(java.sql.Connection con);

}

