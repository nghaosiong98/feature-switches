package com.nghaosiong.technicalassessment.controller;

import com.nghaosiong.technicalassessment.model.entity.Feature;
import com.nghaosiong.technicalassessment.model.entity.User;
import com.nghaosiong.technicalassessment.model.entity.UserAccess;
import com.nghaosiong.technicalassessment.model.exception.UserAccessNotFoundException;
import com.nghaosiong.technicalassessment.model.request.EnableFeatureRequest;
import com.nghaosiong.technicalassessment.model.response.CheckFeatureResponse;
import com.nghaosiong.technicalassessment.service.FeatureService;
import com.nghaosiong.technicalassessment.service.UserAccessService;
import com.nghaosiong.technicalassessment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeatureController {

    @Autowired
    FeatureService featureService;
    @Autowired
    UserService userService;
    @Autowired
    UserAccessService userAccessService;

    @GetMapping("/feature")
    ResponseEntity<CheckFeatureResponse> checkUserAccess(@RequestParam String email, @RequestParam String featureName) {
        try {
            User user = userService.getUserByEmail(email);
            Feature feature = featureService.getFeatureByName(featureName);
            UserAccess userAccessByUserIdAndFeatureId =
                    userAccessService.getUserAccessByUserIdAndFeatureId(user.getId(), feature.getId());
            return ResponseEntity.ok()
                    .body(new CheckFeatureResponse(userAccessByUserIdAndFeatureId.isHas_access()));
        } catch (UserAccessNotFoundException uae) {
            return ResponseEntity.ok()
                    .body(new CheckFeatureResponse(false));
        } catch (RuntimeException re) {
            throw re;
        }
    }

    @PostMapping("/feature")
    ResponseEntity<String> featureSwitch(@RequestBody EnableFeatureRequest enableFeatureRequest) {
        try {
            User user = userService.getUserByEmail(enableFeatureRequest.getEmail());
            Feature feature = featureService.getFeatureByName(enableFeatureRequest.getFeatureName());
            UserAccess oldUserAccess =
                    userAccessService.getUserAccessByUserIdAndFeatureId(user.getId(), feature.getId());
            UserAccess newUserAccess = new UserAccess(user.getId(), feature.getId(), enableFeatureRequest.isEnable());
            if (oldUserAccess != null) {
                newUserAccess.setId(oldUserAccess.getId());
            }
            userAccessService.saveOrUpdate(newUserAccess);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }

    }

}
