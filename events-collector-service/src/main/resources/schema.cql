-- docker exec -it cassandra cqlsh

CREATE KEYSPACE spring_keyspace WITH REPLICATION = {
        'class' : 'SimpleStrategy',
        'replication_factor' : 1
        };