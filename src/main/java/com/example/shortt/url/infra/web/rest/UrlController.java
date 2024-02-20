package com.example.shortt.url.infra.web.rest;

import com.example.shortt.url.application.common.NoCommandHandler;
import com.example.shortt.url.application.dto.request.CreateUrlRequest;
import com.example.shortt.url.application.dto.response.GetAllUrlsResponse;
import com.example.shortt.url.application.query.GetAllUrls;
import com.example.shortt.url.domain.model.Url;
import com.example.shortt.url.infra.common.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/urls")
public class UrlController {

    private final NoCommandHandler<List<Url>> getAllUrlsCommandHandler;

    @GetMapping
    public Response<List<GetAllUrls>> getAllUrls() {
        var respond = getAllUrlsCommandHandler.handle();
        log.info("All urls are retrieved.");
        return new Response<>(true, "", GetAllUrlsResponse.fromModel(respond));
    }
    /*
    @GetMapping("/{alias}")
    public Response<GetUrlResponse> getUrlByAlias(@PathVariable String alias) {

    }
    @GetMapping("/pin")
    public Response<GetUrlsResponse> getAllPinUrls() {

    }

    @PostMapping
    public Response<CreateUrlResponse> createUrl(@Valid @RequestBody CreateUrlRequest createUrlRequest){


    }
    @PostMapping("/pin/{alias}")
    public Response<PinUrlResponse> pinUrl(@PathVariable String alias) {

    }
    @DeleteMapping("/{alias}")
    public Response<DeleteUrlResponse> deleteUrlByAlias(@PathVariable String alias) {

    }
     */
}
