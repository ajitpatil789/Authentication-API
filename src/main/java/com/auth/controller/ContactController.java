package com.auth.controller;
import com.auth.dto.ContactRequest;
import com.auth.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping
    public String submitContact(@RequestBody ContactRequest request) {
        contactService.submit(request);
        return "Message Sent";
    }
}
