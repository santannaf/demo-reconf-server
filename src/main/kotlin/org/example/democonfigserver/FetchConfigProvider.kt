package org.example.democonfigserver

interface FetchConfigProvider {
    fun fetchConfig(keyName: String): Config?
}
