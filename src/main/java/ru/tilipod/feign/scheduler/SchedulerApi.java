package ru.tilipod.feign.scheduler;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.tilipod.controller.dto.TrainingRequestDto;
import ru.tilipod.controller.dto.TrainingResponseDto;
import ru.tilipod.controller.dto.enums.TaskStatusEnum;

import javax.validation.Valid;
import java.util.UUID;

public interface SchedulerApi {

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
    @ApiOperation(value = "Создать новую задачу по обучению нейронной сети", nickname = "createTaskUsingPOST", response = UUID.class, tags={ "client-request-controller" })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = UUID.class),
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found") }
    )
    @PostMapping(value = "/client/")
    ResponseEntity<UUID> createTaskUsingPOST(@ApiParam(value = "request", required = true)  @Valid @RequestBody TrainingRequestDto request);


    /**
     * GET /client/{taskId} : Получить статус задачи по обучению нейронной сети
     *
     * @param taskId taskId (required)
     * @return OK (status code 200)
     *         or Unauthorized (status code 401)
     *         or Forbidden (status code 403)
     *         or Not Found (status code 404)
     */
    @ApiOperation(value = "Получить статус задачи по обучению нейронной сети", nickname = "getTaskStatusUsingGET", response = String.class, tags={ "client-request-controller" })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = String.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found") })
    @GetMapping(value = "/client/{taskId}")
    ResponseEntity<TaskStatusEnum> getTaskStatusUsingGET(@ApiParam(value = "taskId", required = true) @PathVariable("taskId") UUID taskId);

    /**
     * GET /client/{taskId}/result : Получить результат задачи по обучению нейронной сети
     *
     * @param taskId taskId (required)
     * @return OK (status code 200)
     *         or Unauthorized (status code 401)
     *         or Forbidden (status code 403)
     *         or Not Found (status code 404)
     */
    @ApiOperation(value = "Получить результат задачи по обучению нейронной сети", nickname = "getTaskTrainingResultUsingGET", response = Object.class, tags={ "client-request-controller" })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Object.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found") })
    @GetMapping(value = "/client/{taskId}/result")
    ResponseEntity<TrainingResponseDto> getTaskTrainingResultUsingGET(@ApiParam(value = "taskId", required = true) @PathVariable("taskId") UUID taskId);


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
    @ApiOperation(value = "Остановить задачу по обучению нейронной сети", nickname = "stopTrainingUsingPOST", response = Boolean.class, tags={ "client-request-controller" })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Boolean.class),
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found") })
    @PostMapping(value = "/client/{taskId}/stop")
    ResponseEntity<Boolean> stopTrainingUsingPOST(@ApiParam(value = "taskId", required = true) @PathVariable("taskId") UUID taskId);

}
