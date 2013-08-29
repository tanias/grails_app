dataSource {
    pooled = true
    driverClassName = "org.postgresql.Driver"
    username = "postgres"
    password = "root"
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory'
}
// environment specific settings
environments {
    development {
        dataSource {
			pooled = false
            dbCreate = "create-drop" // one of 'create', 'create-drop', 'update', 'validate', ''
            url = 'jdbc:postgresql://localhost:5432/herokutest'
        }
    }
    test {
        dataSource {
            dbCreate = "update"
            url = "jdbc:h2:mem:testDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
        }
    }
    production {
    dataSource {
            dbCreate = "create-drop"
            driverClassName = "org.postgresql.Driver"
            dialect = org.hibernate.dialect.PostgreSQLDialect
            url = 'jdbc:postgresql://localhost:5432/herokutest'
            username = 'postgres'
            password = 'root'
    }
   }
}
