package com.employees.api.position.infrastructure.controller;

import com.employees.api.position.application.PositionService;
import com.employees.api.position.domain.Position;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PositionController {

    private final PositionService positionService;

    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @GetMapping(path = "api/v1/position/list")
    public List<Position> listAll() {
        return positionService.listAll();
    }
}
