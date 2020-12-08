/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.suipacha.jsf;

import com.suipacha.jpa.TbTipologia;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Denis Macagno
 */
@Stateless
public class TbTipologiaFacade extends AbstractFacade<TbTipologia> {

    @PersistenceContext(unitName = "suipachaVersion1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TbTipologiaFacade() {
        super(TbTipologia.class);
    }
    
}
