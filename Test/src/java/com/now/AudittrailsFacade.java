/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.now;

import com.now.entity.Audittrails;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author VANSO
 */
@Stateless
public class AudittrailsFacade extends AbstractFacade<Audittrails> {
    @PersistenceContext(unitName = "TestPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AudittrailsFacade() {
        super(Audittrails.class);
    }
    
}
