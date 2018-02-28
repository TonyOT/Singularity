package com.hubspot.mesos.client;

import java.util.List;

import com.hubspot.mesos.master.MesosMasterMetricsSnapshotObject;
import com.hubspot.mesos.master.MesosMasterStateObject;
import com.hubspot.mesos.slave.MesosSlaveMetricsSnapshotObject;
import com.hubspot.mesos.slave.MesosSlaveStateObject;
import com.hubspot.mesos.slave.MesosTaskMonitorObject;

public interface MesosClient {

  public String getMasterUri(String hostnameAndPort);

  default String getMetricsSnapshotUri(String hostnameAndPort) {
    return getMasterMetricsSnapshotUri(hostnameAndPort);
  }

  public String getMasterMetricsSnapshotUri(String hostnameAndPort);

  public static class MesosClientException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public MesosClientException(String message) {
      super(message);
    }

    public MesosClientException(String message, Throwable cause) {
      super(message, cause);
    }

  }

  public MesosMasterStateObject getMasterState(String uri);

  public MesosMasterMetricsSnapshotObject getMasterMetricsSnapshot(String uri);

  public MesosSlaveMetricsSnapshotObject getSlaveMetricsSnapshot(String uri);

  public String getSlaveUri(String hostname);

  public MesosSlaveStateObject getSlaveState(String uri);

  public List<MesosTaskMonitorObject> getSlaveResourceUsage(String hostname);

}
