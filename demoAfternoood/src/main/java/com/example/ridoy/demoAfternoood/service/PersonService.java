package com.example.ridoy.demoAfternoood.service;

import com.example.ridoy.demoAfternoood.entity.Person;
import com.example.ridoy.demoAfternoood.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Person getPersonById(Long id) {
        return personRepository.findById(id).orElseThrow(() -> new RuntimeException("Person not found"));
    }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

    private static final String UPLOAD_DIRECTORY = "/path/to/upload/directory"; // Change this to your file storage location

    // Other service methods...

    public Person updateProfilePicture(Long personId, MultipartFile file) {
        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new RuntimeException("Person not found with ID: " + personId));

        try {
            person.setProfilePicture(file.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Failed to read file content", e);
        }

        return personRepository.save(person);
    }

    public Person addMember(Person member){
        return personRepository.save(member);
    }

    public String uploadProfilePicture(Long id, MultipartFile file) throws IOException {
        Optional<Person> optionalMember = personRepository.findById(id);
        if (optionalMember.isPresent()) {
            Person member = optionalMember.get();
            member.setProfilePicture(file.getBytes());
            personRepository.save(member);
            return "Profile picture uploaded successfully.";
        } else {
            return "Member not found.";
        }
    }

    public byte[] getProfilePicture(Long id) {
        Optional<Person> optionalMember = personRepository.findById(id);
        return optionalMember.map(Person::getProfilePicture).orElse(null);
    }

    public Person addMember(String firstName, String lastName, String email, String phone, String address, MultipartFile profilePicture) throws IOException {
        Person member = new Person();  // No need to pass memberId
        member.setFirstName(firstName);
        member.setLastName(lastName);
        member.setEmail(email);
        member.setPhone(phone);
        member.setAddress(address);
        member.setProfilePicture(profilePicture.getBytes());

        return personRepository.save(member);
    }

    public List<Person> getMemberHistory(Long personId, int month, int year) {
        return personRepository.findMemberHistoryByIdAndMonth(personId, month, year);
    }

    public List<Person> getBalanceHistory(Long personId, LocalDateTime startDate, LocalDateTime endDate) {
        return personRepository.findMemberHistoryByIdAndDateRange(personId, startDate, endDate);
    }
}
