package com.ads.projetoengenhariasoftware.dados;

import com.ads.projetoengenhariasoftware.model.Pessoa;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

public class PessoaDAO {

    private final EntityManager em;


    public PessoaDAO(EntityManager em) {
        this.em = em;
    }


    public void addPessoa(Pessoa pessoa) {
        em.getTransaction().begin();
        em.persist(pessoa);
        em.getTransaction().commit();
    }

    public List<Pessoa> pessoas(){
        Query query = em.createQuery("SELECT p FROM Pessoa p");
        List<Pessoa> pessoas = null;
        try {
            pessoas = query.getResultList();
            System.out.println("deu certo aqui");
        }catch (NoResultException e){
            System.out.println(e.getMessage());
        }
        return pessoas;
    }


}

