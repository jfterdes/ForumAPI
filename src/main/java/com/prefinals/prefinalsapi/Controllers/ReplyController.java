package com.prefinals.prefinalsapi.Controllers;
import java.util.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prefinals.prefinalsapi.Models.ReplyModel;
import com.prefinals.prefinalsapi.Services.ReplyService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/reply")
public class ReplyController {
    private ReplyService replyService;

    public ReplyController(ReplyService replyService) {
        this.replyService = replyService;
    }

    @GetMapping("")
    public ResponseEntity<List<ReplyModel>> GetAll(){
        List<ReplyModel> replys = replyService.GetAll();
        if(!replys.isEmpty())
            return ResponseEntity.ok(replys);
        else
            return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReplyModel> GetById(@PathVariable int id){
        try {
            ReplyModel targetReply = replyService.GetById(id);
            return ResponseEntity.ok(targetReply);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("")
    public ResponseEntity<ReplyModel> Create(@RequestBody ReplyModel reply) {
        if(reply!=null && reply.getId()==0)
        {
            ReplyModel newReply = replyService.Create(reply);
            if(newReply!=null)
                return ResponseEntity.ok(newReply);
        }    
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Delete(@PathVariable int id){
        try {
            replyService.Delete(id);
            return ResponseEntity.noContent().build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
