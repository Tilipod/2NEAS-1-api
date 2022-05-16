package ru.tilipod.controller.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.validation.Valid;

/**
 * User
 */
public class User   {
  @JsonProperty("accountNonExpired")
  private Boolean accountNonExpired;

  @JsonProperty("accountNonLocked")
  private Boolean accountNonLocked;

  @JsonProperty("createdDateTime")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime createdDateTime;

  @JsonProperty("credentialsNonExpired")
  private Boolean credentialsNonExpired;

  @JsonProperty("email")
  private String email;

  @JsonProperty("enabled")
  private Boolean enabled;

  @JsonProperty("id")
  private Integer id;

  @JsonProperty("lastUpdatedDateTime")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime lastUpdatedDateTime;

  @JsonProperty("password")
  private String password;

  @JsonProperty("roles")
  @Valid
  private List<Role> roles = null;

  @JsonProperty("username")
  private String username;

  @JsonProperty("uuid")
  private UUID uuid;

  /**
   * Gets or Sets vipLevel
   */
  public enum VipLevelEnum {
    NONE("NONE"),
    
    BASIC("BASIC"),
    
    GOLD("GOLD"),
    
    PLATINUM("PLATINUM");

    private String value;

    VipLevelEnum(String value) {
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
    public static VipLevelEnum fromValue(String value) {
      for (VipLevelEnum b : VipLevelEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("vipLevel")
  private VipLevelEnum vipLevel;

  public User accountNonExpired(Boolean accountNonExpired) {
    this.accountNonExpired = accountNonExpired;
    return this;
  }

  /**
   * Get accountNonExpired
   * @return accountNonExpired
  */
  @ApiModelProperty(value = "")


  public Boolean getAccountNonExpired() {
    return accountNonExpired;
  }

  public void setAccountNonExpired(Boolean accountNonExpired) {
    this.accountNonExpired = accountNonExpired;
  }

  public User accountNonLocked(Boolean accountNonLocked) {
    this.accountNonLocked = accountNonLocked;
    return this;
  }

  /**
   * Get accountNonLocked
   * @return accountNonLocked
  */
  @ApiModelProperty(value = "")


  public Boolean getAccountNonLocked() {
    return accountNonLocked;
  }

  public void setAccountNonLocked(Boolean accountNonLocked) {
    this.accountNonLocked = accountNonLocked;
  }

  public User createdDateTime(OffsetDateTime createdDateTime) {
    this.createdDateTime = createdDateTime;
    return this;
  }

  /**
   * Get createdDateTime
   * @return createdDateTime
  */
  @ApiModelProperty(value = "")

  @Valid

  public OffsetDateTime getCreatedDateTime() {
    return createdDateTime;
  }

  public void setCreatedDateTime(OffsetDateTime createdDateTime) {
    this.createdDateTime = createdDateTime;
  }

  public User credentialsNonExpired(Boolean credentialsNonExpired) {
    this.credentialsNonExpired = credentialsNonExpired;
    return this;
  }

  /**
   * Get credentialsNonExpired
   * @return credentialsNonExpired
  */
  @ApiModelProperty(value = "")


  public Boolean getCredentialsNonExpired() {
    return credentialsNonExpired;
  }

  public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
    this.credentialsNonExpired = credentialsNonExpired;
  }

  public User email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
  */
  @ApiModelProperty(value = "")


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public User enabled(Boolean enabled) {
    this.enabled = enabled;
    return this;
  }

  /**
   * Get enabled
   * @return enabled
  */
  @ApiModelProperty(value = "")


  public Boolean getEnabled() {
    return enabled;
  }

  public void setEnabled(Boolean enabled) {
    this.enabled = enabled;
  }

  public User id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @ApiModelProperty(value = "")


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public User lastUpdatedDateTime(OffsetDateTime lastUpdatedDateTime) {
    this.lastUpdatedDateTime = lastUpdatedDateTime;
    return this;
  }

  /**
   * Get lastUpdatedDateTime
   * @return lastUpdatedDateTime
  */
  @ApiModelProperty(value = "")

  @Valid

  public OffsetDateTime getLastUpdatedDateTime() {
    return lastUpdatedDateTime;
  }

  public void setLastUpdatedDateTime(OffsetDateTime lastUpdatedDateTime) {
    this.lastUpdatedDateTime = lastUpdatedDateTime;
  }

  public User password(String password) {
    this.password = password;
    return this;
  }

  /**
   * Get password
   * @return password
  */
  @ApiModelProperty(value = "")


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public User roles(List<Role> roles) {
    this.roles = roles;
    return this;
  }

  public User addRolesItem(Role rolesItem) {
    if (this.roles == null) {
      this.roles = new ArrayList<>();
    }
    this.roles.add(rolesItem);
    return this;
  }

  /**
   * Get roles
   * @return roles
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<Role> getRoles() {
    return roles;
  }

  public void setRoles(List<Role> roles) {
    this.roles = roles;
  }

  public User username(String username) {
    this.username = username;
    return this;
  }

  /**
   * Get username
   * @return username
  */
  @ApiModelProperty(value = "")


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public User uuid(UUID uuid) {
    this.uuid = uuid;
    return this;
  }

  /**
   * Get uuid
   * @return uuid
  */
  @ApiModelProperty(value = "")

  @Valid

  public UUID getUuid() {
    return uuid;
  }

  public void setUuid(UUID uuid) {
    this.uuid = uuid;
  }

  public User vipLevel(VipLevelEnum vipLevel) {
    this.vipLevel = vipLevel;
    return this;
  }

  /**
   * Get vipLevel
   * @return vipLevel
  */
  @ApiModelProperty(value = "")


  public VipLevelEnum getVipLevel() {
    return vipLevel;
  }

  public void setVipLevel(VipLevelEnum vipLevel) {
    this.vipLevel = vipLevel;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(this.accountNonExpired, user.accountNonExpired) &&
        Objects.equals(this.accountNonLocked, user.accountNonLocked) &&
        Objects.equals(this.createdDateTime, user.createdDateTime) &&
        Objects.equals(this.credentialsNonExpired, user.credentialsNonExpired) &&
        Objects.equals(this.email, user.email) &&
        Objects.equals(this.enabled, user.enabled) &&
        Objects.equals(this.id, user.id) &&
        Objects.equals(this.lastUpdatedDateTime, user.lastUpdatedDateTime) &&
        Objects.equals(this.password, user.password) &&
        Objects.equals(this.roles, user.roles) &&
        Objects.equals(this.username, user.username) &&
        Objects.equals(this.uuid, user.uuid) &&
        Objects.equals(this.vipLevel, user.vipLevel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountNonExpired, accountNonLocked, createdDateTime, credentialsNonExpired, email, enabled, id, lastUpdatedDateTime, password, roles, username, uuid, vipLevel);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class User {\n");
    
    sb.append("    accountNonExpired: ").append(toIndentedString(accountNonExpired)).append("\n");
    sb.append("    accountNonLocked: ").append(toIndentedString(accountNonLocked)).append("\n");
    sb.append("    createdDateTime: ").append(toIndentedString(createdDateTime)).append("\n");
    sb.append("    credentialsNonExpired: ").append(toIndentedString(credentialsNonExpired)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    lastUpdatedDateTime: ").append(toIndentedString(lastUpdatedDateTime)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    roles: ").append(toIndentedString(roles)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
    sb.append("    vipLevel: ").append(toIndentedString(vipLevel)).append("\n");
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

