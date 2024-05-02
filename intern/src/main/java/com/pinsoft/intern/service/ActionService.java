package com.pinsoft.intern.service;


import com.pinsoft.intern.dto.ActionRequest;
import com.pinsoft.intern.dto.ActionUpdateRequest;
import com.pinsoft.intern.entity.Action;
import com.pinsoft.intern.entity.User;
import com.pinsoft.intern.repository.ActionRepository;
import com.pinsoft.intern.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ActionService {

    private final ActionRepository actionRepository;
    private final UserRepository userRepository;

    public List<Action> getAll() {
        return actionRepository.findAll();
    }

    public Action getAction(Long id) {
        return actionRepository.findById(id).orElse(null);
    }

    public Action saveAction(ActionRequest actionRequest) throws Exception {
        Action action = new Action();
        User user = userRepository.findById(actionRequest.getUserId()).orElse(null);
        if (user != null) {
            action.setUser(user);
            action.setType(actionRequest.getType());
            action.setDescription(actionRequest.getDescription());
            action.setMoney(actionRequest.getMoney());
            LocalDateTime dateTime = LocalDateTime.now().toLocalDate()  .atTime(LocalTime.now().getHour() , LocalTime.now().getMinute(), LocalTime.now().getSecond());
            action.setDate(dateTime);
            if (action.getType().equals("Income")){
                user.setBalance(user.getBalance()+action.getMoney());
                userRepository.save(user);
            }
            else{
                user.setBalance(user.getBalance()-action.getMoney());
                userRepository.save(user);
            }
            return actionRepository.save(action);
        }else{
            throw new Exception("User is null!");
        }



    }

    public Action updateAction(ActionUpdateRequest actionUpdateRequest) throws Exception {
        Action action =actionRepository.findById(actionUpdateRequest.getId()).orElse(null);
        if (action != null) {
            action.setMoney(actionUpdateRequest.getMoney());
            action.setDescription(actionUpdateRequest.getDescription());
            action.setType(actionUpdateRequest.getType());
            return actionRepository.save(action);
        }
        else{
            throw new Exception("Action is null!");
        }
    }
}
