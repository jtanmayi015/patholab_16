package com.patholab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patholab.entity.Contact;
import com.patholab.entity.ContactForm;
import com.patholab.repository.ContactRepository;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public void processContactForm(Contact contactForm) {
        Contact contact = new Contact();
        contact.setName(contactForm.getName());
        contact.setEmail(contactForm.getEmail());
        contact.setPhone(contactForm.getPhone());
        contact.setMessage(contactForm.getMessage());
        contactRepository.save(contact);
    }
}
