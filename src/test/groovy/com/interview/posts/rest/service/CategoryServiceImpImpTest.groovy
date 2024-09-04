package com.interview.posts.rest.service

import com.interview.posts.rest.model.Category
import com.interview.posts.rest.model.dto.CategoryDto
import com.interview.posts.rest.model.parser.CategoryParser
import com.interview.posts.rest.repository.CategoryRepository
import spock.lang.Specification

class CategoryServiceImpImpTest extends Specification {

    CategoryServiceImp categoryService
    CategoryParser categoryParser

    CategoryRepository categoryRepository = Mock()

    Category testCategory
    Category testCategory2

    CategoryDto testCategoryDto

    void setup() {
        categoryParser = new CategoryParser()
        categoryService = new CategoryServiceImp(categoryRepository, categoryParser)

        testCategory = new Category(id: 1, name: "testCategory")
        testCategory2 = new Category(id: 2, name: "testCategory2")

        testCategoryDto = new CategoryDto(id: 1, name: "testCategory")
    }

    def "given test categories when call to get all categories then get test categories"() {
        given:
        categoryRepository.findAll() >> [testCategory, testCategory2]

        when:
        Optional<List<CategoryDto>> categories = categoryService.getAll()

        then:
        categories.get().get(0).id == 1
        categories.get().get(0).name == "testCategory"
        categories.get().get(1).id == 2
        categories.get().get(1).name == "testCategory2"
    }

    def "given test category when call to get category by id then get test category"() {
        given:
        categoryRepository.findById(_ as Long) >> Optional.of(testCategory)

        when:
        Optional<CategoryDto> category = categoryService.get(1)

        then:
        category.get().id == 1
        category.get().name == "testCategory"
    }

    def "given test category when call to save category then get saved category"() {
        given:
        categoryRepository.save(_ as Category) >> testCategory

        when:
        Optional<CategoryDto> category = categoryService.save(testCategoryDto)

        then:
        category.get().id == 1
        category.get().name == "testCategory"
    }

}
