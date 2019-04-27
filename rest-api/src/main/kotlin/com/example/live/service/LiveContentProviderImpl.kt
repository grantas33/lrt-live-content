package com.example.live.service

import com.example.live.dto.LiveContent
import org.jsoup.Jsoup
import org.springframework.stereotype.Service

@Service
class LiveContentProviderImpl: LiveContentProvider {
    private val URL = "https://www.lrt.lt/mediateka/tiesiogiai/lrt-televizija";

    override fun getLiveContents(): MutableList<LiveContent> {
        var liveContents = mutableListOf<LiveContent>()
        val doc = Jsoup.connect(URL).get()
        val contentList = doc.select("#tvprog")
        if (contentList.isEmpty()) {
            throw NoSuchElementException()
        }
        val channelElements = contentList.select(".channel-item.live-program")
        val airTimeElements = contentList.select(".data-block__text")
        val contentElements = contentList.select(".channel-item__title")
        for (i in 0 until channelElements.count()) {
            val channel = channelElements[i].attr("data-tvprogname")
            val airTime = airTimeElements[i].text()
            val content = contentElements[i].text()
            liveContents.add(LiveContent(channel, airTime, content))
        }
        return liveContents
    }
}