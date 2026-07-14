package com.examly.springapp.service;

import com.examly.springapp.repository.*;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class AnalyticsService {
    private final CustomerRepository customerRepo;
    private final InteractionRepository interactionRepo;

    public AnalyticsService(CustomerRepository c,
                            InteractionRepository i){
        customerRepo=c;
        interactionRepo=i;
    }

    public Map<String,Long> getKpis(){
        Map<String,Long> data=new HashMap<>();
        data.put("customers",customerRepo.count());
        data.put("interactions",interactionRepo.count());
        return data;
    }
}
