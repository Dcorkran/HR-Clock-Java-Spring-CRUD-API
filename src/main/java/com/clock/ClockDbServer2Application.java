package com.clock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class ClockDbServer2Application implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(ClockDbServer2Application.class);

    public static void main(String args[]) {
        SpringApplication.run(ClockDbServer2Application.class, args);
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... strings) throws Exception {

        log.info("Creating tables");
        jdbcTemplate.execute("DROP TABLE IF EXISTS users");
        jdbcTemplate.execute("DROP TABLE IF EXISTS clocks");
        jdbcTemplate.execute("CREATE TABLE clocks(" +
                "id SERIAL UNIQUE, key VARCHAR(255), alarm TIMESTAMP)");

        jdbcTemplate.execute("DROP TABLE IF EXISTS users");
        jdbcTemplate.execute("CREATE TABLE users(" +
                "id SERIAL UNIQUE, first_name VARCHAR(50), last_name VARCHAR(50), email VARCHAR(50), password VARCHAR(255), clock_id INTEGER, FOREIGN KEY(clock_id) REFERENCES clocks(id)) ");

//        // Split up the array of whole names into an array of first/last names
//        List<Object[]> splitUpNames = Arrays.asList("John Woo", "Jeff Dean", "Josh Bloch", "Josh Long").stream()
//                .map(name -> name.split(" "))
//                .collect(Collectors.toList());
//        System.out.println(Arrays.toString(splitUpNames.toArray()));
//
//        // Use a Java 8 stream to print out each tuple of the list
//        splitUpNames.forEach(name -> log.info(String.format("Inserting customer record for %s %s", name[0], name[1])));
//
//        // Uses JdbcTemplate's batchUpdate operation to bulk load data
        jdbcTemplate.update("INSERT INTO clocks(key, alarm) VALUES ('1A1A','2017-01-01 12:00')");
        jdbcTemplate.update("INSERT INTO users(first_name, last_name, email, password, clock_id) VALUES ('Josh','Corkran','dcorkran972@gmail.com','$2a$10$kRbOLTXlsp9ag7nW.t0MO.Wg9NfZp2A7Q5H7EkuXyeadO2hW.cTrW',1)");
//
//        log.info("Querying for customer records where first_name = 'Josh':");
//        jdbcTemplate.query("SELECT * FROM users WHERE first_name = ?", new Object[] { "Josh" },
//                (rs, rowNum) -> new User(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"), rs.getString("password"), rs.getLong("clock_id"))
//        ).forEach(customer -> log.info(customer.toString()));
    }
}