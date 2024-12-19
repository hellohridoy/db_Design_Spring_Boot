package Com.example.bankingApp.DesignDB.service;

import Com.example.bankingApp.DesignDB.entity.Branch;

import java.util.List;

public interface BranchService {
    List<Branch> getAllBranches();
    Branch getBranchById(Long id);
    Branch createBranch(Branch branch);
    Branch updateBranch(Long id, Branch branch);
    void deleteBranch(Long id);
}
