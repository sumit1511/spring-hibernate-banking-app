package com.bank.controller;
import com.bank.dao.BranchDao;
import com.bank.entity.Branch;
import com.bank.exceptions.custom.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.rmi.StubNotFoundException;
import java.util.List;

@RestController
@RequestMapping("branch")
public class BranchRestController {

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
        if(branchDao.getBranch(branchId)==null)
        {
            throw  new CustomException("Branch Not Found for this Id " +branchId);
        }
        return branchDao.getBranch(branchId);
    }


}
