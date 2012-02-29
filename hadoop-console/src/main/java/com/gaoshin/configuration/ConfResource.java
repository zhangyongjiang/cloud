package com.gaoshin.configuration;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gaoshin.cloud.web.bean.GenericResponse;
import common.util.web.JerseyBaseResource;

@Path("/conf")
@Component
@Produces({ "text/html;charset=utf-8", "text/xml;charset=utf-8", "application/json" })
public class ConfResource extends JerseyBaseResource {
    @Autowired private ConfService confService;

    @POST
    @Path("/set")
    public Configuration set(Configuration conf) {
        return confService.set(conf);
    }
    
    @POST
    @Path("/remove/{id}")
    public GenericResponse remove(@PathParam("id") Long confid) {
        confService.remove(confid);
        return new GenericResponse();
    }
    
    @GET
    @Path("/get/{id}")
    public Configuration get(@PathParam("id") Long confid) {
        return confService.get(confid);
    }
    
    @GET
    @Path("list")
    public List<Configuration> list() {
        return confService.list();
    }
}
