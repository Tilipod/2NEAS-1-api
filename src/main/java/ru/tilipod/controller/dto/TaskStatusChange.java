package ru.tilipod.controller.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.UUID;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Данные для обновления статуса задачи
 */
@ApiModel(description = "Данные для обновления статуса задачи")
public class TaskStatusChange   {
  @JsonProperty("comment")
  private String comment;

  /**
   * Новый статус задачи
   */
  public enum NewStatusEnum {
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

    NewStatusEnum(String value) {
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
    public static NewStatusEnum fromValue(String value) {
      for (NewStatusEnum b : NewStatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("newStatus")
  private NewStatusEnum newStatus;

  @JsonProperty("userUuid")
  private UUID userUuid;

  public TaskStatusChange comment(String comment) {
    this.comment = comment;
    return this;
  }

  /**
   * Комментарий к изменению статуса
   * @return comment
  */
  @ApiModelProperty(required = true, value = "Комментарий к изменению статуса")
  @NotNull


  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public TaskStatusChange newStatus(NewStatusEnum newStatus) {
    this.newStatus = newStatus;
    return this;
  }

  /**
   * Новый статус задачи
   * @return newStatus
  */
  @ApiModelProperty(required = true, value = "Новый статус задачи")
  @NotNull


  public NewStatusEnum getNewStatus() {
    return newStatus;
  }

  public void setNewStatus(NewStatusEnum newStatus) {
    this.newStatus = newStatus;
  }

  public TaskStatusChange userUuid(UUID userUuid) {
    this.userUuid = userUuid;
    return this;
  }

  /**
   * ID пользователя, изменившего статус
   * @return userUuid
  */
  @ApiModelProperty(required = true, value = "ID пользователя, изменившего статус")
  @NotNull

  @Valid

  public UUID getUserUuid() {
    return userUuid;
  }

  public void setUserUuid(UUID userUuid) {
    this.userUuid = userUuid;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TaskStatusChange taskStatusChange = (TaskStatusChange) o;
    return Objects.equals(this.comment, taskStatusChange.comment) &&
        Objects.equals(this.newStatus, taskStatusChange.newStatus) &&
        Objects.equals(this.userUuid, taskStatusChange.userUuid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(comment, newStatus, userUuid);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TaskStatusChange {\n");
    
    sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
    sb.append("    newStatus: ").append(toIndentedString(newStatus)).append("\n");
    sb.append("    userUuid: ").append(toIndentedString(userUuid)).append("\n");
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

