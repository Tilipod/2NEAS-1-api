package ru.tilipod.controller.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Обученная нейронная сеть
 */
@ApiModel(description = "Обученная нейронная сеть")
public class TrainingResponse   {
  @JsonProperty("comment")
  private String comment;

  /**
   * Текущий статус задачи на обучение
   */
  public enum StatusEnum {
    CREATED("CREATED"),
    
    ANALYSIS("ANALYSIS"),
    
    ANALYZED("ANALYZED"),
    
    DISTRIBUTING("DISTRIBUTING"),
    
    DISTRIBUTED("DISTRIBUTED"),
    
    TRAINING("TRAINING"),
    
    TRAINED("TRAINED"),
    
    CONFIRMED("CONFIRMED"),
    
    STOPPED("STOPPED"),
    
    ANALYSIS_ERROR("ANALYSIS_ERROR"),
    
    TRAINING_ERROR("TRAINING_ERROR"),
    
    DISTRIBUTE_ERROR("DISTRIBUTE_ERROR"),
    
    SYSTEM_ERROR("SYSTEM_ERROR");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String value) {
      for (StatusEnum b : StatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("status")
  private StatusEnum status;

  public TrainingResponse comment(String comment) {
    this.comment = comment;
    return this;
  }

  /**
   * Комментарий к статусу
   * @return comment
  */
  @ApiModelProperty(value = "Комментарий к статусу")


  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public TrainingResponse status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * Текущий статус задачи на обучение
   * @return status
  */
  @ApiModelProperty(value = "Текущий статус задачи на обучение")


  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TrainingResponse trainingResponse = (TrainingResponse) o;
    return Objects.equals(this.comment, trainingResponse.comment) &&
        Objects.equals(this.status, trainingResponse.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(comment, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TrainingResponse {\n");
    
    sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

