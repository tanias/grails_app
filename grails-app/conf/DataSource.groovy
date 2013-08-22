dataSource {
    pooled = true
    driverClassName = "org.h2.Driver"
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
            dbCreate = "create-drop" // one of 'create', 'create-drop', 'update', 'validate', ''
            url = "jdbc:h2:mem:devDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
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
            dbCreate = "none"
            driverClassName = "org.postgresql.Driver"
            dialect = org.hibernate.dialect.PostgreSQLDialect
            url = 'jdbc:postgresql://localhost:5432/herokutest?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory'
            username = 'postgres'
            password = 'root'
    }
   }
}
