package controllers;

import dao.impls.MatchDaoImpl;
import dao.impls.MatchStatisticDaoImpl;
import org.springframework.stereotype.Controller;

@Controller
public class MatchController {
    MatchDaoImpl matchDB = new MatchDaoImpl();
    MatchStatisticDaoImpl matchStatDb = new MatchStatisticDaoImpl();
}
