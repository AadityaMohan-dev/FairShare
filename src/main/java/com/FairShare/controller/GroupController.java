package com.FairShare.controller;

import com.FairShare.entity.Group;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/groups")
@Tag(name = "Group Management", description = "APIs for managing groups")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @PostMapping
    @Operation(summary = "Create a new group", description = "Creates a new group with the provided details")
    public ResponseEntity<Group> createGroup(@RequestBody Group group) {
        Group createdGroup = groupService.createGroup(group);
        return ResponseEntity.ok(createdGroup);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get group by ID", description = "Retrieves a group by its ID")
    public ResponseEntity<Group> getGroupById(@PathVariable Long id) {
        Group group = groupService.getGroupById(id);
        return ResponseEntity.ok(group);
    }

    @GetMapping
    @Operation(summary = "Get all groups", description = "Retrieves a list of all groups")
    public ResponseEntity<List<Group>> getAllGroups() {
        List<Group> groups = groupService.getAllGroups();
        return ResponseEntity.ok(groups);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update group", description = "Updates an existing group with the provided details")
    public ResponseEntity<Group> updateGroup(@PathVariable Long id, @RequestBody Group group) {
        Group updatedGroup = groupService.updateGroup(id, group);
        return ResponseEntity.ok(updatedGroup);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete group", description = "Deletes a group by its ID")
    public ResponseEntity<Void> deleteGroup(@PathVariable Long id) {
        groupService.deleteGroup(id);
        return ResponseEntity.noContent().build();
    }
}