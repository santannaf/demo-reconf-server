package org.example.democonfigserver

import org.springframework.stereotype.Repository
import org.yaml.snakeyaml.introspector.Property

@Repository
class FetchConfigOracleProvider : FetchConfigProvider {

    override fun fetchConfig(keyName: String): Config? {
        return Config(system = keyName, keyName = keyName, property = "'true'")

//        return jdbcClient.sql("select system, key_name as keyName, property from templateapp_adm.configs where key_name = :keyName")
//            .param("keyName", keyName)
//            .query(Config::class.java)
//            .optional().orElse(null)
    }
}
