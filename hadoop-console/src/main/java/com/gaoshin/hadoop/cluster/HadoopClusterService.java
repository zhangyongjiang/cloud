package com.gaoshin.hadoop.cluster;

import java.util.List;

public interface HadoopClusterService {

    HadoopCluster create(HadoopCluster cluster);

    List<HadoopCluster> list();

}
