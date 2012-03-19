package com.gaoshin.hadoop.cluster;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("hadoopClusterService")
@Transactional
public class HadoopClusterServiceImpl implements HadoopClusterService {
    @Autowired private HadoopClusterDao hadoopClusterDao;

    @Override
    public HadoopCluster create(HadoopCluster cluster) {
        cluster.setId(null);
        hadoopClusterDao.saveEntity(cluster);
        return cluster;
    }

    @Override
    public List<HadoopCluster> list() {
        return hadoopClusterDao.find(HadoopCluster.class, "from HadoopCluster");
    }

}
