package com.allstate.customer.service;

import com.allstate.customer.data.CustomerRepository;
import com.allstate.customer.data.InteractionRepository;
import com.allstate.customer.domain.CustomerData;
import com.allstate.customer.domain.Interaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional(Transactional.TxType.REQUIRED)
public class InteractionServiceImpl implements InteractionService {

    @Autowired
    private InteractionRepository interactRepo;

    @Autowired
    private CustomerRepository customerRepo;

    @Override
    public List<Interaction> getAllInteractionById(Integer id) {
        return interactRepo.findAllByCustD_CustomerId(id);
    }

    @Override
    public void updateInteractions(Integer id, Interaction newinteraction) {
        Interaction intra = interactRepo.findById(id).get();
        if (newinteraction.getCountry() != null){
            intra.setCountry(newinteraction.getCountry());
        }
        if (newinteraction.getEmailAddress() != null) {
            intra.setEmailAddress(newinteraction.getEmailAddress());
        }
        if (newinteraction.getPhoneNumber() != null) {
            intra.setPhoneNumber(newinteraction.getPhoneNumber());
        }
    }

    @Override
    public void saveInteraction(Interaction newinteraction) {
        Integer custId = newinteraction.getCustomerId();
        CustomerData data = customerRepo.findById(custId).get();
        newinteraction.setCustD(data);
        data.getInteractions().add(newinteraction);
        //data.getPurposeOfCall().add(newinteraction);
        interactRepo.save(newinteraction);
        customerRepo.save(data);

    }


}
