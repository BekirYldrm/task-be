package com.pinsoft.intern.controller;


import com.pinsoft.intern.dto.ActionRequest;
import com.pinsoft.intern.dto.ActionUpdateRequest;
import com.pinsoft.intern.entity.Action;
import com.pinsoft.intern.service.ActionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ActionController {

    private final ActionService actionService;

    @GetMapping("/actions")
    public List<Action> get() {
        return  actionService.getAll();
    }

    @GetMapping("/actions/{id}")
    public Action findAction(@PathVariable Long id) {
        return actionService.getAction(id);
    }

    @PostMapping("/action")
    public Action createAction(@RequestBody ActionRequest actionRequest) throws Exception {
    return actionService.saveAction(actionRequest);
    }

    @PatchMapping("/action")
    public Action updateAction(@RequestBody ActionUpdateRequest actionUpdateRequest) throws Exception {
        return actionService.updateAction(actionUpdateRequest);
    }
}
