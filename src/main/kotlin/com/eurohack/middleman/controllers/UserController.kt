package com.eurohack.middleman.controllers

import com.eurohack.middleman.models.Interest
import com.eurohack.middleman.services.MiddleManService
import io.micronaut.http.HttpResponse.accepted
import io.micronaut.http.HttpResponse.ok
import io.micronaut.http.MediaType
import io.micronaut.http.MutableHttpResponse
import io.micronaut.http.annotation.*
import javax.inject.Inject

@Controller("/user")
class UserController @Inject constructor(
        private val middleManService: MiddleManService
) {

    @Post("/{id}/interest")
    fun addInterest(id: String, @Body interest: Interest) : MutableHttpResponse<Any?> {
        middleManService.addInterest(id, interest)
        return accepted()
    }

    @Get("/{id}/notifications")
    @Produces(MediaType.APPLICATION_JSON)
    fun getNotifications(id: String) : MutableHttpResponse<Any?> = ok(middleManService.getNotifications(id))

}