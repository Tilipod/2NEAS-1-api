package ru.tilipod.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.tilipod.controller.dto.enums.TaskStatusEnum;
import ru.tilipod.controller.dto.TrainingRequestDto;
import ru.tilipod.controller.dto.TrainingResponseDto;
import ru.tilipod.feign.scheduler.SchedulerApi;

import java.util.UUID;

@RestController
@RequestMapping("/training")
@RequiredArgsConstructor
@Api(description = "Контроллер для обучения нейронных сетей")
public class TrainingNeuronNetworkController {

    private final SchedulerApi schedulerApi;

    @PostMapping("/")
    @ApiOperation(value = "Создать новую задачу по обучению нейронной сети")
    public ResponseEntity<UUID> createTask(@RequestBody TrainingRequestDto request) {
        return schedulerApi.createTaskUsingPOST(request);
    }

    @GetMapping("/{taskId}")
    @ApiOperation(value = "Получить статус задачи по обучению нейронной сети")
    public ResponseEntity<TaskStatusEnum> getTaskStatus(@PathVariable UUID taskId) {
        return schedulerApi.getTaskStatusUsingGET(taskId);
    }

    @GetMapping("/{taskId}/result")
    @ApiOperation(value = "Получить результат задачи по обучению нейронной сети")
    public ResponseEntity<TrainingResponseDto> getTaskTrainingResult(@PathVariable UUID taskId) {
        return schedulerApi.getTaskTrainingResultUsingGET(taskId);
    }

    @PostMapping("/{taskId}/stop")
    @ApiOperation(value = "Остановить задачу по обучению нейронной сети")
    public ResponseEntity<Boolean> stopTraining(@PathVariable UUID taskId) {
        return schedulerApi.stopTrainingUsingPOST(taskId);
    }
}