package com.hubspot.mesos;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.annotations.Beta;
import com.google.common.base.Optional;

import io.swagger.v3.oas.annotations.media.Schema;

@Beta
@Schema(description = "Represents a volume to be mounted into a docker container")
public class SingularityVolume {
  private final String containerPath;
  private final Optional<String> hostPath;
  private final Optional<SingularityDockerVolumeMode> mode;
  private final Optional<SingularityVolumeSource> source;

  public SingularityVolume(
      String containerPath,
      Optional<String> hostPath,
      SingularityDockerVolumeMode mode) {
    this(containerPath, hostPath, mode, Optional.absent());
  }

  @JsonCreator
  public SingularityVolume(
      @JsonProperty("containerPath") String containerPath,
      @JsonProperty("hostPath") Optional<String> hostPath,
      @JsonProperty("mode") SingularityDockerVolumeMode mode,
      @JsonProperty("source") Optional<SingularityVolumeSource> source) {
    this.containerPath = containerPath;
    this.hostPath = hostPath;
    this.mode = Optional.fromNullable(mode);
    this.source = source;
  }

  @Schema(description = "The path within the container")
  public String getContainerPath() {
    return containerPath;
  }

  @Schema(description = "The path on on the host")
  public Optional<String> getHostPath() {
    return hostPath;
  }

  @Schema(description = "Read write or read only mode")
  public Optional<SingularityDockerVolumeMode> getMode() {
    return mode;
  }

  @Schema(description = "Volume source")
  public Optional<SingularityVolumeSource> getSource()
  {
    return source;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SingularityVolume that = (SingularityVolume) o;
    return Objects.equals(containerPath, that.containerPath) &&
        Objects.equals(hostPath, that.hostPath) &&
        Objects.equals(mode, that.mode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(containerPath, hostPath, mode);
  }

  @Override
  public String toString() {
    return "SingularityVolume{" +
        "containerPath='" + containerPath + '\'' +
        ", hostPath=" + hostPath +
        ", mode=" + mode +
        '}';
  }
}
