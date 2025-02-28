package com.FairShare.svc;

import com.FairShare.dto.GroupRequest;
import com.FairShare.entity.Group;
import com.FairShare.entity.User;
import com.FairShare.repository.GroupRepository;
import com.FairShare.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.expensetracker.dto.GroupResponse;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;
    private final UserRepository userRepository;

    @Override
    public GroupResponse createGroup(GroupRequest groupRequest) {
        // Fetch the creator (user) from the database
        User creator = userRepository.findById(groupRequest.getCreatedBy())
                .orElseThrow(() -> new RuntimeException("User not found with id: " + groupRequest.getCreatedBy()));

        // Fetch members from the database
        Set<User> members = groupRequest.getMemberIds().stream()
                .map(memberId -> userRepository.findById(memberId)
                        .orElseThrow(() -> new RuntimeException("User not found with id: " + memberId)))
                .collect(Collectors.toSet());

        // Create the group entity
        Group group = Group.builder()
                .name(groupRequest.getName())
                .description(groupRequest.getDescription())
                .createdBy(creator)
                .members(members)
                .createdAt(LocalDateTime.now())
                .build();

        // Save the group to the database
        Group savedGroup = groupRepository.save(group);

        // Build and return the response
        return GroupResponse.builder()
                .id(savedGroup.getId())
                .name(savedGroup.getName())
                .description(savedGroup.getDescription())
                .createdBy(savedGroup.getCreatedBy().getId())
                .memberIds(savedGroup.getMembers().stream()
                        .map(User::getId)
                        .collect(Collectors.toSet()))
                .createdAt(savedGroup.getCreatedAt())
                .build();
    }

    @Override
    public GroupResponse getGroupById(Long id) {
        // Fetch the group from the database
        Group group = groupRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Group not found with id: " + id));

        // Build and return the response
        return GroupResponse.builder()
                .id(group.getId())
                .name(group.getName())
                .description(group.getDescription())
                .createdBy(group.getCreatedBy().getId())
                .memberIds(group.getMembers().stream()
                        .map(User::getId)
                        .collect(Collectors.toSet()))
                .createdAt(group.getCreatedAt())
                .build();
    }

    @Override
    public List<GroupResponse> getAllGroups() {
        // Fetch all groups from the database
        List<Group> groups = groupRepository.findAll();

        // Map each group to a GroupResponse
        return groups.stream()
                .map(group -> GroupResponse.builder()
                        .id(group.getId())
                        .name(group.getName())
                        .description(group.getDescription())
                        .createdBy(group.getCreatedBy().getId())
                        .memberIds(group.getMembers().stream()
                                .map(User::getId)
                                .collect(Collectors.toSet()))
                        .createdAt(group.getCreatedAt())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public GroupResponse updateGroup(Long id, GroupRequest groupRequest) {
        // Fetch the existing group from the database
        Group group = groupRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Group not found with id: " + id));

        // Update the group details
        group.setName(groupRequest.getName());
        group.setDescription(groupRequest.getDescription());

        // Update members if provided
        if (groupRequest.getMemberIds() != null) {
            Set<User> members = groupRequest.getMemberIds().stream()
                    .map(memberId -> userRepository.findById(memberId)
                            .orElseThrow(() -> new RuntimeException("User not found with id: " + memberId)))
                    .collect(Collectors.toSet());
            group.setMembers(members);
        }

        // Save the updated group to the database
        Group updatedGroup = groupRepository.save(group);

        // Build and return the response
        return GroupResponse.builder()
                .id(updatedGroup.getId())
                .name(updatedGroup.getName())
                .description(updatedGroup.getDescription())
                .createdBy(updatedGroup.getCreatedBy().getId())
                .memberIds(updatedGroup.getMembers().stream()
                        .map(User::getId)
                        .collect(Collectors.toSet()))
                .createdAt(updatedGroup.getCreatedAt())
                .build();
    }

    @Override
    public void deleteGroup(Long id) {
        // Check if the group exists
        if (!groupRepository.existsById(id)) {
            throw new RuntimeException("Group not found with id: " + id);
        }

        // Delete the group
        groupRepository.deleteById(id);
    }
}