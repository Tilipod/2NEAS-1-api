package ru.tilipod.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.tilipod.controller.dto.User;
import ru.tilipod.controller.dto.UserRegister;
import ru.tilipod.feign.scheduler.SchedulerApi;

import java.util.UUID;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
@Api(description = "Контроллер администратора")
public class AdminController {

    private final SchedulerApi schedulerApi;

    @GetMapping("/{username}/by-username")
    @ApiOperation(value = "Получить информацию о пользователе по его имени")
    public ResponseEntity<User> findUserByUsername(@PathVariable String username) {
        return schedulerApi.findUserByUsernameUsingGET(username);
    }

    @GetMapping("/{uuid}/by-uuid")
    @ApiOperation(value = "Получить информацию о пользователе по его uuid")
    public ResponseEntity<User> findUserByUuid(@PathVariable UUID uuid) {
        return schedulerApi.findUserByUuidUsingGET1(uuid);
    }

    @PostMapping("/register")
    @ApiOperation(value = "Зарегистрировать пользователя")
    public ResponseEntity<User> register(@RequestBody UserRegister registerDto) {
        return schedulerApi.registerUsingPOST(registerDto);
    }

    @PutMapping("/{uuid}/role")
    @ApiOperation(value = "Добавить роль пользователю")
    public ResponseEntity<Void> addRole(@PathVariable UUID uuid, @RequestParam String role) {
        return schedulerApi.addRoleUsingPUT(role, uuid);
    }

    @DeleteMapping("/{uuid}/role")
    @ApiOperation(value = "Удалить роль пользователю")
    public ResponseEntity<Void> deleteRole(@PathVariable UUID uuid, @RequestParam String role) {
       return schedulerApi.deleteRoleUsingDELETE(role, uuid);
    }

}
