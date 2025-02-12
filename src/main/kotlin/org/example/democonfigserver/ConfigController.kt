package org.example.democonfigserver

import org.slf4j.LoggerFactory
import org.springframework.http.MediaType.TEXT_PLAIN_VALUE
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["/santannaf/client"])
class ConfigController(
    private val fetchConfigProvider: FetchConfigProvider
) {
    private val log = LoggerFactory.getLogger(javaClass)

    @GetMapping(path = ["/{key}"], produces = [TEXT_PLAIN_VALUE])
    fun fetchConfig(@PathVariable key: String): ResponseEntity<String> {
        log.info("receive call to get property $key")
        return ResponseEntity.ok(fetchConfigProvider.fetchConfig(key)?.property)
    }
}
