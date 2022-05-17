package ru.tilipod.feign.scheduler;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import ru.tilipod.controller.dto.TaskStatusChange;
import ru.tilipod.controller.dto.TrainingRequest;
import ru.tilipod.controller.dto.TrainingResponse;
import ru.tilipod.controller.dto.TrainingStatistic;
import ru.tilipod.controller.dto.User;
import ru.tilipod.controller.dto.UserRegister;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public interface SchedulerApi {

    /**
     * PUT /users/{uuid}/role : Добавить роль пользователю
     *
     * @param role role (required)
     * @param uuid uuid (required)
     * @return OK (status code 200)
     *         or Created (status code 201)
     *         or Unauthorized (status code 401)
     *         or Forbidden (status code 403)
     *         or Not Found (status code 404)
     */
    @ApiOperation(value = "Добавить роль пользователю", nickname = "addRoleUsingPUT", notes = "", tags={ "user-controller", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found") })
    @PutMapping(
            value = "/users/{uuid}/role"
    )
    ResponseEntity<Void> addRoleUsingPUT(@NotNull @ApiParam(value = "role", required = true) @Valid @RequestParam(value = "role", required = true) String role, @ApiParam(value = "uuid",required=true) @PathVariable("uuid") UUID uuid);


    /**
     * DELETE /users/{uuid}/role : Удалить роль пользователю
     *
     * @param role role (required)
     * @param uuid uuid (required)
     * @return OK (status code 200)
     *         or No Content (status code 204)
     *         or Unauthorized (status code 401)
     *         or Forbidden (status code 403)
     */
    @ApiOperation(value = "Удалить роль пользователю", nickname = "deleteRoleUsingDELETE", notes = "", tags={ "user-controller", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 204, message = "No Content"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden") })
    @DeleteMapping(
            value = "/users/{uuid}/role"
    )
    ResponseEntity<Void> deleteRoleUsingDELETE(@NotNull @ApiParam(value = "role", required = true) @Valid @RequestParam(value = "role", required = true) String role, @ApiParam(value = "uuid",required=true) @PathVariable("uuid") UUID uuid);


    /**
     * GET /users/{username}/by-username : Получить информацию о пользователе по его имени
     *
     * @param username username (required)
     * @return OK (status code 200)
     *         or Unauthorized (status code 401)
     *         or Forbidden (status code 403)
     *         or Not Found (status code 404)
     */
    @ApiOperation(value = "Получить информацию о пользователе по его имени", nickname = "findUserByUuidUsingGET", notes = "", response = User.class, tags={ "user-controller", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = User.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found") })
    @GetMapping(
            value = "/users/{username}/by-username",
            produces = { "*/*" }
    )
    ResponseEntity<User> findUserByUsernameUsingGET(@ApiParam(value = "username",required=true) @PathVariable("username") String username);


    /**
     * GET /users/{uuid}/by-uuid : Получить информацию о пользователе по его uuid
     *
     * @param uuid uuid (required)
     * @return OK (status code 200)
     *         or Unauthorized (status code 401)
     *         or Forbidden (status code 403)
     *         or Not Found (status code 404)
     */
    @ApiOperation(value = "Получить информацию о пользователе по его uuid", nickname = "findUserByUuidUsingGET1", notes = "", response = User.class, tags={ "user-controller", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = User.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found") })
    @GetMapping(
            value = "/users/{uuid}/by-uuid",
            produces = { "*/*" }
    )
    ResponseEntity<User> findUserByUuidUsingGET1(@ApiParam(value = "uuid",required=true) @PathVariable("uuid") UUID uuid);


    /**
     * POST /users/register : Зарегистрировать пользователя
     *
     * @param registerDto registerDto (required)
     * @return OK (status code 200)
     *         or Created (status code 201)
     *         or Unauthorized (status code 401)
     *         or Forbidden (status code 403)
     *         or Not Found (status code 404)
     */
    @ApiOperation(value = "Зарегистрировать пользователя", nickname = "registerUsingPOST", notes = "", response = User.class, tags={ "user-controller", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = User.class),
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found") })
    @PostMapping(
            value = "/users/register",
            produces = { "*/*" },
            consumes = { "application/json" }
    )
    ResponseEntity<User> registerUsingPOST(@ApiParam(value = "registerDto" ,required=true )  @Valid @RequestBody UserRegister registerDto);

    /**
     * PUT /client/{taskId}/status : Обновить статус задачи по обучению нейронной сети
     *
     * @param taskId taskId (required)
     * @param statusChangeDto statusChangeDto (required)
     * @return OK (status code 200)
     *         or Created (status code 201)
     *         or Unauthorized (status code 401)
     *         or Forbidden (status code 403)
     *         or Not Found (status code 404)
     */
    @ApiOperation(value = "Обновить статус задачи по обучению нейронной сети", nickname = "changeTaskStatusUsingPUT", notes = "", tags={ "client-request-controller", })
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK"),
                           @ApiResponse(code = 201, message = "Created"),
                           @ApiResponse(code = 401, message = "Unauthorized"),
                           @ApiResponse(code = 403, message = "Forbidden"),
                           @ApiResponse(code = 404, message = "Not Found") })
    @PutMapping(value = "/client/{taskId}/status", consumes = { "application/json" })
    ResponseEntity<Void> changeTaskStatusUsingPUT(@ApiParam(value = "taskId", required=true) @PathVariable("taskId") UUID taskId,@ApiParam(value = "statusChangeDto", required=true)  @Valid @RequestBody TaskStatusChange statusChangeDto);

    /**
     * GET /client/{taskId}/statistic : Получить статистику обучения нейронной сети
     *
     * @param taskId taskId (required)
     * @return OK (status code 200)
     *         or Unauthorized (status code 401)
     *         or Forbidden (status code 403)
     *         or Not Found (status code 404)
     */
    @ApiOperation(value = "Получить статистику обучения нейронной сети", nickname = "getStatisticUsingGET", notes = "", response = TrainingStatistic.class, tags={ "client-request-controller", })
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = TrainingStatistic.class),
                           @ApiResponse(code = 401, message = "Unauthorized"),
                           @ApiResponse(code = 403, message = "Forbidden"),
                           @ApiResponse(code = 404, message = "Not Found") })
    @GetMapping(value = "/client/{taskId}/statistic", produces = { "*/*" })
    ResponseEntity<TrainingStatistic> getStatisticUsingGET(@ApiParam(value = "taskId", required=true) @PathVariable("taskId") UUID taskId);

    /**
     * POST /client/ : Создать новую задачу по обучению нейронной сети
     *
     * @param request request (required)
     * @return OK (status code 200)
     *         or Created (status code 201)
     *         or Unauthorized (status code 401)
     *         or Forbidden (status code 403)
     *         or Not Found (status code 404)
     */
    @ApiOperation(value = "Создать новую задачу по обучению нейронной сети", nickname = "createTaskUsingPOST", response = UUID.class, tags={ "client-request-controller", })
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = UUID.class),
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found") })
    @PostMapping(value = "/client/", produces = { "*/*" }, consumes = { "application/json" })
    ResponseEntity<UUID> createTaskUsingPOST(@ApiParam(value = "request" ,required=true )  @Valid @RequestBody TrainingRequest request);


    /**
     * GET /client/{taskId} : Получить статус задачи по обучению нейронной сети
     *
     * @param taskId taskId (required)
     * @return OK (status code 200)
     *         or Unauthorized (status code 401)
     *         or Forbidden (status code 403)
     *         or Not Found (status code 404)
     */
    @ApiOperation(value = "Получить статус задачи по обучению нейронной сети", nickname = "getTaskStatusUsingGET", notes = "", response = TrainingResponse.class, tags={ "client-request-controller", })
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = TrainingResponse.class),
                           @ApiResponse(code = 401, message = "Unauthorized"),
                           @ApiResponse(code = 403, message = "Forbidden"),
                           @ApiResponse(code = 404, message = "Not Found") })
    @GetMapping(value = "/client/{taskId}", produces = { "*/*" })
    ResponseEntity<TrainingResponse> getTaskStatusUsingGET(@ApiParam(value = "taskId",required=true) @PathVariable("taskId") UUID taskId);


    /**
     * GET /client/{taskId}/result : Получить результат задачи по обучению нейронной сети
     *
     * @param taskId taskId (required)
     * @return OK (status code 200)
     *         or Unauthorized (status code 401)
     *         or Forbidden (status code 403)
     *         or Not Found (status code 404)
     */
    @ApiOperation(value = "Получить результат задачи по обучению нейронной сети", nickname = "getTaskTrainingResultUsingGET", notes = "", response = byte[].class, tags={ "client-request-controller", })
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = byte[].class),
                           @ApiResponse(code = 401, message = "Unauthorized"),
                           @ApiResponse(code = 403, message = "Forbidden"),
                           @ApiResponse(code = 404, message = "Not Found") })
    @GetMapping(value = "/client/{taskId}/result", produces = { "*/*" })
    ResponseEntity<byte[]> getTaskTrainingResultUsingGET(@ApiParam(value = "taskId",required=true) @PathVariable("taskId") UUID taskId);

    /**
     * POST /client/{taskId}/stop : Остановить задачу по обучению нейронной сети
     *
     * @param taskId taskId (required)
     * @return OK (status code 200)
     *         or Created (status code 201)
     *         or Unauthorized (status code 401)
     *         or Forbidden (status code 403)
     *         or Not Found (status code 404)
     */
    @ApiOperation(value = "Остановить задачу по обучению нейронной сети", nickname = "stopTrainingUsingPOST", response = Boolean.class, tags={ "client-request-controller", })
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Boolean.class),
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found") })
    @PostMapping(value = "/client/{taskId}/stop", produces = { "*/*" })
    ResponseEntity<Boolean> stopTrainingUsingPOST(@ApiParam(value = "taskId",required=true) @PathVariable("taskId") UUID taskId);

}
