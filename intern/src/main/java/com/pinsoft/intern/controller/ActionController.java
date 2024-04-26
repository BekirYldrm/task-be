package com.pinsoft.intern.controller;


import com.pinsoft.intern.entity.Action;
import com.pinsoft.intern.service.ActionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ActionController {

    private final ActionService actionService;

    @GetMapping("/actions")
    public List<Action> get() {
        return  actionService.getAll();
    }
}
