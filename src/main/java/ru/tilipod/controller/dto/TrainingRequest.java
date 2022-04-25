package ru.tilipod.controller.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.Valid;

/**
 * Запрос на создание задачи по обучению нейронной сети
 */
@ApiModel(description = "Запрос на создание задачи по обучению нейронной сети")
public class TrainingRequest   {
  @JsonProperty("cloudToken")
  private String cloudToken;

  /**
   * Тип облака для выгрузки датасетов
   */
  public enum CloudTypeEnum {
    YANDEX("YANDEX");

    private String value;

    CloudTypeEnum(String value) {
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
    public static CloudTypeEnum fromValue(String value) {
      for (CloudTypeEnum b : CloudTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("cloudType")
  private CloudTypeEnum cloudType;

  @JsonProperty("countEpoch")
  private Integer countEpoch;

  /**
   * Тип данных для обучения нейросети
   */
  public enum DatasetTypeEnum {
    IMAGE("IMAGE");

    private String value;

    DatasetTypeEnum(String value) {
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
    public static DatasetTypeEnum fromValue(String value) {
      for (DatasetTypeEnum b : DatasetTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("datasetType")
  private DatasetTypeEnum datasetType;

  @JsonProperty("neuronNetworkStructure")
  private NeuronNetworkDto neuronNetworkStructure;

  @JsonProperty("pathToDataset")
  private String pathToDataset;

  @JsonProperty("withMentoring")
  private Boolean withMentoring;

  public TrainingRequest cloudToken(String cloudToken) {
    this.cloudToken = cloudToken;
    return this;
  }

  /**
   * Токен для авторизации в облаке
   * @return cloudToken
  */
  @ApiModelProperty(value = "Токен для авторизации в облаке")


  public String getCloudToken() {
    return cloudToken;
  }

  public void setCloudToken(String cloudToken) {
    this.cloudToken = cloudToken;
  }

  public TrainingRequest cloudType(CloudTypeEnum cloudType) {
    this.cloudType = cloudType;
    return this;
  }

  /**
   * Тип облака для выгрузки датасетов
   * @return cloudType
  */
  @ApiModelProperty(value = "Тип облака для выгрузки датасетов")


  public CloudTypeEnum getCloudType() {
    return cloudType;
  }

  public void setCloudType(CloudTypeEnum cloudType) {
    this.cloudType = cloudType;
  }

  public TrainingRequest countEpoch(Integer countEpoch) {
    this.countEpoch = countEpoch;
    return this;
  }

  /**
   * Кол-во эпох для обучения нейросети
   * @return countEpoch
  */
  @ApiModelProperty(value = "Кол-во эпох для обучения нейросети")


  public Integer getCountEpoch() {
    return countEpoch;
  }

  public void setCountEpoch(Integer countEpoch) {
    this.countEpoch = countEpoch;
  }

  public TrainingRequest datasetType(DatasetTypeEnum datasetType) {
    this.datasetType = datasetType;
    return this;
  }

  /**
   * Тип данных для обучения нейросети
   * @return datasetType
  */
  @ApiModelProperty(value = "Тип данных для обучения нейросети")


  public DatasetTypeEnum getDatasetType() {
    return datasetType;
  }

  public void setDatasetType(DatasetTypeEnum datasetType) {
    this.datasetType = datasetType;
  }

  public TrainingRequest neuronNetworkStructure(NeuronNetworkDto neuronNetworkStructure) {
    this.neuronNetworkStructure = neuronNetworkStructure;
    return this;
  }

  /**
   * Get neuronNetworkStructure
   * @return neuronNetworkStructure
  */
  @ApiModelProperty(value = "")

  @Valid

  public NeuronNetworkDto getNeuronNetworkStructure() {
    return neuronNetworkStructure;
  }

  public void setNeuronNetworkStructure(NeuronNetworkDto neuronNetworkStructure) {
    this.neuronNetworkStructure = neuronNetworkStructure;
  }

  public TrainingRequest pathToDataset(String pathToDataset) {
    this.pathToDataset = pathToDataset;
    return this;
  }

  /**
   * Путь к папке в облаке с датасетами
   * @return pathToDataset
  */
  @ApiModelProperty(value = "Путь к папке в облаке с датасетами")


  public String getPathToDataset() {
    return pathToDataset;
  }

  public void setPathToDataset(String pathToDataset) {
    this.pathToDataset = pathToDataset;
  }

  public TrainingRequest withMentoring(Boolean withMentoring) {
    this.withMentoring = withMentoring;
    return this;
  }

  /**
   * Включить подкрепление к обучению
   * @return withMentoring
  */
  @ApiModelProperty(value = "Включить подкрепление к обучению")


  public Boolean getWithMentoring() {
    return withMentoring;
  }

  public void setWithMentoring(Boolean withMentoring) {
    this.withMentoring = withMentoring;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TrainingRequest trainingRequest = (TrainingRequest) o;
    return Objects.equals(this.cloudToken, trainingRequest.cloudToken) &&
        Objects.equals(this.cloudType, trainingRequest.cloudType) &&
        Objects.equals(this.countEpoch, trainingRequest.countEpoch) &&
        Objects.equals(this.datasetType, trainingRequest.datasetType) &&
        Objects.equals(this.neuronNetworkStructure, trainingRequest.neuronNetworkStructure) &&
        Objects.equals(this.pathToDataset, trainingRequest.pathToDataset) &&
        Objects.equals(this.withMentoring, trainingRequest.withMentoring);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cloudToken, cloudType, countEpoch, datasetType, neuronNetworkStructure, pathToDataset, withMentoring);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TrainingRequest {\n");
    
    sb.append("    cloudToken: ").append(toIndentedString(cloudToken)).append("\n");
    sb.append("    cloudType: ").append(toIndentedString(cloudType)).append("\n");
    sb.append("    countEpoch: ").append(toIndentedString(countEpoch)).append("\n");
    sb.append("    datasetType: ").append(toIndentedString(datasetType)).append("\n");
    sb.append("    neuronNetworkStructure: ").append(toIndentedString(neuronNetworkStructure)).append("\n");
    sb.append("    pathToDataset: ").append(toIndentedString(pathToDataset)).append("\n");
    sb.append("    withMentoring: ").append(toIndentedString(withMentoring)).append("\n");
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

