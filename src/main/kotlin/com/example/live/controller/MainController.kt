package com.example.live.controller

import com.example.live.dto.LiveContent
import com.example.live.service.LiveContentProvider
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin


@RestController
class MainController {

    @Autowired
    lateinit var liveContentProvider: LiveContentProvider;

    @CrossOrigin(origins = ["http://localhost:3000"])
    @RequestMapping("/", method = [RequestMethod.GET], produces = ["application/json"])
    fun api(): MutableList<LiveContent> = liveContentProvider.getLiveContents()

}