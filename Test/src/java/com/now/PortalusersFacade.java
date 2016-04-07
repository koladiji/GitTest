/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.now;

import com.now.entity.Portalusers;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author VANSO
 */
@Stateless
public class PortalusersFacade extends AbstractFacade<Portalusers> {
    @PersistenceContext(unitName = "TestPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PortalusersFacade() {
        super(Portalusers.class);
    }
    
}
