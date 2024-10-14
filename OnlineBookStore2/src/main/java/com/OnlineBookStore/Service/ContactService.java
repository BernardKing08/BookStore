package com.OnlineBookStore.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OnlineBookStore.Model.Contact;
import com.OnlineBookStore.Repository.ContactRepository;
import com.OnlineBookStore.constants.OnlineBookStoreConstants;

@Service
public class ContactService {
	
    @Autowired
    private ContactRepository contactRepository;

    /**
     * Save Contact Details into DB
     * @param contact
     * @return boolean
     */
    public boolean saveMessageDetails(Contact contact){
        boolean isSaved = false;
        contact.setStatus(OnlineBookStoreConstants.OPEN);
        Contact result = contactRepository.save(contact);
        if(result != null) {
            isSaved = true;
        }
        return isSaved;
    }
    
    public List<Contact> getOpenMsg(){
    	List<Contact> contactMsg = contactRepository.findByStatus(OnlineBookStoreConstants.OPEN);
    	return contactMsg;
    }
    
    public boolean UpdateMessageStatus(int id) {
    	boolean isUpdated = false;
    	
    	Optional<Contact> contact = contactRepository.findById(id);
    	contact.ifPresent(contact1 -> {
    		contact1.setStatus(OnlineBookStoreConstants.CLOSE);
    	});
    	Contact updatedContact = contactRepository.save(contact.get());
    	if(null != updatedContact && updatedContact.getUpdatedBy()!=null) {
            isUpdated = true;
        }
        return isUpdated;
    }
    
	
	
}
