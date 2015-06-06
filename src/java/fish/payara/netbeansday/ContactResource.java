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
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;

/**
 * REST Web Service
 *
 * @author steve
 */
@Path("contact")
public class ContactResource {

    @Context
    private UriInfo context;
    
    @EJB
    ContactsSessionBean bean;

    /**
     * Creates a new instance of ContactResource
     */
    public ContactResource() {
    }

    /**
     * Retrieves representation of an instance of fish.payara.netbeansday.ContactResource
     * @return an instance of fish.payara.netbeansday.ContactEntity
     */
    @GET
    @Produces("application/json")
    public List<ContactEntity> getAll() {
        //TODO return proper representation object
        return bean.getAll();
    }
    
    @GET
    @Path("/{contactid}")
    @Produces("application/json")
    public ContactEntity getContact(@PathParam("contactid") long ID) {
        //TODO return proper representation object
        return bean.get(ID);
    }

    /**
     * PUT method for updating or creating an instance of ContactResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(ContactEntity content) {
        bean.save(content);
    }
}
