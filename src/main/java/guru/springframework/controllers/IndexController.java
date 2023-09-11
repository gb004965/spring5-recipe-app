package guru.springframework.controllers;

import guru.springframework.domain.Category;
import guru.springframework.domain.UnitOfMeasure;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

/**
 * Created by jt on 6/1/17.
 */
@Controller
public class IndexController {

    private CategoryRepository categoryRespository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRespository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRespository = categoryRespository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(){

        Optional<Category> category = categoryRespository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasure = unitOfMeasureRepository.findByDescription("Teaspoon");

        System.out.println("find Category : " + category.get().getId());
        System.out.println("find Unit Of Measure : " + unitOfMeasure.get().getId());

        return "index";
    }
}
