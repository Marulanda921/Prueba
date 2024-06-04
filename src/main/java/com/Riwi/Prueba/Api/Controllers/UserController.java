package com.Riwi.Prueba.Api.Controllers;


import com.Riwi.Prueba.Api.Dto.Request.UserRequest;
import com.Riwi.Prueba.Api.Dto.Response.UserResponse;
import com.Riwi.Prueba.Infraestructure.IUserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private final IUserService userService;


    @PostMapping
    public ResponseEntity<UserResponse> create(@Valid @RequestBody UserRequest requestDTO) {
        UserResponse responseDTO = userService.create(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> get(@PathVariable Integer id) {
        UserResponse responseDTO = userService.get(id);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping
    public ResponseEntity<Page<UserResponse>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Page<UserResponse> estudiantesPage = userService.getAll(page, size);
        return ResponseEntity.ok(estudiantesPage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> update(@PathVariable Integer id, @Valid @RequestBody UserRequest requestDTO) {
        UserResponse responseDTO = userService.update(requestDTO, id);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
