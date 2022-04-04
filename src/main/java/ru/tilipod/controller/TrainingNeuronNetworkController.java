package ru.tilipod.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
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

import java.util.UUID;

@RestController
@RequestMapping("/training")
@Api(description = "Контроллер для обучения нейронных сетей")
// todo Ожидает API шедулера
public class TrainingNeuronNetworkController {

    @PostMapping("/")
    @ApiOperation(value = "Создать новую задачу по обучению нейронной сети")
    public UUID createTask(@RequestBody TrainingRequestDto request) {
        return UUID.randomUUID();
    }

    @GetMapping("/{taskId}")
    @ApiOperation(value = "Получить статус задачи по обучению нейронной сети")
    public TaskStatusEnum getTaskStatus(@PathVariable UUID taskId) {
        return TaskStatusEnum.CREATED;
    }

    @GetMapping("/{taskId}/result")
    @ApiOperation(value = "Получить результат задачи по обучению нейронной сети")
    public ResponseEntity<TrainingResponseDto> getTaskTrainingResult(@PathVariable UUID taskId) {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);
    }

    @PostMapping("/{taskId}/stop")
    @ApiOperation(value = "Остановить задачу по обучению нейронной сети")
    public Boolean stopTraining(@PathVariable UUID taskId) {
        return true;
    }
}
