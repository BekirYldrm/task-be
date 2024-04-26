package com.pinsoft.intern.service;


import com.pinsoft.intern.entity.Action;
import com.pinsoft.intern.repository.ActionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActionService {

    private final ActionRepository actionRepository;

    public List<Action> getAll() {
        return actionRepository.findAll();
    }
}
