package com.clock;

import java.sql.Timestamp;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;


@RestController
@RequestMapping("/clock")
public class ClockAPI {

	@Autowired
	JdbcTemplate jdbcTemplate;
    
    @RequestMapping(method=RequestMethod.GET)
    public @ResponseBody List getUser(@RequestParam(value="id", required=true) long id) {
        List<Clock> test = jdbcTemplate.query("SELECT * FROM clocks WHERE id = ?",
        		new Object[] { id },
                (rs, rowNum) -> new Clock(rs.getLong("id"), rs.getString("key"), rs.getTimestamp("alarm"))
        );
    	return test;
    }
    @RequestMapping(method=RequestMethod.PUT)
    public void setClock(@RequestBody Clock clock) {
    	final long id = clock.getId();
    	final Timestamp alarm = clock.getAlarm();
    	jdbcTemplate.update("UPDATE clocks SET alarm = ? WHERE id = ?",
    			new Object[]{ alarm, id});
    }

}


