package com.allstate.customer.control;

import com.allstate.customer.domain.Interaction;
import com.allstate.customer.service.InteractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@CrossOrigin
@Transactional(Transactional.TxType.REQUIRED)
@RequestMapping("/api/interaction")
public class InteractionController {

    @Autowired
    private InteractionService interaction;

    @PostMapping()
    public void addInteractions(@RequestBody Interaction newinteraction){
        interaction.saveInteraction(newinteraction);

    }

    //@GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    //public List<Interaction> getAllInteractions(@PathVariable Integer id)
    @GetMapping()
    public List<Interaction> getAllInteractions(@RequestParam(value = "customerId", required = false) Integer customerId)
    {
        return interaction.getAllInteractionById(customerId);
    }

    @PutMapping("/{id}")
    public void updateInteractions(@PathVariable Integer id, @RequestBody Interaction newinteraction){
        interaction.updateInteractions(id, newinteraction);
    }
}
