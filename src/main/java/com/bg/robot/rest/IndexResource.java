package com.bg.robot.rest;

import com.bg.robot.config.ResultCode;
import com.bg.robot.rest.dto.ResultDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
public class IndexResource {

    public static final Logger LOGGER = LoggerFactory.getLogger(IndexResource.class);


    @RequestMapping(value = "/index",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<ResultDTO> getInfo() {
        LOGGER.debug("REST request to get Server Info");
        ResultDTO resultDTO = new ResultDTO();

        return new ResponseEntity<>(resultDTO, HttpStatus.OK);
    }
}
