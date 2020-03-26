package com.bank.controller;
import com.bank.dao.BranchDao;
import com.bank.entity.Branch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("branch")
public class BranchController {

    @Autowired
    BranchDao branchDao;

    @PostMapping("/create")
    public String createBranch(@RequestBody Branch branch)
    {
        branchDao.createBranch(branch);
        return "branch created";
    }
    @GetMapping("/list")
    public  List<Branch> allBranch()
    {
      return branchDao.allBranch();
    }

    @PostMapping(value ="/get")
    public Branch getBranch(@RequestParam String branchId)
    {
       return branchDao.getBranch(branchId);
    }
}
