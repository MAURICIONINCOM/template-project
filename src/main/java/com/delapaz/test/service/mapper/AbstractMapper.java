package com.delapaz.test.service.mapper;

import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractMapper<RequestDto, ResponseDto, Entity> {

    public abstract Entity toEntity(RequestDto request);

    public abstract ResponseDto toDto(Entity entity);

    public List<Entity> toEntity(List<RequestDto> requests) {
        return requests.stream().map(this::toEntity).collect(Collectors.toList());
    }

    public List<ResponseDto> toDto(List<Entity> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }

}
