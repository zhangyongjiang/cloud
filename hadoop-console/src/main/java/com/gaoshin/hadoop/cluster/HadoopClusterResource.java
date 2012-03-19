package com.gaoshin.hadoop.cluster;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import common.util.web.JerseyBaseResource;

@Path("/ws/v1/hadoop/cluster")
@Component
@Produces({ "text/html;charset=utf-8", "text/xml;charset=utf-8", "application/json;charset=utf-8" })
public class HadoopClusterResource extends JerseyBaseResource {
    @Autowired
    private HadoopClusterService hadoopClusterService;

    @Path("create")
    @POST
    public HadoopCluster create(HadoopCluster cluster) {
        return hadoopClusterService.create(cluster);
    }
    
    @Path("list")
    @GET
    public List<HadoopCluster> list() {
        return hadoopClusterService.list();
    }
}
