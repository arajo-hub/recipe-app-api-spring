package com.example.recipe.api.user;

import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserServiceImpl implements UserService {

    private static Map<User, String> userRepository = new ConcurrentHashMap<>();

    @Override
    public HttpStatus validateUser(User user) {

        // user 확인
        // 1. name 최대 길이 255자
        if (user.getName().length() <= 0 && user.getName().length() > 255) {
            return HttpStatus.BAD_REQUEST;
        }

        // 2. password 5글자 이상(문자, 숫자, 특수문자 포함 가능)
        if (user.getPassword().length() < 5) {
            return HttpStatus.BAD_REQUEST;
        }

        // 3. @와 .를 포함한 문자열
        if (user.getEmail().length() > 0) {
            if (user.getEmail().indexOf("@") == -1 && user.getEmail().indexOf(".") == -1) {
                return HttpStatus.BAD_REQUEST;
            } else if (user.getEmail().indexOf("@") > user.getEmail().indexOf(".")) {
                return HttpStatus.BAD_REQUEST;
            } else {
                return HttpStatus.OK;
            }
        } else {
            return HttpStatus.BAD_REQUEST;
        }
    }

    @Override
    public HttpStatus createUser(User user) {
        HttpStatus status = HttpStatus.EXPECTATION_FAILED;
        int before = userRepository.size();
        String token = UUID.randomUUID().toString();
        boolean isFirstTime = true;
        for (User userInRepo : userRepository.keySet()) {
            if (user.equals(userInRepo)) {
                isFirstTime = false;
            }
        }
        if (isFirstTime) {
            userRepository.put(user, token);
        }
        int after = userRepository.size();

        if (isFirstTime && before != after) {
            if ((after - before) == 1) {
                status = HttpStatus.OK;
            }
        } else {
            status = HttpStatus.BAD_REQUEST;
        }
        return status;
    }

    @Override
    public HttpStatus login(User user) {
        HttpStatus status = HttpStatus.EXPECTATION_FAILED;
        boolean isExist = false;
        for (User userInRepo : userRepository.keySet()) {
            if (user.equals(userInRepo)) {
                isExist = true;
            }
        }

        if (isExist) {
            status = HttpStatus.OK;
        } else {
            status = HttpStatus.NO_CONTENT;
        }
        return status;
    }

    @Override
    public HttpStatus saveToken(User user) {
        boolean isExist = false;
        User key = user;
        for (User userInRepo : userRepository.keySet()) {
            if (user.equals(userInRepo)) {
                isExist = true;
                key = userInRepo;
            }
        }

        if (isExist) {
            if (userRepository.get(key) == null) {
                userRepository.put(key, UUID.randomUUID().toString());
            }
        }

        return HttpStatus.OK;
    }

    @Override
    public String getToken(User user) {
        boolean isExist = false;
        User key = user;
        for (User userInRepo : userRepository.keySet()) {
            if (user.equals(userInRepo)) {
                isExist = true;
                key = userInRepo;
            }
        }

        if (isExist) {
            return userRepository.get(key);
        } else {
            return null;
        }
    }

    @Override
    public HttpStatus replaceUser(UserIncludeToken user) {
        HttpStatus status = HttpStatus.EXPECTATION_FAILED;
        User replaceUser = user;
        if (userRepository.containsValue(user.getToken())) {
            // token 이용해서 User 찾기
            for (var userAndToken : userRepository.entrySet()) {
                if (userAndToken.getValue().equals(user.getToken())) {
                    replaceUser = userAndToken.getKey();
                    replaceUser.setName(user.getName());
                    replaceUser.setPassword(user.getPassword());
                    replaceUser.setEmail(user.getEmail());
                    status = HttpStatus.OK;
                }
            }
        } else {
            status = HttpStatus.NO_CONTENT;
        }

        return status;
    }

    @Override
    public List<User> getAll(String token) {
        List<User> userList = new ArrayList<>();

        if (userRepository.containsValue(token)) {
            for (var userInRepo : userRepository.entrySet()) {
                userList.add(userInRepo.getKey());
            }
        }

        return userList;
    }

}
