package com.clock;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

//@RestController
//public class API {

//    private static final String template = "Hello, %s!";
//    private final AtomicLong counter = new AtomicLong();
//    
//    @RequestMapping("/greeting")
//    public @ResponseBody User user(@RequestParam(value="id", defaultValue="null") long id) {
////        return new User(counter.incrementAndGet(),String.format(template, id));
////        return "hi";
//    	return new User(counter.incrementAndGet(),String.format(template, "Dillon"),String.format(template, "Corkran"));
//    }

//}



@RestController
@RequestMapping("/user")
public class API {
	@Autowired
	JdbcTemplate jdbcTemplate;
    
    @RequestMapping(method=RequestMethod.GET)
    public @ResponseBody List getUser(@RequestParam(value="email", required=true) String email) {
        List<User> test = jdbcTemplate.query("SELECT * FROM users WHERE email = ?",
        		new Object[] { email },
                (rs, rowNum) -> new User(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"), rs.getString("password"), rs.getLong("clock_id"))
        );
    	return test;
    }

}


