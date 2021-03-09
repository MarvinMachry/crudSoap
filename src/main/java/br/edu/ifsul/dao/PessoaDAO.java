/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Pessoa;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jorge
 */
@Stateless
public class PessoaDAO implements Serializable {

    @PersistenceContext(unitName = "SW-CRUDSOAP-PU")
    private EntityManager em;

    private List<Pessoa> lista;

    public PessoaDAO() {

    }

    public Pessoa persist(Pessoa objeto) throws Exception {
        objeto.setId(null);
        em.persist(objeto);
        return objeto;
    }

    public Pessoa merge(Pessoa objeto) throws Exception {
        em.merge(objeto);
        return objeto;
    }

    public void remove(Object id) throws Exception {
        Pessoa obj = em.find(Pessoa.class, id);
        em.remove(obj);
    }

    public Pessoa findById(Integer id) throws Exception {
        return (Pessoa) em.find(Pessoa.class, id);
    }

    public List<Pessoa> getLista() {
        return em.createQuery("from Pessoa order by nome").getResultList();
    }

    public void setLista(List<Pessoa> lista) {
        this.lista = lista;
    }

}
