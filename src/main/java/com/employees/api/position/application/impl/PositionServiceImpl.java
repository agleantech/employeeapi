package com.employees.api.position.application.impl;

import com.employees.api.position.application.PositionService;
import com.employees.api.position.domain.Position;
import com.employees.api.position.infrastructure.repository.PositionRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PositionServiceImpl implements PositionService {

    private final PositionRepository positionRepository;

    public PositionServiceImpl(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    @Override
    public List<Position> listAll() {
        return positionRepository.findAll();
    }
}
