package org.statisticService.controllers;

import org.statisticService.dao.impls.MatchDaoImpl;
import org.statisticService.dao.impls.MatchStatisticDaoImpl;
import org.springframework.stereotype.Controller;

@Controller
public class MatchController {
    MatchDaoImpl matchDB = new MatchDaoImpl();
    MatchStatisticDaoImpl matchStatDb = new MatchStatisticDaoImpl();
}
