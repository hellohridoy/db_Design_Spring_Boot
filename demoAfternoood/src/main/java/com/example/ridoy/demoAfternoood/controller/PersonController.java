package com.example.ridoy.demoAfternoood.controller;

import com.example.ridoy.demoAfternoood.entity.Person;
import com.example.ridoy.demoAfternoood.service.PersonService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping("/api/v1/afternoon-delights/person-infos/{personId}")
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @GetMapping("/api/v1/afternoon-delights/person-infos/{id}")
    public Person getPersonById(@PathVariable Long id) {
        return personService.getPersonById(id);
    }

    @PostMapping("/api/v1/afternoon-delights/person-infos")
    public ResponseEntity<Person> addMember(
                                            @RequestParam("firstName") String firstName,
                                            @RequestParam("lastName") String lastName,
                                            @RequestParam("email") String email,
                                            @RequestParam("phone") String phone,
                                            @RequestParam("address") String address,
                                            @RequestParam(value = "profilePicture", required = false) MultipartFile profilePicture) { // Optional
        try {
            // Handling null or missing optional parameters
            Person member = personService.addMember(firstName, lastName, email, phone, address, profilePicture);
            return ResponseEntity.ok(member);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/api/v1/afternoon-delights/person-infos/{id}")
    public void deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
    }



    @GetMapping("/afternoon-delights/members/all-members/{id}/profilePicture")
    public ResponseEntity<byte[]> getProfilePicture(@PathVariable Long id) {
        byte[] profilePicture = personService.getProfilePicture(id);
        if (profilePicture != null) {
            return ResponseEntity.ok(profilePicture);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    @PostMapping("/afternoon-delights/member/add-member-infos")
    public ResponseEntity<Person> addMember(@RequestBody Person member) {
        try {
            // Call the service to add the new member
            Person savedMember = personService.addMember(member);

            // Return success response with the saved member
            return new ResponseEntity<>(savedMember, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            // Handle any exceptions such as duplicate PIN or other errors
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/afternoon-delights/member/member-history/{personId}")
    public ResponseEntity<List<Person>> getMemberHistory(
            @PathVariable Long personId,
            @RequestParam int month,
            @RequestParam int year) {
        try {
            List<Person> memberHistory = personService.getMemberHistory(personId, month, year);
            return ResponseEntity.ok(memberHistory);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }




    @GetMapping("/afternoon-delights/member/{personId}/balance-history")
    public List<Person> getBalanceHistory(
            @PathVariable Long personId,
            @RequestParam int month,
            @RequestParam int year) {

        // Generate start and end date for the given month and year
        LocalDateTime startDate = LocalDateTime.of(year, Month.of(month), 1, 0, 0, 0, 0);
        LocalDateTime endDate = LocalDateTime.of(year, Month.of(month), startDate.toLocalDate().lengthOfMonth(), 23, 59, 59, 999999);

        // Fetch the balance history using the service layer
        return personService.getBalanceHistory(personId, startDate, endDate);
    }

}