package com.auth.service;
import com.auth.dto.ContactRequest;
import com.auth.entity.Contact;
import com.auth.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepo;

    public void submit(ContactRequest request) {
        Contact contact = new Contact(null, request.getName(), request.getEmail(), request.getMessage());
        contactRepo.save(contact);
    }
}
