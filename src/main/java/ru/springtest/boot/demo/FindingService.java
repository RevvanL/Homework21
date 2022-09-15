package ru.springtest.boot.demo;

import org.springframework.stereotype.Service;
import ru.springtest.boot.demo.annotations.LogMethod;
import ru.springtest.boot.demo.dao.CookiesDao;

@Service
public class FindingService {
    private final CookiesDao cookiesDao;

    public FindingService(CookiesDao cookiesDao) {
        this.cookiesDao = cookiesDao;
    }

    public CookieLovers findLoversByWho(String who) {
        return cookiesDao.findByWho(who);
    }

    @LogMethod
    public CookieLovers submitLovers(CookieLovers cookieLovers) {
        return cookiesDao.submitCookieLover(cookieLovers);
    }
}
