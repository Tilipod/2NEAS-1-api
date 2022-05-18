package ru.tilipod.controller;

import feign.FeignException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.tilipod.controller.dto.TaskStatusChange;
import ru.tilipod.controller.dto.TrainingRequest;
import ru.tilipod.controller.dto.TrainingResponse;
import ru.tilipod.controller.dto.TrainingStatistic;
import ru.tilipod.controller.dto.User;
import ru.tilipod.feign.scheduler.SchedulerApi;
import ru.tilipod.utils.Roles;

import java.util.UUID;

@RestController
@RequestMapping("/training")
@RequiredArgsConstructor
@Api(description = "Контроллер для обучения нейронных сетей")
public class TrainingNeuronNetworkController {

    private final SchedulerApi schedulerApi;

    @PostMapping("/")
    @ApiOperation(value = "Создать новую задачу по обучению нейронной сети")
    @Secured({Roles.CLIENT})
    public ResponseEntity<UUID> createTask(@RequestBody TrainingRequest request) {
        try {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            request.setUserUuid(user.getUuid());
            return schedulerApi.createTaskUsingPOST(request);
        } catch (FeignException e) {
            return ResponseEntity.status(e.status()).body(null);
        }
    }

    @GetMapping("/{taskId}")
    @ApiOperation(value = "Получить статус задачи по обучению нейронной сети")
    @Secured({Roles.CLIENT})
    public ResponseEntity<TrainingResponse> getTaskStatus(@PathVariable UUID taskId) {
        try {
            return schedulerApi.getTaskStatusUsingGET(taskId);
        } catch (FeignException e) {
            return ResponseEntity.status(e.status()).body(null);
        }
    }

    @GetMapping("/{taskId}/result")
    @ApiOperation(value = "Получить результат задачи по обучению нейронной сети")
    @Secured({Roles.CLIENT})
    public ResponseEntity<byte[]> getTaskTrainingResult(@PathVariable UUID taskId) {
        try {
            return schedulerApi.getTaskTrainingResultUsingGET(taskId);
        } catch (FeignException e) {
            return ResponseEntity.status(e.status()).body(null);
        }
    }

    @PostMapping("/{taskId}/stop")
    @ApiOperation(value = "Остановить задачу по обучению нейронной сети")
    @Secured({Roles.CLIENT})
    public ResponseEntity<Boolean> stopTraining(@PathVariable UUID taskId) {
        try {
            return schedulerApi.stopTrainingUsingPOST(taskId);
        } catch (FeignException e) {
            return ResponseEntity.status(e.status()).body(null);
        }
    }

    @PutMapping("/{taskId}/status")
    @ApiOperation(value = "Обновить статус задачи по обучению нейронной сети")
    @Secured({Roles.SUPPORT, Roles.ADMIN})
    public ResponseEntity<Void> changeTaskStatus(@PathVariable UUID taskId, @RequestBody TaskStatusChange statusChangeDto) {
        try {
            return schedulerApi.changeTaskStatusUsingPUT(taskId, statusChangeDto);
        } catch (FeignException e) {
            return ResponseEntity.status(e.status()).body(null);
        }
    }

    @GetMapping("/{taskId}/statistic")
    @ApiOperation(value = "Получить статистику обучения нейронной сети")
    @Secured({Roles.CLIENT, Roles.ANALYTIC})
    public ResponseEntity<TrainingStatistic> getStatistic(@PathVariable UUID taskId) {
        try {
            return schedulerApi.getStatisticUsingGET(taskId);
        } catch (FeignException e) {
            return ResponseEntity.status(e.status()).body(null);
        }
    }
}
