package yte.intern.application.book;

import jakarta.persistence.Entity;
import lombok.Getter;
import yte.intern.application.common.entity.BaseEntity;

import java.time.LocalDate;
@Entity
@Getter
public class Book extends BaseEntity {

    private String name;
    private LocalDate publishDate;
    private Integer pageCount;
}