package ru.tilipod.controller;

import feign.FeignException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
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
import ru.tilipod.utils.Roles;

import java.util.UUID;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
@Api(description = "Контроллер администратора")
public class AdminController {

    private final SchedulerApi schedulerApi;

    @GetMapping("/{username}/by-username")
    @ApiOperation(value = "Получить информацию о пользователе по его имени")
    @Secured({Roles.ADMIN, Roles.SUPPORT})
    public ResponseEntity<User> findUserByUsername(@PathVariable String username) {
        try {
            return schedulerApi.findUserByUsernameUsingGET(username);
        } catch (FeignException e) {
            return ResponseEntity.status(e.status()).body(null);
        }
    }

    @GetMapping("/{uuid}/by-uuid")
    @ApiOperation(value = "Получить информацию о пользователе по его uuid")
    @Secured({Roles.ADMIN, Roles.SUPPORT})
    public ResponseEntity<User> findUserByUuid(@PathVariable UUID uuid) {
        try {
            return schedulerApi.findUserByUuidUsingGET1(uuid);
        } catch (FeignException e) {
            return ResponseEntity.status(e.status()).body(null);
        }
    }

    @PostMapping("/register")
    @ApiOperation(value = "Зарегистрировать пользователя")
    public ResponseEntity<User> register(@RequestBody UserRegister registerDto) {
        try {
            return schedulerApi.registerUsingPOST(registerDto);
        } catch (FeignException e) {
            return ResponseEntity.status(e.status()).body(null);
        }
    }

    @PutMapping("/{uuid}/role")
    @ApiOperation(value = "Добавить роль пользователю")
    @Secured({Roles.ADMIN})
    public ResponseEntity<Void> addRole(@PathVariable UUID uuid, @RequestParam String role) {
        try {
            return schedulerApi.addRoleUsingPUT(role, uuid);
        } catch (FeignException e) {
            return ResponseEntity.status(e.status()).body(null);
        }
    }

    @DeleteMapping("/{uuid}/role")
    @ApiOperation(value = "Удалить роль пользователю")
    @Secured({Roles.ADMIN})
    public ResponseEntity<Void> deleteRole(@PathVariable UUID uuid, @RequestParam String role) {
        try {
            return schedulerApi.deleteRoleUsingDELETE(role, uuid);
        } catch (FeignException e) {
            return ResponseEntity.status(e.status()).body(null);
        }
    }

}
