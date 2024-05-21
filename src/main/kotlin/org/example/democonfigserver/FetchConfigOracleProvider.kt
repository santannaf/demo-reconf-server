package org.example.democonfigserver

import org.springframework.jdbc.core.simple.JdbcClient
import org.springframework.stereotype.Repository

@Repository
class FetchConfigOracleProvider(
    private val jdbcClient: JdbcClient
) : FetchConfigProvider {
    override fun fetchConfig(keyName: String): Config? {
        return jdbcClient.sql("select system, key_name as keyName, property from templateapp_adm.configs where key_name = :keyName")
            .param("keyName", keyName)
            .query(Config::class.java)
            .optional().orElse(null)
    }
}
