/*

 DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.

 Copyright (c) 2015 C2B2 Consulting Limited. All rights reserved.

 The contents of this file are subject to the terms of the Common Development
 and Distribution License("CDDL") (collectively, the "License").  You
 may not use this file except in compliance with the License.  You can
 obtain a copy of the License at
 https://glassfish.dev.java.net/public/CDDL+GPL_1_1.html
 or packager/legal/LICENSE.txt.  See the License for the specific
 language governing permissions and limitations under the License.

 When distributing the software, include this License Header Notice in each
 file and include the License file at packager/legal/LICENSE.txt.
 */
package fish.payara.netbeansday;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author steve
 */
@Stateless
public class ContactsSessionBean {
    
    @PersistenceContext
    EntityManager em;
    
    public void save(ContactEntity ce) {
        em.persist(ce);
    }
    
    public List<ContactEntity> getAll() {
        return em.createNamedQuery("Contact.findAll", ContactEntity.class).getResultList();
    }
    
    public ContactEntity get(long ID) {
        return em.find(ContactEntity.class, ID);
    }
    
    public void populateTestData() {
        ContactEntity ce = new ContactEntity();
        ce.setEmail("info@payara.co");
        ce.setFirstName("Payara");
        ce.setLastName("BadAssFish");
        ce.setTelephoneNumber("12345678");
        em.persist(ce);
        
        ContactEntity ce2 = new ContactEntity();
        ce2.setEmail("sales@payara.co");
        ce2.setFirstName("Fred");
        ce2.setLastName("Flash");
        ce2.setTelephoneNumber("12345678");
        em.persist(ce2);       
    }

}
