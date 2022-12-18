package org.j2os.controller;

import org.j2os.common.exception.ValidationException;
import org.j2os.entity.Person;
import org.j2os.service.PersonServiceImpl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import static org.j2os.common.exception.ErrorHandler.getError;
import static org.j2os.common.json.JSONProvider.toJSon;

@Path("/person")
public class PersonController {
    @Path("/bulkSave")
    @GET
    @Produces("text/plain")
    public String bulkSave() throws Exception {
        try {
            new Thread()
            {
                @Override
                public void run() {
                    for (int counter = 0; counter < 1000; counter++) {
                        try {
                            PersonServiceImpl.getInstance().save(new Person("A" + counter, "B" + counter));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("TASK COMPLETED");
                }
            }.start();

            return "OK";
        } catch (Exception e) {
            return toJSon(getError(e));
        }
    }

    @Path("/save")
    @GET
    @Produces("application/json")
    public String save(@QueryParam("name") String name, @QueryParam("family") String family) throws Exception {
        try {
            if (name != null && !name.isEmpty())
                return PersonServiceImpl.getInstance().save(new Person().setName(name).setFamily(family));
            throw new ValidationException();
        } catch (Exception e) {
            return toJSon(getError(e));
        }
    }

    @Path("/update")
    @GET
    @Produces("application/json")
    public String update(@QueryParam("id") String id, @QueryParam("name") String name, @QueryParam("family") String family) throws Exception {
        try {
            return PersonServiceImpl.getInstance().update(new Person().setId(Long.parseLong(id)).setName(name).setFamily(family));
        } catch (Exception e) {
            return toJSon(getError(e));
        }
    }

    @Path("/remove")
    @GET
    @Produces("application/json")
    public String remove(@QueryParam("id") String id) throws Exception {
        try {
            return PersonServiceImpl.getInstance().remove(new Person().setId(Long.parseLong(id)));
        } catch (Exception e) {
            return toJSon(getError(e));
        }
    }

    @Path("/findAll")
    @GET
    @Produces("application/json")
    public String findAll() throws Exception {
        try {
            return PersonServiceImpl.getInstance().findAll();
        } catch (Exception e) {
            return toJSon(getError(e));
        }
    }
}
