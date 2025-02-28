package com.FairShare.controller;

import com.FairShare.dto.GroupRequest;
import com.FairShare.entity.Group;
import com.FairShare.svc.GroupService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.expensetracker.dto.GroupResponse;

import java.util.List;

@RestController
@RequestMapping("/api/groups")
@Tag(name = "Group Management", description = "APIs for managing groups")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @PostMapping
    @Operation(summary = "Create a new group", description = "Creates a new group with the provided details")
    public ResponseEntity<GroupResponse> createGroup(@RequestBody GroupRequest group) {
        GroupResponse createdGroup = groupService.createGroup(group);
        return ResponseEntity.ok(createdGroup);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get group by ID", description = "Retrieves a group by its ID")
    public ResponseEntity<GroupResponse> getGroupById(@PathVariable Long id) {
        GroupResponse group = groupService.getGroupById(id);
        return ResponseEntity.ok(group);
    }

    @GetMapping
    @Operation(summary = "Get all groups", description = "Retrieves a list of all groups")
    public ResponseEntity<List<GroupResponse>> getAllGroups() {
        List<GroupResponse> groups = groupService.getAllGroups();
        return ResponseEntity.ok(groups);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update group", description = "Updates an existing group with the provided details")
    public ResponseEntity<GroupResponse> updateGroup(@PathVariable Long id, @RequestBody GroupRequest group) {
        GroupResponse updatedGroup = groupService.updateGroup(id, group);
        return ResponseEntity.ok(updatedGroup);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete group", description = "Deletes a group by its ID")
    public ResponseEntity<Void> deleteGroup(@PathVariable Long id) {
        groupService.deleteGroup(id);
        return ResponseEntity.noContent().build();
    }
}