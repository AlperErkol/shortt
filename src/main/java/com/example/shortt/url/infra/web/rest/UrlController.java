package com.example.shortt.url.infra.web.rest;

import com.example.shortt.url.application.command.CreateUrl;
import com.example.shortt.url.application.command.DeleteUrlByAlias;
import com.example.shortt.url.application.command.GetUrlByAlias;
import com.example.shortt.url.application.common.CommandHandler;
import com.example.shortt.url.application.common.NoCommandHandler;
import com.example.shortt.url.application.dto.request.CreateUrlRequest;
import com.example.shortt.url.application.dto.response.UrlResponse;
import com.example.shortt.url.domain.model.Url;
import com.example.shortt.url.infra.common.Response;
import jakarta.validation.Valid;
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
    private final CommandHandler<Url, GetUrlByAlias> getUrlCommandHandler;
    private final CommandHandler<Url, CreateUrl> createUrlCommandHandler;
    private final CommandHandler<Url, DeleteUrlByAlias> deleteUrlCommandHandler;

    @GetMapping
    public Response<List<UrlResponse>> getAllUrls() {
        var respond = getAllUrlsCommandHandler.handle();
        log.info("All urls are retrieved.");
        return new Response<>(true, "All urls are retrieved.", UrlResponse.fromListModel(respond));
    }

    @GetMapping("/{alias}")
    public Response<UrlResponse> getUrlByAlias(@PathVariable String alias) {
        var respond = getUrlCommandHandler.handle(GetUrlByAlias.from(alias));
        log.info("Url with alias {} is retrieved.", alias);
        return new Response<>(true, "Url is retrieved.", UrlResponse.fromModel(respond));
    }

    @PostMapping
    public Response<UrlResponse> createUrl(@Valid @RequestBody CreateUrlRequest createUrlRequest){
        var respond = createUrlCommandHandler.handle(createUrlRequest.toModel());
        log.info("Url with alias {} is created.", respond.getAlias());
        return new Response<>(true, "Url is created.", UrlResponse.fromModel(respond));
    }

    @DeleteMapping("/{alias}")
    public Response<UrlResponse> deleteUrlByAlias(@PathVariable String alias) {
        var respond = deleteUrlCommandHandler.handle(DeleteUrlByAlias.from(alias));
        log.info("Url with alias {} is deleted.", respond.getAlias());
        return new Response<>(true, "Url is deleted.", UrlResponse.fromModel(respond));
    }

    /*
    @GetMapping("/pin")
    public Response<GetUrlsResponse> getAllPinUrls() {

    }


    @PostMapping("/pin/{alias}")
    public Response<PinUrlResponse> pinUrl(@PathVariable String alias) {

    }

     */
}
