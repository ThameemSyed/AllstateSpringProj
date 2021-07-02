package com.allstate.customer.service;

import com.allstate.customer.domain.Interaction;
import org.springframework.stereotype.Service;

import java.util.List;


public interface InteractionService {
    public void saveInteraction(Interaction newinteraction);

    public List<Interaction> getAllInteractionById(Integer id);

    public void updateInteractions(Integer id, Interaction newinteraction);
}
