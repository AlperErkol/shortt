package com.example.shortt.url.infra.web.rest;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/urls")
public class UrlController {

    @GetMapping
    public Response<GetUrlsResponse> getUrls() {

    }
    @GetMapping
    public Response<GetUrlResponse> getUrlById() {

    }
    @GetMapping
    public Response<GetUrlResponse> getUrlByAlias(@PathVariable String alias) {

    }
    @GetMapping
    public Response<GetUrlsResponse> getPinnedUrls() {

    }
    @PostMapping
    public Response<CreateUrlResponse> createUrl(@RequestBody CreateUrlRequest createUrlRequest){

    }
    @PostMapping
    public Response<PinUrlResponse> pinUrl(@PathVariable String alias) {

    }
    @DeleteMapping
    public Response<DeleteUrlResponse> deleteUrlByAlias(@PathVariable String alias) {

    }
}
