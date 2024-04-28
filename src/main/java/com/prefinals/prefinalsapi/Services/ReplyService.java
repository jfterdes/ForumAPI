package com.prefinals.prefinalsapi.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prefinals.prefinalsapi.Models.ReplyModel;
import com.prefinals.prefinalsapi.Repositories.ReplyRepository;

@Service
public class ReplyService {
    @Autowired

    private ReplyRepository replyRepository;

    ReplyService(ReplyRepository replyRepository)
    {
        this.replyRepository = replyRepository;
    }

    public List<ReplyModel> GetAll(){
        return replyRepository.findAll();
    }

    public ReplyModel GetById(int id)
    {
        return replyRepository.findById(id).orElseThrow();
    }

    public ReplyModel Create(ReplyModel reply){
        
        if(reply != null)
        {   
            List<ReplyModel> replys = GetAll();

            Optional<ReplyModel> existingReply = replys.stream()
                                                .filter(existing -> existing.getId() == reply.getId())
                                                .findFirst();
            
            if(!existingReply.isPresent())
            { 
                return replyRepository.save(reply);
            }
        }

        return null;
    }

    public void Delete(int id)
    {
        var targetReply = GetById(id);

        if(targetReply!=null)
            replyRepository.deleteById(id);
    }
}