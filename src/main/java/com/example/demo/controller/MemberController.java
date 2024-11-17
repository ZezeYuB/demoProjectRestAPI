package com.example.demo.controller;

import com.example.demo.model.Member;
import com.example.demo.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController // Indicates that this class is a Spring MVC controller where every method returns a response body (usually in JSON format).
@RequestMapping("/members") // Sets a base URL path for all endpoints in this controller. Every method in the class will start with /members (e.g., /members, /members/{id}).
public class MemberController {
    @Autowired // Injects the memberRepository dependency into the controller. Ensures that we can use memberRepository to interact with the database.
    private MemberRepository memberRepository;

    // Creating a member
    @PostMapping
    public Member createMember(@RequestBody Member member) {
        return memberRepository.save(member);
    }

    // Get all members
    @GetMapping
    public List<Member> getMembers() {
        return memberRepository.findAll();
    }

    // Get member by ID
    @GetMapping("/{id}")
    public ResponseEntity<Member> getMemberById (@PathVariable Long id) {
        return memberRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update a member
    @PutMapping("/{id}")
    public ResponseEntity<Member>updateMember(@PathVariable Long id, @RequestBody Member updatedMember) {
        return memberRepository.findById(id)
                .map(member -> {
                    member.setName(updatedMember.getName());
                    member.setEmail(updatedMember.getEmail());
                    memberRepository.save(member);
                    return ResponseEntity.ok(member);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete a member
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteMember(@PathVariable Long id) {
        return memberRepository.findById(id)
                .map(member -> {
                    memberRepository.delete(member);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

}
