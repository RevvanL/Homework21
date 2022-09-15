package ru.springtest.boot.demo.dao;

import org.springframework.stereotype.Repository;
import ru.springtest.boot.demo.CookieLovers;

@Repository
public class CookiesDao {
    public CookieLovers findByWho(String who) {
        return new CookieLovers("Jill", "ate", 6, "cakes");
    }

    public CookieLovers submitCookieLover(CookieLovers cookieLovers) {
        return cookieLovers;
    }
}

