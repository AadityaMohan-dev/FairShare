package com.FairShare.svc;

import com.FairShare.dto.GroupRequest;
import com.example.expensetracker.dto.GroupResponse;

import java.util.List;

public class GroupServiceImpl implements GroupService{
    @Override
    public GroupResponse createGroup(GroupRequest group) {
        return null;
    }

    @Override
    public GroupResponse getGroupById(Long id) {
        return null;
    }

    @Override
    public List<GroupResponse> getAllGroups() {
        return List.of();
    }

    @Override
    public GroupResponse updateGroup(Long id, GroupRequest group) {
        return null;
    }

    @Override
    public void deleteGroup(Long id) {

    }
}
