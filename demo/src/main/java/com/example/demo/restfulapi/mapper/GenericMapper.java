package com.example.demo.restfulapi.mapper;

import org.springframework.stereotype.Component;
import java.util.List;

/**
 * Generic interface for Mapper Entity
 */
@Component
public abstract class GenericMapper<E,D> {
    abstract E dtoToEntity(D dto);
    abstract D entityToDto(E entity);
    abstract List<E> dtoToEntity(List<D> dList);
    abstract List<D> entityToDto(List<E> eList);
}


