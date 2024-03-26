package com.example.shortt.url.infra.web.rest;

import com.example.shortt.url.application.command.CreateUrl;
import com.example.shortt.url.application.command.DeleteUrlByAlias;
import com.example.shortt.url.application.command.GetUrlByAlias;
import com.example.shortt.url.application.command.PinUrl;
import com.example.shortt.url.application.common.CommandHandler;
import com.example.shortt.url.application.common.NoCommandHandler;
import com.example.shortt.url.application.dto.request.CreateUrlRequest;
import com.example.shortt.url.application.dto.response.UrlResponse;
import com.example.shortt.url.domain.model.Url;
import com.example.shortt.url.infra.common.Response;
import io.swagger.v3.oas.annotations.Operation;
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
    private final CommandHandler<Url, PinUrl> pinUrlCommandHandler;
    private final CommandHandler<List<Url>, String> getAllPinnedUrlsCommandHandler;
    private final CommandHandler<List<Url>, String> getAllUrlsByUuidCommandHandler;

    @GetMapping
    @Operation(summary = "Gets all short urls.")
    public Response<List<UrlResponse>> getAllUrls() {
        var respond = getAllUrlsCommandHandler.handle();
        log.info("All urls are retrieved.");
        return new Response<>(true, "All urls are retrieved.", UrlResponse.fromListModel(respond));
    }

    @GetMapping("/uuid/{uuid}")
    @Operation(summary = "Gets all short urls by given uuid.")
    public Response<List<UrlResponse>> getAllUrlsByUUID(@Valid @PathVariable String uuid) {
        var respond = getAllUrlsByUuidCommandHandler.handle(uuid);
        log.info("All urls by uuid are retrieved.");
        return new Response<>(true, "All urls by uuid are retrieved.", UrlResponse.fromListModel(respond));
    }

    @GetMapping("/{alias}")
    @Operation(summary = "Gets a short url by alias.")
    public Response<UrlResponse> getUrlByAlias(@Valid @PathVariable String alias) {
        var respond = getUrlCommandHandler.handle(GetUrlByAlias.from(alias));
        log.info("Url with alias {} is retrieved.", alias);
        return new Response<>(true, "Url is retrieved.", UrlResponse.fromModel(respond));
    }

    @PostMapping
    @Operation(summary = "Creates a short url.")
    public Response<UrlResponse> createUrl(@Valid @RequestBody CreateUrlRequest createUrlRequest){
        var respond = createUrlCommandHandler.handle(createUrlRequest.toModel());
        log.info("Url with alias {} is created.", respond.getAlias());
        return new Response<>(true, "Url is created.", UrlResponse.fromModel(respond));
    }

    @DeleteMapping("/{alias}")
    @Operation(summary = "Deletes a short url by alias.")
    public Response<UrlResponse> deleteUrlByAlias(@Valid @PathVariable String alias) {
        var respond = deleteUrlCommandHandler.handle(DeleteUrlByAlias.from(alias));
        log.info("Url with alias {} is deleted.", respond.getAlias());
        return new Response<>(true, "Url is deleted.", UrlResponse.fromModel(respond));
    }

    @PatchMapping("/pin/{alias}")
    @Operation(summary = "Pins short url.")
    public Response<UrlResponse> pinUrl(@Valid @PathVariable String alias) {
        var respond = pinUrlCommandHandler.handle(PinUrl.from(alias));
        log.info("Url with alias \"{}\" is pinned.", respond.getAlias());
        return new Response<>(true, "Url is pinned.", UrlResponse.fromModel(respond));
    }

    @GetMapping("/pin/uuid/{uuid}")
    @Operation(summary = "Gets all pinned short urls.")
    public Response<List<UrlResponse>> getAllPinUrls(@Valid @PathVariable String uuid) {
        var respond = getAllPinnedUrlsCommandHandler.handle(uuid);
        log.info("All pinned urls are retrieved.");
        return new Response<>(true, "All pinned urls are retrieved.", UrlResponse.fromListModel(respond));
    }
}