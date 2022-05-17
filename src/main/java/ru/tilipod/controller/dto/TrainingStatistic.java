package ru.tilipod.controller.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;

/**
 * Статистика обучения нейросети
 */
@ApiModel(description = "Статистика обучения нейросети")
public class TrainingStatistic   {
  @JsonProperty("precisions")
  @Valid
  private List<Double> precisions = null;

  public TrainingStatistic precisions(List<Double> precisions) {
    this.precisions = precisions;
    return this;
  }

  public TrainingStatistic addPrecisionsItem(Double precisionsItem) {
    if (this.precisions == null) {
      this.precisions = new ArrayList<>();
    }
    this.precisions.add(precisionsItem);
    return this;
  }

  /**
   * Get precisions
   * @return precisions
  */
  @ApiModelProperty(value = "")


  public List<Double> getPrecisions() {
    return precisions;
  }

  public void setPrecisions(List<Double> precisions) {
    this.precisions = precisions;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TrainingStatistic trainingStatistic = (TrainingStatistic) o;
    return Objects.equals(this.precisions, trainingStatistic.precisions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(precisions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TrainingStatistic {\n");
    
    sb.append("    precisions: ").append(toIndentedString(precisions)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

