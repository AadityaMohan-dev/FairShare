package com.FairShare.svc;

import com.FairShare.dto.GroupRequest;
import com.example.expensetracker.dto.GroupResponse;

import java.util.List;

public interface GroupService {
    GroupResponse createGroup(GroupRequest group);

    GroupResponse getGroupById(Long id);

    List<GroupResponse> getAllGroups();

    GroupResponse updateGroup(Long id, GroupRequest group);

    void deleteGroup(Long id);
}
