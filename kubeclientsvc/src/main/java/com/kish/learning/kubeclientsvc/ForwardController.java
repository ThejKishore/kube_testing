package com.kish.learning.kubeclientsvc;


import com.kish.learning.kubeclientsvc.client.CallKubeServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ForwardController {

    @Autowired
    private CallKubeServiceClient callKubeServiceClient;

    @GetMapping("/forward/greet")
    public ResponseEntity<String> forwardGreet(){
        String responseString = callKubeServiceClient.doOtherStuff();
        return ResponseEntity.ok(responseString);
    }
}
