package com.onlineProgramming.Service.Impl;

import com.onlineProgramming.Entity.ProblemUtils;
import com.onlineProgramming.Service.ProblemService;
import com.onlineProgramming.Utils.FIleUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author CKC
 * @DateTime 2021/4/28 20:38
 */
@Service
public class ProblemServiceImpl implements ProblemService {
    
    @Override
    public ProblemUtils Problem() {
        Map<Integer, ProblemUtils> map = FIleUtils.inquiryFile();
        return map.get((int) (Math.random() * map.size()));
    }
}
