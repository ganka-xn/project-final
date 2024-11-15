package com.javarush.jira.bugtracking.task;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//todo задача 7
// Добавить новый функционал: добавления тегов к задаче (REST API + реализация на сервисе).
// Фронт делать необязательно. Таблица task_tag уже создана.


@RestController
@RequestMapping
public class TagController {

    private final TagService tagService;


    public TagController(TagService tagService) {
        this.tagService = tagService;
    }
}
