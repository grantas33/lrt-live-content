package com.example.live.service

import com.example.live.dto.LiveContent

interface LiveContentProvider {
    fun getLiveContents(): MutableList<LiveContent>
}