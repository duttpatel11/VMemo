/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vmemo;

import vmemo.model.Memo;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * @author Dutt2
 */
public class MemoRepository {
    private final EntityManager manager;

    public MemoRepository(EntityManager manager) {
        this.manager = manager;
    }

    public List<Memo> findAll() {
        return manager.createNamedQuery("Memo.findAll", Memo.class).getResultList();
    }

    public void save(Memo memo) {
        System.out.println(memo);
        this.manager.getTransaction().begin();
        this.manager.persist(memo);
        this.manager.getTransaction().commit();
    }

}
    