package io.khasang.gahelp.service.impl;

import io.khasang.gahelp.service.KnightService;
import org.springframework.stereotype.Component;

@Component
public class KnightServiceImpl implements KnightService {

    @Override
    public String getAchievement(String enemy) {
        if(enemy.equalsIgnoreCase("dragon")){
            throw new IllegalArgumentException("Dragon has eaten the Knight!");
        }
        return "I have slain " + enemy;
    }
}
