package com.agile.controllers.admin;


import com.agile.model.Game;
import com.agile.services.api.GameServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GameFormController {

    @Autowired
    private GameServiceInterface gameService;

    @RequestMapping(value = "/admin/games/{id}/delete")
    public String delete(@PathVariable(value="id") Integer id) {
        gameService.deleteGame(id);
        return "redirect:/admin/games";
    }

    @RequestMapping(value = "/admin/games/create", method = RequestMethod.GET)
    public String create(Model model) {
        model.addAttribute("url", "/admin/games/create");
        return "game_form";
    }

    @RequestMapping(value = "/admin/games/create", method = RequestMethod.POST)
    public String save(@ModelAttribute("game") Game game) {
        gameService.saveGame(game);
        return "redirect:/admin/games";
    }

    @RequestMapping(value = "/admin/games/{id}/edit", method = RequestMethod.GET)
    public String edit(@PathVariable(value="id") Integer id, Model model) {
        Game game = gameService.getGame(id);
        model.addAttribute("game", game);
        model.addAttribute("url", "/admin/games/" + id + "/edit");
        return "game_form";
    }

    @RequestMapping(value = "/admin/games/{id}/edit", method = RequestMethod.POST)
    public String change(@ModelAttribute("game") Game game) {
        gameService.saveGame(game);
        return "redirect:/admin/games";
    }
}
