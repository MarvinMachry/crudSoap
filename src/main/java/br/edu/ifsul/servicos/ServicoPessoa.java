/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.servicos;

import br.edu.ifsul.dao.PessoaDAO;
import br.edu.ifsul.modelo.Pessoa;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.WebApplicationException;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author Jorge
 */
@WebService
public class ServicoPessoa implements Serializable {

    @EJB
    private PessoaDAO dao;

    public ServicoPessoa() {
    }

    @WebMethod
    public List<Pessoa> listaPessoas() {
        return dao.getLista();
    }


    @WebMethod
    public Pessoa inserir(@WebParam(name = "pessoa")
            @XmlElement(required = true) Pessoa objeto) {
        try {
            return dao.persist(objeto);
        } catch (Exception e) {
            return null;
        }
    }

    @WebMethod
    public Pessoa alterar(@WebParam(name = "pessoa")
            @XmlElement(required = true) Pessoa objeto) {

        try {
            return dao.merge(objeto);
        } catch (Exception e) {
            return null;
        }
    }

    @WebMethod
    public Boolean remover(@WebParam(name = "id")
            @XmlElement(required = true) Integer id) {
        try {
            dao.remove(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
