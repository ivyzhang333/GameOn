package com.weizhang.project1.service;

import com.weizhang.project1.dao.RegisterDao;
import com.weizhang.project1.entity.db.User;
import com.weizhang.project1.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Controller
public class RegisterService {
    @Autowired
    private RegisterDao registerDao;

    public boolean register(User user) throws IOException {
        user.setPassword(Util.encryptPassword(user.getUserId(), user.getPassword()));
        return registerDao.register(user);
    }

}
